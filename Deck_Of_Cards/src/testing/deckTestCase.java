package testing;

import static org.junit.Assert.*;

import org.junit.Test;

import deck.Deck;

public class deckTestCase {

	@Test
	public void testDeckLength() {
		Deck deck = new Deck();
		int myDeck[] = deck.createDeck(); 
		
		
		assertEquals(myDeck.length, 52);
		
	}
	
	
	@Test
	public void testDeckShuffle() {
		Deck deck = new Deck();
		int myDeck[] = deck.createDeck(); 
		myDeck = deck.shuffleTheDeck(myDeck);
		
		assertNotEquals(myDeck[3], 3);
		assertNotEquals(myDeck[10], 10);

		assertNotEquals(myDeck[20], 20);
		assertNotEquals(myDeck[50], 50);

		
		
	}
	
	
	@Test
	public void testValues() {
		Deck deck = new Deck();
		
		assertEquals(deck.getCardValue(1), "A of Spades");
		assertEquals(deck.getCardValue(13), "King of Spades");

		assertEquals(deck.getCardValue(24), "Jack of Hearts");

		
	}

	
	

}
