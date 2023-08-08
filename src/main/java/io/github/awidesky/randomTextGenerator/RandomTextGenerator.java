package io.github.awidesky.randomTextGenerator;

import java.util.Arrays;
import java.util.Random;

/**
 * A Random text generator.
 * */
public class RandomTextGenerator {

	private final UnicodeLanguage[] ranges;
	
	//TODO : create with given random generatorS
	/**
	 * Creates a random text generator that uses given languages.
	 * */
	public RandomTextGenerator(UnicodeLanguage... launguages) {
		ranges = launguages;
	}
	
	/**
	 * Generates a random {@code String} in given length.
	 * Each candidate character has same possibility of occurrence.
	 * So if one of the selected language(like Korean, Chinese, etc..) has way more characters than the others(like English),
	 * characters of the language will occur in result text way more than characters of other languages.
	 * */
	public String randomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		new Random().ints(0, 1114111).filter(i -> Arrays.stream(ranges).anyMatch(u -> u.test(i))).limit(len).mapToObj(Character::toChars).forEach(sb::append);
		return sb.toString();
	}
	
	/**
	 * Generates a <i>evenly-distributed</i> random {@code String} in given length.
	 * Each candidate language has same possibility of occurrence.
	 * So even if one of the selected language(like Korean, Chinese, etc..) has way more characters than the others(like English),
	 * characters of the language will have same frequency of occurrence with characters of other languages.
	 * */
	public String evenlyDistributedRandomString(int len) {
		StringBuilder sb = new StringBuilder(len);
		new Random().ints(len, 0, Integer.MAX_VALUE).map(i -> i % ranges.length).flatMap(i -> 
			new Random().ints(0, 1114111).filter(j -> ranges[i].test(j)).limit(1)
		).mapToObj(Character::toChars).forEach(sb::append);
		return sb.toString();
	}

}
