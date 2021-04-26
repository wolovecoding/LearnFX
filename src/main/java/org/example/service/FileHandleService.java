package org.example.service;

import java.io.*;
import java.util.ArrayList;

/**
 * @description:
 * @author: wangzi
 * @time: 2021/4/26 9:02
 */
public class FileHandleService {

    public String getText(File file) throws IOException {
        String context = new String();

        Reader rr = null;
        try {
            rr = new FileReader(file.getAbsolutePath());
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到");
        }

        BufferedReader br = new BufferedReader(rr);

        String s = br.readLine();
        //System.out.println(s);
        while (s!=null){
            context = context.concat(s);
            context = context.concat("\n");
            s = br.readLine();
        }

        rr.close();
        System.out.println("这是"+context.toString());
        return context;
    }

    public void editTextFile(String filePath,String context) throws IOException {
        //节点流
        Writer fos = new FileWriter(filePath);

        //缓存流
        //BufferedWriter bos = new BufferedWriter(fos);  //这里我是从内存中放数据，所以不需要缓冲区
        fos.write(context);
        fos.close();
    }
}
