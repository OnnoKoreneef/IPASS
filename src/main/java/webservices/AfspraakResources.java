package webservices;

import model.Afspraak;
import model.Bedrijf;
import model.Klant;
import model.Medewerker;

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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Path("/afspraken")
public class AfspraakResources {
    @Context
    private ServletContext servletContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Afspraak> getAlleAfspraken() {
        Bedrijf bedrijf = (Bedrijf) servletContext.getAttribute("bedrijf");
        return bedrijf.getAfspraken();
    }

    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Afspraak> getAfspraken(@PathParam("email") String email) {
        Klant klant = (Klant) servletContext.getAttribute(email);
        return klant.getAfspraken();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addAfspraak(String jsonBody) {
        JsonObjectBuilder responseObject = Json.createObjectBuilder();

        try {
            StringReader stringReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonObject jsonObject = jsonReader.readObject();

            LocalDate datum = LocalDate.parse(jsonObject.getString("datum"));
            LocalTime beginTijd = LocalTime.parse(jsonObject.getString("beginTijd"));
            LocalTime eindTijd = LocalTime.parse(jsonObject.getString("eindTijd"));
            String woonplaats = jsonObject.getString("woonplaats");
            String straatnaam = jsonObject.getString("straatnaam");
            int huisNummer = jsonObject.getInt("huisNummer");
            String onderwerp = jsonObject.getString("onderwerp");

            Bedrijf bedrijf = (Bedrijf) servletContext.getAttribute("bedrijf");
            Klant klant = (Klant) servletContext.getAttribute("onnokoreneef@hotmail.nl");
            ArrayList<Medewerker> medewerkers = bedrijf.getMedewerkers();

            Afspraak afspraak = new Afspraak(datum, beginTijd, eindTijd, woonplaats, straatnaam, huisNummer, onderwerp);
            afspraak.setMedewerker(medewerkers.get(0));
            klant.addAfspraak(afspraak);

            responseObject.add("message", "Afspraak gemaakt");
        } catch (Exception e) {
            responseObject.add("message", "Error " + e.getMessage());
        }
        return Response.ok(responseObject).build();
    }
}