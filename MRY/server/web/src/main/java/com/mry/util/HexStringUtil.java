package com.mry.util;

/**
 * @author vito
 * @version 1.0
 * 创建时间 2016/6/5 14:09
 */
public class HexStringUtil {

    /**
     * 16进制字符串转byte[]
     * @param data
     * @return
     */
    public static byte[] hexStringToByteArray(String data) {
        int lenth = data.length() / 2;
        byte[] res = new byte[lenth];
        for (int i = 0; i < lenth; i++) {
            int pos = i * 2;
            res[i] = (byte) (hexCharToByte(data.charAt(pos)) << 4 | hexCharToByte(data.charAt(pos + 1)));
        }
        return res;
    }

    /**
     * 16进制字符转byte
     * @param data
     * @return
     */
    public static byte hexCharToByte(char data) {
        return (byte) "0123456789ABCDEF".indexOf(data);
    }

    /**
     * byte[]转16进制字符串
     * @param data
     * @return
     */
    public static String byteArrayToHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            String hex = Integer.toHexString(data[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}
