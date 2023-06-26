package org.example.Week2_Assignment;

import org.apache.commons.lang3.ArrayUtils;

public class Main {
    public static void main(String[] args) {

        Novel novel1 = new Novel();
        novel1.setNume("Novel1");
        novel1.setNumarPagini(100);
        novel1.setTip("Mister");

        Album album1 = new Album();
        album1.setNume("Album1");
        album1.setNumarPagini(7);
        album1.setPaperQuality("Luster Paper");

        Book[] carti = new Book[]{album1, novel1};

        System.out.println("Lista originala de carti: ");
        for (Book item : carti) {

            System.out.println(item.getNume());
        }

        Book carte1 = new Book();
        carte1.setNume("Carte1");
        carte1.setNumarPagini(12);

        Book[] listaAdaugare;
        listaAdaugare = ArrayUtils.add(carti, carte1);
        System.out.println("Lista dupa adaugare un element: ");
        for (Book i : listaAdaugare) {
            System.out.println(i.getNume());
        }

        Book[] listaStergere;
        listaStergere = ArrayUtils.remove(listaAdaugare, 1);
        System.out.println("Lista dupa stergere un element: ");
        for (Book item : listaStergere) {
            System.out.println(item.getNume());
        }
    }
}