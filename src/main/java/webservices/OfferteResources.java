package webservices;

import model.Bedrijf;
import model.Klant;
import model.Offerte;

import javax.annotation.PostConstruct;
import javax.json.*;
import javax.servlet.ServletContext;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Path("/offertes")
public class OfferteResources {
    @Context
    private ServletContext servletContext;
    private Bedrijf bedrijf;

    @PostConstruct
    private void init() {
        bedrijf = (Bedrijf) servletContext.getAttribute("bedrijf");
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Offerte> getOffertes(){
        return bedrijf.getOffertes();
    }

    @GET
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Offerte> getOffertesKlant(@PathParam("email") String email) {
        Klant klant = Bedrijf.getKlant(bedrijf.getKlanten(), email);
        assert klant != null;
        return klant.getOffertes();
    }

    @POST
    @Path("{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOfferte(@PathParam("email") String email, String jsonBody) {
        JsonObjectBuilder responseObject = Json.createObjectBuilder();

        try {
            StringReader stringReader = new StringReader(jsonBody);
            JsonReader jsonReader = Json.createReader(stringReader);
            JsonObject jsonObject = jsonReader.readObject();

            JsonArray onderwerpenArray = jsonObject.getJsonArray("onderwerp");
            JsonArray onderdelenArray = jsonObject.getJsonArray("onderdeel");
            String klantType = jsonObject.getString("klantType");
            String onderwerpen = getStringFromJsonArray(onderwerpenArray);
            String onderdelen = getStringFromJsonArray(onderdelenArray);
            String omschrijving = jsonObject.getString("omschrijving");

            Offerte offerte = new Offerte(onderwerpen, bedrijf.getOffertes().size() + 1, LocalDate.now(), LocalDate.now().plusMonths(3), omschrijving, klantType, onderdelen);
            bedrijf.addOfferte(offerte);
            Klant klant = Bedrijf.getKlant(bedrijf.getKlanten(), email);
            assert klant != null;
            klant.addOfferte(offerte);

            responseObject.add("message", "Offerte toegevoegd");
        } catch (Exception e) {
            responseObject.add("message", "Error" + e.getMessage());
        }
        return Response.ok(responseObject.build()).build();
    }

    private String getStringFromJsonArray(JsonArray jsonArray) {
        List<String> values = new ArrayList<>();
        for (JsonValue jsonValue : jsonArray) {
            values.add(jsonValue.toString().replaceAll("^\"|\"$", ""));
        }
        return String.join(", ", values);
    }
}
