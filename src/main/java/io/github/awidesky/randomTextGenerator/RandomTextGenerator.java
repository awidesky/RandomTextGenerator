package io.github.awidesky.randomTextGenerator;

import java.util.Arrays;
import java.util.Random;

public class RandomTextGenerator {

	private final UnicodeLanguage[] ranges;
	
	public RandomTextGenerator(UnicodeLanguage... availableRanges) {
		ranges = availableRanges;
	}
	
	public String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		new Random().ints(0, 1114111).filter(i -> Arrays.stream(ranges).anyMatch(u -> u.test(i))).limit(len).mapToObj(Character::toChars).forEach(sb::append);
		return sb.toString();
	}
	
	public String evenlyDistributedRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		new Random().ints(len, 0, Integer.MAX_VALUE).map(i -> i % ranges.length).flatMap(i -> 
			new Random().ints(0, 1114111).filter(j -> ranges[i].test(j)).limit(1)
		).mapToObj(Character::toChars).forEach(sb::append);
		return sb.toString();
	}

}
