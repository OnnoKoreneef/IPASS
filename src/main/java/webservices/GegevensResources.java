package webservices;

import model.Klant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;

@Path("/gegevens")
public class GegevensResources {
    @GET
    @Produces("application/json")
    public ArrayList<Klant> gegevens() {
        //        Klant pierre = new Klant("Pierre", "Koreneef", "phkoreneef@hotmail.com", "1", "Bunnik", "Ds pasmastraat", 5, "06244676398");
//        klanten.add(pierre);
        return new ArrayList<>();
    }
}
