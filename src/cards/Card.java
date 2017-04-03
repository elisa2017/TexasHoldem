package cards;


/**
 * Die Klasse {@link Card} ist der Datentyp f&uuml;r eine Spiel<strong>karte</strong>.
 */
@ClassPreamble (
    vcs             = "git@bitbucket.org:schaefers/Prg_Support_Cards[.git]",
    author          = "Michael Schäfers",
    contact         = "Michael.Schaefers@HAW-Hamburg.de",
    organization    = "Dept.Informatik; HAW Hamburg",
    date            = "2012/11/19",
    version         = "2.4",
    note            = "release for SS17 ;  1st release WS07/08",
    lastModified    = "2017/03/25",
    lastModifiedBy  = "Michael Schäfers",
    reviewers       = ( "none" )
)
/* ----------------------------------------------------------------------------
 * KNOWN PROBLEMS: 130114: JavaDoc has problem with inner classes : "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
 * 
 * NOTEs:          This class was decided to be implemented as class on purpose
 *                 An enum is avoided since the "natural order" of an enum is explicitly NOT wanted
 * 
 * OPEN POINTS:    Should all be removed in the final version, anyway they have been
 *                 marked with: _???_<YYMMDD>  (search/grep for _???_)
 *                 Currently there is only "bug_id=4464323" (see above)
 * -----------------------------------------------------------------------------
 */
public class Card implements Comparable<Card> {
    
    //
    //
    // TYPEs--------------------------------------------------------------------
    
    /**
     * Der enum {@link #Suit} beschreibt die m&ouml;glichen <strong>Farb</strong>werte einer Karte:
     * <table>
     *   <tr> <td valign="top">&bull;</td> <td><code>CLUB</code></td>    <td>&harr;</td> <td>&clubs; (bzw. <strong>Kreuz</strong> oder auch Eichel)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>DIAMOND</code></td> <td>&harr;</td> <td><font color="red">&diams;</font> (bzw. <strong>Karo</strong> oder auch Schellen)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>HEART</code></td>   <td>&harr;</td> <td><font color="red">&hearts;</font> (bzw. <strong>Herz</strong> oder auch Rot)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SPADES</code></td>  <td>&harr;</td> <td>&spades; (bzw. <strong>Pik</strong> oder auch Laub/Blatt/Schippen/Gras/Gr&uuml;n)<td> </tr>
     * </table>
     */
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
    public enum Suit {
        
        CLUB,     // Kreuz
        DIAMOND,  // Karo
        HEART,    // Herz
        SPADES;   // Pik
       
        
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
        @Override
        public String toString(){
            String resu;
            
            switch ( this ) {
                case CLUB    : resu = "C"; break;  // \u2663
                case DIAMOND : resu = "D"; break;  // \u2666
                case HEART   : resu = "H"; break;  // \u2665
                case SPADES  : resu = "S"; break;  // \u2660
                default      : resu = "?";
            }//switch
            
            return resu;
        }//method()

    }//enum
    
    
    
    /**
     * Der enum {@link #Rank} beschreibt die m&ouml;glichen <strong>R&auml;nge</strong> bzw. Kartenwerte einer Karte <em>(bzw. {@link Card})</em> :
     * <table>
     *   <tr> <td valign="top">&bull;</td> <td><code>TWO</code></td>   <td>&harr;</td> <td>&quot;2&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>THREE</code></td> <td>&harr;</td> <td>&quot;3&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>FOUR</code></td>  <td>&harr;</td> <td>&quot;4&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>FIVE</code></td>  <td>&harr;</td> <td>&quot;5&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SIX</code></td>   <td>&harr;</td> <td>&quot;6&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>SEVEN</code></td> <td>&harr;</td> <td>&quot;7&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>EIGHT</code></td> <td>&harr;</td> <td>&quot;8&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>NINE</code></td>  <td>&harr;</td> <td>&quot;9&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>TEN</code></td>   <td>&harr;</td> <td>&quot;10&quot;<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>JACK</code></td>  <td>&harr;</td> <td>Bube (bzw. Unter)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>QUEEN</code></td> <td>&harr;</td> <td>Dame (bzw. Ober)<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>KING</code></td>  <td>&harr;</td> <td>K&ouml;nig<td> </tr>
     *   <tr> <td valign="top">&bull;</td> <td><code>ACE</code></td>   <td>&harr;</td> <td>Ass (bzw. Daus)<td> </tr>
     * </table>
     */
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
    public enum Rank {
        
        TWO,    //  2
        THREE,  //  3
        FOUR,   //  4
        FIVE,   //  5
        SIX,    //  6
        SEVEN,  //  7
        EIGHT,  //  8
        NINE,   //  9
        TEN,    //  T bzw. 10
        JACK,   //  J bzw. Bube
        QUEEN,  //  Q bzw. Dame
        KING,   //  K bzw. König
        ACE;    //  A bzw. Ass
        
        
        /**
         * Die Methode {@link #value()} berechnet den (&quot;&uuml;blichen&quot;) numerischen Wert eines Karten-Ranges <em>(bzw. {@link #Rank})</em>.
         * Hierbei ist das Ass <em>(bzw. <code>ACE</code>)</em> die Karte <em>(bzw. {@link Card})</em> mit dem h&ouml;chsten Wert.
         * Ein Ass weist also <u>immer</u> den Wert 14 auf.
         * (Achtung! Sonderf&auml;lle wie z.B. Ass als Wheel bei &quot;TEXAS HOLD’EM&quot; werden von {@link #value()} nicht berücksichtigt.
         * @return numerischer Wert des Karten-Ranges <em>(bzw. {@link Rank})</em>.
         */
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
        public int value(){
           return ordinal() + 2;
        }//method()
        
        
        /**
         * Die Methode {@link #incremented()} liefert den Wert des Karten-Ranges <em>(bzw. {@link #Rank})</em> der aktuellen Karte <em>(bzw. {@link Card})</em> erh&ouml;ht um eins.
         * Falls die aktuelle Karte <em>(bzw. {@link Card})</em> ein Ass <em>(bzw. <code>ACE</code>)</em> ist,
         * dann wird (sofern enabled) eine Assertion-Exception ausgel&ouml;st,
         * andernfalls der Wert 15 zur&uuml;ckgeliefert.
         * @return Wert <em>(bzw. {@link #Rank})</em> des aktuellen Karten-Ranges <em>(bzw. {@link #Rank})</em> erh&ouml;ht um eins.
         */
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
        public Rank incremented(){
            assert !equals( ACE ) : "ERROR: Ace is already highest value and can NOT be incremented!";
            return Rank.values()[ ordinal() +1 ];
        }//method()
        
        /**
         * Die Methode {@link #decremented()} liefert den Wert des Karten-Ranges <em>(bzw. {@link #Rank})</em> der aktuellen Karte <em>(bzw. {@link Card})</em> erniedrigt um eins.
         * Falls die aktuelle Karte <em>(bzw. {@link Card})</em> eine 2 <em>(bzw. <code>TWO</code>)</em> ist,
         * dann wird (sofern enabled) eine Assertion-Exception ausgel&ouml;st,
         * andernfalls der Wert 1 zur&uuml;ckgeliefert.
         * @return Wert <em>(bzw. {@link #Rank})</em> des aktuellen Karten-Ranges <em>(bzw. {@link #Rank})</em> erniegrigt um eins.
         */
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
        public Rank decremented(){
            assert !equals( TWO ) : "ERROR: Two is already lowest value and can NOT be decremented!";
            return Rank.values()[ ordinal() -1 ];
        }//method()
        
        
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
        @Override
        public String toString(){
            String resu;
            
            switch ( this ) {
                case TEN   : resu = "T"; break;
                case JACK  : resu = "J"; break;
                case QUEEN : resu = "Q"; break;
                case KING  : resu = "K"; break;
                case ACE   : resu = "A"; break;
                default    : resu = "" + value();
            }//switch
            
            return resu;
        }//method()

    }//enum

    

    //
    //
    // CONSTANTs----------------------------------------------------------------
    
    
    @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" )
    public static class Constant {
        
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Suit CLUB    = Suit.CLUB;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Suit DIAMOND = Suit.DIAMOND;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Suit HEART   = Suit.HEART;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Suit SPADES  = Suit.SPADES;
        
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank TWO     = Rank.TWO;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank THREE   = Rank.THREE;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank FOUR    = Rank.FOUR;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank FIVE    = Rank.FIVE;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank SIX     = Rank.SIX;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank SEVEN   = Rank.SEVEN;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank EIGHT   = Rank.EIGHT;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank NINE    = Rank.NINE;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank TEN     = Rank.TEN;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank JACK    = Rank.JACK;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank QUEEN   = Rank.QUEEN;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank KING    = Rank.KING;
        @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) public static final Rank ACE     = Rank.ACE;
        
        
        
        
        /**
         * Die Konstante {@link #C2} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>TWO</strong></code> bzw. &clubs;2.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C2 = new Card ( CLUB, TWO );
        /**
         * Die Konstante {@link #C3} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>THREE</strong></code> bzw. &clubs;3.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C3 = new Card ( CLUB, THREE );
        /**
         * Die Konstante {@link #C4} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>FOUR</strong></code> bzw. &clubs;4.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C4 = new Card ( CLUB, FOUR );
        /**
         * Die Konstante {@link #C5} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>FIVE</strong></code> bzw. &clubs;5.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C5 = new Card ( CLUB, FIVE );
        /**
         * Die Konstante {@link #C6} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>SIX</strong></code> bzw. &clubs;6.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C6 = new Card ( CLUB, SIX );
        /**
         * Die Konstante {@link #C7} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>SEVEN</strong></code> bzw. &clubs;7.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C7 = new Card ( CLUB, SEVEN );
        /**
         * Die Konstante {@link #C8} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>EIGHT</strong></code> bzw. &clubs;8.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C8 = new Card ( CLUB, EIGHT );
        /**
         * Die Konstante {@link #C9} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>NINE</strong></code> bzw. &clubs;9.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card C9 = new Card ( CLUB, NINE );
        /**
         * Die Konstante {@link #CT} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>TEN</strong></code> bzw. &clubs;10.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card CT = new Card ( CLUB, TEN );
        /**
         * Die Konstante {@link #CJ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>JACK</strong></code> bzw. &clubs;Bube.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card CJ = new Card ( CLUB, JACK );
        /**
         * Die Konstante {@link #CQ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>QUEEN</strong></code> bzw. &clubs;Dame.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card CQ = new Card ( CLUB, QUEEN );
        /**
         * Die Konstante {@link #CK} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>KING</strong></code> bzw. &clubs;K&ouml;nig.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card CK = new Card ( CLUB, KING );
        /**
         * Die Konstante {@link #CA} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>CLUB</strong>-<strong>ACE</strong></code> bzw. &clubs;Ass.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card CA = new Card ( CLUB, ACE );
        
        
        /**
         * Die Konstante {@link #D2} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>TWO</strong></code> bzw. <font color="red">&diams;2</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D2 = new Card ( DIAMOND, TWO );
        /**
         * Die Konstante {@link #D3} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>THREE</strong></code> bzw. <font color="red">&diams;3</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D3 = new Card ( DIAMOND, THREE );
        /**
         * Die Konstante {@link #D4} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>FOUR</strong></code> bzw. <font color="red">&diams;4</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D4 = new Card ( DIAMOND, FOUR );
        /**
         * Die Konstante {@link #D5} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>FIVE</strong></code> bzw. <font color="red">&diams;5</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D5 = new Card ( DIAMOND, FIVE );
        /**
         * Die Konstante {@link #D6} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>SIX</strong></code> bzw. <font color="red">&diams;6</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D6 = new Card ( DIAMOND, SIX );
        /**
         * Die Konstante {@link #D7} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>SEVEN</strong></code> bzw. <font color="red">&diams;7</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D7 = new Card ( DIAMOND, SEVEN );
        /**
         * Die Konstante {@link #D8} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>EIGHT</strong></code> bzw. <font color="red">&diams;8</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D8 = new Card ( DIAMOND, EIGHT );
        /**
         * Die Konstante {@link #D9} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>NINE</strong></code> bzw. <font color="red">&diams;9</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card D9 = new Card ( DIAMOND, NINE );
        /**
         * Die Konstante {@link #DT} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>TEN</strong></code> bzw. <font color="red">&diams;10</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card DT = new Card ( DIAMOND, TEN );
        /**
         * Die Konstante {@link #DJ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>JACK</strong></code> bzw. <font color="red">&diams;JACK</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card DJ = new Card ( DIAMOND, JACK );
        /**
         * Die Konstante {@link #DQ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>QUEEN</strong></code> bzw. <font color="red">&diams;QUEEN</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card DQ = new Card ( DIAMOND, QUEEN );
        /**
         * Die Konstante {@link #DK} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>KING</strong></code> bzw. <font color="red">&diams;KING</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card DK = new Card ( DIAMOND, KING );
        /**
         * Die Konstante {@link #DA} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>DIAMOND</strong>-<strong>ACE</strong></code> bzw. <font color="red">&diams;ACE</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card DA = new Card ( DIAMOND, ACE );
        
        
        /**
         * Die Konstante {@link #H2} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>TWO</strong></code> bzw. <font color="red">&hearts;2</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H2 = new Card ( HEART, TWO );
        /**
         * Die Konstante {@link #3} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>THREE</strong></code> bzw. <font color="red">&hearts;3</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H3 = new Card ( HEART, THREE );
        /**
         * Die Konstante {@link #H4} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>FOUR</strong></code> bzw. <font color="red">&hearts;4</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H4 = new Card ( HEART, FOUR );
        /**
         * Die Konstante {@link #H5} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>FIVE</strong></code> bzw. <font color="red">&hearts;5</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H5 = new Card ( HEART, FIVE );
        /**
         * Die Konstante {@link #H6} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>SIX</strong></code> bzw. <font color="red">&hearts;6</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H6 = new Card ( HEART, SIX );
        /**
         * Die Konstante {@link #H7} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>SEVEN</strong></code> bzw. <font color="red">&hearts;7</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H7 = new Card ( HEART, SEVEN );
        /**
         * Die Konstante {@link #H8} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>EIGHT</strong></code> bzw. <font color="red">&hearts;8</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H8 = new Card ( HEART, EIGHT );
        /**
         * Die Konstante {@link #H9} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>NINE</strong></code> bzw. <font color="red">&hearts;9</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card H9 = new Card ( HEART, NINE );
        /**
         * Die Konstante {@link #HT} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>TEN</strong></code> bzw. <font color="red">&hearts;10</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card HT = new Card ( HEART, TEN );
        /**
         * Die Konstante {@link #HJ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>JACK</strong></code> bzw. <font color="red">&hearts;JACK</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card HJ = new Card ( HEART, JACK );
        /**
         * Die Konstante {@link #HQ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>QUEEN</strong></code> bzw. <font color="red">&hearts;QUEEN</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card HQ = new Card ( HEART, QUEEN );
        /**
         * Die Konstante {@link #HK} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>KING</strong></code> bzw. <font color="red">&hearts;KING</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card HK = new Card ( HEART, KING );
        /**
         * Die Konstante {@link #HA} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>HEART</strong>-<strong>ACE</strong></code> bzw. <font color="red">&hearts;ACE</font>.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card HA = new Card ( HEART, ACE );
        
        
        /**
         * Die Konstante {@link #S2} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>TWO</strong></code> bzw. &spades;2.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S2 = new Card ( SPADES, TWO );
        /**
         * Die Konstante {@link #S3} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>THREE</strong></code> bzw. &spades;3.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S3 = new Card ( SPADES, THREE );
        /**
         * Die Konstante {@link #S4} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>FOUR</strong></code> bzw. &spades;4.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S4 = new Card ( SPADES, FOUR );
        /**
         * Die Konstante {@link #S5} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>FIVE</strong></code> bzw. &spades;5.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S5 = new Card ( SPADES, FIVE );
        /**
         * Die Konstante {@link #S6} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>SIX</strong></code> bzw. &spades;6.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S6 = new Card ( SPADES, SIX );
        /**
         * Die Konstante {@link #S7} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>SEVEN</strong></code> bzw. &spades;7.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S7 = new Card ( SPADES, SEVEN );
        /**
         * Die Konstante {@link #S8} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>EIGHT</strong></code> bzw. &spades;8.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S8 = new Card ( SPADES, EIGHT );
        /**
         * Die Konstante {@link #S9} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>NINE</strong></code> bzw. &spades;9.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card S9 = new Card ( SPADES, NINE );
        /**
         * Die Konstante {@link #ST} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>TEN</strong></code> bzw. &spades;10.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card ST = new Card ( SPADES, TEN );
        /**
         * Die Konstante {@link #SJ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>JACK</strong></code> bzw. &spades;JACK.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card SJ = new Card ( SPADES, JACK );
        /**
         * Die Konstante {@link #SQ} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>QUEEN</strong></code> bzw. &spades;QUEEN.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card SQ = new Card ( SPADES, QUEEN );
        /**
         * Die Konstante {@link #SK} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>KING</strong></code> bzw. &spades;KING.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card SK = new Card ( SPADES, KING );
        /**
         * Die Konstante {@link #SA} steht f&uuml;r die Spielkarte <em>(bzw. {@link Card})</em> <code><strong>SPADES</strong>-<strong>ACE</strong></code> bzw. &spades;ACE.
         */
        @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" ) public static final Card SA = new Card ( SPADES, ACE );
        
    }//class
    
    
    
    //
    //
    // ATTRIBUTE DATA-----------------------------------------------------------

    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) private final Suit suit;
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" ) private final Rank rank;

    
    
    //
    //
    // CONSTRUCTORs-------------------------------------------------------------

    // _???_<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Der Konstruktor erzeugt eine Karte <em>(bzw. {@link Card})</em>.
     * Dieser Konstrukor ist nur f&uuml;r interne Zwecke und setzt interne Variablen.
     * Studenten d&uuml;rfen diesen Konstruktor <strong><u>nicht</u></strong> zur L&ouml;sung der Poker-Aufgabe nutzen.
     * @param suit bestimmt die Farbe <em>(bzw. {@link Card.Suit})</em> der zu erzeugenden Karte <em>(bzw. {@link Card})</em>.
     * @param rank bestimmt den Karten-Wert <em>(bzw. {@link Card.Rank}</em> der zu erzeugenden Karte <em>(bzw. {@link Card})</em>.
     */
    @ChunkPreamble ( lastModified="2014/04/24", lastModifiedBy="Michael Schäfers" )
    Card( final Suit suit, final Rank rank ) {                                  // friendly on purpose - do NOT(!) change this
        this.suit = suit;
        this.rank = rank;
    }//constructor()
    
    
    
    //
    //
    // METHODs------------------------------------------------------------------
    
    /**
     * Die Methode {@link #printCardArray()} druckt alle Karten <em>(bzw. {@link Card})</em> eines Arrays &uuml;ber Karten <em>(bzw. {@link Card})</em>.
     * @param   cards Das Array &uuml;ber Karten <em>(bzw. {@link Card})</em>, das ausgedruckt werden soll.
     * @author  Mark-Andr&eacute; Kloesters (Idee und 1.Version 2009)
     */
    @ChunkPreamble ( author="Mark-Andre Kloesters", lastModified="2012/11/19", lastModifiedBy="Michael Schäfers" )
    public static void printCardArray( final Card... cards ){
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                System.out.printf( "%15s", " ________ " );
            }else{
                System.out.printf( "%15s", " ..NULL.. " );
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch(cards[i].getSuit()){
                    case HEART   : System.out.printf( "%15s", String.format( "|%s _  _  |", cards[i].getRank())); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|%s       |", cards[i].getRank())); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|%s  __   |", cards[i].getRank())); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|%s  __   |", cards[i].getRank())); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch(cards[i].getSuit()){
                    case HEART   : System.out.printf( "%15s", String.format( "| / \\/ \\ |" )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   /\\   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "| _|  |_ |"   )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|  /  \\  |"  )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch(cards[i].getSuit()){
                case HEART   : System.out.printf( "%15s", String.format( "| \\    / |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  /  \\  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||      ||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "| /    \\ |" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ".   00   ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch(cards[i].getSuit()){
                case HEART   : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case DIAMOND : System.out.printf( "%15s", String.format( "|  \\  /  |" )); break;
                case CLUB    : System.out.printf( "%15s", String.format( "||__  __||"  )); break;
                case SPADES  : System.out.printf( "%15s", String.format( "|/      \\|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( ". 00  00 ." ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                switch( cards[i].getSuit() ){
                    case HEART   : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case DIAMOND : System.out.printf( "%15s", String.format( "|   \\/   |"  )); break;
                    case CLUB    : System.out.printf( "%15s", String.format( "|  /__\\  |"  )); break;
                    case SPADES  : System.out.printf( "%15s", String.format( "|\\_/||\\_/|" )); break;
                }//switch
            }else{
                System.out.printf( "%15s", String.format( "00      00" ));
            }//if
        }//for
        System.out.println();
        
        for( int i=0;  i < cards.length;  i++ ){
            if( cards[i] != null ){
                System.out.printf( "%15s", "|________|" );
            }else{
                System.out.printf( "%15s", String.format( "'''NULL'''" ));
            }//if
        }//for
        System.out.println();
        
    }//method()
    
    
    
    // _???_<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Die Methode {@link #getRank()} liefert den Karten-Wert <em>(bzw. {@link Card.Rank})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.
     * @return Rang der aktuellen Karte <em>(bzw. {@link Card})</em>.
     */
    @ChunkPreamble ( lastModified="2013/01/14", lastModifiedBy="Michael Schäfers" )
    public Rank getRank() {
        return rank;     
    }//method()
    
    
    // _???_<130114> see "bug_id=4464323" resp. "http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4464323"
    /**
     * Die Methode {@link #getSuit()} liefert die Farbe <em>(bzw. {@link Card.Suit})</em> der aktuellen Karte <em>(bzw. {@link Card})</em>.
     * @return Farbe der aktuellen Karte <em>(bzw. {@link Card})</em>.
     */
    @ChunkPreamble ( lastModified="2012/01/14", lastModifiedBy="Michael Schäfers" )
    public Suit getSuit() {
        return suit;
    }//method()
    
    
    
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
    @Override
    public int compareTo( final Card other ){
        return rank.compareTo( other.rank );
    }//method()
    
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
    @Override
    public boolean equals( final Object other ){
        return ( getClass()==other.getClass() )  ?  ( suit==((Card)other).getSuit()) && (rank==((Card)other).getRank())  :  false;    
    }//method()
    
    @ChunkPreamble ( lastModified="2012/11/19", lastModifiedBy="Michael Schäfers" )
    @Override
    public int hashCode() {
        final int prime = 31;
        return  ((rank==null) ? 0 : rank.hashCode())  +  prime*((suit==null) ? 0 : suit.hashCode());
    }//method()
    
    
    
    @ChunkPreamble ( lastModified="2012/02/12", lastModifiedBy="Michael Schäfers" )
    @Override
    public String toString(){
        return " [" + suit + rank + "] ";
    }//method()
    
}//class
