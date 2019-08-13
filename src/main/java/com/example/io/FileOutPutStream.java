package com.example.io;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.util.Assert;

import javax.swing.filechooser.FileSystemView;
import java.io.*;

/**
 * Author by Sun, Date on 2019/2/13.
 * PS: Not easy to write code, please indicate.
 */
public class FileOutPutStream {


    public static void main(String[] args) {
        String copyFilePath = "D:\\parkingRecordImages\\codeTcc1\\2019-01-08\\in_codeTcc1_1546929060160.jpg";
        copyForDesktop(copyFilePath);

    }

    /**
     * @Author SuZeRen
     * @Description //复制文件到桌面
     **/
    private static void copyForDesktop(String copyFilePath) {
        Assert.hasLength(copyFilePath);
        File file = new File(copyFilePath);
        Assert.isTrue(file.exists(), "文件不存在!");

        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();    //这便是读取桌面路径的方法了
        String desktopHomePath = System.getProperty("user.home");
        InputStream inputStream = null;
        File file1 = new File("C:\\Users\\Sun");
        FileOutputStream fileOutputStream = null;
        try {
            //读取原文件
            inputStream = new FileInputStream(copyFilePath);
            //复制后的文件
            fileOutputStream = new FileOutputStream(desktopHomePath + "\\copy.jpg");
            byte[] buff = new byte[1024 * 100];
            inputStream.read(buff);
            fileOutputStream.write(buff);

            // bufferedOutputStream.write();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭资源");
            IOUtils.closeQuietly(inputStream);
            IOUtils.closeQuietly(fileOutputStream);
        }

    }
}
