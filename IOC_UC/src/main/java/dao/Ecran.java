package dao;

import org.springframework.stereotype.Repository;

@Repository
public class Ecran implements VGA {
    @Override
    public void print(String message) {
        System.out.println("Affichage sur l'écran : " + message);
    }
}
