package deck;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

	public static void main(String[] args) {		
		
		Deck deck = new Deck();
		int myDeck[] = deck.createDeck(); 
		myDeck = deck.shuffleTheDeck(myDeck);
		
		
		Scanner sc = new Scanner(System.in);
		int numberOfPlayers = 0;
		
		while (numberOfPlayers <= 0 || numberOfPlayers > 10)
		{
			System.out.print("How many players are playing?: ");
			numberOfPlayers = sc.nextInt();
			
			if (numberOfPlayers <= 0 || numberOfPlayers > 10)
				System.out.println("Number of players should be less than 10 and greater than 0");
			
		}
		
		String[] names = new String[] {"Hank","Frank","Edward", "Abel","Reuben","Abelson", "James","Jane","Creighton"};
		
		for (int i = 0; i < numberOfPlayers; i++)
		{
			System.out.println("Let the player " + (i + 1) + " is " + names[i]);
		}
		
		System.out.println("");
		System.out.println("Cards of players are: ");
		System.out.println("");
		
		
		for (int i = 0; i< numberOfPlayers; i++)
		{
			print(names[i] );
		}		
		
		for (int i = 0; i < myDeck.length ; i++)
		{
			
			if( i % numberOfPlayers == 0)
				System.out.println("");
			
			print(deck.getCardValue(myDeck[i]));			
			
		}
		
		
	}
	
	public static void print(String string)
	{
		int length = string.length();
		
		length = 17 - length;
		
		for(int i = 0; i < length; i++)
			string+= " ";
		
		System.out.print(string + " | ");
		
		
	}
	
	
	public int[] createDeck()
	{
		
		int deck[] = new int[52];
		for(int i = 0 ; i < 52; i++)
		{
			deck[i] = i + 1;
		}
		
		return deck; 
	}
	public int[] shuffleTheDeck(int []deck)
	{
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = deck.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = deck[index];
	      deck[index] = deck[i];
	      deck[i] = a;
	    }
	    
	    return deck;
	}
	public String getCardValue(int number)
	{
		int value  = number % 13;
		
		String sign = "";
		
		if (number < 14)
			sign = "Spades";
		else if (number < 27)
			sign = "Hearts";
		else if (number < 40)
				sign = "clubs";
		else 
			sign = "Diamond";
		
		
		
		String ValueNumber = "";
		
		if (value == 1)
			ValueNumber = "A";
		else if (value == 11)
			ValueNumber = "Jack";
		else if (value == 12)
			ValueNumber = "Queen";
		else if (value == 0)
			ValueNumber = "King";
		else
			ValueNumber = value + "";
		
		
		return ValueNumber + " of " + sign;
		
	}

}
