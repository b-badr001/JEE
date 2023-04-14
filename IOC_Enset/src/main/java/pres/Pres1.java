package pres;

import dao.DaoImpl;
import metier.MetierImpl;

public class Pres1 {
    public static void main(String[] args) {
        DaoImpl dao = new DaoImpl();
        MetierImpl metier = new MetierImpl(dao); //Injection via constructeur
        //metier.setDao(dao); //Injection de dépendances
        System.out.println("RES = "+metier.calcul());
    }
}