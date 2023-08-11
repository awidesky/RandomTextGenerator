package io.github.awidesky.randomTextGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.SecureRandom;

class Test {
	
	private static final int LEN = 50;

	@org.junit.jupiter.api.Test
	void checkRandomStringLength() {
		RandomTextGenerator rt = new RandomTextGenerator(UnicodeLanguage.ENGLISH, UnicodeLanguage.NUMERIC, UnicodeLanguage.ASCII_PUNCTUATION_SYMBOL);
		String s = rt.randomString(LEN);
		System.out.println("randomString(" + LEN + ") : \"" + s + "\"");
		assertEquals(LEN, s.length());
	}
	@org.junit.jupiter.api.Test
	void checkEvenlyDistributedRandomStringLength() {
		RandomTextGenerator rt = new RandomTextGenerator(UnicodeLanguage.ENGLISH, UnicodeLanguage.NUMERIC, UnicodeLanguage.ASCII_PUNCTUATION_SYMBOL, UnicodeLanguage.KOREAN);
		String s = rt.evenlyDistributedRandomString(LEN);
		System.out.println("evenlyDistributedRandomString(" + LEN + ") : \"" + s + "\"");
		assertEquals(LEN, s.length());
	}
	
	@org.junit.jupiter.api.Test
	void checkSecureRandomStringLength() {
		RandomTextGenerator rt = new RandomTextGenerator(new SecureRandom(), UnicodeLanguage.ENGLISH, UnicodeLanguage.NUMERIC, UnicodeLanguage.ASCII_PUNCTUATION_SYMBOL);
		String s = rt.randomString(LEN);
		System.out.println("randomString(" + LEN + ") : \"" + s + "\"");
		assertEquals(LEN, s.length());
	}
	@org.junit.jupiter.api.Test
	void checkEvenlyDistributedSecureRandomStringLength() {
		RandomTextGenerator rt = new RandomTextGenerator(new SecureRandom(), UnicodeLanguage.ENGLISH, UnicodeLanguage.NUMERIC, UnicodeLanguage.ASCII_PUNCTUATION_SYMBOL, UnicodeLanguage.KOREAN);
		String s = rt.evenlyDistributedRandomString(LEN);
		System.out.println("evenlyDistributedRandomString(" + LEN + ") : \"" + s + "\"");
		assertEquals(LEN, s.length());
	}

}
