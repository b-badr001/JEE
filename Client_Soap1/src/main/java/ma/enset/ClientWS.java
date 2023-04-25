package ma.enset;

import proxy.ReleveServiceService;
import proxy.ReleveWS;

public class ClientWS {
    public static void main(String[] args) {

        ReleveServiceService stub = new ReleveWS().getReleveServiceServicePort();
    }
}
