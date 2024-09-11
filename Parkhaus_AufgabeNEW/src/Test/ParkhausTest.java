import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParkhausTest {

    private Parkhaus parkhaus;

    @Before
    public void setUp() {
        parkhaus = new Parkhaus(5);
    }

    @Test
    public void testAutoEinfahrenMitFreienPlaetzen() {
        assertTrue(parkhaus.autoEinfahren.get());
    }

    @Test
    public void testAutoEinfahrenOhneFreiePlaetze() {
        for (int i = 0; i < 5; i++) {
            parkhaus.autoEinfahren.get();
        }
        assertFalse(parkhaus.autoEinfahren.get());
    }

    @Test
    public void testAutoAusfahrenMitBezahltemTicket() {
        Ticket ticket = new Ticket(1);
        parkhaus.autoEinfahren.get();
        ticket.bezahlen();
        parkhaus.autoAusfahren.apply(ticket);
    }

    @Test
    public void testAutoAusfahrenMitUnbezahltemTicket() {
        Ticket ticket = new Ticket(1);
        parkhaus.autoEinfahren.get();
        parkhaus.autoAusfahren.apply(ticket);

    }
}