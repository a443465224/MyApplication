package com.xsdm.www.myutil.Zip4J;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Zip4J压缩文件代码示例
 * Created by XDH on 2017/10/23.
 */
public class Zip4JCondense {
    public static void main(String[] args) throws ZipException, UnsupportedEncodingException {
        dozip1("D:\\笔记\\Android基础.txt");
    }

    /**
     * 压缩单个文件
     * @param src   压缩文件的路径
     * @throws ZipException
     */
    public static void dozip1(String src) throws ZipException {
        File srcFile = new File(src);
        if (!srcFile.exists()) {
            System.out.println("目标文件不存在");
            return;
        }
        // 创建同路径的同名压缩文件
        ZipFile zip = new ZipFile(src.substring(0,src.lastIndexOf(".")) + ".zip");
        // 设置文件名编码，设置要紧跟在实例化对象后
        zip.setFileNameCharset("GBK");

        // 设置参数
        ZipParameters para = new ZipParameters();
        // 设置压缩方式,默认是COMP_DEFLATE
        para.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        // 设置压缩级别,压缩级别有5种：级别跟好压软件是对应的；
        // static final int DEFLATE_LEVEL_FASTEST = 1;
        // static final int DEFLATE_LEVEL_FAST = 3;
        // static final int DEFLATE_LEVEL_NORMAL = 5;
        // static final int DEFLATE_LEVEL_MAXIMUM = 7;
        // static final int DEFLATE_LEVEL_ULTRA = 9;
        para.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        // 设置是否加密
        para.setEncryptFiles(true);
        // 设置加密方式
        para.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        // ENC_METHOD_AES方式必须设置长度
        para.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        para.setPassword("sb168168");

        zip.addFile(srcFile, para);
        System.out.println("压缩成功！");
    }

    // 压缩多个文件
    public void dozip2() throws ZipException {
        ZipFile zip = new ZipFile("D://压缩//test.zip");
        // 要紧跟设置编码
        zip.setFileNameCharset("GBK");
        ArrayList<File> list = new ArrayList<>();
        list.add(new File("src//com//压缩解压//abc.txt"));
        list.add(new File("src//com//压缩解压//abcUTF-8.txt"));
        list.add(new File("src//com//压缩解压//解压之后.txt"));

        ZipParameters para = new ZipParameters();
        para.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        para.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        // 设置密码：
        para.setEncryptFiles(true);
        // 设置AES加密方式
        para.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        // 必须设置长度
        para.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        para.setPassword("111");
        zip.addFiles(list, para);
        System.out.println("压缩成功！");
    }

    // 压缩文件夹
    public void dozip3() throws ZipException {
        ZipFile zip = new ZipFile("D:\\压缩\\test.zip");
        File file = zip.getFile();
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        // 为了不被原有文件干扰,保证每次重新生成
        if (file.exists()) {
            file.delete();
        }
        ZipParameters para = new ZipParameters();
        // 设置压缩级别，压缩方法默认
        para.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        zip.addFolder("E:\\测试压缩", para);
        System.out.println("压缩完成！");
    }



}
