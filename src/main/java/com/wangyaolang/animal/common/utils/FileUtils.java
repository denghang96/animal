package com.wangyaolang.animal.common.utils;


import java.io.File;
import java.io.FileOutputStream;

public class FileUtils {

  /**
   * 文件上传方法
   *
   * @param file 文件byte[]
   * @param filePath 文件上传路径
   * @param fileName 文件保存路径
   * @throws Exception void
   */
  public static void uploadFile(byte[] file, String filePath, String fileName) {
    File targetFile = new File(filePath);
    if (!targetFile.exists()) {
      targetFile.mkdirs();
    }
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(filePath + fileName);
      out.write(file);
      out.flush();
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}