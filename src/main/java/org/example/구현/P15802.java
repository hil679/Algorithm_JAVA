package org.example.구현;

import java.io.*;

public class P15802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String name = br.readLine();

        if(name.equals("hil")){
            bw.write(String.valueOf("1"));
        }else{
            bw.write(String.valueOf("0"));
        }

        bw.flush();
    }
}
