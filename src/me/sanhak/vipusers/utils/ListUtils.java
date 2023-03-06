package me.sanhak.vipusers.utils;

import java.util.List;

public class ListUtils {

	public static String toString(List<String> stringList) {
		String result = "";
		if (stringList != null) {
			for (String lines : stringList) {
				lines += "\n";
				result += lines;
			}
		}
		return result;
	}
}
