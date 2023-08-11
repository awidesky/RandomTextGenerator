package io.github.awidesky.randomTextGenerator;

import java.util.Arrays;
import java.util.function.IntPredicate;

/**
 * Represent set of unicode characters (languages, symbols, etc...).
 * If needed unicode characters are not in static fields, you can create one.
 * <a href="https://en.wikipedia.org/wiki/List_of_Unicode_characters">https://en.wikipedia.org/wiki/List_of_Unicode_characters</a> 
 * */
public class UnicodeLanguage implements IntPredicate {

	/** ASCII numeric characters(0~9) */
	public static final UnicodeLanguage NUMERIC = new UnicodeLanguage(48, 57);
	/** ASCII English alphabets(both lower case and upper case) */
	public static final UnicodeLanguage ENGLISH = new UnicodeLanguage(new Range(65, 90), new Range(97, 122));
	/** ASCII punctuation and symbols */
	public static final UnicodeLanguage ASCII_PUNCTUATION_SYMBOL = new UnicodeLanguage(new Range(33, 47), new Range(58, 64), new Range(91, 96), new Range(123, 126));
	/** Unicode Korean (한글 소리 마디/Hangul Syllables) */
	public static final UnicodeLanguage KOREAN = new UnicodeLanguage(44032, 55203);
	/** Unicode Japanese (Hiragana & Katakana) */
	public static final UnicodeLanguage JAPANESE = new UnicodeLanguage(new Range(0x3040, 0x309f), new Range(0x30a0, 0x30ff));
	/** Unicode Chinese (CJK Unified Ideographs(common)) */
	public static final UnicodeLanguage CHINESE = new UnicodeLanguage(0x4e00, 0x9fff);
	/** Unicode Arabic */
	public static final UnicodeLanguage CYRILLIC = new UnicodeLanguage(0x400, 0x4ff);
	/** Unicode Thai */
	public static final UnicodeLanguage THAI = new UnicodeLanguage(0xe00, 0xe7f);
	
	private final Range[] rangeArr;

	/**
	 * Creates an set of unicode characters.
	 * unicode characters whose code point is between {@code unicodePointStart} and {@code unicodePointLast} are included.
	 * 
	 * @param unicodePointStart <i>inclusive</i>
	 * @param unicodePointLast <i>inclusive</i>
	 * */
	public UnicodeLanguage(int unicodePointStart, int unicodePointLast) {
		rangeArr = new Range[] {new Range(unicodePointStart, unicodePointLast)};
	}
	/**
	 * Creates an set of unicode characters.
	 * unicode characters whose code point is in given {@code Range} are included.
	 */
	public UnicodeLanguage(Range... ranges) {
		rangeArr = ranges;
	}

	/** Test if given unicode code point is included in this {@code UnicodeLanguage} instance. */
	@Override
	public boolean test(int t) {
		return Arrays.stream(rangeArr).anyMatch(r -> r.check(t));
	}
	
	public static class Range {
		public final int unicodePointStart;
		public final int unicodePointLast;
		
		/**
		 * @param unicodePointStart <i>inclusive</i>
		 * @param unicodePointLast  <i>inclusive</i>
		 */
		public Range(int unicodePointStart, int unicodePointLast) {
			this.unicodePointStart = unicodePointStart;
			this.unicodePointLast = unicodePointLast;
		}

		public boolean check(int t) {
			return unicodePointStart <= t && t <= unicodePointLast;
		}
	}
}
