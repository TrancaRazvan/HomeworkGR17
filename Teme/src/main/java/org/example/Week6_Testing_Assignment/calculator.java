package org.example.Week6_Testing_Assignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        System.out.println("Adauga expresia: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
double calcul = calcul(expression);
        System.out.println(calcul + "mm.");
    }

    public static double calcul(String expression) {
        String[] elements = expression.split("\\s+");
        double finalValue = 0;
        int semn = 1;
        double value = 0;
        for (String element : elements) {
            if (isNumber(element)) {
                value = Double.parseDouble(element);
            } else if (isMetricUnit(element)) {
                finalValue += convertToMM(value, element) * semn;
                value = 0;
            } else if (element.equals("+")) {
                semn = 1;
            } else if (element.equals("-")) {
                semn = -1;
            }
        }
        return finalValue;
    }

    public static boolean isNumber(String expression) {
        return expression.matches("-?\\d+");
    }

    public static boolean isMetricUnit(String str) {
        String[] units = {"mm", "cm", "dm", "m", "km",};
        for (String unit : units) {
            if (str.equalsIgnoreCase(unit)) {
                return true;
            }
        }
        return false;
    }

    public static double convertToMM(double value, String unit) {
        switch (unit.toLowerCase()) {
            case "km":
                return value * 1000000;
            case "cm":
                return value * 10;
            case "mm":
                return value;
            case "dm":
                return value * 100;
            case "m":
                return value * 1000;
        }
        return value;
    }
}

