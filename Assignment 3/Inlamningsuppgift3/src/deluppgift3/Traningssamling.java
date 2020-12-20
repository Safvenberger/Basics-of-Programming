/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deluppgift3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus Säfvenberg
 */
public class Traningssamling {

    private final List<Traningspass> samling;

    public Traningssamling() {
        samling = new ArrayList<>();
    }

    public void addTraningspass(Traningspass pass) {
        samling.add(pass);
    }

    public void deleteTraningspass(int index) {
        samling.remove(index);
    }

    public Traningspass getTraningspass(int index) {
        return samling.get(index);
    }

    public int getAntalTraningspass() {
        return samling.size();
    }

    // Läs in filen som innehåller data och lägg till detta som ett träningspass
    // i träningssamlingen
    public void readTraningslogg(String fileName) throws IOException {
        String data;
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            while ((data = br.readLine()) != null) {
                String[] pass = data.split("\t");
                Traningspass newPass = new Traningspass();
                newPass.setTraningsIndex(Integer.parseInt(pass[0]));
                newPass.setTraningsDag(pass[1]);
                newPass.setTraningsTyp(pass[2]);
                newPass.setTraningsLangd(Integer.parseInt(pass[3]));
                newPass.setTraningsIntensitet(pass[4]);
                this.addTraningspass(newPass);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("Ingen träningslogg hittades.");
        }

    }

    // Uppdatera den angivna egenskapen, med det angivna värdet för det
    // angivna index
    public void updateTraningspass(int index, int egenskap, String newValue) {
        Traningspass pass = samling.get(index);

        switch (egenskap) {
            case 1:
                pass.setTraningsDag(newValue);
                break;
            case 2:
                pass.setTraningsTyp(newValue);
                break;
            case 3:
                pass.setTraningsLangd(Integer.parseInt(newValue));
                break;
            case 4:
                pass.setTraningsIntensitet(newValue);
                break;
            default:
                System.out.println("Felaktigt värde.");
                break;
        }
    }

    // Skapa ett "rullande" index, där varje nytt träningspass får ett index som
    // är det nästkommande index. 
    public int getTraningspassNummer() {
        int passNummer = -1;

        for (Traningspass pass : samling) {
            if (pass.getTraningsIndex() > passNummer) {
                passNummer = pass.getTraningsIndex();
            }
        }
        return passNummer + 1;  // Nästkommande index
    }

    // Skriv ut info angående träningssamlingen
    public void printInfo() {
        System.out.println("Rad\tIndex\tDag\tPass\tLängd\tIntensitet");
        for (int i = 0; i < samling.size(); i++) {
            Traningspass pass = samling.get(i);

            if (pass.getTraningsIndex() == 0) {
                pass.setTraningsIndex(getTraningspassNummer());
            }

            String info = (i + 1) + "\t" + pass.getTraningsIndex()
                    + "\t" + pass.getTraningsDag()
                    + "\t" + pass.getTraningsTyp()
                    + "\t" + pass.getTraningsLangd()
                    + "\t" + pass.getTraningsIntensitet();

            System.out.println(info);
        }
    }

    // "Uppdatera" datafilen genom att skapa en ny datafil med samma namn
    public void writeString(String fileName)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < samling.size(); i++) {
            Traningspass pass = samling.get(i);

            if (pass.getTraningsIndex() == 0) {
                pass.setTraningsIndex(getTraningspassNummer());
            }

            String writePass = pass.getTraningsIndex() + "\t"
                    + pass.getTraningsDag() + "\t"
                    + pass.getTraningsTyp() + "\t"
                    + pass.getTraningsLangd() + "\t"
                    + pass.getTraningsIntensitet() + "\t";

            writer.write(writePass);
            writer.newLine();
        }
        writer.close();
    }

}
