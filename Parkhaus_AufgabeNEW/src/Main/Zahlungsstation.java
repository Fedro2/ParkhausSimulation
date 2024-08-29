
public class Zahlungsstation {
        public void bezahlen(Ticket ticket) {
            ticket.bezahlen();
            System.out.println("Ticket " + ticket.getTicketID() + " wurde bezahlt.");
        }
    }

