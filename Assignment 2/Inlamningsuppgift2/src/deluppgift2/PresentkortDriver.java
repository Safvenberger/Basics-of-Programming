/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift2;

/**
 *
 * @author Rasmus Säfvenberg
 */
public class PresentkortDriver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Presentkort kort = new Presentkort("1998"); // Skapa nytt presentkort
        kort.setSaldo(550); // Nytt saldo
        System.out.println(kort.toString()); // Skriv ut information om kortet

        genomforInkop(kort, 150); // Lyckat inköp.
        genomforInkop(kort, 500); // Misslyckat inköp.

        kort.okaSaldo(300); // Öka saldot med 300

        genomforInkop(kort, 500); // Nu lyckat inköp.

    }

    public static void genomforInkop(Presentkort kort, int inkopssumma) {
        String nuvarandeKort = kort.getKortnummer();
        int saldo = kort.getSaldo();
        boolean kopStatus = kort.kontrolleraInkop(inkopssumma);
        String kopResultat = "på " + inkopssumma + " kr misslyckades. Summan för köpet är " + inkopssumma
                + " kr och det nuvarande saldo på kortnummer " + nuvarandeKort
                + " är " + saldo + " kr. Det saknas således " + 
                (inkopssumma - saldo) + " kr.";

        if (kopStatus) {
            kopResultat = "på " + inkopssumma + " kr lyckades. Återstående saldo på kortnummer "
                    + nuvarandeKort + " är " + (saldo - inkopssumma) + " kr.";
            //kort.setSaldo((saldo-inkopspris)); // Känns mer logiskt att den ska vara här än under kontrolleraInkop............................
        }

        System.out.println("Köpet " + kopResultat);
    }
}
