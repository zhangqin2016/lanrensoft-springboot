package com.lanrensoft.generator.auto.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.util.DigestUtils;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 
* @ClassName: FileTool 
* @Description:文件读写
* @author zhangqin
* @date 2016年4月5日 上午11:08:22 
*
 */
public class FileTool {

	public static String readAll(String fileName) throws IOException {
		return readAll(fileName, "UTF-8");
	}

	public static String readAll(String fileName, String encodeing)
			throws IOException {
		FileInputStream in = null;
		try {
			in = new FileInputStream(fileName);
			String res;
			int len = in.available();
			if (len > 0) {
				byte[] buf = new byte[len];
				in.read(buf, 0, len);
				res =new String(buf, encodeing);
			} else {
				res = null;
			}
			return res;
		} finally {
			try {
				if(in!=null) {
					in.close();
				}
			} catch (Exception e) {
			}
		}
	}

	public static boolean isUTF8File(String srcFileName) throws IOException {
		String fileContent = readAll(srcFileName);
		if (fileContent == null) {
			return true;
		}
		if (fileContent == null
				|| Charset.forName("UTF-8").newEncoder().canEncode(fileContent)) {
			return true;
		} else {
			return false;
		}
	}

	public static String getEncoding(String str) throws Exception {
		if (str == null) {
			return "";
		}
		String encode = "GB2312";
		try {
			if (Charset.forName("GB2312").newEncoder().canEncode(str)) {
				String s = encode;
				return s;
			}
		} catch (Exception exception) {
		}
		encode = "ISO-8859-1";
		try {
			if (Charset.forName("ISO-8859-1").newEncoder().canEncode(str)) {
				String s1 = encode;
				return s1;
			}
		} catch (Exception exception1) {
		}
		encode = "UTF-8";
		try {
			if (Charset.forName("UTF-8").newEncoder().canEncode(str)) {
				String s2 = encode;
				return s2;
			}
		} catch (Exception exception2) {
		}
		encode = "GBK";
		try {
			if (Charset.forName("GBK").newEncoder().canEncode(str)) {
				String s3 = encode;
				return s3;
			}
		} catch (Exception exception3) {
		}
		return encode;
	}

	public static void write(String srcFileName, InputStream inputStream) throws IOException {
		FileOutputStream fos =null;
		try {
			fos = new FileOutputStream(srcFileName);
			byte[] read = new byte[1024];
			int len = 0;
			while((len = inputStream.read(read))!= -1){
				fos.write(read,0,len);
			}
			fos.flush();
		}finally {
			try {
			if(fos!=null) {
				fos.close();
			}
			inputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public static void write(String srcFileName, String fileContent,
			String encodeing) throws IOException {
		BufferedWriter bf = null;
		FileOutputStream fileOutputStream =new FileOutputStream(srcFileName);
		try {
			bf = new BufferedWriter(new OutputStreamWriter(fileOutputStream, encodeing));
			String[] ss = fileContent.split("__eol__");
			for (int i = 0; i < ss.length; i++) {
				bf.write(ss[i]);
				if (i != ss.length - 1) {
					bf.newLine();
				}
			}

			bf.flush();
		} finally {
			if (bf != null) {
				try {
					bf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(fileOutputStream!=null){
				fileOutputStream.close();
			}
		}
	}

	public static void write(String srcFileName, String fileContent)
			throws IOException {
		write(srcFileName, fileContent, "UTF8");
	}
	/**
	 * 递归得到指定路径下的指定格式的文件如：xxx.xml那么type就是xml
	 */

	public static List<File> getAllFile(File file, String type) {
		List<File> list = new ArrayList<File>();
		if (file.exists()) {
			if (file.isFile()) {
				return null;
			} else {
				recursionFiles(file, list, type);
			}
		}

		return list;

	}

	public static List<File> getAllFile(File file) {
		List<File> list = new ArrayList<File>();
		if (file.exists()) {
			if (file.isFile()) {
				return null;
			} else {
				recursionFiles(file, list, "");
			}
		}
		return list;

	}

	private static List<File> recursionFiles(File file, List<File> lf,
			String type) {
		File[] files = file.listFiles();
		for (File file2 : files) {
			if (file2.isFile()) {
				if (type.equals("")) {
					lf.add(file2);
				} else {
					if (file2.getName().endsWith("." + type)) {
						lf.add(file2);
					}
				}
			} else {
				recursionFiles(file2, lf, type);
			}
		}
		return lf;

	}

	public static void deleteFile(File file) {
		if (file.exists()) {
			if (file.isFile()) {
				file.delete();
			} else if (file.isDirectory()) {
				File file2[] = file.listFiles();
				for (File file3 : file2) {
					deleteFile(file3);
				}

			}
		}
		file.delete();
	}
	
	/**
	 * 获取文件后缀名
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		if(fileName==null){
			return "";
		}
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	/**
	 * 下载创建文件
	 * @param dir
	 * @param url
	 * @param name
	 */
	public static void create(String dir,String url ,String name){
		HttpURLConnection conn=null;
		InputStream inputStream=null;
		FileOutputStream fops=null;
			try {
				URL url2=new URL(url);
				conn = (HttpURLConnection)url2.openConnection();  
				conn.setRequestMethod("GET");  
				conn.setConnectTimeout(5 * 1000);
				inputStream = conn.getInputStream();
				ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
				byte[] buffer = new byte[1024];  
				int len = 0;  
				while( (len=inputStream.read(buffer)) != -1 ){  
					outStream.write(buffer, 0, len);  
				}  
				byte[] btImg=outStream.toByteArray();
				File file = new File(dir);  
				if(!file.exists()){
					file.mkdirs();
				}
				File file2 = new File(dir+name); 
				file2.createNewFile();
				fops = new FileOutputStream(file2);
				fops.write(btImg);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					if(inputStream!=null){
					inputStream.close();
					}
					if(fops!=null){
						fops.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}  
				

			}
	}

	public static String getMd5ByFile(File file) throws FileNotFoundException {
		String value = null;
		FileInputStream in = new FileInputStream(file);
		try {
			MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(byteBuffer);
			BigInteger bi = new BigInteger(1, md5.digest());
			value = bi.toString(16);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(null != in) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}

}
