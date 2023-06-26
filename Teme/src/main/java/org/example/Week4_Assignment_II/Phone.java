package org.example.Week4_Assignment_II;

import java.util.*;

public abstract class Phone {

    ArrayList<String> mesaje;
    int baterie = 30;

    ArrayList<String> numePersoana = new ArrayList<>();
    ArrayList<String> persoaneSunate = new ArrayList<>();
    ArrayList<Integer> numereLista = new ArrayList<>();
    public Set<Integer> numeredeTelefon = new HashSet<>();

    void addContact(int numarLista, int numarTelefon, String nume, String prenume) {
        if (numeredeTelefon.contains(numarTelefon)) {
            System.out.println("Contact deja existent!");
        } else {
            numePersoana.add(nume + " " + prenume);
            this.numereLista.add(numarLista);
            this.numeredeTelefon.add(numarTelefon);
            mesaje = new ArrayList<>();
        }
    }

    public void sendMessage(int numarTelefon, String message) {
        if (baterie >= 1) {
            if (numeredeTelefon.contains(numarTelefon)) {
                if (message.length() > 500) {
                    System.out.println("Numarul maxim de caractere este 500!");
                } else {
                    System.out.println("Mesaj trimis!");
                    mesaje.add(message);
                    baterie--;
                }
            } else {
                System.out.println("Persoana nu exista in contacte.");
            }
        } else {
            System.out.println("Baterie insuficienta");
        }
    }

    public void call(String numePers) {
        if (baterie >= 2) {
            if (numePersoana.contains(numePers)) {
                System.out.println("Se apeleaza " + numePers);
                persoaneSunate.add(numePers);
                baterie = baterie - 2;
            } else {
                System.out.println("Persoana nu exista in contacte");
            }
        } else {
            System.out.println("Baterie insuficienta");
        }
    }

    public void istoricApel() {
        System.out.println(persoaneSunate);
    }

    void listaContacte() {
        System.out.println(numePersoana);
    }

    public void getFirstContact() {
        System.out.println(numePersoana.get(0));
    }

    public void getLastContact() {
        System.out.println(numePersoana.get(numePersoana.size() - 1));
    }


    public void showMessages(int numarTelefon) {
        if (mesaje.isEmpty()) {
            System.out.println("Nu exista mesaje!");
        } else {
            System.out.println(mesaje);
        }
    }

    public void checkBaterie() {
        System.out.println(baterie);
    }

    public void incarca() {
        baterie = 30;
        System.out.println(baterie);
    }

}




