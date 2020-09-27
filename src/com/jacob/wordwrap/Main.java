package com.jacob.wordwrap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input;
        char[][] wrapArr;
        int wordLen;

        System.out.println("Enter a single word");

        //grab input and convert to char array
        input = scanner.nextLine().toCharArray();

        if (input.length < 1) {
            System.out.println("You entered nothing, so no output to display.");
            return;
        }

        //grab word length and initialise wrapArr for filling
        wordLen = input.length;
        wrapArr = new char[wordLen][wordLen];

        for (int i=0, j=wordLen-1; i < wordLen; i++, j--) {
            //first fill the row with spaces if not on first or last row
            if (j != 0) {
                for (char c : wrapArr[i]) {
                    c = ' ';
                }
            }

            //now fill the first and last column with the correct letter
            wrapArr[i][0] = input[i];
            wrapArr[i][wordLen-1] = input[j];

            //fill the first row from input simultaneously
            wrapArr[0][i] = input[i];

            //and fill the last row backwards from input simultaneously
            wrapArr[wordLen-1][i] = input[j];
        }

        //print out each row into the console
        for (char[] c : wrapArr) {
            System.out.println(c);
        }
    }
}
