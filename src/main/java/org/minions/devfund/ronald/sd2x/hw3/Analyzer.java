package org.minions.devfund.ronald.sd2x.hw3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {
		List<Sentence> list = new LinkedList<>();

		if (filename ==  null || filename.isEmpty()) {
			return list;
		}
		try {
			File file = new File(filename);
			if (file.exists()) {
				BufferedReader br = new BufferedReader(new FileReader(file));
				String str;
				while ((str = br.readLine()) != null) {
					Sentence sentence = getSentence(str);
					if (sentence != null) {
						list.add(sentence);
					}
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("File was not found:" + ex.fillInStackTrace() );
		} catch (IOException ex) {
			System.out.println("Failed input or output data:" + ex.fillInStackTrace() );

		}
		return list;
	}

	public static Sentence getSentence(String lineText) {
		final String regex = "(?<score>\\-?[0-2])(?<text>\\s.*$)";

		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(lineText);

		if (matcher.find()) {
			String score = matcher.group("score");
			String text = matcher.group("text");
			return new Sentence(Integer.valueOf(score), text.trim());
		}

		return null;
	}

	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		HashMap<String, Word> wordsMap = new HashMap<>();
		if (sentences == null || sentences.isEmpty()) {
			return new HashSet<>();
		}

		for (Sentence sentence : sentences) {
			if (sentence == null || sentence.getText().isEmpty()) continue;
			String[] words = sentence.getText().split("\\s");
			for (String word : words) {
				if (isWord(word)) {
					word = word.toLowerCase();
					final int score = sentence.getScore();
					if (wordsMap.containsKey(word)) {
						wordsMap.get(word).increaseTotal(score);
					} else {
						Word wordObj = new Word(word);
						wordObj.increaseTotal(score);
						wordsMap.put(word, wordObj);

					}
				}
			}
		}

		return new HashSet<>(wordsMap.values());
	}

	private static boolean isWord(String word) {
		for (char character : word.toCharArray()) {
			if (!Character.isLetter(character)) {
				return false;
			}
		}
		return true;
	}

	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {
		Map<String, Double> wordsMap = new HashMap<>();
		if (words ==  null || words.isEmpty()) {
			return wordsMap;
		}

		for (Word word : words) {
			if (word == null) continue;
			wordsMap.put(word.getText(), word.calculateScore());
		}

		return wordsMap;
	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		if (wordScores == null || wordScores.isEmpty() || sentence == null || sentence.isEmpty()) {
			return 0.0;
		}

		double total = 0.0;
		int count = 0;
		String[] words = sentence.split("\\s");
		for (String word : words) {
			word = word.toLowerCase();
			if (!isWord(word)) continue;
			if (!wordScores.containsKey(word)) {
				wordScores.put(word, 0.0);
				total += 0.0;
			} else {
				total += wordScores.get(word);
			}
			count++;
		}
		
		return count > 0 ? total / count : 0.0;

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = "reviews2.txt";/*args[0]*/;
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		System.out.println("Here");
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
