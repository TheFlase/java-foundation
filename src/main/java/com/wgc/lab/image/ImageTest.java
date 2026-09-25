package com.wgc.lab.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


//https://blog.csdn.net/frightingforambition/article/details/49929201
public class ImageTest {
    public static void main(String[] args) throws IOException {
        File imageFileDirPath = new File("d:"+File.separator+"tempImage");

        //初始化图片输出路径
        File output = new File("d:"+File.separator+"tempImageOut");
        if(!output.exists()){
            output.mkdir();
        }
        if(imageFileDirPath.isDirectory()){
            File[] files = imageFileDirPath.listFiles();
            for(int i=0;i<files.length;i++){
                BufferedImage bufferedimage = ImageIO.read(files[i]);
                int width = bufferedimage.getWidth();
                int height = bufferedimage.getHeight();

                int perWidthSize  = (int) width/2;
                int perHeightSize  = (int) height/2;

                //依次操作四次,水平切分

                BufferedImage bufferedimagetemp1 = ImgUtils.cropImage(bufferedimage, 0, 0, perWidthSize, perHeightSize);
                ImageIO.write(bufferedimagetemp1, "jpg", new File("d:"+File.separator+"tempImageOut"+
                        File.separator+files[i].getName().substring(0,files[i].getName().lastIndexOf("."))+"-"+(1)+".jpg"));    //输出裁剪图片

                BufferedImage bufferedimagetemp2 = ImgUtils.cropImage(bufferedimage, perWidthSize, 0, perWidthSize*2, perHeightSize+1);
                ImageIO.write(bufferedimagetemp2, "jpg", new File("d:"+File.separator+"tempImageOut"+
                        File.separator+files[i].getName().substring(0,files[i].getName().lastIndexOf("."))+"-"+(2)+".jpg"));    //输出裁剪图片

                BufferedImage bufferedimagetemp3 = ImgUtils.cropImage(bufferedimage, 0, perHeightSize, perWidthSize, perHeightSize*2);
                ImageIO.write(bufferedimagetemp3, "jpg", new File("d:"+File.separator+"tempImageOut"+
                        File.separator+files[i].getName().substring(0,files[i].getName().lastIndexOf("."))+"-"+(3)+".jpg"));    //输出裁剪图片

                BufferedImage bufferedimagetemp4 = ImgUtils.cropImage(bufferedimage, perWidthSize, perHeightSize, perWidthSize*2, perHeightSize*2);
                ImageIO.write(bufferedimagetemp4, "jpg", new File("d:"+File.separator+"tempImageOut"+
                        File.separator+files[i].getName().substring(0,files[i].getName().lastIndexOf("."))+"-"+(4)+".jpg"));    //输出裁剪图片


                /*for(int j=0;j<4;j++){
                   BufferedImage bufferedimagetemp = ImgUtils.cropImage(bufferedimage, 0, perHeightSize*j, width, perHeightSize*j+perHeightSize);
                   ImageIO.write(bufferedimagetemp, "jpg", new File("d:"+File.separator+"tempImageOut"+
                           File.separator+files[i].getName().substring(0,files[i].getName().lastIndexOf("."))+"-"+(j+1)+".jpg"));    //输出裁剪图片
               }*/

            }
            System.out.println("裁剪完毕！");
        }else{
            System.out.println("图片路径无效,请确认有效输入。在d盘根目录创建名称为tempImage文件夹，然后把要裁剪的图片丢进去");
        }
    }
}
