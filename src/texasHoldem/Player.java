
package texasHoldem;

import cards.Card;

//this class should organize the players
public class Player {

	private Card[] karten = new Card[2];
	
	public Player() {

	}// constucter
	
	public void takeCardFromDealer(Card card1, Card card2){
		karten[0] = card1;
		karten[1]= card2;
	}
	
	public String showCards(){
		return ("Karte1: " + karten[0] + " Karte2: " + karten[1]);
	}
	
	

}
