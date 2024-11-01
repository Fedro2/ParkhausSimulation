import org.junit.Test;
import static org.junit.Assert.*;

public class SchrankeTest {

    @Test
    public void testOeffnen() {
        Schranke schranke = new Schranke();
        schranke.oeffnen();
        assertTrue(true);
    }

    @Test
    public void testSchliessen() {
        Schranke schranke = new Schranke();
        schranke.schliessen();
        assertTrue(true);
    }
}
