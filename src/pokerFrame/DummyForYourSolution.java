// release for SS17 by Michael Schäfers;  1st release WS07/08 by Michael Schäfers
// lastModified 2016/03/20 by Michael Schäfers
package pokerFrame;


// just import "anything" in case it might be needed
//
import static cards.Card.*;
import static cards.Card.Constant.*;
import static pokerFrame.testSupport.HandRanking.*;

//
import cards.*;
import cards.Card.*;
import pokerFrame.testSupport.*;


public class DummyForYourSolution implements GameAnalyzer {
    
    @Override
    public ResultOfGame compute( final TestCaseActual tca ){
        
        // Zugriff auf die Karten
        // ======================
        
        /* Card[]  player1_hole_cards = */ tca.getPlayerHoleCards( 0 );         // player #1
        /* Card[]  player2_hole_cards = */ tca.getPlayerHoleCards( 1 );         // player #2
        /* Card[]  player3_hole_cards = */ tca.getPlayerHoleCards( 2 );         // player #3
        /* Card[]  player4_hole_cards = */ tca.getPlayerHoleCards( 3 );         // player #4
        /* Card[]  player5_hole_cards = */ tca.getPlayerHoleCards( 4 );         // player #5
        
        /* Card[]  community_cards = */    tca.getCommunityCards();             // 
        
        
        
        
        
        // Ihre Berechnung
        // ===============
        //
        // ...
        // Hier kommt Code von Ihnen hin - (moegliche) Idee:
        // Moeglicher Weise Konstruktion der 5 Player und uebergabe der 7 zugehoerigen Karten an den jeweiligen Konstruktor.
        // Abfrage des Ergebnisses vom jeweiligen Player
        // ...
        //
        // Weitere Annahme fuer das Beispiel - das (berechnete) Ergebnis sei "wie unten"
        
        
        
        
        
        // Abliefern des Ergebnisses
        // =========================
        
        ResultOfGame rog = null;
        
        // Alternative 1: "Direkt"
        rog = new ResultOfGame(
            new ResultOfPlayer[]{
                //
                //                  /------------------------------------------------------ position of player:
                //                  |                                                       1 is the best, .., 5 is the worst
                //                  |
                //                  |   /-------------------------------------------------- handranking of player - valid values are:
                //                  |   |                                                   STRAIGHT_FLUSH, QUADS, FULL_HOUSE, FLUSH, STRAIGHT, 
                //                  |   |                                                   TRIPS, TWO_PAIR, ONE_PAIR and HIGH_CARD.
                //                  |   |                                                   These values are defined in the enum poker.testSupport.HandRanking
                //                  |   |
                //                  |   |           /-------------------------------------- cards of player that are played (to be computed by your solution)
                //                  |   |           |
                //                  V   V           V
                new ResultOfPlayer( 2,  ONE_PAIR,   new Card[]{ SQ, HQ, HJ, H9, D7 } ),  // player #1 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 1,  TRIPS,      new Card[]{ SJ, HJ, CJ, H9, D7 } ),  // player #2 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HIGH_CARD,  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #3 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HIGH_CARD,  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #4 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 2,  ONE_PAIR,   new Card[]{ DQ, CQ, HJ, H9, D7 } )   // player #5 ;  just an example - it's not that easy ;-)
            }//array-new
        );//new
        
        // Alternative 2: "Richtig" geschriebenen String nutzen - valueOf() wandelt String in "Enum"
        rog = new ResultOfGame(
            new ResultOfPlayer[]{
                new ResultOfPlayer( 2,  HandRanking.valueOf( "ONE_PAIR" ),   new Card[]{ SQ, HQ, HJ, H9, D7 } ),  // player #1 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 1,  HandRanking.valueOf( "TRIPS" ),      new Card[]{ SJ, HJ, CJ, H9, D7 } ),  // player #2 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HandRanking.valueOf( "HIGH_CARD" ),  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #3 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HandRanking.valueOf( "HIGH_CARD" ),  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #4 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 2,  HandRanking.valueOf( "ONE_PAIR" ),   new Card[]{ DQ, CQ, HJ, H9, D7 } )   // player #5 ;  just an example - it's not that easy ;-)
            }//array-new
        );//new
        
        // Alternative 3: String nutzen - toUpperCase() korrigiert moegliche Gross-/Klein-Schreibungs-Fehler
        rog = new ResultOfGame(
            new ResultOfPlayer[]{
                new ResultOfPlayer( 2,  HandRanking.valueOf( "one_pair".toUpperCase() ),   new Card[]{ SQ, HQ, HJ, H9, D7 } ),  // player #1 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 1,  HandRanking.valueOf( "trips".toUpperCase() ),      new Card[]{ SJ, HJ, CJ, H9, D7 } ),  // player #2 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HandRanking.valueOf( "high_card".toUpperCase() ),  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #3 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 4,  HandRanking.valueOf( "high_card".toUpperCase() ),  new Card[]{ HJ, H9, D7, C5, D4 } ),  // player #4 ;  just an example - it's not that easy ;-)
                new ResultOfPlayer( 2,  HandRanking.valueOf( "one_pair".toUpperCase() ),   new Card[]{ DQ, CQ, HJ, H9, D7 } )   // player #5 ;  just an example - it's not that easy ;-)
            }//array-new
        );//new
        
        // Viele weitere Varianten sind moeglich
        
        // Moegliche Werte fuer "HandRanking" sind die 9 Werte:  HIGH_CARD, ONE_PAIR, TWO_PAIR, TRIPS, STRAIGHT, FLUSH, FULL_HOUSE, QUADS, STRAIGHT_FLUSH
        // Bemerkung: Diese Werte sind in poker.testSupport.HandRanking als enum definiert. Sie duerfen diese Werte weder veraendern noch ergaenzen!
        
        return rog;
    }//method()
    
}//class
