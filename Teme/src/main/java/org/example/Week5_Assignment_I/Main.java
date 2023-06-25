package org.example.Week5_Assignment_I;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        PersonAgeComparator comparatorAge = new PersonAgeComparator();
        PersonNameComparator comparatorName = new PersonNameComparator();

        Set<Person> personTreeSet = new TreeSet<>(comparatorName);
        Person p1 = new Unemployed(35, "Mihai", 3333);
        Person p2 = new Unemployed(30, "Alex", 111);
        Person p3 = new Hired("Andrei", 25, 2000, 11111);
        Person p4 = new Student("UTCN", "Cristi", 20, 2222);
        personTreeSet.add(p1);
        personTreeSet.add(p2);
        personTreeSet.add(p3);
        personTreeSet.add(p4);

        List<Person> listaPersoaneNume = new ArrayList<>(personTreeSet);
        List<Person> listaPersoaneVarsta = new ArrayList<>(personTreeSet);
        Collections.sort(listaPersoaneNume, comparatorName);
        Collections.sort(listaPersoaneVarsta, comparatorAge);

        System.out.println("Lista de persoana ordonata in functie de nume: " + listaPersoaneNume);
        System.out.println("Lista de persoana ordonata in functie de varsta: " + listaPersoaneVarsta);
        System.out.println("Lista persoane TreeSet: " + personTreeSet);


        List<Adress> adresaCyclingList = new ArrayList<>();
        Adress adresaCycling = new Adress("Park");
//        adresaCyclingList.add(adresaCycling);

        HashMap<Adress,  HashMap<Person, List<Hobby> >> hashMapHobbyAdress = new HashMap<>();

        List<Hobby> hobbyListP1 = new ArrayList<>();
        Hobby hobby1 = new Hobby("cycling", 5);
        hobbyListP1.add(hobby1);

        HashMap<Person, List<Hobby> > personListHashMap = new HashMap<>();
        personListHashMap.put(p1,hobbyListP1);

        hashMapHobbyAdress.put(adresaCycling, personListHashMap);
        System.out.println(hashMapHobbyAdress);


    }

}
