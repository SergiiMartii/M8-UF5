/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package coleccions;

/**
 *
 * @author sergi
 */
public class CPersona {

    private String nom;
    private String cognom1;
    private String cognom2;
    private int numSecret;

    public CPersona(String nom, String cognom1, String cognom2, int numSecret) {
        this.nom = nom;
        this.cognom1 = cognom1;
        this.cognom2 = cognom2;
        this.numSecret = numSecret;
    }
    
    public CPersona(CPersona objPersona){
        this.nom = objPersona.nom;
        this.cognom1 = objPersona.cognom1;
        this.cognom2 = objPersona.cognom2;
        this.numSecret = objPersona.numSecret;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom1() {
        return cognom1;
    }

    public void setCognom1(String cognom1) {
        this.cognom1 = cognom1;
    }

    public String getCognom2() {
        return cognom2;
    }

    public void setCognom2(String cognom2) {
        this.cognom2 = cognom2;
    }

    public int getNumSecret() {
        return numSecret;
    }

    public void setNumSecret(int numSecret) {
        this.numSecret = numSecret;
    }

    @Override
    public String toString() {
        return "CPersona{" + "nom=" + nom + ", cognom1=" + cognom1 + ", cognom2=" + cognom2 + ", numSecret=" + numSecret + '}';
    }
    
    

}
