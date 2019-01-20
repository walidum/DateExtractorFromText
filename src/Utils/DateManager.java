package Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateManager {
    /**
     *
     * @param item1
     * @param item2
     * @param item3
     * @return
     */
    public static boolean hasDateFormat (String item1 , String item2, String item3) {
        return   (StringManager.isNumeric(item3)) && (StringManager.isNumeric(item1) || StringManager.isNumeric(item2)) ;
    }

    /**
     *
     * @param item1
     * @param item2
     * @param item3
     * @return
     */
    public static Date TryParseToDate (String item1 , String item2, String item3){
        if (StringManager.isNumeric(item1) && StringManager.isNumeric(item2))
        {//si le mois de la date est numéric
            return DateManager.tryParseNumericDate (item1 ,   item2,   item3);
        }else //si le mois de la date n'est pas numéric
        {
            return DateManager.tryParseNotNumericDate(item1,item2,item3);
        }
    }

    /**
     *
     * @param item1
     * @param item2
     * @param item3
     * @return
     */
    public static Date tryParseNumericDate (String item1 , String item2, String item3 ) {
        Date date = null ;
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("dd.MM.yyyy");
        try {
            if (item1.length()>2) // si item1 est une annee on utilise le format1
                date  = format1.parse ( item1+"-"+item2+"-"+item3  );
            else // on utilise le format2 pour parser (item1+item2+item3)
                date  = format2.parse ( item1+"."+item2+"."+item3  );
        }catch ( Exception e) {
            date = null ;
        }
        return date ;
    }

    /**
     *
     * @param item1
     * @param item2
     * @param item3
     * @return
     */
    public static   Date tryParseNotNumericDate (  String item1 , String item2, String item3) {
        Date date = null;
        String  localeDateformat ,ourStringDate;
        DateFormat dateFormat;
        //recuperer la liste des locales de java (US, FR ....)
        Locale[] locales = DateFormat.getAvailableLocales();
        //Pour chaque locale on essayer d'obtenir la date à partir de (item1+item2+item3)
        for (Locale locale : locales) {
            try {
                //on récupère le dateformat propre au Locale actuel
                localeDateformat = StringManager.getDateFormatOfLocale( locale );
                //mettre notre (item1+item2+item3) sous la forme de dateformat du locale
                ourStringDate = StringManager.makeToDateFormat(locale,  item1 ,   item2,   item3);
                // essayer de "parser" notre String Date
                dateFormat = new SimpleDateFormat(localeDateformat, locale);
                //on essaie de parcer la date
                date   = dateFormat.parse(ourStringDate);
                //une fois trouver une date juste on sort de la boucle
                break;
            }catch (Exception e){
                date = null ;
            }
        }
        return date  ;
    }
}
