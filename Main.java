package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s, buf="", vivod="";
        System.out.print("Key word = ");
        String keyword = sc.nextLine();
        int flag=0;
        try {
            BufferedReader in = new BufferedReader(new FileReader("data.txt"));
            while ((s = in.readLine()) != null) {
                if(!s.contains(".") ){
                    buf+=s+" ";
                }
                else {
                    while(s.contains(".") ) {
                        buf+=s.substring(0, s.indexOf("."));
                        String[] buffer = buf.split(" +");
                        for (int i=0;i<buffer.length;i++){
                            vivod += buffer[i] + " ";
                            if (buffer[i].contains(keyword))
                                flag = 1;
                        }
                        if (flag==1) System.out.println(vivod);

                        buf="";
                        s=s.substring(s.indexOf(".")+1);
                    }
                    buf=s+" ";
                }

                flag = 0;
                vivod = "";
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода");
        }


    }
}