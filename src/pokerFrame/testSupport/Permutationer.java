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
public class Permutationer {
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    static int[] decodePermutation( long codedPermutation ){                    // friendly on purpose
        final int[] permutation = new int[5];
        
        for ( int i=5; --i>=0; ){
            int cnt=0;
            while ( codedPermutation % Constant.PRIME[i] == 0 ){
                codedPermutation /= Constant.PRIME[i];
                cnt++;
            }//while
            permutation[i] = cnt;
        }//for
        
        assert codedPermutation==1 : "INTERNAL PROGRAMMING ERROR - contact programmer resp. Shf";
        return permutation;
    }//method()
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    static long encodePermutation( int[] permutation ){                         // friendly on purpose
        long codedPermutation;
        
        codedPermutation = -1;  // see c07_S12W_TI1_P1.aufgabenzettel4_A9.inputGeneration.PermutationManagerModified

        assert codedPermutation>0 : "INTERNAL PROGRAMMING ERROR - contact programmer resp. Shf";
        return codedPermutation;
    }//method()
    
    
    
    @ChunkPreamble ( lastModified="2014/05/25", lastModifiedBy="Michael Schäfers" )
    static int[][] generateRandomPermutation( final int size ){                 // friendly
        assert size>0 : "INTERNAL PROGRAMMING ERROR - contact programmer resp. Shf";
        final int sm1 = size-1;
        
        final int[][] permutation = new int[2][size];
        for ( int i=size; --i>=0; ){
            permutation[0][i] = -1;                                             // init
            permutation[1][i] = -1;                                             // init
        }//for
        
        int j = 0;
        for ( int i=size; i>0; ){
            int r=1+(int)( Math.random() * i-- );
            while ( r>0 ){
                do{
                    if ( j < sm1 )  j++;  else  j=0;
                }while ( permutation[0][j] != -1 );
                r--;
            }//while
            permutation[0][j] = i;
            permutation[1][i] = j;
        }//for
        
        for ( int i=size; --i>=0; )  assert permutation[0][i]!=-1 && permutation[1][i]!=-1 : "INTERNAL PROGRAMMING ERROR - contact programmer resp. Shf";
        return permutation;
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
