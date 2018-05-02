package com.snehal.me;

public class Testing {

	public static boolean isEmpty(int b, int r, int g, int y) {
		if (b == 0 && r == 0 && g == 0 && y == 0)
			return true;
		return false;
	}

	public static int max(int a, int b) {
		if (a > b)
			return a;
		return b;
	}

	public static int getMaxLength(int b, int r, int g, int y, char curr) {

		if (isEmpty(b, r, g, y))
			return 0;

		if (curr == 'B' || curr == 'Y') {
			if (b == 0 && r == 0)
				return 0;
			else if (b != 0 && r != 0)
				return max(1 + getMaxLength(b - 1, r, g, y, 'B'), 1 + getMaxLength(b, r - 1, g, y, 'R'));
			else if (b == 0)
				return 1 + getMaxLength(b, r - 1, g, y, 'R');
			else
				return 1 + getMaxLength(b - 1, r, g, y, 'B');
		} else {
			if (g == 0 && y == 0)
				return 0;
			else if (g != 0 && y != 0)
				return max(1 + getMaxLength(b, r, g - 1, y, 'G'), 1 + getMaxLength(b, r, g, y - 1, 'Y'));
			else if (g == 0)
				return 1 + getMaxLength(b, r, g, y - 1, 'Y');
			else
				return 1 + getMaxLength(b, r, g - 1, y, 'G');
		}

	}

	public static void main(String[] args) {

		int result;
		int b = 2, r = 1, g = 0, y = 1;

		if (b != 0 && r != 0)
			result = max(getMaxLength(b, r, g, y, 'B'), getMaxLength(b, r, g, y, 'R'));
		else if (b != 0 && r == 0)
			result = getMaxLength(b, r, g, y, 'B');
		else if (b == 0 && r != 0)
			result = getMaxLength(b, r, g, y, 'R');
		else if (y != 0 || g != 0)
			result = max(getMaxLength(b, r, g, y, 'Y'), getMaxLength(b, r, g, y, 'G'));
		else
			result = 0;

		System.out.println(result);

	}

}

