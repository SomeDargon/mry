package com.mry.util;

import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

public final class ImageUtil {
    private static final Logger logger = LoggerFactory
            .getLogger(ImageUtil.class);

    private static final int MAGIC_NUMBER_LEN = 4;
    public static final String DEFAULT_TYPE = "jpg";

    public static final int icon_height = 150;
    public static final int icon_width = 150;
    public static final int normal_width = 600;
    public static final int thumbnail_width = 250;

    public static void main(String[] args) throws Exception {
        String s = "D:\\wallpapers\\DSC02527.JPG";
        // s = "d:\\test.jpg";
        byte[] data = getFileBinary(s);

        data = zoomImageForSystemWith(data, "jpg");

        ImageIO.write(ImageIO.read(new ByteArrayInputStream(data)), "jpg",
                new File("d:\\test1.jpg"));

    }

    public static byte[] getFileBinary(String filename) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            InputStream input = new FileInputStream(new File(filename));
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = input.read(buffer)) > -1) {
                output.write(buffer, 0, len);
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toByteArray();
    }

    public static byte[] processIconToSquare(byte[] src, String type) {
        return processIconToSquare(src, icon_width, type);
    }

    public static byte[] zoomImageForSystemWith(byte[] src, String type) {
        return zoomImageToFixWidth(src, normal_width, type);
    }

    public static byte[] createThumbnail(byte[] src, String type) {
        return zoomImageToFixWidth(src, thumbnail_width, type);
    }

    public static byte[] processIconToSquare(byte[] src, int fixLen, String type) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(src));
            image = processIconToSquare(image, fixLen);
            return convertImageToByteArray(image, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] zoomImageToFixWidth(byte[] src, int maxWidth,
                                             String type) {
        try {
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(src));
            int width = image.getWidth();
            if (width <= maxWidth) {
                return src;
            }

            double rate = maxWidth / (double) width;
            width = maxWidth;
            int height = (int) (image.getHeight() * rate);

            image = zoomImage(image, width, height);
            return convertImageToByteArray(image, type);
        } catch (Exception e) {
            return null;
        }
    }

    public static BufferedImage zoomImageToFixWidth(BufferedImage src,
                                                    int maxWidth) {
        int width = src.getWidth();
        if (width <= maxWidth) {
            return src;
        }

        double rate = (double) maxWidth / width;
        width = maxWidth;
        int height = (int) (src.getHeight() * rate);

        BufferedImage result = zoomImage(src, width, height);
        return result;
    }

    private static BufferedImage zoomImage(BufferedImage src, int width,
                                           int height) {
        BufferedImage result = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);

        result.getGraphics().drawImage(
                src.getScaledInstance(width, height,
                        java.awt.Image.SCALE_SMOOTH), 0, 0, null);

        return result;

    }

    public static byte[] convertImageToByteArray(BufferedImage image,
                                                 String type) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            type = type == null ? DEFAULT_TYPE : type;
            ImageIO.write(image, type, baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();
        return bytes;

    }

    /**
     * 图片转Base64字符串
     *
     * @param image 图片数据
     * @param type  图片格式
     * @return Base64字符串
     */
    public static String convertImageToBase64(BufferedImage image, String type) {
        return java.util.Base64.getEncoder().encodeToString(convertImageToByteArray(image, type));
    }

    public static void saveImage(byte[] binary, String filename) {
        FileOutputStream output = null;
        try {
            File file = new File(filename);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            output = new FileOutputStream(file);
            output.write(binary);
            output.flush();
        } catch (IOException e) {
            logger.error("Cannot write " + filename + " to disk.");
            logger.error(e.getMessage(), e);
        } finally {
            if (output != null) {
                try {
                    output.close();
                    binary = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static ImageType getImageType(byte[] data) {
        ImageType type = null;
        if (isImage(data)) {
            type = getImageTypeByBinary(data);
            if (type == null) {
                type = getImageTypeByImageIO(data);
            }
        }
        return type;
    }

    public static ImageType getImageTypeByBinary(byte[] data) {
        if (data.length < MAGIC_NUMBER_LEN) {
            return null;
        }

        byte[] magicNumber = new byte[MAGIC_NUMBER_LEN];
        System.arraycopy(data, 0, magicNumber, 0, MAGIC_NUMBER_LEN);
        String magicCode = Hex.encodeHexString(magicNumber);
        return ImageType.fromMagicCode(magicCode);
    }

    public static boolean isImage(byte[] data) {
        boolean flag = false;
        try {
            BufferedImage bufreader = ImageIO.read(new ByteArrayInputStream(
                    data));
            int width = bufreader.getWidth();
            int height = bufreader.getHeight();
            if (width == 0 || height == 0) {
                flag = false;
            } else {
                flag = true;
            }
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    public static ImageType getImageTypeByImageIO(byte[] data) {
        ImageInputStream iis = null;
        try {
            iis = ImageIO
                    .createImageInputStream(new ByteArrayInputStream(data));
            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);
            if (!iter.hasNext()) {
                return null;
            }
            ImageReader reader = iter.next();
            return ImageType.fromType(reader.getFormatName());
        } catch (Exception e) {
            return null;
        } finally {
            if (iis != null) {
                try {
                    iis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static BufferedImage processIconToSquare(BufferedImage src,
                                                     int fixLen) {
        int width = src.getWidth();
        int height = src.getHeight();
        if (width <= fixLen && height <= fixLen) {
            return src;
        }

        if (width > height) {
            double rate = fixLen / (double) width;
            width = fixLen;
            height = (int) (height * rate);
        } else {
            double rate = fixLen / (double) height;
            height = fixLen;
            width = (int) (width * rate);
        }

        BufferedImage result = zoomImage(src, width, height);
        return result;
    }

}
