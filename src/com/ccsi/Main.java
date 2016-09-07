package com.ccsi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] dic={"deer","door","cake","card"};
        ValidWordAbb word=new ValidWordAbb(dic);

        System.out.println(word.isUnique("dear"));
        System.out.println(word.isUnique("cart"));
        System.out.println(word.isUnique("cane"));
        System.out.println(word.isUnique("make"));
    }
}
//A abbreviation of a word follows the from <first letter><number><last letter>.
//Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary.
//A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
class ValidWordAbb{
    private Map<String,String> dictionary;

    public ValidWordAbb(String[] dic) {
        this.dictionary = new HashMap<>();
        for (int i = 0; i < dic.length; i++) {
            String key=abbreviate(dic[i]);
            if(!this.dictionary.containsKey(key)){
                this.dictionary.put(key,dic[i]);
            }
        }
    }

    private String abbreviate(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+String.valueOf(str.length()-2)+str.charAt(str.length()-1);
    }

    public boolean isUnique(String s) {
        String abbr = abbreviate(s);
        if (this.dictionary.containsKey(abbr)) {
            return false;
        } else {
            return true;
        }
    }
}
