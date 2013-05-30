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
		int i = 0;
		List<KeyValueObject> tempList = new ArrayList<KeyValueObject>();
		List<Integer> intList = new ArrayList<Integer>();
		char[] charArray = input.toCharArray();
		for (int j = 0; j < charArray.length; j++) {
			for (int num : ascii)
				if ((int) charArray[j] == num) {
					i++;
				} else {
					if (i > 0) {
						KeyValueObject obj = new KeyValueObject(j, i);
						tempList.add(obj);
					}
					i = 0;
				}
		}
		for (int k = 0; k < tempList.size(); k++) {
			KeyValueObject obj = tempList.get(k);
			String newNumberInStr = "";
			for (int l = obj.getKey(); l < (obj.getKey() + obj.getValue()); l++) {
				newNumberInStr += charArray[l];
			}
			if (toInt(newNumberInStr) < 1000)
				intList.add(toInt(newNumberInStr));
		}
		int num0 = intList.get(0);
		int num1 = intList.get(1);
		System.out.print(num0 + "-----" + num1);
		return intList;
	}

	public static void main(String[] args) {
		add("12, 1");
	}
}
