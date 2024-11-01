import java.util.function.Function;
import java.util.function.Supplier;

public class Parkhaus {
    private int gesamtPlaetze;
    private int freiePlaetze;
    private Schranke schranke;

    public Parkhaus(int gesamtPlaetze) {
        this.gesamtPlaetze = gesamtPlaetze;
        this.freiePlaetze = gesamtPlaetze;
        this.schranke = new Schranke();
    }

    public Supplier<Boolean> autoEinfahren = () -> {
        if (freiePlaetze > 0) {
            freiePlaetze--;
            schranke.oeffnen();
            System.out.println("Ein Ticket wurde gezogen. Es gibt noch " + freiePlaetze + " freie Plätze.");
            return true;
        } else {
            System.out.println("Keine freien Plätze verfügbar.");
            return false;
        }
    };

    public Function<Ticket, Void> autoAusfahren = (ticket) -> {
        if (ticket.isBezahlt()) {
            freiePlaetze++;
            schranke.oeffnen();
            System.out.println("Das Auto fährt aus. Es gibt jetzt " + freiePlaetze + " freie Plätze.");
            ticket.ausfahren();
        } else {
            System.out.println("Ticket wurde nicht bezahlt. Ausfahrt nicht möglich.");
        }
        return null;
    };
}