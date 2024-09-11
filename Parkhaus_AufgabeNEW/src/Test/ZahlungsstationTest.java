import org.junit.Test;
import static org.junit.Assert.*;

public class ZahlungsstationTest {

    @Test
    public void testBezahlen() {
        Ticket ticket = new Ticket(1);
        Zahlungsstation zahlungsstation = new Zahlungsstation();
        zahlungsstation.bezahlen.accept(ticket);
        assertTrue(ticket.isBezahlt());
    }
}