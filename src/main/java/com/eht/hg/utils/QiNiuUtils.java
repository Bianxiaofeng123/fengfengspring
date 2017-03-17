package com.eht.hg.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.eht.hg.Constants;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

public class QiNiuUtils {

	// 设置好账号的ACCESS_KEY和SECRET_KEY
	// 创建上传对象
	static UploadManager uploadManager = new UploadManager();

	// 密钥配置
	final static Auth auth = Auth.create(Constants.ACCESS_KEY, Constants.SECRET_KEY);

	// 简单上传，使用默认策略，只需要设置上传的空间名就可以了
	private static String getUpToken(String bucketname) {
		return auth.uploadToken(bucketname);
		// (bucket, key) 覆盖上传
	}

	/*
	 * @param file 文件
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间
	 */
	private static String upload(File file, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			if (isNeedCrc32) {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname), null,
						null, true);
			} else {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname));
			}
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}
	
	

	/*
	 * @param byte[]
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间
	 */
	private static String upload(byte[] file, boolean isUpload2Private, boolean isNeedCrc32) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			if (isNeedCrc32) {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname), null,
						null, true);
			} else {
				res = uploadManager.put(file, null,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname));
			}
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}

	private static boolean checkFileLenth(File file) throws IOException {
		if (file.length() > Constants.checkFileLong) {
			throw new IOException("文件不得大于2m");
		}
		return true;
	}

	private static boolean checkFileLenth(byte[] file) throws IOException {
		if (file.length > Constants.checkFileLong) {
			throw new IOException("文件不得大于2m");
		}
		return true;
	}

	/**
	 * 上传至公共空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPublic(File file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}

	/**
	 * 上传至私有空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPrivate(File file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, true, isNeedCrc32);
	}

	/**
	 * 上传至公共空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPublic(byte[] file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, false, isNeedCrc32);
	}
	
	/**
	 * 上传至私有空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String uploadPrivate(byte[] file, boolean isNeedCrc32) throws Exception {
		checkFileLenth(file);
		return upload(file, true, isNeedCrc32);
	}
	

	/**
	 * 上传至私有空间
	 * 
	 * @param file
	 * @param isNeedCrc32
	 *            是否需要文件验证<由七牛服务器进行验证>
	 * @return file key
	 */
	public static String qhuploadPrivate(File file, boolean isNeedCrc32, String flieName) throws Exception {
		checkFileLenth(file);
		return upload(file, true, isNeedCrc32, flieName);
	}
	
	/**
	 * @param file 文件
	 * 
	 * @param isUpload2Private 是否需要上传至私有空间
	 */
	private static String upload(File file, boolean isUpload2Private, boolean isNeedCrc32 ,String flieName) throws Exception {
		try {
			Response res = null;
			// 调用put方法上传
			if (isNeedCrc32) {
				res = uploadManager.put(file, flieName,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname), null,
						null, true);
			} else {
				res = uploadManager.put(file, flieName,
						getUpToken(isUpload2Private ? Constants.privateBucketname : Constants.publicBucketname));
			}
			return res.bodyString();
		} catch (QiniuException e) {
			Response r = e.response;
			throw new QiniuException(r);
		}
	}
	
	/**
	 * 获取私有图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPrivateFilePath(String key, long invalidSec) throws Exception {
		return auth.privateDownloadUrl(Constants.privateUrl + "/" + key, invalidSec);
	}

	/**
	 * 获取私有图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPrivateFilePath(String key) throws Exception {
		return auth.privateDownloadUrl(Constants.privateUrl + "/" + key, Constants.tokenFailedSec);
	}

	/**
	 * 获取public图片
	 * 
	 * @param key
	 *            文件key
	 * @param invalidSec
	 *            失效时间(秒)
	 * @return url
	 */
	public static String getPublicPath(String key) throws Exception {
		return Constants.publicUrl + "/" + key;
	}

	/**
	 * 根据string 获取key值
	 * 
	 * @param str:
	 *            "{\"hash\":\"FoS4hOJm5EZSEXHaPuUs7HF8o4-g\",\"key\":\"FoS4hOJm5EZSEXHaPuUs7HF8o4-g\"}"
	 * @param key:
	 *            hash
	 * @return FoS4hOJm5EZSEXHaPuUs7HF8o4-g
	 */
	public static String getValByKey4Str(String str, String key) throws Exception {
		Map<String, String> map = new Gson().fromJson(str, HashMap.class);
		return map.get(key);
	}
	
	public static void main(String[] args) {
		try {
//			System.out.println(uploadPublic(new File("C:/Users/Administrator/Desktop/V60429-170742.mp4"), false));
//			System.out.println(getPrivateFilePath("Fkq6SDqV0sJEYfuUW_QJTpC2IbCc"));
//			for(int i = 0; i < 10000; i++)
//			System.out.println(Base64.encodeBase64(UUID.randomUUID().toString().getBytes()).toString());
//			System.out.println(getPrivateFilePath("FpAXlVKStFihyjEg12Xig8wYeYb4"));
//			String en = URLEncoder.encode("http://www.mewechat.net/main.html?urlCode=link1&orduuid=A887A38AFBD74E339140380CA37F3181", "utf-8");
//			String de = URLDecoder.decode(en, "utf-8");
//			System.out.println(en);
//			System.out.println(de);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
