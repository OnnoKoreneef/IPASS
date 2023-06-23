package setup;

import model.Afspraak;
import model.Bedrijf;
import model.Klant;
import model.Medewerker;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.ws.rs.POST;
import java.time.LocalDate;
import java.time.LocalTime;

@WebListener
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Initializing application");

        Bedrijf durenbeg = new Bedrijf("Durenbeg", "Bunnik", "Ds pasmastraat", 5, 88633071, 1);
        Klant onno = new Klant("Onno", "Koreneef", "onnokoreneef@hotmail.nl", "W8woord!", "Bennekom", "Cederlaan", 5, "0638485404");
        Klant friso = new Klant("Friso", "Harff", "frisoharff@hotmail.com", "1", "Losser", "De Pol", 4, "0610403974");
        Medewerker pierre = new Medewerker("Pierre", "Koreneef", "phkoreneef@hotmail.com", "0624467398", "oprichter");
        Afspraak afspraak = new Afspraak(LocalDate.now().plusDays(1), LocalTime.now(), LocalTime.now().plusHours(1), "Bennekom", "cederlaan", 5, "Duurzaamheid", pierre, onno);

        durenbeg.addMedewerker(pierre);
        durenbeg.addKlant(onno);
        durenbeg.addAfspraak(afspraak);
        durenbeg.addKlant(friso);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("bedrijf", durenbeg);
        servletContext.setAttribute("klant", onno);
        servletContext.setAttribute("klant", friso);
        servletContext.setAttribute("medewerker", pierre);
        servletContext.setAttribute("afspraak", afspraak);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Terminating application");
    }
}
