package Service;

import Model.MyDate;
import Utils.DateManager;
import Utils.FileManager;

import java.util.*;
import java.util.stream.IntStream;

public class DateExtractorService implements IDateExtractorService{
    @Override
    public List<MyDate>   extractDateFromText(String text) {
        //convertir le text en tableau de mots
        String[] Tableau = text.split("\\W+");
        int length = Tableau.length ;
        Date date ;
        List<MyDate> list = new ArrayList<MyDate>();
        for ( int i = 0 ;i<length ; i++){
            if (i+2 < length) {
                //on prend 3 mots (items), puis on vérifie est-ce qu'ils forment une date
                if ( DateManager.hasDateFormat(Tableau[i],Tableau[i+1],Tableau[i+2]) ){//premier test
                    //essayer d'avoire une date à partire des Tableau[i]+Tableau[i+1]+Tableau[i+2]
                    date =  DateManager.TryParseToDate(Tableau[i],Tableau[i+1],Tableau[i+2]);
                    //si on a une date valide on la rajoute à notre liste de dates
                    if (date!=null) addToListe(date,list);
                }
            }
        }
        //trier la liste des dates valides
        Collections.sort(list,  (o1, o2) -> o1.getDate().compareTo(o2.getDate())) ;
        return  list ;
    }
    @Override
    public void showDateListe(List<MyDate> list) {
        if (list==null || list.size() <1) return;
        int annee = list.get(0).getAnnee() ;
        int mois =0 ;
        System.out.println("The program would produce : ");
        System.out.println(annee + " :");
        for (MyDate date: list ) {
            if (date.getAnnee() != annee) { //pour afficher les date qui ont la méme année
                annee = date.getAnnee() ;
                System.out.println(annee + " :");
            }
            if (mois != date.getMois() ){//pour afficher les date qui ont le méme mois
                System.out.println("        -"+date.getMoisString()  );
                mois = date.getMois() ;
            }
            System.out.println("                -"+date.getJourString() +"("+date.getCompteur()+")" );
        }
        System.out.println("--------------------------------------");
    }
    @Override
    public String getTextFromExterne() {
        String path = "src/text.txt" ;
        String text =  FileManager.readTextFromFile(path) ;
        return  text ;
    }
    private   void  addToListe(Date date , List<MyDate> list) {
        MyDate myDate = new MyDate(date) ;
        OptionalInt indexOpt = IntStream.range(0, list.size())
                .filter(i -> myDate.getDate().equals(list.get(i).getDate()))
                .findFirst();
        try { //si  la date existe déjà dans la liste on incrimente le compteur
            list.get(indexOpt.getAsInt()).incrementerCpt();
        }catch (Exception e){  //sinon on l'ajoute dérectement
            list.add(myDate) ;
        }
    }
}
