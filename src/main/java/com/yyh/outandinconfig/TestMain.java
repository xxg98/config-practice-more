package com.yyh.outandinconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Arrays;

public class TestMain {

    public static void main(String[] args) throws Throwable {
        String str = "no soul";
        byte[] byteArrayFromObject = getByteArrayFromObject(str);
        byte[] bytes = str.getBytes();
        System.out.println("序列化后的字节数组："+Arrays.toString(byteArrayFromObject));
        System.out.println("String类的getBytes方法："+Arrays.toString(bytes));


        System.out.println("序列化后的字节数组反序列化："+getObjectFromByteArray(byteArrayFromObject));
        System.out.println("String类的getBytes方法后反序列化："+getObjectFromByteArray(bytes));

//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//        ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext();
    }
    private static byte[] getByteArrayFromObject(Object o) throws Throwable {
        ObjectOutputStream out = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bo);
            out.writeObject(o);
            out.flush();
            return bo.toByteArray();
        }
        finally {
            if (out != null)
                out.close();
        }
    }

    private static Object getObjectFromByteArray(byte[] bytes) throws Throwable {
        ObjectInputStream in = null;
        try {
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            in = new ObjectInputStream(bi);
            return in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("反序列化失败！");
            return null;
        }
        finally {
            if (in != null)
                in.close();
        }
    }
}
