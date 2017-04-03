package pokerFrame.testSupport;


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
public class Constant {
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static final public int NUM_OF_PLAYERS = 5;
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Schäfers" )
    static final long[] PRIME = {
          2,     3,     5,     7,    11,    13,    17,    19,    23,    29,
         31,    37,    41,    43,    47,    53,    59,    61,    67,    71,
         73,    79,    83,    89,    97,   101,   103,   107,   109,   113,
        127,   131,   137,   139,   149,   151,   157,   163,   167,   173,
        179,   181,   191,   193,   197,   199,   211,   223,   227,   229,
        233,   239,   241,   251,   257,   263,   269,   271,   277,   281,
        283,   293,   307,   311,   313,   317,   331,   337,   347,   349,
        353,   359,   367,   373,   379,   383,   389,   397,   401,   409,
        419,   421,   431,   433,   439,   443,   449,   457,   461,   463,
        467,   479,   487,   491,   499,   503,   509,   521,   523,   541
    };//array
    
    @ChunkPreamble ( lastModified="2016/03/18", lastModifiedBy="Michael Schäfers" )
    static final String requestedPackagePath = "pokerFrame.testSupport";
    
    
    
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
