/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.tsg.unittesting.strings;

/**
 *
 * @author ahill
 */
public class StringsExerciseC {

    /**
     * Take a word, and remove all its vowels and returns it.
     *
     * Ex:
     * removeTheVowels( "truncate" ) ->  "trnct"
     * removeTheVowels( "squashed" ) ->  "sqshd"
     * removeTheVowels( "compressed" ) ->  "cmprssd"
     * @param word
     * @return String
     */
    public static String removeTheVowels(String word){
    String noA=word.replaceAll("a","");
    String noE=noA.replaceAll("e","");
    String noI=noE.replaceAll("i","");
    String noO=noI.replaceAll("o","");
    String noU=noO.replaceAll("u","");
    return noU;
    }
    
}
