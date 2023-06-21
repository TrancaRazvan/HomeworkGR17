package org.example.Week4_Assignment_II;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class Phone {

    ArrayList<String> mesaje;

    ArrayList<String> numePersoana = new ArrayList<>();
    ArrayList<Integer> numereLista = new ArrayList<>();
    public Set<Integer> numeredeTelefon = new HashSet<>();

    void addContact(int numarLista, int numarTelefon, String nume, String prenume) {
        if(numeredeTelefon.contains(numarTelefon)){
            System.out.println("Numar deja existent!");
        }else{
            numePersoana.add(nume + " " + prenume);
            this.numereLista.add(numarLista);
            this.numeredeTelefon.add(numarTelefon);
            mesaje = new ArrayList<>();
        }
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

    public void sendMessage(int numarTelefon, String message) {
        if (numeredeTelefon.contains(numarTelefon)) {
            if (message.length() > 500) {
                System.out.println("Numarul maxim de caractere este 500!");
            } else {
                System.out.println("Mesaj trimis!");
               mesaje.add(message);
            }
        } else {
            System.out.println("Persoana nu exista in contacte.");
        }
    }

    public void showMessages(int numarTelefon) {
       if(mesaje.isEmpty()){
           System.out.println("Nu exista mesaje!");
       }else{
           System.out.println(mesaje);
       }
    }

}




