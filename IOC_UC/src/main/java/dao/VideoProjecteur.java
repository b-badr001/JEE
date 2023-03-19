package dao;

import org.springframework.stereotype.Repository;

@Repository
public class VideoProjecteur implements VGA {
    @Override
    public void print(String message) {
        System.out.println("Affichage sur le vidéo projecteur : " + message);
    }
}
