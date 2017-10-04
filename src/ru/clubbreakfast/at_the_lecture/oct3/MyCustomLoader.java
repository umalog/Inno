package ru.clubbreakfast.at_the_lecture.oct3;

import java.io.*;

public class MyCustomLoader extends ClassLoader {
    protected MyCustomLoader(ClassLoader parent) {
        super(parent);
    }

    public MyCustomLoader() {
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if(name.contains("ru.clubbreakfast.at_the_lecture")) {
            String fileName = name.replace('.', File.separatorChar) + ".class";

            InputStream stream = getClass().getClassLoader().getResourceAsStream(fileName);
            try {
                int size = stream.available();
                byte[] buffer = new byte[size];

                DataInputStream inputStream = new DataInputStream(stream);
                inputStream.readFully(buffer);
                inputStream.close();

                Class cl = defineClass(name, buffer, 0, buffer.length);
                resolveClass(cl);

                return cl;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }

    // Задание! : сделать такую же замену через findClass
    @Override
    public Class<?> findClass(String name) {
        byte[] bt = loadClassData(name);
        return defineClass(name, bt, 0, bt.length);

    }
    private byte[] loadClassData(String className) {
        //read class
        InputStream is = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/")+".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        //write into byte
        int len =0;
        try {
            while((len=is.read())!=-1){
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //convert into byte array
        return byteSt.toByteArray();
    }
}

