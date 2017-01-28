package com.epam.courses.io.t03;

import java.io.*;

/**
 * Date: 28.01.2017
 * @author Karapetyan N.K
 */
public class ChangeEncoding {
    /**
     *  <p>
     * Используем классы декораторы {@link InputStreamReader} и {@link OutputStreamWriter}
     * для определения кодера и декодера.
     * Так же классы декораторы {@link BufferedReader} и {@link BufferedWriter}
     * для буфферизации чтения и записи.
     * </p>
     * */
    public void readWriteUTF8(File r, File w) {
        // try with resources
        try (BufferedReader input = new BufferedReader(
                new InputStreamReader(new FileInputStream(r), "UTF-8"));
            PrintWriter output = new PrintWriter(new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(w),"UTF-16")
            ))) {
            String str;
            while((str = input.readLine())!=null)
                output.println(str);
            output.flush();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Не поддерживаемая операция "+e);
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден "+e);
        } catch (IOException e) {
            System.err.println("Ошибка ввода/вывода");
        }
    }

    public static void main(String[] args) {
        File r = new File("t3_resource.txt");
        File w = new File("t3_result.txt");
        new ChangeEncoding().readWriteUTF8(r,w);
    }
}
