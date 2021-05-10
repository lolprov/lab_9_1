package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, buf="";
        System.out.print("Key word = ");
        String keyword = sc.nextLine();

        try {
            BufferedReader in = new BufferedReader(new FileReader("data.txt"));
            while ((s = in.readLine()) != null) {
                if(!(s.contains(".") || s.contains("?") || s.contains("!")) ){
                    buf +=" " + s + " ";
                }
                else {
                    while (s.contains(".") || s.contains("!") || s.contains("?")) {
                        if (s.contains(".") && (!s.contains("!") || (s.indexOf("!") > s.indexOf("."))) && (!s.contains("?") || (s.indexOf("?") > s.indexOf(".")))) {
                            if (buf.equals(s)) {buf = s.substring(0, s.indexOf("."));}
                            else   { buf += s.substring(0, s.indexOf("."));}
                            proverka(buf, keyword);
                            buf = s.substring(s.indexOf(".") + 1) + " ";
                            s = s.substring(s.indexOf(".")+1) + " ";
                        }
                        if (s.contains("!") && (!s.contains(".") || (s.indexOf(".") > s.indexOf("!"))) && (!s.contains("?") || (s.indexOf("?") > s.indexOf("!")))) {
                            if (buf.equals(s)) {buf = s.substring(0, s.indexOf("!"));}
                            else   { buf += s.substring(0, s.indexOf("!"));}
                            proverka(buf, keyword);
                            buf = s.substring(s.indexOf("!") + 1)+ " ";
                            s = s.substring(s.indexOf("!")+1) + " ";
                        }
                        if (s.contains("?") && (!s.contains("!") || (s.indexOf("!") > s.indexOf("?"))) && (!s.contains(".") || (s.indexOf(".") > s.indexOf("?")))) {
                            if (buf.equals(s)) {buf = s.substring(0, s.indexOf("?"));}
                            else   { buf += s.substring(0, s.indexOf("?"));}
                            proverka(buf, keyword);
                            buf = s.substring(s.indexOf("?") + 1)+ " ";
                            s = s.substring(s.indexOf("?")+1)+ " ";
                        }
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }


    }
    public static void proverka(String buf, String keyword){
        String vivod="";
        int flag=0;
        String[] buffer = buf.split(" +");
        for (int i=0;i<buffer.length;i++){
            vivod += buffer[i] + " ";
            if (buffer[i].equals(keyword))
                flag = 1;
        }
        if (flag==1) System.out.println(vivod.trim());
    }
}

