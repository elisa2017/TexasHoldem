// release for SS17 by Michael Schäfers;  1st release WS07/08 by Michael Schäfers
// lastModified 2014/05/05 by Michael Schäfers
package cards;


import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ChunkPreamble {
    String author()         default "see author of class";
    String lastModified()   default "yyyy/mm/dd";                               // yyyy/mm/dd
    String lastModifiedBy() default "N/A";
}//ChunkPreamble
