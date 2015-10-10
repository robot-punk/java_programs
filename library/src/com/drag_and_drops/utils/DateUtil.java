package com.drag_and_drops.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日付ユーティリティ
 *
 * @author takashi-okumura
 *
 */
public final class DateUtil {
	/**
	 * 日付文字列を解析する.
	 *
	 * @param fmt
	 *            日付書式
	 * @param value
	 *            日付文字列
	 * @return 解析された日付
	 * @throws ParseException
	 */
	public static Date parseDate(String fmt, String value) throws ParseException {
		DateFormat df = new SimpleDateFormat(fmt);
		return df.parse(value);
	}

	/**
	 * 指定された日付の曜日名を取得する
	 *
	 * @param date
	 *            日付
	 * @return 曜日文字列。null の場合は空文字を返す。
	 */
	public static String getDayOfWeek(Date date) {
		if (date == null) {
			return "";
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY:
			return ResourceUtil.getPropertyValue("sun");
		case Calendar.MONDAY:
			return ResourceUtil.getPropertyValue("mon");
		case Calendar.TUESDAY:
			return ResourceUtil.getPropertyValue("tue");
		case Calendar.WEDNESDAY:
			return ResourceUtil.getPropertyValue("wed");
		case Calendar.THURSDAY:
			return ResourceUtil.getPropertyValue("thu");
		case Calendar.FRIDAY:
			return ResourceUtil.getPropertyValue("fri");
		case Calendar.SATURDAY:
			return ResourceUtil.getPropertyValue("sat");
		default:
			return "";
		}
	}

}
