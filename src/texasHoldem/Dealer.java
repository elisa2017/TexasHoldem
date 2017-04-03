package texasHoldem;

import cards.Card;
import cards.Deck;

public class Dealer {

	// one main deck to deal from
	private Deck deck;

	// declare arraysfor the players
	private Player[] allPlayer = new Player[5];
	// private Player player1;
	// private Player player2;
	// private Player player3;
	// private Player player4;
	// private Player player5;

	private Card[] playerCards; // 10
	private Card[] communitycards; // 5

	// Wenn Dealer erstellt wird, übergebe alle SPieler
	public Dealer(Player player1, Player player2, Player player3, Player player4, Player player5) {
		deck = new Deck();

		// just for the dealer
		communitycards = new Card[5];
		playerCards = new Card[10];

		allPlayer[0] = player1;
		allPlayer[1] = player2;
		allPlayer[2] = player3;
		allPlayer[3] = player4;
		allPlayer[4] = player5;

	}

	//
	public void dealCardsToPlayers() {
		
		//get th
		for (int playerNumber = 0; playerNumber < 5; playerNumber++) {
			Card firstCard = deck.deal();
			Card secondCard = deck.deal();
			
			allPlayer[playerNumber].takeCardFromDealer(firstCard, secondCard);
			System.out.println("Spieler " + playerNumber + " " + allPlayer[playerNumber].showCards());

			
		}

	}
}