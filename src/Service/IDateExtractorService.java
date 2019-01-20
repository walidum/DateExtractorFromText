package Service;

import Model.MyDate;

import java.util.List;

public interface IDateExtractorService {
    /**
     *
     * @return
     */
    String  getTextFromExterne() ;

    /**
     *
     * @param text
     * @return
     */
    List<MyDate> extractDateFromText(String text);

    /**
     *
     * @param list
     */
    void  showDateListe(List<MyDate> list) ;
}
