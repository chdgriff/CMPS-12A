import java.util.Random;

/*
 * Assignment #3.
 * This program allows user to simulate games of Craps to find the
 * probability that a user would win.
 * 
 * Authors: Chris Griffis (chdgriff@ucsc.edu)
 */

public class SimCraps {
	int point;//Variable holding point value
	int dice1;//First dice throw
	int dice2;//Second dice throw
	int roll;//Sum of dice1 and dice2
	Random rand = new Random();//Random object used to roll dice
	boolean comeOut;//variable for first roll
	boolean cont;//If point is not rolled
	double gamesWon;//Games won
	
	public static void main(String[] args) {
		SimCraps run = new SimCraps();
		
		double totalGames = Double.parseDouble(args[0]);
		
		//For test use
		//double totalGames = 1000;
		
		for (int i = 0; i < totalGames; i++) {
			run.craps();
		}
		
		double probability = (run.gamesWon / totalGames);
		System.out.println("Probability of winning: " + probability);
	}
	
	//Runs one game of craps
	public void craps() {
		do {
			if (comeOut) {
				rollDice();
				
				if (roll == 7 || roll == 11) {
					win();
				}
				else if (roll == 2 || roll == 3 || roll == 12) {
					lose();	
				}
				else {
					comeOut = false;
					cont = true;
					point = roll;
				}
			}
			else {
				rollDice();
				
				if (roll == 7) {
					lose();
				}
				else if (roll == point) {
					win();
				}
			}
		} while (cont);
	}
	
	//Marks another win and prevents another game from running.
	public void win() {
		gamesWon++;
		comeOut = true;
		cont = false;
	}
	
	//Prevents another game from running.
	public void lose() {
		comeOut = true;
		cont = false;
	}
	
	//Method to roll dice and its sum to variable roll
	public void rollDice() {
		dice1 = rand.nextInt(6) + 1;
		dice2 = rand.nextInt(6) + 1;
		roll = dice1 + dice2;
	}
}


