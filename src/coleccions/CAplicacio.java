package coleccions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author sergi
 */
public class CAplicacio {

    // Creem ArrayList
    static ArrayList col = new ArrayList();
    // Scanners
    static Scanner scInt = new Scanner(System.in);
    static Scanner scString = new Scanner(System.in);
    static Scanner scDouble = new Scanner(System.in);
    // Variables
    static int comprovNumCompte;
    static int comprovNumSecret;
    static boolean compteTrobat = false;
    static boolean dadesCorrectes = false;
    static int i;

    public static void main(String[] args) {

        // Objectes hardcodejats
        CPersona propietari1 = new CPersona("a", "a", "a", 2345);
        CCompteBancari compte1 = new CCompteBancari(propietari1);
        col.add(compte1);
        CPersona propietari2 = new CPersona("b", "b", "b", 2345);
        CCompteBancari compte2 = new CCompteBancari(propietari2);
        col.add(compte2);
        // Variables
        int resposta;
        double quantitat;
        CCompteBancari objecte = new CCompteBancari();

        do {
            // Cada cop que acabi un case reiniciarem el valor d'aquestes variables
            compteTrobat = false;
            dadesCorrectes = false;

            // Imprimim el menu
            menu();
            System.out.println("Que vols fer?: ");
            resposta = scInt.nextInt();

            switch (resposta) {
                case 1:
                    // Creem un nou propietari 
                    CPersona propietari = new CPersona("", "", "", 0);

                    System.out.println("-----Crear nou compte-----\n");
                    System.out.print("Introdueix el nom: ");
                    propietari.setNom(scString.nextLine());
                    System.out.print("Introdueix el primer cognom: ");
                    propietari.setCognom1(scString.nextLine());
                    System.out.print("Introdueix el segon cognom: ");
                    propietari.setCognom2(scString.nextLine());
                    do { // Bucle perquè el numero sigui de 4 dígits
                        System.out.print("Introdueix el numero secret de 4 digits: ");
                        propietari.setNumSecret(scInt.nextInt());
                    } while (Integer.toString(propietari.getNumSecret()).length() != 4);
                    // Creem un nou compte fent referencia al propietari creat
                    CCompteBancari compte = new CCompteBancari(propietari);
                    // L'afegim a la colecció
                    col.add(compte);

                    System.out.println("Compte creat.");
                    System.out.println("El teu numero de compte es: " + compte.getNumero() + ".\n");

                    System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                    scString.nextLine();
                    break;
                case 2:
                    System.out.println("-----Modificar compte-----\n");
                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        // Donem valor a l'objecte buit, del escollit al mètode demanarDades()
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            System.out.print("Introdueix el nom: ");
                            objecte.getPropietari().setNom(scString.nextLine());
                            System.out.print("Introdueix el primer cognom: ");
                            objecte.getPropietari().setCognom1(scString.nextLine());
                            System.out.print("Introdueix el segon cognom: ");
                            objecte.getPropietari().setCognom2(scString.nextLine());
                            System.out.println("Dades modificades.");
                        }
                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("-----Eliminar compte-----\n");

                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            col.remove(objecte); // Eliminem l'objecte de la colecció
                            System.out.println("Compte eliminat.");
                        }

                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;
                case 4:
                    System.out.println("-----Consultar saldo-----\n");
                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            System.out.println("El teu saldo es de: " + objecte.getSaldo() + " euros.");
                        }
                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;
                case 5:
                    System.out.println("-----Ingressar-----\n");

                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            System.out.print("Quantitat a ingressar: ");
                            quantitat = scInt.nextDouble();
                            objecte.setSaldo(objecte.getSaldo() + quantitat); // Sumem la quantitat introduida al saldo actual
                            System.out.println("Saldo actual: " + objecte.getSaldo() + " euros.");
                        }
                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;
                case 6:
                    System.out.println("-----Extreure-----\n");

                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            System.out.print("Quantitat a extreure: ");
                            quantitat = scInt.nextDouble();
                            objecte.setSaldo(objecte.getSaldo() - quantitat); // Restem la quantitat introduida al saldo actual
                            if (objecte.getSaldo() < 0) {
                                System.out.println("Error - Saldo inferior a 0. Saldo no modificat.");
                                objecte.setSaldo(objecte.getSaldo() + quantitat);
                            }
                            System.out.println("Saldo actual: " + objecte.getSaldo() + " euros.");
                        }
                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;

                case 7:
                    System.out.println("-----Canviar numero secret-----\n");

                    if (col.isEmpty()) {
                        System.out.println("Error - No hi ha cap compte creat.\n");
                    } else {
                        objecte = demanarDades();

                        if (compteTrobat && dadesCorrectes) {
                            System.out.print("Introdueix el nou numero secret: ");
                            objecte.getPropietari().setNumSecret(scInt.nextInt());
                            System.out.println("Numero secret modificat.");
                        }
                        System.out.println("PRESSIONA ENTER PER CONTINUAR...");
                        scString.nextLine();
                    }
                    break;
                case 8:
                    System.out.println("-----Ingressar a un altre compte bancari-----");
                    
                    
                    break;
                case 9:
                    System.out.println("-----Sortint del programa-----\n");
                    break;

                case 99:
                    //Mostrar tots els objectes de la col·lecció
                    for (i = 0; i < col.size(); i++) {
                        CCompteBancari cuenta = (CCompteBancari) col.get(i);
                        System.out.println(cuenta);
                    }
                    break;
            }
        } while (resposta != 8);
    }

    public static void menu() {
        System.out.println("////////// Menu //////////");
        System.out.println("1. Crear nou compte");
        System.out.println("2. Modificar compte");
        System.out.println("3. Eliminar compte");
        System.out.println("4. Consultar saldo");
        System.out.println("5. Ingressar");
        System.out.println("6. Extreure");
        System.out.println("7. Modificar numero secret");
        System.out.println("8. Ingressar a un altre compte");
        System.out.println("9. Sortir");
        System.out.println("//////////////////////////");
    }

    public static CCompteBancari demanarDades() {
        System.out.print("Introdueix el numero de compte: ");
        comprovNumCompte = scInt.nextInt();
        System.out.print("Introdueix el numero secret: ");
        comprovNumSecret = scInt.nextInt();

        Iterator iter = col.iterator(); // Enllaçem l'iterador amb la colecció
        CCompteBancari objecte = new CCompteBancari();
        while (iter.hasNext() && !dadesCorrectes) {
            objecte = (CCompteBancari) iter.next();

            if (objecte.getNumero() == comprovNumCompte && objecte.getPropietari().getNumSecret() != comprovNumSecret) {
                // Si existeix el compte i el numSecret no és correcte
                compteTrobat = true;
            } else if (objecte.getNumero() == comprovNumCompte && objecte.getPropietari().getNumSecret() == comprovNumSecret) {
                compteTrobat = true;
                dadesCorrectes = true;
                System.out.println("Dades introduides correctament.\n");
            }
        }

        if (compteTrobat == false) {
            System.out.println("No existeix el compte.");
        } else if (dadesCorrectes == false) {
            System.out.println("Les dades introduides no son correctes.");
        }
        return objecte;
    }
}
