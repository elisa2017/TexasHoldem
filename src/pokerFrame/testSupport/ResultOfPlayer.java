package pokerFrame.testSupport;


import cards.*;


@ClassPreamble (
    vcs             = "git@BitBucket.org:schaefers/Prg_Px_Poker_Distr[.git]",
    author          = "Michael Sch�fers",
    contact         = "Michael.Schaefers@HAW-Hamburg.de",
    organization    = "Dept.Informatik; HAW Hamburg",
    date            = "2012/11/19",
    version         = "3.04",
    note            = "release for SS17 ;  1st release WS08/09",
    lastModified    = "2017/03/25",
    lastModifiedBy  = "Michael Sch�fers",
    reviewers       = ( "none" )
)
public class ResultOfPlayer {
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    final HandRanking handRank;
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    final Card[] card;
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    int position;                                                               // 1=best, 5=worst(of 5)
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    public ResultOfPlayer( final int pos,  final HandRanking hrk,  final Card[] card ){
        this.position = pos;
        this.handRank = hrk;
        this.card     = card.clone();
    }//constructor()
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    public ResultOfPlayer( final HandRanking hrk,  final Card[] card ){ this( Integer.MAX_VALUE, hrk, card ); }
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    public int setPosition( final int newPositionValue ){
        final int oldPositionValue = position;
        position = newPositionValue;
        return oldPositionValue;
    }//method()
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Sch�fers" )
    @Override
    public ResultOfPlayer clone(){ return new ResultOfPlayer( this.position, this.handRank, card.clone() ); }
    
    
    
    //___under_development______________________________________________________
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    static final private CID cid = new CID();
    //
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    static final private class CID {                                            // Class IDentification
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        private CID(){
            final Registration registration = Registration.getInstance();
            registration.registrate( getClass() );
        }//constructor()
    }//class
    
}//class
