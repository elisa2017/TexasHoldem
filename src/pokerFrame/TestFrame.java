package pokerFrame;


import java.text.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;

import pokerFrame.testSupport.*;


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
public class TestFrame {
    
    @ChunkPreamble ( lastModified="2017/03/21", lastModifiedBy="Michael Schäfers" )
    public static void main( final String... unused ){
        final ZoneId localZoneId = ZoneId.of( "Europe/Berlin");
        
        System.out.printf( "\n\n\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "### Informationen zum Environment:\n" );
        System.out.printf( "### ==============================\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### Java:     %s bzw. %s\n",                System.getProperty( "java.specification.version" ), System.getProperty( "java.version" ) );
        System.out.printf( "### O.-P.:    %s\n",                        new Object().getClass().getPackage() );
        System.out.printf( "###\n" );
        System.out.printf( "### %s  is home of \".class\"-files\n",     TestFrame.class.getProtectionDomain().getCodeSource().getLocation().getPath() );
        System.out.printf( "### %s  is running\n",                       cid.getClass().getEnclosingClass().getCanonicalName() );
        System.out.printf( "###\n" );
        System.out.printf( "###\n" );
        System.out.printf( "### STARTING @ %s %s\n",                    LocalDate.now( localZoneId ), LocalTime.now( localZoneId ) );
      //System.out.printf( "### STARTING @ %s\n", new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss.SSS", new Locale("de","DE") ).format( new Date().getTime() ) );
        System.out.printf( "\n" );
        System.out.flush();
        
        final GameAnalyzer ga = new DummyForYourSolution();
        final TestExecutor te = new FieldSimulator( ga );
        te.execute();
        
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "###############################################################################\n" );
        System.out.printf( "### THE END @ %s %s", LocalDate.now( localZoneId ), LocalTime.now( localZoneId ) );
      //System.out.printf( "### THE END @ %s", new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss.SSS", new Locale("de","DE") ).format( new Date().getTime() ) );
        
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
