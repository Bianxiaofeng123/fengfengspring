package com.eht.hg;

public class Constants {
	// -------------------------------------七牛云储存-------------------------------------
	// AK
	final static public String ACCESS_KEY = "oeBTarE2Eg6v5cTY3EJES1Z05E0HYNquq0u--Fgm";
	// SK
	final static public String SECRET_KEY = "1LTeWOCE82D88SfO2uFRwGJ1q9HOOoDIN4j4NelJ";
	// 图片上传校验图片大小默认值 b （2m）
	final static public long checkFileLong = 1024 * 1024 * 2;
	// 私有图片获取过期默认时间（秒）
	final static public long tokenFailedSec = 3600;
	// 要上传的空间(公共空间)
	public static String publicBucketname = "fengfeng";
	// 公共url
	public static String publicUrl = "omy6bhj64.bkt.clouddn.com";
	// 私有空间
	public static String privateBucketname = "";
	// 私有url
	public static String privateUrl = "";
	// -------------------------------------七牛云储存-------------------------------------

	// -------------------------------------百度ocr--------------------------------------
	// APP_ID
	public static final String BAIDU_OCR_APP_ID = "9402809";
	// AK
	public static final String BAIDU_OCR_API_KEY = "svWDc1plyHgWlKD2MmGf9nG0";
	// SK
	public static final String BAIDU_OCR_SECRET_KEY = "39yfKa49bmMFyjPHxtZg4v95ygeny5C1";
	// AK_ID
	public static final String BAIDU_OCR_ACCESS_KEY_ID = "ef503624977f4a198a0e1b2e2c0b3c9e";
	//检测朝向
	public static final String BAIDU_OCR_DETECT_DIRECTION = "false";
	// 语言
	// - CHN_ENG：中英文混合；
	// - ENG：英文；
	// - POR：葡萄牙语；
	// - FRE：法语；
	// - GER：德语；
	// - ITA：意大利语；
	// - SPA：西班牙语；
	// - RUS：俄语；
	// - JAP：日语
	public static final String BAIDU_OCR_LANGUAGE_TYPE = "CHN_ENG";

	// -------------------------------------百度ocr--------------------------------------
}
