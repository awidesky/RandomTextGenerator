package io.github.awidesky.randomTextGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
