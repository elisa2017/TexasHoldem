// release for SS17 by Michael Sch�fers;  1st release WS07/08 by Michael Sch�fers
// lastModified 2016/03/19 by Michael Sch�fers
package pokerFrame.testSupport;


import java.lang.annotation.*;


@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassPreamble {
    String vcs()            default "bitbucket.org/schaefers/cards.git";
    String author()         default "Michael Sch�fers";
    String contact()        default "michael.schaefers@haw-hamburg.de";
    String organization()   default "Dept.Informatik; HAW Hamburg";
    String date()           default "yyyy/mm/dd";                               // yyyy/mm/dd
    String version()        default "1.0";
    String note()           default "N/A";
    String lastModified()   default "yyyy/mm/dd";                               // yyyy/mm/dd
    String lastModifiedBy() default "N/A";
    String reviewed()       default "N/A";                                      // yyyy/mm/dd
    String[] reviewers()    default { "N/A" };
}//annotation declaration
