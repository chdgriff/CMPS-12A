import java.io.*;
import java.util.*;

public class AnagramPuzzleGenerator {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner in = new Scanner(new FileInputStream(args[0]));
		
		int size = in.nextInt();//first item is the number of words
		
		//while loop to create ArrayList of txt file
		ArrayList<String> wordList = new ArrayList<String>();
		int i = 0;
		while ( i < size ) {
		    wordList.add(in.next());
		    i++;
		}
		
		Random rnd = new Random();
		String word = wordList.get(rnd.nextInt(size));
		//Sets word to random word
		
		System.out.print(word + " >>> ");//Prints selected Word
		
		ArrayList<Integer> scramble = new ArrayList<Integer>();
		
		for (int x = 0; x < word.length(); x++)	{
			scramble.add(x);
		}//creates ArrayList of numbers to correspond with the word
		
		Collections.shuffle(scramble);//Scramble's number order
		
		for (int y : scramble)	{
			System.out.print(word.charAt(y));
		}//Prints scrambled word
		
		System.out.println();		
		in.close();
		
	    }
}
