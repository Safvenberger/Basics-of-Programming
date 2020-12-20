/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift1;

/**
 *
 * @author Rasmus Säfvenberg
 */
public class Note {

    private String heading;
    private String text;
    private String signed;

    public Note(String rubrik, String notistext, String underskrift) {
        // Skapa en konstruktor som tar tre inparametrar. 
        this.heading = rubrik;
        this.text = notistext;
        this.signed = underskrift;
    }

    public String getHeading() {
        // Skapar en funktion som returnerar rubriken (heading) på notisen
        return heading;
    }

    public String getText() {
        // Skapar en funktion som returnerar texten i notisen   
        return text;
    }

    public String getSigned() {
        // Skapar en funktion som returnerar underskriften (signed) på notisen
        return signed;
    }

    public int getNumberOfWords() {
        // Räknar antalet ord i hela textsträngen
        String wordCount[] = text.split("\\s+");
        return wordCount.length;
    }

    public int getNumberOfChars() {
        // Beräkna antal tecken i alla de tre olika delarna av notisen.
        int charCount = heading.length() + text.length() + signed.length();
        return charCount;
    }

    public int getPriceClass() {
        // Beräkna antalet tecken i notisen och ange vilken prisklass den bör få
        int charNumber = getNumberOfChars();
        int prisKlass = 1; // Default värde om antal tecken är mindre än 250.

        if (charNumber >= 500) {
            prisKlass = 3;
        } else if (charNumber >= 250) {
            prisKlass = 2;
        }

        return prisKlass;
    }

}
