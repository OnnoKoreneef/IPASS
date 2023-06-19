package setup;

import model.Afspraak;
import model.Bedrijf;
import model.Klant;
import model.Medewerker;

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
        Medewerker pierre = new Medewerker("Pierre", "Koreneef", "phkoreneef@hotmail.com", "0624467398", "oprichter");
        Afspraak afspraak = new Afspraak(LocalDate.now().plusDays(1), LocalTime.now(), LocalTime.now().plusHours(1), "Bennekom", "cederlaan", 5, "Duurzaamheid", pierre, onno);
        durenbeg.addMedewerker(pierre);
        durenbeg.addKlant(onno);
        durenbeg.addAfspraak(afspraak);
    }
}
