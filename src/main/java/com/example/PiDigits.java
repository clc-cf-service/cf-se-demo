package com.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PiDigits {
	private static final int SCALE = 10000;
	private static final int ARRINIT = 2000;

	public static String pi_digits(int digits){
		short logIn = 20;
		StringBuffer pi = new StringBuffer();
		int[] arr = new int[digits + 1];
		int carry = 0;

		for (int i = 0; i <= digits; ++i)
			arr[i] = ARRINIT;

		for (int i = digits; i > 0; i-= 14) {
			if (logIn-- == 0) {
				logIn = 20;
				log.info("We're at iteration " + i);
			}

			int sum = 0;
			for (int j = i; j > 0; --j) {
				sum = sum * j + SCALE * arr[j];
				arr[j] = sum % (j * 2 - 1);
				sum /= j * 2 - 1;
			}

			pi.append(String.format("%04d", carry + sum / SCALE));
			carry = sum % SCALE;
		}
		return pi.toString();
	}
}
