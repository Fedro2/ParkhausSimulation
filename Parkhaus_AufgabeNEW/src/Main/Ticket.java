public class Ticket {
    private int ticketID;
    private boolean bezahlt;

    public Ticket(int ticketID) {
        this.ticketID = ticketID;
        this.bezahlt = false;
    }

    public int getTicketID() {
        return ticketID;
    }

    public boolean isBezahlt() {
        return bezahlt;
    }

    public void bezahlen() {
        bezahlt = true;
    }
}
