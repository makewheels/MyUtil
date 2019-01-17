package util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 * 
 * @author Administrator
 *
 */
public class TimeUtil {

	/**
	 * 当前日期
	 * 
	 * @return
	 */
	public static String getDate() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return dateTimeFormatter.format(localDateTime);
	}

	/**
	 * 当前时间
	 * 
	 * @return
	 */
	public static String getTime() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return dateTimeFormatter.format(localDateTime);
	}

	/**
	 * 文件名能用的时间名
	 * 
	 * @return
	 */
	public static String getFilenameTime() {
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss.SSS");
		return dateTimeFormatter.format(localDateTime);
	}

	/**
	 * 程序结束，输出耗时
	 * 
	 * @param startTimeMillis
	 *            开始时间戳
	 */
	public static void printCostTime(long startTimeMillis) {
		long cost = System.currentTimeMillis() - startTimeMillis;
		System.out.println("done cost: " + cost);
	}
}
