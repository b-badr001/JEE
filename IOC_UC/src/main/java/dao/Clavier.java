package dao;

import org.springframework.stereotype.Repository;

@Repository
public class Clavier implements USB {
    @Override
    public int read() {
        System.out.println("Lecture du clavier...");
        return 0;
    }
}
