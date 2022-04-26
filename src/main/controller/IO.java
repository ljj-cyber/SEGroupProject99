package main.controller;


import java.io.*;
import java.net.URL;

/**
 * IO operations
 * @author Lingsong Feng
 * @version 5.3
 */
public class IO {

    /**
     * read file from disk
     * @param fileName
     * @return the content of that file
     * @throws IOException
     */
    protected static String read(String fileName) throws IOException {
        System.out.println(IO.class.getResourceAsStream("/Data/"+fileName));
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(IO.class.getResourceAsStream("/Data/"+fileName)))
        ) {
            StringBuilder sb = new StringBuilder();
            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp + "\n");
            }
            return sb.toString();
        }
    }

    /**
     * write to disk
     * @param fileName
     * @param str content of file
     * @throws IOException
     */
    protected static void write(String fileName, String str) throws IOException {
        File file = new File("./src/resource/data/" + fileName);
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
        ps.close();
    }
}
