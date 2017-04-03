package pokerFrame.testSupport;


import java.math.BigInteger;
import cards.Card;


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
public class Coder {
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static BigInteger encodeROP( final ResultOfPlayer rop,  final TestCaseActual tca ){  // friendly on prurpose
        BigInteger resu = BigInteger.ONE;
        Long value = encodeCards( rop.card, tca );
        resu = resu.multiply( new BigInteger( value.toString() ) );
        value = Constant.PRIME[52] * (1+rop.handRank.ordinal());                         // 13*4 = 52 cards => 0, .., 51
        resu = resu.multiply( new BigInteger( value.toString() ) );
        value = Constant.PRIME[53] * rop.position;                                       //
        resu = resu.multiply( new BigInteger( value.toString() ) );
        return resu;
    }//method()
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static long encodeCards( final Card[] ca,  final TestCaseActual tca ){               // friendly on prurpose
        assert ca!=null & 5<=ca.length && ca.length<=7 : "Invalid parameter - card array requires 5 to 7 cards";
        long resu = 1L;
        for ( final Card c : ca ){
            resu *= Constant.PRIME[ computeCardOrdinal( tca.decodeSuite( c ) ) ];
        }//for
        return resu;
    }//method()
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static int computeCardOrdinal( final Card card ){                                    // friendly on prurpose
        return 4*card.getRank().ordinal() + card.getSuit().ordinal();
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
    
}//Coder
