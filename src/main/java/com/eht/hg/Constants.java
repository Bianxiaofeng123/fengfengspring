package com.eht.hg;

public class Constants {
	//-------------------------------------七牛云储存-------------------------------------
	//AK
	final static public String ACCESS_KEY = "oeBTarE2Eg6v5cTY3EJES1Z05E0HYNquq0u--Fgm";
	//SK
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
	//-------------------------------------七牛云储存-------------------------------------
}
