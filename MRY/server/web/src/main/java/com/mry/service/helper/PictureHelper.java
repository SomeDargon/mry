package com.mry.service.helper;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import com.mry.util.ImageType;
import com.mry.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PictureHelper {
	private static final Logger logger = LoggerFactory
			.getLogger(PictureHelper.class);

	// format:/pics/business/images
	private static final String DEFAULT_WEB_IMAGE_STORE_DIR = File.separator
			+ "pics" + File.separator + "business" + File.separator + "images";
	
	private static final String DEFAULT_WEB_PDF_STORE_DIR = File.separator
			+ "pics" + File.separator + "business" + File.separator + "pdfs";

	private static final DateTimeFormatter DATE_PATH_FORMATER = DateTimeFormatter
			.ofPattern("yyyy" + File.separator + "MM");
	

	public static String savePic(FilePath path, byte[] data, PicProcessType type) {
		ImageType imageType = ImageUtil.getImageType(data);
		if (imageType == null) {
			logger.info("Received pic binary data is not an image.");
			//return null;
			imageType = ImageType.NULL;
		}

		final String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR
				+ File.separator + type.name().toLowerCase() + File.separator
				+ DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator
				+ UUID.randomUUID().toString() + imageType.getSuffix();

		String fileDiskPath = path.getAbsolutePath() + relativePath;
		persistImage(data, type, imageType, fileDiskPath);

		return path.getHost() + relativePath.replaceAll("\\\\", "/");
	}
	
	public static String[] getPicPath(FilePath path, PicProcessType type) {

		final String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR
				+ File.separator + type.name().toLowerCase() + File.separator
				+ DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator
				+ UUID.randomUUID().toString() + ".jpg";

		String fileDiskPath = path.getAbsolutePath() + relativePath;
		String[] str = new String[2];
		str[0] = fileDiskPath;
		str[1] = path.getHost() + relativePath.replaceAll("\\\\", "/");
		return str;
	}
	
	public static String[] getPdfPath(FilePath path, PicProcessType type) {

		final String relativePath = DEFAULT_WEB_PDF_STORE_DIR
				+ File.separator + type.name().toLowerCase() + File.separator
				+ DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator
				+ UUID.randomUUID().toString() + ".pdf";

		String fileDiskPath = path.getAbsolutePath() + relativePath;
		String[] str = new String[3];
		str[0] = fileDiskPath;
		str[1] = path.getHost() + relativePath.replaceAll("\\\\", "/");
		str[2] = path.getAbsolutePath()+DEFAULT_WEB_PDF_STORE_DIR
				+ File.separator + type.name().toLowerCase() + File.separator
				+ DATE_PATH_FORMATER.format(LocalDate.now()) + File.separator;
		File pdfdir = new File(str[2]);
		if(!pdfdir.exists()){
			pdfdir.mkdirs();
		}
		return str;
	}
	
	public static String[] getPicPathForCusMainPag(FilePath path, PicProcessType type,Long cusid,String testType) {

		final String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR
				+ File.separator + type.name().toLowerCase() + File.separator
				+ cusid.toString()+testType + ".jpg";

		String fileDiskPath = path.getAbsolutePath() + relativePath;
		String[] str = new String[2];
		str[0] = fileDiskPath;
		str[1] = path.getHost() + relativePath.replaceAll("\\\\", "/");
		return str;
	}
	
//	public static String saveDefaultPic(FilePath path,Gender gender) {
//
//		String relativePath = DEFAULT_WEB_IMAGE_STORE_DIR
//				+ File.separator+"default"+File.separator;
//		if(gender.equals(Gender.MALE)){
//			relativePath = relativePath + "male.png";
//		}else{
//			relativePath = relativePath + "female.png";
//		}
//
//		return path.getHost() + relativePath.replaceAll("\\\\", "/");
//	}

	private static void persistImage(byte[] data, PicProcessType type,
			ImageType imageType, String path) {
		new Thread() {
			public void run() {
				byte[] imageData = data;
				if (PicProcessType.ICON.equals(type)) {
					byte[] tmp = ImageUtil.processIconToSquare(imageData,
							imageType.getType());
					if (tmp != null) {
						imageData = tmp;
					}
				} else if (PicProcessType.BUSINESS.equals(type)) {
					byte[] tmp = ImageUtil.zoomImageForSystemWith(imageData,
							imageType.getType());
					if (tmp != null) {
						imageData = tmp;
					}
				}else if (PicProcessType.THUMBNAIL.equals(type)) {
					byte[] tmp = ImageUtil.createThumbnail(imageData,
							imageType.getType());
					if (tmp != null) {
						imageData = tmp;
					}
				}

				logger.info("Picture path: " + path);
				ImageUtil.saveImage(imageData, path);
			}
		}.start();
	}
}
