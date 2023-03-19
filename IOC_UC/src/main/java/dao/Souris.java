package dao;

import org.springframework.stereotype.Repository;

@Repository
public class Souris implements USB {
    @Override
    public int read() {
        System.out.println("Lecture de la souris...");
        return 0;
    }
}
