package com.epam.courses.io.t01;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Narek on 27.01.2017.
 */
public class ReadWriteStreams {
    private static final String KEYWORDS =
                    "(abstract|continue|for|new|switch|" +
                    "assert|default|goto|package|synchronized|" +
                    "boolean|do|if|private|this|" +
                    "break|double|implements|protected|throw|" +
                    "byte|else|import|public|throws|" +
                    "case|enum|instanceof|return|transient|" +
                    "catch|extends|int|short|try|" +
                    "char|final|interface|static|void|" +
                    "class|finally|long|strictfp|volatile|" +
                    "const|float|native|super|while)[^\\w]";

    private StringBuilder text = new StringBuilder();

    public void readFromFile(File file){
        try(BufferedInputStream bin = new BufferedInputStream
                (new FileInputStream(file))) {
            int i;
            while((i = bin.read())!=-1)
                text.append((char)i);
        } catch (FileNotFoundException e) {
            System.err.println("File not found for read "+e);
        } catch (IOException e) {
            System.err.println("Read exception from file "+e);
        }
    }

    private SimpleMap result = new SimpleMap();

    public void writeToFile(File file){
        try(BufferedOutputStream bout = new BufferedOutputStream(
                new FileOutputStream(file))) {
            Pattern p = Pattern.compile(KEYWORDS);
            Matcher m = p.matcher(text);
            while(m.find())
                result.add(m.group(1));
            bout.write(result.toString().getBytes());
            bout.flush();
        } catch (FileNotFoundException e) {
            System.err.println("File not found for write "+e);
        } catch (IOException e) {
            System.err.println("Write exception to file "+e);
        }
    }

    public static void main(String[] args) throws IOException {
        ReadWriteStreams rws = new ReadWriteStreams();
        rws.readFromFile(new File("C:/Users/Narek/workspace/OOP/" +
                "Homework/src/main/java/com/epam/courses/oop/t01/Pen.java"));
        rws.writeToFile(new File("data.txt"));
    }
}
