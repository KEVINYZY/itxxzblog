package com.itxxz.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
/**
 * ʱ������ת��
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��7�� ����1:20:20
 */
public class StringToDateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = dateTimeFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
