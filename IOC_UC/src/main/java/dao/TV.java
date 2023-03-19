package dao;

import org.springframework.stereotype.Repository;

@Repository
public class TV implements HDMI {
    @Override
    public void print(byte[] data) {
        System.out.println("Affichage sur la TV : " + new String(data));
    }
}
