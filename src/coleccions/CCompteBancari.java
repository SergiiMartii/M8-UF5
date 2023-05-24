/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coleccions;


/**
 *
 * @author sergi
 */
public class CCompteBancari {

    // Atributs
    private int numero;
    private CPersona propietari;
    private double saldo;

    private static int seguentCompte = 1234;
    private static double saldoInicial = 100;

    // Constructors
    public CCompteBancari(CPersona propietari) {
        this.numero = seguentCompte;
        seguentCompte++;
        this.propietari = propietari;
        this.saldo = saldoInicial;
    }

        public CCompteBancari() {
        this.numero = 0;       
        this.propietari = null;
        this.saldo = 0;
    }
    

    public CCompteBancari(CCompteBancari compteBancari) {
        this.numero = compteBancari.numero;
        this.propietari = compteBancari.propietari;
        this.saldo = compteBancari.saldo;
    }

    // Sets i gets
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public CPersona getPropietari() {
        return propietari;
    }

    public void setPropietari(CPersona propietari) {
        this.propietari = propietari;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static int getSeguentCompte() {
        return seguentCompte;
    }

    public static void setSeguentCompte(int seguentCompte) {
        CCompteBancari.seguentCompte = seguentCompte;
    }

    public static double getSaldoInicial() {
        return saldoInicial;
    }

    public static void setSaldoInicial(double saldoInicial) {
        CCompteBancari.saldoInicial = saldoInicial;
    }

    // Metodes
    public static void modSaldoInicial(double nouSaldoInicial) {
        saldoInicial = nouSaldoInicial;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public boolean comprovarNumSecret(int n1, int n2) {
        return n1 == n2;
    }

    public boolean ingressar(double quantitat, int numSecret) {
        if (comprovarNumSecret(numSecret, this.numero)) {
            saldo += quantitat;
            return true;
        } else {
            return false;
        }
    }

    public boolean extreure(double quantitat, int numSecret) {
        if (comprovarNumSecret(numSecret, this.numero)) {
            saldo -= quantitat;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "CCompteBancari{" + "numero=" + numero + ", propietari=" + propietari + ", saldo=" + saldo + '}';
    }
    
    public String salu2() {
        return "salu2";
    }
    
    
}
