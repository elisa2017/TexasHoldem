package pokerFrame.testSupport;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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
final public class Registration {
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    final class Data {
        
        @ChunkPreamble ( lastModified="2014/05/29", lastModifiedBy="Michael Sch�fers" )
        Class<?> getClss(){ return clss; }
        
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        String getPackagePath(){ return pckg.getName(); }
        
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        @Override
        public String toString(){
            return String.format(
                "%s -> %s",
                clss.getSimpleName(),
                pckg.getName()
            );
        }//method()
        
        @ChunkPreamble ( lastModified="2016/03/19", lastModifiedBy="Michael Sch�fers" )
        @Override
        public int hashCode(){
            return (    pckg.hashCode()
                + 31 *( clss.hashCode() )
            );
        }//method()
        
        @ChunkPreamble ( lastModified="2016/03/19", lastModifiedBy="Michael Sch�fers" )
        @Override
        public boolean equals( final Object otherObject ){
            if( this == otherObject )  return true;
            if( null == otherObject )  return false;
            if( getClass()!=otherObject.getClass() )  return false;
            final Data other = (Data)( otherObject );
            if( isUnequal( clss, other.clss ))  return false;
            if( isUnequal( pckg, other.pckg ))  return false;
            return true;
        }//method()
        //
        @ChunkPreamble ( lastModified="2016/03/19", lastModifiedBy="Michael Sch�fers" )
        private boolean isUnequal( final Object o1, final Object o2 ){
            return (o1!=o2) && ( (null==o1) || ( ! o1.equals( o2 )));
        }//method()
        
        
        
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        private Data( final Class<?> clss,  final Package pckg ){
            this.clss = clss;
            this.pckg = pckg;
        }//constructor()
        
        
        
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        final Class<?> clss;
        
        @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
        final Package  pckg;
        
    }//class
    
    
    
    
    
    @ChunkPreamble ( lastModified="2016/03/19", lastModifiedBy="Michael Sch�fers" )
    private Registration(){
        set = new HashSet<Data>();
    }//constructor()
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    static public Registration getInstance(){ return instance; }
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    static final private Registration instance = new Registration();
    
    
    
    @ChunkPreamble ( lastModified="2014/05/28", lastModifiedBy="Michael Sch�fers" )
    public final void registrate( final Class<?> clss ){
        final Class<?> enclosingClass = clss.getEnclosingClass();
        set.add( new Data( enclosingClass, enclosingClass.getPackage() ) );
    }//method()
    
    
    
    
    
    @ChunkPreamble ( lastModified="2014/05/30", lastModifiedBy="Michael Sch�fers" )
    private final Set<Data> set;      public Collection<Data> getCollectionList(){ return set; }
    
}//class
