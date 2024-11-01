import java.util.function.Consumer;

public class Zahlungsstation {
    public Consumer<Ticket> bezahlen = (ticket) -> {
        ticket.bezahlen();
        System.out.println("Ticket " + ticket.getTicketID() + " wurde bezahlt.");
    };
}