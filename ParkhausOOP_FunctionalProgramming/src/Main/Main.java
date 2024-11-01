import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(5);
        Zahlungsstation zahlungsstation = new Zahlungsstation();
        Scanner scanner = new Scanner(System.in);
        final int[] ticketCounter = {1};
        final Ticket[] currentTicket = new Ticket[1];

        Map<Integer, Runnable> actions = new HashMap<>();
        actions.put(1, () -> {
            if (parkhaus.autoEinfahren.get()) {
                currentTicket[0] = new Ticket(ticketCounter[0]++);
            }
        });
        actions.put(2, () -> {
            if (currentTicket[0] != null) {
                zahlungsstation.bezahlen.accept(currentTicket[0]);
            } else {
                System.out.println("Kein Ticket zum Bezahlen vorhanden.");
            }
        });
        actions.put(3, () -> {
            if (currentTicket[0] != null) {
                parkhaus.autoAusfahren.apply(currentTicket[0]);
            } else {
                System.out.println("Kein Ticket vorhanden.");
            }
        });
        actions.put(4, () -> {
            System.out.println("Programm beendet.");
            scanner.close();
        });

        while (true) {
            System.out.println("\nOptionen:");
            System.out.println("1. Einfahren");
            System.out.println("2. Bezahlen");
            System.out.println("3. Ausfahren");
            System.out.println("4. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int option = scanner.nextInt();

            actions.getOrDefault(option, () -> System.out.println("Ungültige Option.")).run();
        }
    }
}