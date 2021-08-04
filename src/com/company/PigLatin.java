package com.company;

import java.util.Locale;
import java.util.Scanner;

public class PigLatin {
    public static String text;
    public PigLatin() {
        System.out.println("1. you want to enter the text \n2. read it from a file");
        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();
        if (ch == 1) {
            System.out.println("Enter text");
            Scanner sc2 = new Scanner(System.in);
            text = sc2.nextLine();
            text = text.toLowerCase(Locale.ROOT);
            System.out.println("Entered text is: "+text);
            }
        }

    public boolean beginWithVowel(String word)
    {
        word = word.toLowerCase(Locale.ROOT);
        char a = word.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(word.charAt(0));
        sb.append(word.charAt(1));
        String vowel_cluster = sb.toString();
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u' || vowel_cluster.equals("xr") || vowel_cluster.equals("yt"))
        {
            return true;
        }
        return false;
    }
    public void convert()
    {
        String new_string = "";
        StringBuilder sb = new StringBuilder();
        for (String word: text.split(" "))
        {
            String new_word = "";
            if (beginWithVowel(word))
            {
//                System.out.println(word + " starts with vowel cluster");
                new_word = word + "ay";

            }
            else
            {
                String vowel_string = "aeiouy";
                char vowel_array[] = vowel_string.toCharArray();
                int min_vowel_index = 1000000;
                int vowel_index = 1000000;
                int qu_index = 1000000;
                for (char a: vowel_array)
                {
//                    System.out.println("char is " + a);
                    vowel_index = word.indexOf(a);
                    if (vowel_index >0 && vowel_index<min_vowel_index)
                        min_vowel_index = vowel_index;
                }
                qu_index = word.indexOf("qu");
                if (qu_index>=0 && qu_index<min_vowel_index)
                {
                    new_word = word.substring(qu_index+2) + word.substring(0,qu_index+2) + "ay";
                }

                else if (min_vowel_index>0)
                {
                    new_word = word.substring(min_vowel_index) + word.substring(0,min_vowel_index) + "ay";
//                    System.out.println(word.substring(min_vowel_index) +" " + word.substring(0,min_vowel_index));
                }
            }
            new_string = new_string + " " + new_word;
        }
        System.out.println("Pig latin text is: " + new_string);
    }
}
//apple is white ytlove xrhate enjoy world filled with hate square