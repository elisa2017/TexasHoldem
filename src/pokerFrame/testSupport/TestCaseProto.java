package pokerFrame.testSupport;


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
public class TestCaseProto {
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final Card[] card;
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final long id;
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final long prm;
    //
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    final String[] rop;
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public TestCaseProto( final Card[] card,  final long id,  final long prm,  final String[] rop ){
        this.card = card;
        this.id = id;
        this.prm = prm;
        this.rop = rop;
    }//constructor()
    
    
    
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
