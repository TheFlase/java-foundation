package com.wgc.lab.classloader;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 4/23/2020
 **/
public class MyClassLoader extends ClassLoader{

    private String filePath;

    public MyClassLoader(String filePath){
        this.filePath = filePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }

    /* @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            String fileName = getFileName(name);
            File file = new File(filePath,fileName);
            final int bugLen = 4 * 0x400;//4kb
            byte[] buf = new byte[bugLen];
            int readLen;
            FileInputStream fileInputStream = null;
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                fileInputStream = new FileInputStream(file);
                while ((readLen = fileInputStream.read(buf,0,bugLen))!= -1){
                    outputStream.write(buf,0,readLen);
                }
                byte[] toByteArray = outputStream.toByteArray();
                defineClass(name,toByteArray,0,toByteArray.length);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    fileInputStream.close();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            return super.findClass(name);
        }
    */
    private String getFileName(String name) {
        int index = name.lastIndexOf(".");
        System.out.println("index's number is: "+index);
        if(index == -1){
            return name+".class";
        }else {
            return name.substring(index+1)+".class";
        }
    }

    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("dd");
        System.out.println(myClassLoader.getFileName("test."));
    }
}
