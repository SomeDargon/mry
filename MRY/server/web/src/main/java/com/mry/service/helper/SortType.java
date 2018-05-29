package com.mry.service.helper;

public enum SortType {
	DESC, ASC;

	public static SortType fromIntWithDafaultDESC(Integer i) {
		if (i == null) {
			return DESC;
		} else {
			return i == 0 ? ASC : DESC;
		}
	}
}
