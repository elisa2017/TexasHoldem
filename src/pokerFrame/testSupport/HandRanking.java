package pokerFrame.testSupport;


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
public enum HandRanking {
    HIGH_CARD,
    ONE_PAIR,
    TWO_PAIR,
    TRIPS,
    STRAIGHT,
    FLUSH,      
    FULL_HOUSE,
    QUADS,
    STRAIGHT_FLUSH;
    
    
    
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
    
}//enum
