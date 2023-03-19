package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class MetierImpl implements IMetier {

    private IDao dao;

    public MetierImpl(IDao dao)
    {
        this.dao = dao;
    }
    @Override
    public double calcul() {
        double data = dao.getDate();
        double res = data * 11.4;
        return res;
    }

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
