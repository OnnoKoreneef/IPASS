package webservices;

import model.Bedrijf;
import model.Klant;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;

import static javax.ws.rs.core.Response.serverError;

@Path("/klanten")
public class KlantResources {
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String createGegevens(String jsonBody) {
        JsonObjectBuilder responseObject = Json.createObjectBuilder();

        try {
            StringReader stringReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonObject jsonObject = jsonReader.readObject();

            String voornaam = jsonObject.getString("voornaam");
            String achternaam = jsonObject.getString("achternaam");
            String email = jsonObject.getString("email");
            String wachtwoord = jsonObject.getString("wachtwoord");
            String woonplaats = jsonObject.getString("woonplaats");
            String straatnaam = jsonObject.getString("straatnaam");
            int huisnummer = jsonObject.getInt("huisnummer");
            String telefoonnummer = jsonObject.getString("telefoonnummer");

            Bedrijf bedrijf = new Bedrijf();

            bedrijf.createKlant(voornaam, achternaam, email, wachtwoord, woonplaats, straatnaam, huisnummer, telefoonnummer);
            responseObject.add("message", "Klant toegevoegd");
        } catch (Exception e) {
            responseObject.add("message", "Error " + e.getMessage());
        }
        return responseObject.build().toString();
    }

//    @PUT
//    @Path("{email}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response updateKlant(@PathParam("email") String email, Klant klant) {
//
//    }
}
