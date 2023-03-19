package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component("dao")
@Repository
public class DaoImpl implements IDao{
    @Override
    public double getDate() {
        System.out.println("version base de données");
        double data = 37;
        return data;
    }
}
