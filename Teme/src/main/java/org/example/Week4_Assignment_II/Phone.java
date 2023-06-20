package org.example.Week4_Assignment_II;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Phone {
    int numarLista;
    int numarTelefon;
    String nume;
    String prenume;

    ArrayList<String> array = new ArrayList<>();
    Iterator<String> iterator = array.iterator();

    void addContact(int numarLista, int numarTelefon, String nume, String prenume) {
        this.numarLista = numarLista;
        this.numarTelefon = numarTelefon;
        this.nume = nume;
        this.prenume = prenume;
        array.add(nume + " " + prenume);
    }

    void listaContacte() {
        System.out.println(array);
    }

    public void getFirstContact() {
        System.out.println(array.get(0));
    }
    public void getLastContact(){
        System.out.println(array.get(array.size()-1));
    }
    public void sendMessage(int numarTelefon, String message){
        this.numarTelefon = numarTelefon;
        if(message.length() > 10){
            System.out.println("Numarul maxim de caractere este 10!");
        }else{
        System.out.println(message);}
    }
}




