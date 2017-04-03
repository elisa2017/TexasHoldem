package texasHoldem;

public class Main {

	
	public static void main(String[] args){

		
		Player p1 = new Player();
		Player p2 = new Player();
		Player p3 = new Player();
		Player p4 = new Player();
		Player p5 = new Player();
		
		Dealer dealer = new Dealer(p1, p2, p3, p4, p5);
		dealer.dealCardsToPlayers();
		
		
	}
}
