package util;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

import org.apache.commons.io.IOUtils;

/**
 * 文件工具类
 * 
 * @author Administrator
 *
 */
public class FileUtil {

	/**
	 * 保存字符串到文件
	 * 
	 * @param folder
	 * @param filename
	 * @param content
	 */
	public static void saveTextToFile(String folder, String filename, String content) {
		FileOutputStream fop = null;
		File file;
		try {
			file = new File(folder + File.separator + filename);
			fop = new FileOutputStream(file);
			if (!file.exists()) {
				file.createNewFile();
			}
			byte[] contentInBytes = content.getBytes();
			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fop.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读文本文件
	 * 
	 * @param filepath
	 * @return
	 */
	public static String readTextFile(String filepath) {
		StringBuilder stringBuilder = new StringBuilder();
		String line = "";
		try {
			InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			line = bufferedReader.readLine();
			while (line != null) {
				stringBuilder.append(line + "\n");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	/**
	 * 从网上下载文件，保存到本地
	 * 
	 * @param url
	 * @param folder
	 * @param filename
	 */
	public static void downloadFile(String url, String folder, String filename) {
		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setConnectTimeout(10000);
			connection.setRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.59 Safari/537.36");
			InputStream inputStream = connection.getInputStream();
			FileOutputStream fileOutputStream = new FileOutputStream(folder + File.separator + filename);
			IOUtils.copy(inputStream, fileOutputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		downloadFile(
				"http://img.alicdn.com/imgextra/i1/2451699564/TB1d3JMasyYBuNkSnfoXXcWgVXa_!!0-item_pic.jpg_600x600.jpg",
				"C:\\Users\\Administrator\\Desktop", "1.jpg");
	}

	/**
	 * 文件大小
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileSize(File file) {
		long length = file.length();
		final String[] units = new String[] { "B", "KB", "MB", "GB", "TB" };
		int digitGroups = (int) (Math.log10(length) / Math.log10(1024));
		return new DecimalFormat("#,##0.#").format(length / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}

}
