
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
        assertTrue(parkhaus.autoEinfahren());
        assertEquals(4, parkhaus.getFreiePlaetze());
    }

    @Test
    public void testAutoEinfahrenOhneFreiePlaetze() {
        for (int i = 0; i < 5; i++) {
            parkhaus.autoEinfahren();
        }
        assertFalse(parkhaus.autoEinfahren());
        assertEquals(0, parkhaus.getFreiePlaetze());
    }

    @Test
    public void testAutoAusfahrenMitBezahltemTicket() {
        Ticket ticket = new Ticket(1);
        parkhaus.autoEinfahren();
        ticket.bezahlen();
        parkhaus.autoAusfahren(ticket);
        assertEquals(5, parkhaus.getFreiePlaetze());
    }

    @Test
    public void testAutoAusfahrenMitUnbezahltemTicket() {
        Ticket ticket = new Ticket(1);
        parkhaus.autoEinfahren();
        parkhaus.autoAusfahren(ticket);
        assertEquals(4, parkhaus.getFreiePlaetze());
    }
}

