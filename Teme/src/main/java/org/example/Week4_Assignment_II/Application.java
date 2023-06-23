package org.example.Week4_Assignment_II;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
    Iphone13 tel = new Iphone13();
    tel.setCuloare("Negru");
    tel.setImei("123455667");
    tel.setMaterial("Metal");
    tel.addContact(1, 10239,"a","b");
        tel.addContact(2, 1023339,"c","d");
        tel.addContact(3, 11139,"e","f");
        tel.addContact(3, 11139,"g","h");
//        tel.listaContacte();
//        tel.getFirstContact();
//        tel.getLastContact();
//        tel.sendMessage(10239,"mesaj1");
//        tel.sendMessage(10239,"mesaj2");
//        tel.showMessages(10239);
//        tel.sendMessage(11139, "mesaj3");
//        tel.sendMessage(11139, "mesaj4");
//        tel.showMessages(11139);
        tel.listaContacte();
        tel.call("a b");
        tel.call("c d");
        tel.istoricApel();
        tel.checkBaterie();
        tel.incarca();
    }
}
