package Utils;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    /**
     *
     * @param path
     * @return
     */
      public  static  String readTextFromFile (String path  )  {
          String text = "" ;
          try {
              File file =  new File(path);
              Scanner sc = new Scanner(  file);
              while (sc.hasNextLine())
                  text = text + sc.nextLine() +" "  ;
          } catch (Exception e){
              text = "" ;
          }
          return text ;
      }
}
