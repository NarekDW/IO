package com.epam.courses.io.t01;

import java.util.Arrays;

/**
 * Created by Narek on 28.01.2017.
 */
class SimpleMap {
    private int length;
    private Map[] wordsAndAmount = new Map[length];

    SimpleMap(int length){
        assert length >= 0;
        this.length = length;
    }
    SimpleMap(){
        this(0);
    }

    void add(String word){
        for(int i=0; i<wordsAndAmount.length; i++){
            if(wordsAndAmount[i]==null) break;
            if(isContains(wordsAndAmount[i], word)) return;
        }
        addNew(word);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<wordsAndAmount.length; i++){
            sb.append(wordsAndAmount[i]);
        }
        return sb.toString();
    }

    private boolean isContains(Map initial, String check){
        if(initial.word.equals(check)){
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
        Map(String word){
            this.word = word;
        }
        String word;
        int amount = 1;

        @Override
        public String toString(){
            return word+" - "+amount+"\n";
        }
    }

}
