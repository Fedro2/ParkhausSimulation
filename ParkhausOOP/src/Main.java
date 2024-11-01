import java.util.Scanner;
class Main {
    public static void main(String[] args) {
            Parkhaus parkhaus = new Parkhaus();
            System.out.println("Willkommen zum Parkhaus");
            anzahlPlätze(parkhaus);
            tarifeAnzeigen();

            Scanner scanner = new Scanner(System.in);

            System.out.println("Willst du rein?");
            System.out.println("Ja / Nein");
            String goInAntwort = scanner.nextLine();

            if (goInAntwort.toLowerCase().equals("ja") && parkhaus.getCapacity() != 0) {
                System.out.println("Ticket bezogen!");
                parkhaus.carEnters();
                Fahrer fahrer = new Fahrer();
                long checkIn = fahrer.getCheckInTime();
                anzahlPlätze(parkhaus);
                System.out.println("Raus / Zahlen");
                String outOrZahlen = scanner.nextLine();
                if (outOrZahlen.toLowerCase().equals("raus")) {

                    long checkOut = fahrer.getCheckOutTime();
                    long visitTime = fahrer.getVisitTime(checkOut, checkIn);
                    rausGehen(fahrer, visitTime, parkhaus);

                } else if (outOrZahlen.toLowerCase().equals("zahlen")) {
                    long checkOut = fahrer.getCheckOutTime();
                    long visitTime = fahrer.getVisitTime(checkOut, checkIn);
                    zahlen(visitTime, fahrer, parkhaus);
                } else return;


            } else if (goInAntwort.toLowerCase().equals("ja") && parkhaus.getCapacity() == 0) {
                System.out.println("Wir haben leider keine Plätze im Moment!");
                return;

            } else return;

        }

        public static void rausGehen (Fahrer fahrer,long visitTime, Parkhaus parkhaus){
            if (fahrer.isBezahlt() == true) {
                System.out.println("Bis zum nächsten Mal!");
                parkhaus.carLeaves();
                anzahlPlätze(parkhaus);

            } else {
                if (visitTime > 60000) {
                    System.out.println("Du musst noch dein Aufenthalt bezahlen!");
                    zahlen(visitTime, fahrer, parkhaus);
                } else {
                    System.out.println("Bis zum nächsten Mal!");
                    parkhaus.carLeaves();
                    anzahlPlätze(parkhaus);
                }
            }
        }

        public static void zahlen ( long visitTime, Fahrer fahrer, Parkhaus parkhaus){
            Scanner enter = new Scanner(System.in);

            System.out.println("Dein Aufenthalt dauerte: " + visitTime);
            tarifeAnzeigen();
            if (visitTime > 60000 && visitTime < 120000) {
                System.out.println("Zum zahlen: 5 CHF");
                System.out.println("Drücke /ENTER/ zum zahlen");
                enter.nextLine();
                fahrer.setBezahlt(true);
                rausGehen(fahrer, visitTime, parkhaus);
            } else if (visitTime > 120000 && visitTime < 180000) {
                System.out.println("Zum zahlen: 10 CHF");
                System.out.println("Drücke /ENTER/ zum zahlen");
                enter.nextLine();
                fahrer.setBezahlt(true);
                rausGehen(fahrer, visitTime, parkhaus);
            } else if (visitTime > 180000) {
                System.out.println("Zum zahlen 15 CHF");
                System.out.println("Drücke /ENTER/ zum zahlen");
                enter.nextLine();
                fahrer.setBezahlt(true);
                rausGehen(fahrer, visitTime, parkhaus);
            } else {
                System.out.println("Du hast nichts zum Zahlen.");
                rausGehen(fahrer, visitTime, parkhaus);
            }
        }
        public static void anzahlPlätze (Parkhaus parkhaus){
            System.out.println("Plätze Frei: " + parkhaus.getCapacity());
        }


        public static void tarifeAnzeigen () {
            System.out.println("----- Tarife -----");
            System.out.println("Unter 1 Min = Gratis");
            System.out.println("Ab 1 Min = 5 CHF");
            System.out.println("Ab 2 Min = 10 CHF");
            System.out.println("Ab 3 Min = 15 CHF");
            System.out.println("------------------");

        }
    }



