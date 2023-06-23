package webservices;

import model.Bedrijf;
import model.Klant;

import javax.annotation.PostConstruct;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.util.ArrayList;



@Path("/klanten")
public class KlantResources {
    @Context
    private ServletContext servletContext;
    private Bedrijf bedrijf;

    @PostConstruct
    private void init() {
        bedrijf = (Bedrijf) servletContext.getAttribute("bedrijf");
    }

    @GET
    @Produces("application/json")
    public ArrayList<Klant> getKlanten() {
        return bedrijf.getKlanten();
    }

    @Path("{email}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getKlant(@PathParam("email") String email) {
        Klant klant = Bedrijf.getKlant(bedrijf.getKlanten(), email);
        return Response.ok(klant).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String addKlant(String jsonBody) {
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

            bedrijf.createKlant(voornaam, achternaam, email, wachtwoord, woonplaats, straatnaam, huisnummer, telefoonnummer);
            responseObject.add("message", "Klant toegevoegd");
        } catch (Exception e) {
            responseObject.add("message", "Error " + e.getMessage());
        }
        return responseObject.build().toString();
    }
}
