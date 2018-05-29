package com.mry.util;

public enum ImageType {
	JPG("jpg", "FFD8FF"), //
	JPEG("jpeg", "FFD8FF"), //
	PNG("png", "89504E47"), //
	GIF("gif", "47494638"), //
	BMP("bmp", "424D"),//
	NULL("","");//

	private String type;
	private String magicCode;

	private ImageType(String type, String magicCode) {
		this.type = type;
		this.magicCode = magicCode;
	}

	public String getType() {
		return type;
	}

	public String getSuffix() {
		if(type.length() == 0){
			return type;
		}
		return "." + type;
	}

	public static ImageType fromMagicCode(String magicCode) {
		ImageType[] types = ImageType.values();
		for (ImageType t : types) {
			if (t.magicCode.equalsIgnoreCase(magicCode)) {
				return t;
			}
		}
		return null;
	}

	public static ImageType fromType(String type) {
		ImageType[] types = ImageType.values();
		for (ImageType t : types) {
			if (t.type.equalsIgnoreCase(type)) {
				return t;
			}
		}
		return null;
	}
}