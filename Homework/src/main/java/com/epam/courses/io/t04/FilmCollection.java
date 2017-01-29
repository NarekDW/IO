package com.epam.courses.io.t04;

import java.util.Arrays;

/**
 * Date: 29.01.2017
 *
 * <p>
 *     Простое представление структуры данных Карта.
 *     Ключ - название фильма, значение - массив {@link java.lang.String} который хранит
 *     в себе имена актеров, актеров может быть разное кол-во и все имена уникальны.
 * </p>
 * @see java.util.Map
 * @see java.util.ArrayList
 * @author Karapetyan N.K
 */
public class FilmCollection implements java.io.Serializable {
    private int size;
    private Film[] films = new Film[size];

    FilmCollection(int size){
        assert size>=0;
        this.size = size;
    }
    FilmCollection(){
        this(0);
    }

    void add(String title, String ... actors){
        for (Film f : films) {
            if (f == null) break;
            if (f.equals(title)){
                addActors(f, actors);
                return;
            }
        }
        addNew(title, actors);

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Film f : films) {
            sb.append(f.title+":\n");
            for(int i=0; i<f.actors.length; i++){
                sb.append("\t"+f.actors[i]+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private void addActors(Film f, String ... actors){
        f.actorsAdd(actors);
    }

    private void addNew(String title, String ... actors){
        films = Arrays.copyOf(films, size+1);
        films[size] = new Film(title, actors);
        size++;
    }

    private class Film implements java.io.Serializable{
        String title;
        String[] actors;
        Film(String title, String ... actors){
            this.title = title;
            this.actors = actors;
        }
        // Приссоединяет к массиву актеров новый массив с актерами
        // на выходе все имена уникальны, повторяющихся нет
        void actorsAdd(String ... newActors){
            String[] checkA = checkActors(newActors);
            int newSize = actors.length+checkA.length;
            actors = Arrays.copyOf(actors, newSize);
            System.arraycopy(checkA,0, actors,
                    (newSize-checkA.length), checkA.length);
        }

        // Алгоритм принимает массив имен и возвращает новый массив,
        // в котором нет повторяющихся имен с уже существующим массивом
        String[] checkActors(String...newactors){
            String[] checkA = new String[newactors.length];
            for(int i=0; i<newactors.length; i++){
                for (String actor : actors) {
                    if (actor.equals(newactors[i])) {
                        newactors[i] = null;
                    }
                }
            }
            int size=0;
            for (String newactor : newactors) {
                if (newactor != null) {
                    checkA[size++] = newactor;
                }
            }
            checkA = Arrays.copyOf(checkA, size);
            return checkA;
        }

        @Override
        public boolean equals(Object obj){
            return title.equals(obj);
        }
    }
}