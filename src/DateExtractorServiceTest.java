import Model.MyDate;
import Service.DateExtractorService;
import Service.IDateExtractorService;

import java.util.List;

public class DateExtractorServiceTest {

  public static  void main (String [] args) {
      IDateExtractorService dateExtractorService = new DateExtractorService() ;

      String text = dateExtractorService.getTextFromExterne() ;
      if (text =="")  {
          System.out.println("Le fichier source est vide !");
          return;
      }
      List<MyDate> listdates = dateExtractorService.extractDateFromText(text) ;
      if (listdates.size()<1) {
          System.out.println("Aucune Date n'a été trouvée !");
          return;
      }
      dateExtractorService.showDateListe(listdates);
  }
}