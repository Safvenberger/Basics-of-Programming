/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift3;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Rasmus Säfvenberg
 */
public class Traningslogg {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String filNamn = "traningsdata.txt";
        Traningssamling samling = new Traningssamling();

        samling.readTraningslogg(filNamn);

        Scanner inputVal = new Scanner(System.in);
        int val;
        mainMenu();

        do {

            intInputCheck(inputVal);
            val = inputVal.nextInt();
            
            val = intRangeCheck(inputVal, val, 5);
            int rad;
            int updateEgenskap = 0;
            Scanner skapaVal = new Scanner(System.in);

            switch (val) {
                case 1: // Create
                    System.out.println("För att registrera ett träningspass ange "
                            + "följande: ");

                    System.out.print("1: Ange datumet då passet utfördes. "
                            + "(Ex. 5/6): ");
                    String dag = skapaVal.nextLine();
                    dag = nonEmptyStringCheck(dag);
                    
                    System.out.print("2: Ange vilken typ av träningspass det "
                            + "är (k = kondition eller s = styrka): ");
                    String typ = skapaVal.nextLine();
                    typ = nonEmptyStringCheck(typ);

                    System.out.print("3: Ange träningspassets längd i hela "
                            + "minuter: ");
                    intInputCheck(skapaVal);
                    int langd = skapaVal.nextInt();
                    skapaVal.nextLine();

                    System.out.print("4: Ange träningspassets intensitet "
                            + "(h = hög / m = medel / l = låg): ");
                    String intensitet = skapaVal.nextLine();
                    intensitet = nonEmptyStringCheck(intensitet);

                    Traningspass pass = new Traningspass(dag, typ, langd,
                            intensitet);

                    samling.addTraningspass(pass);
                    samling.writeString(filNamn);

                    System.out.println("\nTräningspasset är nu registrerat.");
                    mainMenu();
                    break;

                case 2: // Read
                    samling.printInfo();

                    mainMenu();
                    break;

                case 3: // Update
                    System.out.println("Vilken rad vill du ändra?\n");
                    samling.printInfo();

                    intInputCheck(skapaVal);
                    rad = skapaVal.nextInt();
                    rad = intRangeCheck(skapaVal, rad,
                            samling.getAntalTraningspass());

                    samling.getTraningspass(rad - 1);

                    System.out.println("\nVad vill du uppdatera?"
                            + "\n1. Träningsdagen?"
                            + "\n2. Träningstypen?"
                            + "\n3. Träningslängden?"
                            + "\n4. Träningsintensiteten?\n");

                    intInputCheck(skapaVal);
                    updateEgenskap = skapaVal.nextInt();
                    skapaVal.nextLine();
                    updateEgenskap = intRangeCheck(skapaVal, updateEgenskap, 4);

                    System.out.print("Ange det nya värdet: ");
                    if (updateEgenskap == 3) {
                        intInputCheck(skapaVal);
                    }

                    String uppdatera = skapaVal.nextLine();
                    if (uppdatera.contains("\t")) {
                        uppdatera = uppdatera.replaceAll("\t", " ");
                    }
                    uppdatera = nonEmptyStringCheck(uppdatera);

                    samling.updateTraningspass(rad - 1, updateEgenskap, uppdatera);
                    samling.writeString(filNamn);

                    System.out.println("Värdet har uppdaterats.\n");
                    mainMenu();
                    break;

                case 4: // Delete

                    System.out.println("Vilken rad vill du ta bort?\n");
                    samling.printInfo();

                    intInputCheck(skapaVal);
                    int deleteRad = skapaVal.nextInt();
                    deleteRad = intRangeCheck(skapaVal, deleteRad,
                            samling.getAntalTraningspass());
                    skapaVal.nextLine();
                    
                    System.out.println("Är du säker på att du vill ta bort rad "
                            + (deleteRad) + "? (Ja/Nej)");

                    String taBort = skapaVal.nextLine();
                    if (taBort.toLowerCase().equals("ja")
                            || taBort.toLowerCase().equals("j")) {
                        samling.deleteTraningspass(deleteRad - 1);
                        samling.writeString(filNamn);
                        System.out.println("Träningspasset är borttaget.");
                    } else {
                        System.out.println("Träningspass togs ej bort.");
                    }

                    mainMenu();
                    break;

                case 5:
                    System.out.println("Applikationen avslutas.");
                    break;

                default:
                    System.out.println("Oväntat invärde. Applikationen avslutas.");
                    break;
            }
        } while (0 < val && val < 5);

    }

    public static void mainMenu() {
        // Skapa en metod som innehåller huvudmeny för applikationen
        System.out.println("\n---------------------------------------------------"
                + "\nVälj vad du vill göra: "
                + "\n1. Registrera nytt träningspass."
                + "\n2. Visa träningspass. "
                + "\n3. Redigera ett tidigare registrerat träningspass."
                + "\n4. Ta bort ett tidigare registrerat träningspass."
                + "\n5. Avsluta."
                + "\n---------------------------------------------------\n");
    }

    public static void intInputCheck(Scanner input) {
        // Kolla om det angivna input värdet är ett heltal.
        while (!input.hasNextInt()) {
            System.out.println("Ogiltig inmatning. Se till att inmatningen är "
                    + "ett heltal.");
                input.nextLine();
        }
    }

    public static int intRangeCheck(Scanner scan, int rad, int radNummer) {
        // Undersök om det angivna inputvärdet är ett giltigt heltal i det 
        // angivna intervallet.
        while (rad > radNummer || rad < 1) {
            if (rad < 1) {
                System.out.println("Det där numret understiger antal"
                        + " rader. Det finns " + radNummer
                        + " rader. Vänligen ange ett heltal mellan 1 och "
                                + radNummer + ".");
            } else {
                System.out.println("Det där numret överstiger antal"
                        + " rader. Det finns " + radNummer
                        + " rader. Vänligen ange ett heltal mellan 1 och "
                                + radNummer + ".");
            }
            intInputCheck(scan);
            rad = scan.nextInt();
            scan.nextLine();
        }
        return rad;
    }
    
    public static String nonEmptyStringCheck(String str){
        // Se om en angiven sträng inte innehåller någon text och ersätt denna 
        // tomma sträng med ett mellanslag
        if (str.equals("")){
            return str.replaceAll("", " ");
        } else {
            return str;
        }
    }
    
}
