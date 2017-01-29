package com.epam.courses.io.t04;

import java.io.*;

/**
 * Date: 29.01.2017
 *
 * @author Karapetyan N.K
 */
public class Serializator {
    public static boolean serialization(FilmCollection fc, File file){
        boolean flag = false;
        try(ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(file))) {
            oos.writeObject(fc);
            flag = true;
        } catch (FileNotFoundException e) {
            System.err.println("Файл для сериализации не найден "+e);
        } catch (NotSerializableException e) {
            System.err.println("Объект нельзя сериализовать "+e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static FilmCollection deserialization(File file) throws InvalidObjectException {
        boolean flag = false;
        try(ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(file))) {
            FilmCollection fc = (FilmCollection)ois.readObject();
            return fc;
        } catch (FileNotFoundException e) {
            System.err.println("Файл для десериализации не найден "+e);
        } catch (ClassNotFoundException e) {
            System.err.println("Класс не найден "+e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new InvalidObjectException("Объект не восстановлен!");
    }
}
