package pokerFrame.testSupport;


import static cards.Card.*;
import static cards.Card.Constant.*;

import cards.Card;
import cards.Card.Suit;


@ClassPreamble (
    vcs             = "git@BitBucket.org:schaefers/Prg_Px_Poker_Distr[.git]",
    author          = "Michael Schäfers",
    contact         = "Michael.Schaefers@HAW-Hamburg.de",
    organization    = "Dept.Informatik; HAW Hamburg",
    date            = "2012/11/19",
    version         = "3.04",
    note            = "release for SS17 ;  1st release WS08/09",
    lastModified    = "2017/03/25",
    lastModifiedBy  = "Michael Schäfers",
    reviewers       = ( "none" )
)
public class TestCaseActual {
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    private static Card designCard( final Suit suit,  final Rank rank ){
        switch( rank ){                                                         // NONE of the "default"s is required - they are just for safety's sake - hence, null ist returned
            case TWO:   switch( suit ){ case CLUB: return C2;  case DIAMOND: return D2;  case HEART: return H2;  case SPADES: return S2;  default: return null; }
            case THREE: switch( suit ){ case CLUB: return C3;  case DIAMOND: return D3;  case HEART: return H3;  case SPADES: return S3;  default: return null; }
            case FOUR:  switch( suit ){ case CLUB: return C4;  case DIAMOND: return D4;  case HEART: return H4;  case SPADES: return S4;  default: return null; }
            case FIVE:  switch( suit ){ case CLUB: return C5;  case DIAMOND: return D5;  case HEART: return H5;  case SPADES: return S5;  default: return null; }
            case SIX:   switch( suit ){ case CLUB: return C6;  case DIAMOND: return D6;  case HEART: return H6;  case SPADES: return S6;  default: return null; }
            case SEVEN: switch( suit ){ case CLUB: return C7;  case DIAMOND: return D7;  case HEART: return H7;  case SPADES: return S7;  default: return null; }
            case EIGHT: switch( suit ){ case CLUB: return C8;  case DIAMOND: return D8;  case HEART: return H8;  case SPADES: return S8;  default: return null; }
            case NINE:  switch( suit ){ case CLUB: return C9;  case DIAMOND: return D9;  case HEART: return H9;  case SPADES: return S9;  default: return null; }
            case TEN:   switch( suit ){ case CLUB: return CT;  case DIAMOND: return DT;  case HEART: return HT;  case SPADES: return ST;  default: return null; }
            case JACK:  switch( suit ){ case CLUB: return CJ;  case DIAMOND: return DJ;  case HEART: return HJ;  case SPADES: return SJ;  default: return null; }
            case QUEEN: switch( suit ){ case CLUB: return CQ;  case DIAMOND: return DQ;  case HEART: return HQ;  case SPADES: return SQ;  default: return null; }
            case KING:  switch( suit ){ case CLUB: return CK;  case DIAMOND: return DK;  case HEART: return HK;  case SPADES: return SK;  default: return null; }
            case ACE:   switch( suit ){ case CLUB: return CA;  case DIAMOND: return DA;  case HEART: return HA;  case SPADES: return SA;  default: return null; }
            default:    return null;
        }//switch
    }//method()
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/30", lastModifiedBy="Michael Schäfers" )
    private class FP {                                                          // FP ::= Final Permutation
        private final int[][] suitMix;
        
        private FP( final int[][] suitMix ){ this.suitMix = suitMix; }
        
        private Card decodeSuite( final Card protoCard ){
            return designCard( Suit.values()[suitMix[1][ protoCard.getSuit().ordinal() ]], protoCard.getRank() );
        }//method()
    }//class
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    private final long id;                                                      // ID
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final Card[] communityCard;                                                 // friendly on purpose
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final Card[][] playerHoleCard;                                              // friendly on purpose
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final String[] rop;                                                         // friendly on purpose
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final int[][] suitMix;                                                      // friendly on purpose
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final FP fp;                                                                // Final Permutation - friendly on purpose
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public TestCaseActual( final TestCaseProto tcp ){
        id = tcp.id;
        suitMix = Permutationer.generateRandomPermutation( 4 );
        fp = new FP( suitMix );
        
        final Card[] cc1 = new Card[5];
        cc1[0] = tcp.card[2];
        cc1[1] = tcp.card[5];
        cc1[2] = tcp.card[8];
        cc1[3] = tcp.card[11];
        cc1[4] = tcp.card[14];
        //
        final int[] communityCardMix = Permutationer.generateRandomPermutation( 5 )[0];
        final Card[] cc2 = new Card[5];
        for ( int i=0; i<5; i++ )  cc2[i] = cc1[communityCardMix[i]];
        //
        communityCard = new Card[5];
        for ( int i=0; i<5; i++ )  communityCard[i] = encodeSuite( cc2[i] );
        
        final Card[][] hc1 = new Card[5][];
        for ( int i=0; i<5; i++ )  hc1[i] = new Card[2];
        final int[][] rd = {{0,7},{1,9},{3,10},{4,12},{6,13}};
        for ( int i=5; --i>=0; ){
            final boolean rb = (0.5<=Math.random());
            hc1[i][0] = rb?tcp.card[rd[i][0]]:tcp.card[rd[i][1]];
            hc1[i][1] = rb?tcp.card[rd[i][1]]:tcp.card[rd[i][0]];
        }//for
        
        final int[] permu = Permutationer.decodePermutation( tcp.prm );
        final String[] rp1 = new String[5];
        for ( int i=0; i<5; i++ )  rp1[i] = tcp.rop[permu[i]];
        
        final int[] handCardMix = Permutationer.generateRandomPermutation( 5 )[0];
        final Card[][] hc2 = new Card[5][];
        final String[] rp2 = new String[5];
        for ( int i=0; i<5; i++ ){
            hc2[i] = hc1[handCardMix[i]];
            rp2[i] = rp1[handCardMix[i]];
        }//for
        
        playerHoleCard = new Card[Constant.NUM_OF_PLAYERS][];
        rop = new String[Constant.NUM_OF_PLAYERS];
        for ( int i=0; i<5; i++ ){
             playerHoleCard[i] = new Card[]{ encodeSuite( hc2[i][0] ), encodeSuite( hc2[i][1] ) };
             rop[i] = rp2[i];
        }//for
    }//constructor()
    //
    // for internal debugging only
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    protected TestCaseActual( final Card... card ){
        assert card.length==15 : "15 cards required";
        communityCard  = new Card[5];
        playerHoleCard = new Card[5][2];
        System.arraycopy( card,  0,    communityCard,     0,    5 );
        System.arraycopy( card,  5,    playerHoleCard[0], 0,    2 );
        System.arraycopy( card,  7,    playerHoleCard[1], 0,    2 );
        System.arraycopy( card,  9,    playerHoleCard[2], 0,    2 );
        System.arraycopy( card, 11,    playerHoleCard[3], 0,    2 );
        System.arraycopy( card, 13,    playerHoleCard[4], 0,    2 );
        //
        id = Integer.MIN_VALUE;
        rop = null;
        suitMix = null;
        fp = null;
    }//constructor()
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public Card[] getPlayerHoleCards( final int playerNo ){
        return playerHoleCard[playerNo].clone();
    }//method()
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public Card[] getCommunityCards(){
        return communityCard.clone();
    }//method()
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public String[] getROP(){                                                   // ROG <=> ROP[]
        return rop.clone();
    }//method()
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public Card encodeSuite( final Card protoCard ){ return designCard( Suit.values()[suitMix[0][ protoCard.getSuit().ordinal() ]], protoCard.getRank() ); }
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public Card decodeSuite( final Card protoCard ){ return fp.decodeSuite( protoCard ); }
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public void standardizedPrintOfGivenCards(){
        System.out.printf( "community cards :" );
        for ( int i=0; i<5; i++ ){
            System.out.printf( " %s",  communityCard[i] );
        }//for
        System.out.printf( "\n" );
        
        for (int i=0; i<5; i++ ){ 
            System.out.printf(
                "player#%d        : %s %s\n",
                i+1,
                playerHoleCard[i][0],
                playerHoleCard[i][1]
            );//printf()
        }//for
    }//method()
    
    
    // Getter for ID to "give ID to students"
    @ChunkPreamble ( lastModified="2014/05/26", lastModifiedBy="Michael Schäfers" )
    public long getId(){
        long tmp;
        if ( id < 3_372_036_854_775L ){                                         // Long.Max_Value == 9223372036854775807
            final StringBuffer sb = new StringBuffer();
            tmp = 100+(int)( 900 * Math.random() );
            sb.append( tmp );
            sb.append( id );
            tmp = (int)( 1000*Math.random() );
            final String post = String.format( "%03d", tmp );
            sb.append( post );
            tmp = Long.parseLong( sb.toString() );
        }else{
            System.out.printf("\n===>>> NOTE: id = %d <<<=== !!!!\n", id );
            tmp = id;
        }//if
        return tmp;
    }//method()
    
    
    
    //___under_development______________________________________________________
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static final private CID cid = new CID();
    //
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static final private class CID {                                            // Class IDentification
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
        private CID(){
            final Registration registration = Registration.getInstance();
            registration.registrate( getClass() );
        }//constructor()
    }//class
    
}//class
