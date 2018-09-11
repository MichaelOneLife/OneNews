package com.oneinc.onenews.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil {

	/**
     * 生成32位md5码
     * @param param 需要转码的字符串
     * @return
	 * @throws NoSuchAlgorithmException 
     */
    public static String md5(String param) throws NoSuchAlgorithmException {
        // 得到一个信息摘要器
        MessageDigest digest = MessageDigest.getInstance("md5");
        byte[] result = digest.digest(param.getBytes());
        StringBuffer buffer = new StringBuffer();
        // 把每一个byte 做一个与运算 0xff;
        for (byte b : result) {
            // 与运算
            int number = b & 0xff;// 加盐
            String str = Integer.toHexString(number);
            if (str.length() == 1) {
                buffer.append("0");
            }
            buffer.append(str);
        }

        // 标准的md5加密后的结果
        return buffer.toString();
    }
}
