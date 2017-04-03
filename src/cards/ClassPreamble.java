// release for SS17 by Michael Schäfers;  1st release WS07/08 by Michael Schäfers
// lastModified 2017/03/25 by Michael Schäfers
package cards;


import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassPreamble {
    String vcs()            default "git@bitbucket.org:schaefers/Prg_Support_Cards[.git]";
    String author()         default "Michael Schäfers";
    String contact()        default "Michael.Schaefers@HAW-Hamburg.de";
    String organization()   default "Dept.Informatik; HAW Hamburg";
    String date()           default "yyyy/mm/dd";                               // yyyy/mm/dd
    String version()        default "1.0";
    String note()           default "N/A";
    String lastModified()   default "yyyy/mm/dd";                               // yyyy/mm/dd
    String lastModifiedBy() default "N/A";
    String reviewed()       default "N/A";                                      // yyyy/mm/dd
    String[] reviewers()    default { "N/A" };
}//ClassPreamble
