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

    private FileInputStream fin;
    private FileOutputStream fout;
    private StringBuilder text = new StringBuilder();

    public void readFromFile(File file) throws IOException {
        fin = new FileInputStream(file);
        int i;
        while((i = fin.read())!=-1)
            text.append((char)i);
        fin.close();
    }

    private SimpleMap result = new SimpleMap();

    public void writeToFile(File file) throws IOException {
        fout = new FileOutputStream(file);
        Pattern p = Pattern.compile(KEYWORDS);
        Matcher m = p.matcher(text);
        while(m.find())
            result.add(m.group(1));
        fout.write(result.toString().getBytes());
        fout.close();
    }

    public static void main(String[] args) throws IOException {
        ReadWriteStreams rws = new ReadWriteStreams();
        rws.readFromFile(new File("C:/Users/Narek/workspace/OOP/" +
                "Homework/src/main/java/com/epam/courses/oop/t01/Pen.java"));
        rws.writeToFile(new File("data.txt"));
    }
}
