package com.epam.courses.io.t02;

import com.epam.courses.io.t01.Const;
import com.epam.courses.io.t01.SimpleMap;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Narek on 28.01.2017.
 */
public class SymbolStreams {

    private StringBuilder text = new StringBuilder();
    private SimpleMap result = new SimpleMap();

    public void readAndWrite(File r, File w) {
        try(BufferedReader bin = new BufferedReader(new FileReader(r));
            PrintWriter pout = new PrintWriter(w)){
            String str;
            while((str = bin.readLine())!=null)
                text.append(str).append("\n");
            Pattern p = Pattern.compile(Const.KEYWORDS);
            Matcher m = p.matcher(text);
            while(m.find())
                result.add(m.group(1));
            pout.print(result.toString());
        } catch (FileNotFoundException e) {
            System.err.println("File not found "+e);
        } catch (IOException e) {
            System.err.println("Read Write exception "+e);
        }
    }

    public static void main(String[] args) {
        SymbolStreams ss = new SymbolStreams();
        File f1 = new File("C:/Users/Narek/workspace/OOP/" +
                "Homework/src/main/java/com/epam/courses/oop/t05/group/Group.java");
        File f2 = new File("data2.txt");
        ss.readAndWrite(f1, f2);
    }
}
