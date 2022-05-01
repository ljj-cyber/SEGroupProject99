package main.controller;


import com.alibaba.fastjson.JSON;
import main.model.Order;

import java.io.*;
import java.util.ArrayList;

/**
 * IO operations
 * @author Demiao Li
 * @version 1.0
 */
public class IO {

    /**
     * read file from disk
     * @param fileName
     * @return the content of that file
     * @throws IOException
     */
    public static String read(String fileName) throws IOException {
        System.out.println(IO.class);
        System.out.println(IO.class.getResourceAsStream("/data/"+fileName));
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(IO.class.getResourceAsStream("/data/"+fileName)))
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
    public static void write(String fileName, String str) throws IOException {
        File file = new File("./resource/data/" + fileName);//最后整理提交文件时修改
        System.out.println(file.getAbsolutePath());
        PrintStream ps = new PrintStream(new FileOutputStream(file));
        ps.println(str);
        ps.close();
    }

    public static void main(String[] args) {
        ArrayList<Order> orders;
        try {
            orders= (ArrayList<Order>) JSON.parseArray(IO.read("Order.json"),Order.class);
            orders.get(0).setStatus(2);
            IO.write("Order.json", JSON.toJSONString(orders,true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
