package org.example.Week6_Testing_Assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
//        String expressionNoPlus = expression.replace("+", "");
//        String expressionNoMinus = expressionNoPlus.replace("-", "");
        //       String[] tokens = expression.split("\\s+");
//        System.out.println(Arrays.toString(tokens));
        List<String> list = Arrays.asList(expression);
        System.out.println(list);


    }


}
