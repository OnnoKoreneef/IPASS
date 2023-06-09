package setup;

import model.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
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
        Medewerker aileen = new Medewerker("Aileen", "Jones", "aileenjones@hotmail.com", "0634041387", "medewerker");
        Afspraak afspraak1 = new Afspraak(LocalDate.now().minusDays(1), LocalTime.now(), LocalTime.now().plusHours(1), "Bennekom", "cederlaan", 5, "Duurzaamheid");
        Afspraak afspraak2 = new Afspraak(LocalDate.now().plusDays(1), LocalTime.now(), LocalTime.now().plusHours(1), "Bennekom", "cederlaan", 5, "Duurzaamheid");
        Afspraak afspraak3 = new Afspraak(LocalDate.now().plusDays(1), LocalTime.now(), LocalTime.now().plusHours(1), "Losser", "De pol", 5, "Advies");
        Offerte offerte = new Offerte("Duurzaamheid", 100, 1, LocalDate.now().minusDays(1), LocalDate.now().plusMonths(3), "Dit is een omschrijving", "Particulier", "Dak");

        durenbeg.addMedewerker(pierre);
        durenbeg.addMedewerker(aileen);
        durenbeg.addKlant(onno);
        durenbeg.addKlant(friso);
        durenbeg.addOfferte(offerte);
        afspraak1.setMedewerker(pierre);
        afspraak2.setMedewerker(pierre);
        afspraak3.setMedewerker(aileen);
        onno.addOfferte(offerte);
        onno.addAfspraak(afspraak1);
        onno.addAfspraak(afspraak2);
        friso.addAfspraak(afspraak3);

        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("bedrijf", durenbeg);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Terminating application");
    }
}
