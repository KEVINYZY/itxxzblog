package com.itxxz.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringTokenizerUtils {
	
	/**
	 * �ַ����ָ����
	 * 
	 * 
	 * @author: ITѧϰ��-�з
	 * 
	 * @���� www.itxxz.com
	 * 
	 * @version: 2015��3��6�� ����3:13:42
	 */
	@SuppressWarnings("all")
	public static String[] split(String str,String seperators) {
		StringTokenizer tokenlizer = new StringTokenizer(str,seperators);
		List result = new ArrayList();
		
		while(tokenlizer.hasMoreElements()) {
			Object s = tokenlizer.nextElement();
			result.add(s);
		}
		return (String[])result.toArray(new String[result.size()]);
	}
	
}
