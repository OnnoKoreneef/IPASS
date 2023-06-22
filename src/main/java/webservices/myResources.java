package webservices;

import model.Bedrijf;
import model.Klant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/klanten")
public class myResources {
    @GET
    @Produces("application/json")
    public ArrayList<Klant> getKlanten() {
        ArrayList<Klant> klanten = new ArrayList<>();
        Klant onno = new Klant("Onno", "Koreneef", "onnokoreneef@hotmail.nl", "W8woord!", "Bennekom", "Cederlaan", 5, "0638485404");
        Klant pierre = new Klant("Pierre", "Koreneef", "phkoreneef@hotmail.com", "1", "Bunnik", "Ds pasmastraat", 5, "06244676398");
        klanten.add(onno);
        klanten.add(pierre);
        return klanten;
    }
}
