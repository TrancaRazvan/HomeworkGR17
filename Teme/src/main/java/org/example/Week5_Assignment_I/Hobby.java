package org.example.Week5_Assignment_I;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    String nameHobby;
    int frequency;
    List<Adress> addressList = new ArrayList<>();
    public Hobby(String numeHobby, int frequency){
        this.nameHobby=numeHobby;
        this.frequency=frequency;
    }

    @Override
    public String toString() {
        return nameHobby + " " + frequency;
    }
}
