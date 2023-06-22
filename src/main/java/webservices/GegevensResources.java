package webservices;

import model.Bedrijf;
import model.Klant;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;

import static javax.ws.rs.core.Response.serverError;

@Path("/gegevens")
public class GegevensResources {
    @GET
    @Produces("application/json")
    public ArrayList<Klant> gegevens() {
        ArrayList<Klant> klanten = new ArrayList<>();
        Klant onno = new Klant("Onno", "Koreneef", "onnokoreneef@hotmail.nl", "W@woord!", "Bennekom", "cederlaan", 5, "0638485404");
        klanten.add(onno);
        return klanten;
//        return new ArrayList<>();
    }

//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    public String createGegevens(String jsonBody) {
//        JsonObjectBuilder responseObject = Json.createObjectBuilder();
//
//        try {
//            StringReader stringReader = new StringReader(jsonBody);
//            JsonReader jsonReader = Json.createReader(stringReader);
//            JsonObject jsonObject = jsonReader.readObject();
//
//            String voornaam = jsonObject.getString("voornaam");
//            String achternaam = jsonObject.getString("achternaam");
//            String email = jsonObject.getString("email");
//            String wachtwoord = jsonObject.getString("wachtwoord");
//            String woonplaats = jsonObject.getString("woonplaats");
//            String straatnaam = jsonObject.getString("straatnaam");
//            int huisnummer = jsonObject.getInt("huisnummer");
//            String telefoonnummer = jsonObject.getString("telefoonnummer");
//
//            Bedrijf bedrijf = new Bedrijf();
//
//            bedrijf.createKlant(voornaam, achternaam, email, wachtwoord, woonplaats, straatnaam, huisnummer, telefoonnummer);
//            responseObject.add("message", "Klant toegevoegd");
//        } catch (Exception e) {
//            responseObject.add("message", "Error " + e.getMessage());
//        }
//        return responseObject.build().toString();
//    }
}
