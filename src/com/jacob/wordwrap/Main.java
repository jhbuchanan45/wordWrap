package com.jacob.wordwrap;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordLen;
        String input;
        String spaces;

        System.out.println("Enter a single word");
        //get user input
        input = scanner.nextLine();
        wordLen = input.length();

        //check for input presence
        if (wordLen < 1) {
            System.out.println("You entered nothing, so no output to display.");
        }
        else if (wordLen == 1) {
            //handle special case of single letter
            System.out.println("You entered \"" + input + "\", so the output is:\n" + input);
        }
        else {
            //get number of spaces for middle lines
            spaces = " ".repeat(wordLen - 2);

            //print message for output
            System.out.println("You entered \"" + input + "\", so the output is:");

            //main loop to print to console line by line
            for (int i=0, j=wordLen-1; i < wordLen; i++, j--) {
                if (i==0) {
                    //on first line print word
                    System.out.println(input);
                }
                else if (j==0) {
                    //on last line print word reversed
                    for (int k=wordLen-1; k >= 0; k--) {
                        System.out.print(input.charAt(k));
                    }
                    System.out.print("\n");
                }
                else {
                    //on any other line print letter, then spaces, then opposite
                    System.out.println(input.charAt(i) + spaces + input.charAt(j));
                }
            }
        }
    }
}
