package Model;

import java.util.Calendar;
import java.util.Date;

public class MyDate {
    private Date date ;
    private  int mois ;
    private  int jour ;
    private int  annee;
    private  int compteur ;

    public int getMois() {
        return mois;
    }
    public String getMoisString() {
        if(mois<10) return "0"+mois ;
        else return  mois+"" ;
    }
    public void setMois(int mois) {
        this.mois = mois;
    }
    public int getJour() {
        return jour;
    }
    public String getJourString() {
         if(jour<10) return "0"+jour ;
         else return  jour+"" ;
    }
    public void setJour(int jour) {
        this.jour = jour;
    }
    public int getAnnee() {
        return annee;
    }
    public void setAnnee(int annee) {
        this.annee = annee;
    }
    @Override
    public String toString() {
        return "MyDate{" +
                "date=" + date +
                ", mois=" + mois +
                ", jour=" + jour +
                ", annee=" + annee +
                ", compteur=" + compteur +
                '}';
    }

    public MyDate(Date date) {
        this.date = date;
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        this.annee = cal.get(Calendar.YEAR);
        this.mois = cal.get(Calendar.MONTH )+1;
        this.jour = cal.get(Calendar.DAY_OF_MONTH);
        this.compteur = 1 ;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }
    public  void  incrementerCpt (){
        this.setCompteur(this.getCompteur() +1);
    }
}
