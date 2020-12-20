/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift1;

/**
 *
 * @author djson
 */
public class NoteDriver {

    public static void main(String[] args) {
        Note[] notes = new Note[3];

        notes[0] = new Note("Bortsprungen katt", "Har någon sett min katt Missen? Han är gul och vit och alldeles fluffig. "
                + "Han har varit borta sedan i fredags morse, och brukar vanligtvis aldrig vara ute mer än över dagen. "
                + "Jag är jätteorolig att något kan hänt honom. Om ni ser honom så kan ni försöka locka på honom, eller "
                + "vifta med en fisk, en mjukglass eller något annat gott.", "Sara");
        notes[1] = new Note("Roligt för hela familjen", "Våfflor i hembygdsgården i kväll 18.00.", "Omar");
        notes[2] = new Note("Nu får det vara nog!", "Till dig som slänger fimpar vid badplatsen - du vet vem du är. "  
                + "Nu är det dags att du skärper dig och plockar upp resterna av dina stinkande dödspinnar. " 
                + "Ska jag och alla andra skötsamma personer behöva plocka upp efter dig, då din mamma inte fått fason på dig? "
                + "Vi måste få ett slut på det här beteendet. Jag vill ogärna skriva vad som händer annars, " 
                + "men det involverar dig, en snigel och ditt öga. Ja, just det, om du inte börjar plocka upp ditt skräp "
                + "så kommer jag att se till att du får en snigel på ögat!", "Upprörd pappa");
        for (Note note : notes) {
            System.out.println("----------------------------------------------------------------------");
            String heading = note.getHeading();
            String text = note.getText();
            String signed = note.getSigned();
            int numberOfWords = note.getNumberOfWords();
            int numberOfChars = note.getNumberOfChars();
            int priceClass = note.getPriceClass();
            System.out.println(heading + "\n" + text
                    + "\nSignerat: " + signed
                    + "\nAntal ord: " + numberOfWords
                    + "\nAntal tecken: " + numberOfChars
                    + "\nPrisklass: " + priceClass);
        }
    }
}
