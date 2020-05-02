/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.Scanner;

/**
 *
 * @author Akim
 */
public class Main {
static Scanner scanner= new Scanner(System.in);
    public static void main(String c[]) {
        isMultiplication();
    }

    public static String isMultiplication() {
        int y = 0;
        int c=scanner.nextInt();
        for (int z = 0; z <= 12; z++) {
            y = z * c;
            System.out.println(z+" x "+c+" = "+y);
        }
        return null;
    }
}
