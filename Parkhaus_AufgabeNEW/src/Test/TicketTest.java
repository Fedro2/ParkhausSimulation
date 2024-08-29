import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketTest {

    private Ticket ticket;

    @Before
    public void setUp() {
        ticket = new Ticket(1);
    }

    @Test
    public void testGetTicketID() {
        assertEquals(1, ticket.getTicketID());
    }

    @Test
    public void testIsBezahltInitial() {
        assertFalse(ticket.isBezahlt());
    }

    @Test
    public void testBezahlen() {
        ticket.bezahlen();
        assertTrue(ticket.isBezahlt());
    }
}
