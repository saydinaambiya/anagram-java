package com.enigmacamp.anagram;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        String[] arrayOfStrings = {"cook", "save", "taste", "aves", "vase", "state", "map"};
        ArrayList<String> sortedArray = new ArrayList<>();
        for (int i = 0; i < arrayOfStrings.length; i++) {
            String word = sortCharacterOfWord(arrayOfStrings[i]);
            sortedArray.add(word);
        }

        ArrayList<String> cleanArrayList = removeDuplicate(sortedArray);

        ArrayList<String>[] anagramLists = new ArrayList[cleanArrayList.size()];
        for (int i = 0; i < cleanArrayList.size(); i++) {
            anagramLists[i] = new ArrayList<String>();
        }
        for (int i = 0; i < arrayOfStrings.length; i++) {
            for (int j = 0; j < cleanArrayList.size(); j++) {
                String wordTemp = sortCharacterOfWord(arrayOfStrings[i]);
                if (wordTemp.equals(cleanArrayList.get(j))) {
                    anagramLists[j].add(arrayOfStrings[i]);
                }
            }
        }
        System.out.println(Arrays.toString(anagramLists));
        // OR
        for (int i = 0; i < anagramLists.length; i++) {
            System.out.println(anagramLists[i]+",");
        }
    }


    private static ArrayList<String> removeDuplicate(ArrayList<String> arrayList) {
        ArrayList<String> newList = new ArrayList<>();
        arrayList.forEach(s -> {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        });
        return newList;
    }

    private static String sortCharacterOfWord(String word) {
        int characterTemp = 0;

        char arrOfCharacter[] = word.toCharArray();
        for (int i = 0; i < arrOfCharacter.length; i++) {
            for (int j = 0; j < arrOfCharacter.length; j++) {
                if (arrOfCharacter[i] > arrOfCharacter[j]) {
                    characterTemp = arrOfCharacter[i];
                    arrOfCharacter[i] = arrOfCharacter[j];
                    arrOfCharacter[j] = (char) characterTemp;
                }
            }
        }
        return String.valueOf(arrOfCharacter);
    }
}