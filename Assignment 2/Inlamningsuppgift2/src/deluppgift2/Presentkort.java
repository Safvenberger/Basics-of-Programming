/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift2;

/**
 * En klass för att arbeta med presentkort och dess saldo.
 * @author Rasmus Säfvenberg
 */
public class Presentkort {

    private String kortnummer;
    private int saldo;

    /** 
     * Skapa ett presentkort med valfritt kortnummer och förinställt saldo på 
     * 0 kr
     * 
     * @param kortnummer det nuvarande numret på presentkortet
     */
    public Presentkort(String kortnummer) {
        this.kortnummer = kortnummer;
        this.saldo = 0;
    }

    /**
     * Hämta det nuvarande saldot på ett givet presentkort
     * @return det nuvarande presentkortets saldo i svenska kronor
     */
    public int getSaldo() {
        return saldo;
    }

    /**
     * Uppdatera saldo på ett givet presentkort
     * @param nyttSaldo uppdatera saldo genom att skriva över det nuvarande
     * saldot
     */
    public void setSaldo(int nyttSaldo) {
        this.saldo = nyttSaldo;
    }

    /**
     * Hämta kortnummret för ett givet presentkort
     * @return kortnumret för det aktuella presentkortet
     */
    public String getKortnummer() {
        return kortnummer;
    }

    /**
     * Fyll på saldot för det aktuella presentkortet
     * @param okning den mängd kronor som presentkortets saldo skall ökas med
     */
    public void okaSaldo(int okning) {
        int nyttSaldo = getSaldo() + okning;
        this.saldo = nyttSaldo;
        System.out.println("Kortet fylldes på med " + okning
        + " kr. Det nya saldot är " + nyttSaldo + " kr.");
    }

    /**
     * Kontrollera om saldot är tillräckligt för att genomföra ett inköp
     * @param inkopssumma priset för hela inköpet.
     * @return sant eller falskt. Returnera sant om det nuvarande saldot är
     * högre (eller lika med) summan på inköpet. Returnera falskt om inköpet
     * överstiger presentkortets saldo.
     */
    public boolean kontrolleraInkop(int inkopssumma) {
        int nuvarandeSaldo = getSaldo();
        boolean kontroll = false;

        if (inkopssumma <= nuvarandeSaldo) {
            kontroll = true;
            setSaldo((nuvarandeSaldo-inkopssumma));
        }

        return kontroll;
    }

    /**
     * Skapar en textsträng som beskriver information angående det nuvarande 
     * presentkortet
     * @return en textsträng där det nuvarande kortet beskrivs med hjälp av dess
     * kortnummer och det aktuella saldot på presentkortet.
     */
    @Override
    public String toString() {
        String kortInfo = "Kortnummer " + getKortnummer()
                + " har ett nuvarande saldo på " + getSaldo() + " kr.";
        return kortInfo;
    }

}
