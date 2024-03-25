package cz.cvut.fel.ass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Main {

	static class KwicCompare implements Comparator<Integer[]> {
		@Override
		public int compare(Integer[] indexOne, Integer[] indexTwo) {
			String[] w1 = wordsInLine.get(indexOne[0]);
			String[] w2 = wordsInLine.get(indexTwo[0]);
			int compare = w1[indexOne[1]].compareToIgnoreCase(w2[indexTwo[1]]);
			if (compare == 0) {
				compare = indexOne[0].compareTo(indexTwo[0]);
				if (compare == 0)
					compare = indexOne[1].compareTo(indexTwo[1]);
			}
			return compare;
		}
	}

	protected static List<String> lines = new ArrayList<String>();
	protected static List<Integer[]> index = new ArrayList<Integer[]>();
	protected static List<String[]> wordsInLine = new ArrayList<String[]>();
	protected static SortedSet<Integer[]> sortedIndex = new TreeSet<Integer[]>(
			new KwicCompare());

	protected static List<String> output = new ArrayList<String>();

	public static void main(String[] args) throws IOException {
		input();
		split();
		alphabetize();
		shift();
		writeOutput();
	}

	/*
	 * Subroutine 1 - INPUT
	 */
	protected static void input() {
		try {
			FileInputStream fstream = new FileInputStream("input.txt");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				lines.add(strLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Subroutine 2
	 */
	protected static void split() {
		for (int i = 0; i < lines.size(); i++) {
			String[] split = lines.get(i).split(" ");
			wordsInLine.add(split);
			for (int j = 0; j < split.length; j++)
				index.add(new Integer[] { i, j });
		}
	}

	/*
	 * Subroutine 3
	 */
	protected static void alphabetize() {
		sortedIndex.addAll(index);
	}

	protected static void shift() {
		for (Integer[] indexRow : sortedIndex) {
			int wordIndex = indexRow[1];
			String[] tempWords = wordsInLine.get(indexRow[0]);
			String beforeKeyWord = "";
			String afterKeyWord = "";
			for (int i = 0; i < tempWords.length; i++) {
				if (i < wordIndex) {
					beforeKeyWord += tempWords[i];
					beforeKeyWord += " ";
				} else {
					afterKeyWord += tempWords[i];
					afterKeyWord += " ";
				}
			}
			output.add(afterKeyWord + beforeKeyWord);
		}
	}

	/*
	 * Subroutine 5
	 */
	protected static void writeOutput() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output.txt"), false));
		for (String strLine : output) {
			System.out.println(strLine);
			bw.write(strLine);
			bw.newLine();
		}
		bw.close();
	}

}
