/*
 * Program Assignment #2
 * FindAnag asks for a string of letters and searches through a given list of words 
 * to finds anagrams of the string of letters.
 * 
 * Authors: Chris Griffis (chdgriff@ucsc.edu)
 */


import java.io.*;
import java.util.*;

public class FindAnag {
	
	String abc = "etaoinsrhdlucmfywgpbvkxqjz";//list of all letters in most common order
	ArrayList<String> wordList = new ArrayList<String>();//for txt file given
	ArrayList<Integer> numList = new ArrayList<Integer>();//list of num vaules for letters
	ArrayList<Integer> sumList = new ArrayList<Integer>();//list of the sums based on numList for wordList
	ArrayList<String> anagList = new ArrayList<String>();//for found anagrams
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FindAnag run = new FindAnag();
		Scanner in = new Scanner(System.in);
		String input;//Inputed word
		
		run.inputWordList(args);
		run.findTotalSums();
		
		//A do While loop to ask for input and repeat anagram search if wanted
		boolean doAnother = true;
		String input2;
		do {
			System.out.println("Input a string of letters:");
			input = in.next();
			
			run.findAnag(input);
			run.printAnagList();
			
			//while loop to check if redo anagram search
			while (0 < 1) {
				System.out.println("Do another (y/n)");
				input2 = in.next();
				if(input2.equalsIgnoreCase("y")) {
					run.reset();
					System.out.println();
					break;
				}
				else if(input2.equalsIgnoreCase("n")) {
					doAnother = false;
					System.exit(0);
				}
				else {
					System.out.println("Error, enter either y/n");
				}
			}
		} while (doAnother == true);
		
		in.close();
	}
	
	//Asks and sets a txt file to wordList
	public void inputWordList(String args[]) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream(args[0]));
		
		int size = in.nextInt();//first item is the number of words
		
		//while loop to create ArrayList of txt file
				int i = 0;
				while ( i < size ) {
				    wordList.add(in.next());
				    i++;
				}
		in.close();
	}
	
	//Calculates sums of all the words in wordList
	public void findTotalSums() {
		//create numList with random numbers
		Random r = new Random();
		boolean repeatNum = true;
		int num = r.nextInt(100000);
		numList.add(num);
		for (int i = 0; i< abc.length(); i++) {
			do {
				num = r.nextInt(100000);
				for (int a: numList) {
					if (num == a) {
						repeatNum = true;
						break;
					}
					else {
						repeatNum = false;
					}
				}
			} while (repeatNum == true);
			numList.add(num);
		}
		
		for (String i: wordList) {
			sumList.add(findSum(i));
		}
	}
	
	//Calculates an individual sum of String inputed
	public int findSum(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += findVal(str.charAt(i));
		}
		
		return sum;
	}
	
	//Finds num value of inputed char by searching through numList
	public int findVal(char x) {
		for (int i = 0; i < abc.length(); i++) {
			if (x == abc.charAt(i)) {
				return numList.get(i);
			}
		}
		return 0;
	}
	
	//Finds all anagrams of inputed String
	public void findAnag(String input) { 
		int sum = findSum(input);
		 //test to check sum of input word
		 //System.out.println("input sum: " + sum);
		for (int i = 0; i < sumList.size(); i++) {
			if (sum == sumList.get(i) && input.length() == wordList.get(i).length()) {
				if (wordList.get(i).equals(input) == false)	{
					anagList.add(wordList.get(i));
				}
			}
		}
	}
	
	//Prints anagList
	public void printAnagList() {
		System.out.println();
		//if else to see if no anagrams found
		if (anagList.isEmpty() == true) {
			System.out.println("No anagrams found");
		}
		else {
			for (String i: anagList) {
				System.out.println(i);
			}
		}
		System.out.println();
	}
	
	//Resets anagList to research for anagrams
	public void reset() {
		anagList.clear();
	}
}
