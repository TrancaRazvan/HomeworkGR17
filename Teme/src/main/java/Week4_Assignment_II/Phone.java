package Week4_Assignment_II;

import java.util.ArrayList;

public abstract class Phone {
    int numarLista;
    int numarTelefon;
    String nume;
    String prenume;

    void addContact(int numarLista, int numarTelefon, String nume, String prenume) {
        this.numarLista = numarLista;
        this.numarTelefon = numarTelefon;
        this.nume = nume;
        this.prenume = prenume;
    }

}