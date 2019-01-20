package Utils;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import static java.util.TimeZone.LONG;

public class StringManager {
    /**
     *
     * @param locale
     * @param item1
     * @param item2
     * @param item3
     * @return mettre item1 + item2 + item3 sous la date format du locale
     */
    public static   String  makeToDateFormat(Locale locale, String item1 , String item2, String item3){
        String  res   ;
        DateFormat fmt = DateFormat.getDateInstance(LONG, locale);
        String modeleDateFormat = fmt.format(new Date()) ;
        String del = getDelimiteurs(modeleDateFormat) ;
        res = item1+del.charAt(0)+" "+item2+del.charAt(1)+" "+ item3 ;
        return  res;
    }
    /**
     *
     * @param strNum
     * @return
     */
    public static boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }
    /**
     *
     * @param locale
     * @return date format du locale
     */
    public static   String  getDateFormatOfLocale( Locale locale  ){
        String  res   ;
        DateFormat fmt = DateFormat.getDateInstance(LONG, locale);
        String modeleDateFormat = fmt.format(new Date()) ;
        String[] Tableau = modeleDateFormat.split("\\W+");
        String del = getDelimiteurs(modeleDateFormat) ;
        if (isNumeric(Tableau[0])) {
            res = "dd"+del.charAt(0)+" MMMM"+del.charAt(1)+ " yyyy" ;
        }
        else {
            res = "MMMM"+del.charAt(0)+" dd"+del.charAt(1)+ " yyyy" ;
        }
        return  res;
    }

    /**
     *
     * @param dateformat
     * @return chaine de caractère qui contient les  getDelimiteurs de dateformat
     */
    public static  String  getDelimiteurs ( String dateformat ) {
        char[] chars = dateformat.toCharArray();
        String res ="" ;
        for (int i= 0 ; i<chars.length ; i++){
            if (chars[i] == ',') res = res + ","; ;
            if (chars[i] == '.')res = res + ".";
            if (chars[i] == ' ')res = res + " " ;
        }
        if (res.length()<2 ) res = ", ";
        return res;
    }
}
