package cards;


import cards.*;
import cards.Card.*;
import static cards.Card.*;
import static cards.Card.Constant.*;


@ClassPreamble (
    vcs             = "git@bitbucket.org:schaefers/Prg_Support_Cards[.git]",
    author          = "Michael Sch‰fers",
    contact         = "Michael.Schaefers@HAW-Hamburg.de",
    organization    = "Dept.Informatik; HAW Hamburg",
    date            = "2012/02/12",
    version         = "2.4",
    note            = "release for SS17 ;  1st release WS07/08",
    lastModified    = "2017/03/25",
    lastModifiedBy  = "Michael Sch‰fers",
    reviewers       = ( "none" )
)
public class CardDemo {
    
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Sch‰fers" )
    public static void main( String[] args ){
        
        // Deklarationen
        
        Card   c;
        Card[] ca;
        Deck   d = new Deck();
        
        int    i;
        
        
        
        // Beispiele fuer einfache "Dinge"
        c = d.deal();                                                           // eine Karte vom Kartenstappel geben lassen
        
        System.out.println( "Wird eine Ausgabe kommen?" );
        if ( c.equals( CJ ) ){             System.out.print( c ); }             // ist die Karte eine Kreuzbube ?
        if ( c.getSuit().equals( CLUB ) ){ System.out.print( c ); }             // ist die Karte ein Kreuz ?
        if ( c.getRank().equals( JACK ) ){ System.out.print( c ); }             // ist die Karte ein Bube ?
        System.out.println( "#########################" );
        
        do {                                                                    // nimm solange
            c = d.deal();                                                       // ..eine Karte vom Stappel
            System.out.printf( "%s, ", c );                                     // ..bis es
        }while ( ! c.equals( CJ ) );                                            // ..ein Kreuzbube ist
        
        System.out.printf( "\n Jetzt ist es aber ein Kreuz Bube\n\n\n\n" );
        
        
        
        //----------------------------------------------------------------------
        
        // Ausgabe eines "Karten"-Arrays, das Luecken enthaelt
        
        ca = new Card[7];                                                       // Array hat Platz fuer 7 Karten
        for (i=0; i<5; i++){ ca[i] = d.deal(); }                                // Es werden nur(!) 5 Karten in das Array getan
        System.out.printf( "Das ARRAY kann bis zu %d Karten aufnehmen\n", ca.length );
        System.out.print(  "Das ARRAY enth‰lt die Karten: " );
        //
        // alle Karten (soweit vorhanden einzeln) ausgeben
        i=0;
        while( i<ca.length && ca[i]!=null ){
            System.out.printf( "%s, ", ca[i] );
            i++;
        }//while
        System.out.printf( "\n" );
        //
        // alle Karten des Array (geschlossen) ausgeben
        printCardArray( ca );
        System.out.printf( "\n\n\n" );
        
        
        
        //----------------------------------------------------------------------
        
        // Informationen ueber einzelne Spielkarten abfragen bzw. ausgeben
        
        c = d.deal();
        System.out.printf( "Die Karte %s hat:\n", c );
        System.out.printf( "    Die Position:    %2d   (2 hat Position 0  und Ass hat Position 12\n",               c.getRank().ordinal() );
        System.out.printf( "    Den Rang: %s bzw. %2d   (2 hat Rang 2      und Ass hat Rang 14\n",     c.getRank(), c.getRank().value() );
        System.out.printf( "    Die Farbe:        %s\n",                                                            c.getSuit() );
        System.out.printf( "\n\n\n" );
        
        
        
        // Beispiel fuer Zusammenhang : Rang <-> value <-> ordinal
        for (i=0; i<=12; i++){
            Rank r = Rank.values()[i];
            System.out.printf( "Die Position: %2d entspricht dem Rang: %s ", i, r );
            System.out.printf( "und der Rang: %s entspricht der Position: %2d bzw. dem Wert %2d\n", r, r.ordinal(), r.value() );
        }//for
        System.out.println();
        
        // Beispiel fuer Zusammenhang : Farbe <-> ordinal
        for (i=0; i<=3; i++){
            Suit s = Suit.values()[i];
            System.out.printf( "Die Position: %2d entspricht der Farbe: %s ", i, s );
            System.out.printf( "und die Farbe: %s entspricht der Position: %2d\n", s, s.ordinal() );
        }//for
        System.out.println();
        
        
        
        // alle Spielkartenraenge von TWO bis ACE und zurueck ausgeben
        //
        // Demo fuer increment
        Rank r = TWO;
        while( ! r.equals( ACE )){
            System.out.printf( "%s ", r );
            r = r.incremented();                                                // <<<==== hier Beispiel-Aufruf
        }//while
        System.out.println();
        //
        // Demo fuer decrement
        while( ! r.equals( TWO )){
            System.out.printf( "%s ", r );
            r = r.decremented();                                                // <<<==== hier Beispiel-Aufruf
        }//while
        System.out.println();
        System.out.printf( "\n\n\n" );
        
        
        
        //----------------------------------------------------------------------
        
        // Zwei Karten nehmen und deren Rang vergleichen
        
        Card c1 = d.deal();
        Card c2 = d.deal();
        
        // Rang zweier Karten vergleichen - Variante 1
        if ( c1.getRank().value() < c2.getRank().value() ){
            System.out.printf( "Die Karte %s hat einen \"kleineren\" Rang als die Karte %s\n",  c1, c2 );
        }else if ( c1.getRank().value() > c2.getRank().value() ){
            System.out.printf( "Die Karte %s hat einen \"groeﬂeren\" Rang als die Karte %s\n",  c1, c2 );
        }else{
            System.out.printf( "Die Karte %s hat den gleichen Rang awie die Karte %s\n",  c1, c2 );
        }//if

        // Rang zweier Karten vergleichen - Variante 2 (Verstaendnis erfordert zusaetzliches Wissen)
        if ( c1.getRank().compareTo( c2.getRank() ) < 0 ){
            System.out.printf( "Die Karte %s hat einen \"kleineren\" Rang als die Karte %s\n",  c1, c2 );
        }else if ( c1.getRank().compareTo( c2.getRank() ) > 0 ){
            System.out.printf( "Die Karte %s hat einen \"groeﬂeren\" Rang als die Karte %s\n",  c1, c2 );
        }else{
            System.out.printf( "Die Karte %s hat den gleichen Rang awie die Karte %s\n",  c1, c2 );
        }//if
        
        // Rang zweier Karten vergleichen - Variante 3 (Verstaendnis erfordert zusaetzliches Wissen)
        if ( c1.compareTo( c2 ) < 0 ){
            System.out.printf( "Die Karte %s hat einen \"kleineren\" Rang als die Karte %s\n",  c1, c2 );
        }else if ( c1.compareTo( c2 ) > 0 ){
            System.out.printf( "Die Karte %s hat einen \"groeﬂeren\" Rang als die Karte %s\n",  c1, c2 );
            
        }else{
            System.out.printf( "Die Karte %s hat den gleichen Rang awie die Karte %s\n",  c1, c2 );
        }//if
        
        
        
        //----------------------------------------------------------------------
        
        System.out.printf( "\n\n\n" );
        System.out.println( "THE END" );
    }//method()
    
}//class
