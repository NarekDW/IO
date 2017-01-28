package com.epam.courses.io.t01;

import java.util.Arrays;

/**
 * Created by Narek on 28.01.2017.
 */
public class SimpleMap {
    private int length;
    private Map[] wordsAndAmount = new Map[length];

    public SimpleMap(int length){
        assert length >= 0;
        this.length = length;
    }
    public SimpleMap(){
        this(0);
    }

    public void add(String word){
        for (Map waa : wordsAndAmount) {
            if (waa == null) break;
            if (isContains(waa, word)) return;
        }
        addNew(word);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map waa : wordsAndAmount)
            sb.append(waa);
        return sb.toString();
    }

    private boolean isContains(Map initial, String check){
        if(initial.equals(check)){
            initial.amount+=1;
            return true;
        }
        return false;
    }

    private void addNew(String word){
        wordsAndAmount = Arrays.copyOf(wordsAndAmount, length+1);
        wordsAndAmount[length] = new Map(word);
        length++;
    }

    private class Map{
        String word;
        int amount = 1;
        Map(String word){
            this.word = word;
        }

        @Override
        public String toString(){
            return word+" - "+amount+"\n";
        }
        @Override
        public boolean equals(Object obj){
            return word.equals(obj);
        }
    }

}
