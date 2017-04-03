package pokerFrame.testSupport;


import java.util.Arrays;


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
public class ResultOfGame {
    
    @ChunkPreamble ( lastModified="2014/05/30", lastModifiedBy="Michael Schäfers" )
    final ResultOfPlayer[] rop;                                                 // friendly on purpose
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public ResultOfGame( final ResultOfPlayer[] rop ){
        assert rop.length == Constant.NUM_OF_PLAYERS : String.format( "Usage Error: %d != %d",  rop.length, Constant.NUM_OF_PLAYERS ) ;
        this.rop = rop.clone();
    }//constructor()
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    public void standardizedPrint(){
        
        // print cards of placers in a nice way
        final char RAQUO = '\u00bb';                                            // Guillemet: '>>'
        //
        for ( int i=0; i<Constant.NUM_OF_PLAYERS; i++ ){
            System.out.printf( "player#%d plays:  ", i+1 );
            switch ( rop[i].handRank ){
                case STRAIGHT_FLUSH: System.out.printf( "[%s%c%s%c%s%c%s%c%s]",  rop[i].card[0], RAQUO, rop[i].card[1], RAQUO, rop[i].card[2], RAQUO, rop[i].card[3], RAQUO, rop[i].card[4] ); break;
                case QUADS:          System.out.printf( "[%s-%s-%s-%s|%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case FULL_HOUSE:     System.out.printf( "[%s-%s-%s|%s-%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case FLUSH:          System.out.printf( "[%s~%s~%s~%s~%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case STRAIGHT:       System.out.printf( "[%s>%s>%s>%s>%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case TRIPS:          System.out.printf( "[%s-%s-%s|%s|%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case TWO_PAIR:       System.out.printf( "[%s-%s|%s-%s|%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case ONE_PAIR:       System.out.printf( "[%s-%s|%s|%s|%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
                case HIGH_CARD:      System.out.printf( "[%s|%s|%s|%s|%s]",      rop[i].card[0], rop[i].card[1], rop[i].card[2], rop[i].card[3], rop[i].card[4] ); break;
            }//switch
            System.out.printf( "  %s\n",  rop[i].handRank );
        }//for
        System.out.printf( "\n" );
        
        
        // print showdown rankings of players in a nice way
        @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
        class ShowDownRank implements Comparable<ShowDownRank>{
            @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
            ShowDownRank( final int showDownRank, final int playerId ){
                this.showDownRank = showDownRank;
                this.playerId = playerId;
            }//constructor()
            //
            @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
            @Override
            public int compareTo( ShowDownRank other ){
                final int tmp = showDownRank - other.showDownRank;
                return (tmp!=0) ? tmp : playerId - other.playerId;
            }//method()
            //
            @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
            final int showDownRank;
            //
            @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
            final int playerId;
        }//class
        //
        ShowDownRank[] showDownRanking = new ShowDownRank[Constant.NUM_OF_PLAYERS];
        for ( int i=0; i<Constant.NUM_OF_PLAYERS; )  showDownRanking[i] = new ShowDownRank( rop[i].position, ++i );
        Arrays.sort( showDownRanking );
        //
        StringBuilder sb = new StringBuilder( "~~>    { " );
        loop:
        for ( int i=0; true; ){
            sb.append( String.format( "player#%d_(%d)",  showDownRanking[i].playerId, showDownRanking[i].showDownRank ));
            if ( i>=Constant.NUM_OF_PLAYERS-1)  break loop;
            sb.append( (showDownRanking[i].showDownRank==showDownRanking[++i].showDownRank)  ?  " & "  :  " }   >   { " );
        }//for
        sb.append( " }" );
        //
        System.out.printf( "%s\n", sb );
        
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
