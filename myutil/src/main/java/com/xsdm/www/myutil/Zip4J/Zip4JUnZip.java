package com.xsdm.www.myutil.Zip4J;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

import java.util.List;
import java.util.Scanner;

/**
 * Zip4J解压缩文件代码示例
 * Created by XDH on 2017/10/24.
 */
public class Zip4JUnZip {
    public static void main(String[] args) throws ZipException {
        Unzip4j("D:\\笔记\\Android基础.zip");
    }

    /**
     * 解压单个方法
     * @param src   解压文件路径
     * @throws ZipException
     */
    public static void Unzip4j(String src) throws ZipException {
        ZipFile zip = new ZipFile(src);
        // 第一时间设置编码格式
        zip.setFileNameCharset("GBK");
        // 用自带的方法检测一下zip文件是否合法，包括文件是否存在、是否为zip文件、是否被损坏等
        if (!zip.isValidZipFile()) {
            throw new ZipException("文件不合法或不存在");
        }
        checkEncrypted(zip);
        // 跟java自带相比，这里文件路径会自动生成，不用判断
        zip.extractAll(zip.getFile().getPath());
        System.out.println("解压成功！");
    }

    // 解压方法2
    public static void Unzip4j1(String zipFile) throws ZipException {
        long startTime = System.currentTimeMillis();
        ZipFile zipFile2 = new ZipFile(zipFile);
        //设置编码格式
        zipFile2.setFileNameCharset("GBK");
        if (!zipFile2.isValidZipFile()) {
            throw new ZipException("文件不合法或不存在");
        }
        //检查是否需要密码
        checkEncrypted(zipFile2);
        List<FileHeader> fileHeaderList = zipFile2.getFileHeaders();
        for (int i = 0; i < fileHeaderList.size(); i++) {
            FileHeader fileHeader = fileHeaderList.get(i);
            zipFile2.extractFile(fileHeader, "D:\\压缩\\test");
        }
        System.out.println("解压成功！");
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }

    /**
     * 检测是否有密码
     */
    public static void checkEncrypted(ZipFile zip) throws ZipException {
        Scanner in=new Scanner(System.in);
        if (zip.isEncrypted()) {
            System.out.println("文件"+zip.getFile().getName()+"有密码！");
            System.out.println("请输入密码：");
            zip.setPassword(in.next().trim());
        }
        in.close();
    }
}
