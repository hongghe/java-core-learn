package org.javacore.io.byteoper;

/**
 * @author Jeff Lee
 * @since 2015-6-19 21:26:04
 * 	Long与byte数组转换
 * 	与Int相似，不过long占八个字节，所以要一个长度为8的byte数组
 */
public class LongConvertT {

	/**
	 * long 转 byte数组
	 */
	public static byte[] long2Bytes(long longa){
		byte[] bytes = new byte[8];
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte)(long)(((longa) >> i * 8) & 0xff); // 移位和清零

		return bytes;
	}

	/**
	 * byte数组 转 long
	 */
	public static long bytes2Long(byte[] bytes){
		long longa = 0;
		for (int i = 0; i < bytes.length; i++)
			longa += (long)((bytes[i] & 0xff) << i * 8); // 移位和清零

		return longa;
	}
}
