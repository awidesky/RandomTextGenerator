package io.github.awidesky.randomTextGenerator;

import java.util.Arrays;
import java.util.function.Predicate;

public class UnicodeLanguage implements Predicate<Integer> {

	//TODO : Better Test method..?
	public static final UnicodeLanguage NUMERIC = new UnicodeLanguage(48, 57);
	public static final UnicodeLanguage ENGLISH = new UnicodeLanguage(new Range(65, 90), new Range(97, 122));
	public static final UnicodeLanguage ASCII_PUNCTUATION_SYMBOL = new UnicodeLanguage(new Range(33, 47), new Range(58, 64), new Range(91, 96), new Range(123, 126));
	public static final UnicodeLanguage KOREAN = new UnicodeLanguage(new Range(44032, 55203));
	
	private final Range[] rangeArr;

	/**
	 * Both parameters are <i>inclusive</i>.
	 * */
	public UnicodeLanguage(int unicodePointStart, int unicodePointLast) {
		rangeArr = new Range[] {new Range(unicodePointStart, unicodePointLast)};
	}
	public UnicodeLanguage(Range... ranges) {
		rangeArr = ranges;
	}

	@Override
	public boolean test(Integer t) {
		return Arrays.stream(rangeArr).anyMatch(r -> r.check(t));
	}
	
	public static class Range {
		public final int unicodePointStart;
		public final int unicodePointLast;
		
		/**
		 * Both parameters are <i>inclusive</i>.
		 * */
		public Range(int unicodePointStart, int unicodePointLast) {
			this.unicodePointStart = unicodePointStart;
			this.unicodePointLast = unicodePointLast;
		}

		public boolean check(int t) {
			return unicodePointStart <= t && t <= unicodePointLast;
		}
	}
}
