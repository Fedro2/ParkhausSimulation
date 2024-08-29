import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(5);
        Zahlungsstation zahlungsstation = new Zahlungsstation();
        Scanner scanner = new Scanner(System.in);
        int ticketCounter = 1;
        Ticket currentTicket = null;

        while (true) {
            System.out.println("\nOptionen:");
            System.out.println("1. Einfahren");
            System.out.println("2. Bezahlen");
            System.out.println("3. Ausfahren");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    if (parkhaus.autoEinfahren()) {
                        currentTicket = new Ticket(ticketCounter++);
                    }
                    break;
                case 2:
                    if (currentTicket != null) {
                        zahlungsstation.bezahlen(currentTicket);
                    } else {
                        System.out.println("Kein Ticket zum Bezahlen vorhanden.");
                    }
                    break;
                case 3:
                    if (currentTicket != null) {
                        parkhaus.autoAusfahren(currentTicket);
                    } else {
                        System.out.println("Kein Ticket vorhanden.");
                    }
                    break;
                case 4:
                    System.out.println("Programm beendet.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Ungültige Option.");
            }
        }
    }
}
