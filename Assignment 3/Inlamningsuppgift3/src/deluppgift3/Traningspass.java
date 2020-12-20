/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift3;

/**
 *
 * @author Rasmus Säfvenberg
 */
public class Traningspass {

    private int passIndex;
    private String passDag;
    private String passTyp;
    private int passLangd;
    private String passIntensitet;
    
    // Tom konstruktor
    public Traningspass() {
    }

    // Vanlig konstruktor med alla parametrar
    public Traningspass(String dag, String typAvPass,
            int langd, String intensitet) {
        this.passDag = dag;
        this.passTyp = typAvPass;
        this.passLangd = langd;
        this.passIntensitet = intensitet;
    }

    // Get funktioner
    public int getTraningsIndex() {
        return passIndex;
    }

    public String getTraningsDag() {
        return passDag;
    }

    public String getTraningsTyp() {
        return passTyp;
    }

    public int getTraningsLangd() {
        return passLangd;
    }

    public String getTraningsIntensitet() {
        return passIntensitet;
    }

    // Set funktioner
    public void setTraningsIndex(int index) {
        this.passIndex = index;
    }

    public void setTraningsDag(String dag) {
        this.passDag = dag;
    }

    public void setTraningsTyp(String typ) {
        this.passTyp = typ;
    }

    public void setTraningsLangd(int langd) {
        this.passLangd = langd;
    }

    public void setTraningsIntensitet(String intensitet) {
        this.passIntensitet = intensitet;
    }

}
