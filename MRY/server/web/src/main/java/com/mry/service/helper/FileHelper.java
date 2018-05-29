package com.mry.service.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FileHelper {
    private static final Logger logger = LoggerFactory
            .getLogger(FileHelper.class);

    // format:/pics/business/images

    private static final DateTimeFormatter DATE_PATH_FORMATER = DateTimeFormatter
            .ofPattern("yyyy" + File.separator + "MM");

    private static final String DEFAULT_WEB_IMAGE_STORE_DIR = File.separator
            + "customer" + File.separator + "reports";

    /**
     * 保存文件返回网络路径
     */
    public static String saveBinaryToDisk(FilePath path, byte[] data,
                                          String filename) {

        final String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR + File.separator
                + DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator
                + UUID.randomUUID().toString() + "_" + filename;

        String fileDiskPath = path.getAbsolutePath() + relativePath;
        saveFile(data, fileDiskPath);

        return path.getHost() + relativePath.replaceAll("\\\\", "/");
    }

    /**
     * 保存文件返回相对路径
     *
     * @return
     */
    public static String saveFileReturnRelativePath(FilePath path, byte[] data, String filename) {
        final String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR + File.separator
                + DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator
                + UUID.randomUUID().toString() + "_" + filename;

        String fileDiskPath = path.getAbsolutePath() + relativePath;
        saveFile(data, fileDiskPath);

        return relativePath.replaceAll("\\\\", "/");
    }

    private static void saveFile(byte[] data, String path) {
//        new Thread() {
//            public void run() {
        FileOutputStream writer = null;
        try {
            File file = new File(path);
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
            writer = new FileOutputStream(file);
            writer.write(data, 0, data.length);
            writer.flush();
            logger.info("Save file sucessfully, path: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                    data = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
//            }
//        }.start();
    }

    /**
     * 获得指定文件的byte数组
     */
    public static byte[] getBytes(String filePath) throws IOException {
        FileChannel fc = new RandomAccessFile(filePath, "r").getChannel();
        MappedByteBuffer byteBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0,
                fc.size()).load();
        byte[] result = new byte[(int) fc.size()];
        if (byteBuffer.remaining() > 0) {
            byteBuffer.get(result, 0, byteBuffer.remaining());
        }
        fc.close();
        return result;
    }
}
