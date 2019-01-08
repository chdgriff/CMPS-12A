import java.util.*;

/*
 * Assignment #3.
 * This program allows user to play an interactive game of Craps.
 * 
 * Authors: Chris Griffis (chdgriff@ucsc.edu)
 */

public class PlayCraps {
	int seed;//seed 
	int chips;//variable for chips
	int bet;//variable for inputed bet
	int point;//Variable holding point value
	int dice1;//First dice throw
	int dice2;//Second dice throw
	int roll;//Sum of dice1 and dice2
	Random rand;//Random object used to roll dice
	boolean comeOut;//variable for first roll
	
	public static void main(String[] args) {
		PlayCraps play = new PlayCraps();
		
		play.craps();
	}
	
	//Craps game
	public void craps() {
		Scanner input = new Scanner(System.in);//User inputs
		Scanner keyboard = new Scanner(System.in);//Wait for enter press
		comeOut = true;
		
		System.out.print("Enter the seed: ");
		seed = input.nextInt();
		rand = new Random(seed);
		
		System.out.print("How many chips do you want? ");
		chips = input.nextInt();
		
		//Loop to run until chips run out.
		while (chips > 0) {
			if (comeOut) {
				//Loop to ask for valid bet
				do {
					System.out.print("\nEnter bet: ");
					bet = input.nextInt();
					
					if (bet <= chips) {
						break;
					}
					else {
						System.out.println("You don't have that many chips.");
					}
				} while (bet > chips);
			
				System.out.print("Press \"Enter\" to roll come out dice.");
				keyboard.nextLine();
				rollDice();
				
				if (roll == 7 || roll == 11) {
					win();
					
				}
				else if (roll == 2 || roll == 3 || roll == 12) {
					lose();
					
				}
				else {
					comeOut = false;
					point = roll;
					System.out.println("The point is: " + roll + "\n");
				}
			}
			else {
				System.out.print("Press \"Enter\" to roll for point " + point + ".");
				keyboard.nextLine();
				rollDice();
				
				if (roll == 7) {
					lose();
				}
				else if (roll == point) {
					win();
				}
			}
		}
		keyboard.close();
		input.close();
	}
	
	//Player wins and gets bet
	public void win() {
		chips += bet;
		comeOut = true;
		System.out.println("You won, you now have: " + chips);
	}
	
	//Player loses and loses bet amount
	public void lose() {
		chips -= bet;
		comeOut = true;
		System.out.println("You lost, you now have: " + chips);
	}
	
	//Method to roll dice and sum to variable roll
	public void rollDice() {
		dice1 = rand.nextInt(6) + 1;
		dice2 = rand.nextInt(6) + 1;
		printDice(dice1, dice2);
		roll = dice1 + dice2;
	}
	
	//method to print dice values based on inputs
	public void printDice(int val1, int val2) {		
		String line1, line2, line3, line4, line5;
		String line22, line23, line24;
		line1 = "╔═══════╗ ╔═══════╗";
		line5 = "╚═══════╝ ╚═══════╝";
		switch (val1) {
			case 1: line2 = "║       ║ ";
					line3 = "║   *   ║ ";
					line4 = "║       ║ ";
					break;
			case 2: line2 = "║*      ║ ";
					line3 = "║       ║ ";
					line4 = "║      *║ ";
					break;
			case 3: line2 = "║*      ║ ";
					line3 = "║   *   ║ ";
					line4 = "║      *║ ";
					break;
			case 4: line2 = "║*     *║ ";
					line3 = "║       ║ ";
					line4 = "║*     *║ ";
					break;
			case 5: line2 = "║*     *║ ";
					line3 = "║   *   ║ ";
					line4 = "║*     *║ ";
					break;
			case 6: line2 = "║*     *║ ";
					line3 = "║*     *║ ";
					line4 = "║*     *║ ";;
					break;
			default: line2 = "║       ║ ";
					 line3 = "║       ║ ";
					 line4 = "║       ║ ";
					 break;
		}
		
		switch (val2) {
			case 1: line22 = "║       ║ ";
					line23 = "║   *   ║ ";
					line24 = "║       ║ ";
					break;
			case 2: line22 = "║*      ║ ";
					line23 = "║       ║ ";
					line24 = "║      *║ ";
					break;
			case 3: line22 = "║*      ║ ";
					line23 = "║   *   ║ ";
					line24 = "║      *║ ";
					break;
			case 4: line22 = "║*     *║ ";
					line23 = "║       ║ ";
					line24 = "║*     *║ ";
					break;
			case 5: line22 = "║*     *║ ";
					line23 = "║   *   ║ ";
					line24 = "║*     *║ ";
					break;
			case 6: line22 = "║*     *║ ";
					line23 = "║*     *║ ";
					line24 = "║*     *║ ";;
					break;
			default: line22 = "║       ║ ";
					 line23 = "║       ║ ";
					 line24 = "║       ║ ";
					 break;
		}
		System.out.println("You rolled: " + line1);
		System.out.printf("            %10s%10s\n", line2, line22);
		System.out.printf("            %10s%10s\n", line3, line23);
		System.out.printf("            %10s%10s\n", line4, line24);
		System.out.println("            " + line5);
	}
}
