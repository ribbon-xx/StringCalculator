package com.qsoft.longdt;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public static int add(String input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.length() < 2 && checkInt(input)) {
			return toInt(input);
		} else {
			List<Integer> intList = new ArrayList<Integer>();
			intList = toListInt(input);
			int sum = 0;
			for (Integer integer : intList) {
				sum += integer;
			}
			return sum;
		}
	}

	private static boolean checkInt(String input) {
		try {
			Integer.parseInt(input.trim());
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	private static int toInt(String input) {
		return Integer.parseInt(String.valueOf(input));
	}

	private static List<Integer> toListInt(String input) {
		int[] ascii = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57 };
		List<Integer> intList = new ArrayList<Integer>();
		for (char ch : input.toCharArray()) {
			for (int num : ascii)
				if ((int) ch == num) {
					intList.add(toInt(String.valueOf(ch)));
				}
		}
		return intList;
	}
}
