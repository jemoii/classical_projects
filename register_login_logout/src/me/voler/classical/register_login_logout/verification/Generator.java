package me.voler.classical.register_login_logout.verification;

import java.util.Random;

public class Generator {
	final static int COUNT = 6;

	public static String code() {

		char[] digits = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
				'K', 'L', 'M', 'N', '0', '1', '2', '3', '4', '5', '6', '7',
				'8', '9', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
				'y', 'z', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
				'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
				'k', 'l', 'm', 'n' };

		String code = "";
		Random random = new Random();

		for (int i = 0; i < COUNT; i++)
			code += digits[random.nextInt(62)];

		return code;
	}
}