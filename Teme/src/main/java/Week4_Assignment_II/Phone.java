package Week4_Assignment_II;

import java.util.ArrayList;

public abstract class Phone {
    int numarLista;
    int numarTelefon;
    String nume;
    String prenume;

    ArrayList<Integer> array = new ArrayList<>();

    void addContact(int numarLista, int numarTelefon, String nume, String prenume) {
        this.numarLista = numarLista;
        this.numarTelefon = numarTelefon;
        this.nume = nume;
        this.prenume = prenume;
        array.add(numarLista);
    }
    void lista(){
        System.out.println(array);
    }

}