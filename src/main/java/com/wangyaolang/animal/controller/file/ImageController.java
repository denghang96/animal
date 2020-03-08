package com.wangyaolang.animal.controller.file;

import com.wangyaolang.animal.common.utils.FileUtils;
import com.wangyaolang.animal.controller.common.BaseResponseVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传下载的Controller
 */
@RestController
@RequestMapping("image")
public class ImageController {

  @Value("${file.file-upload-path}")
  //上传地址
  private String IMAGE_URL;

  /**
   * 上传图片
   */
  @RequestMapping(method = RequestMethod.POST, path = "/upload")
  public String upload(@RequestPart("file") MultipartFile file) throws Exception {

    if (file.isEmpty()) {
      return "请选择要上传的文件";
    }
    String filePath = IMAGE_URL;
    //取得当前上传文件的文件名称
    String originalFilename = file.getOriginalFilename();
    //生成文件名
    String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "-" + originalFilename;

    File targetFile = new File(filePath);
    if (!targetFile.exists()) {
      targetFile.mkdirs();
    }
    file.transferTo(new File(filePath + fileName));
    //返回文件存储路径
    return filePath + fileName;
  }

  /**
   * 多文件上传，大量文件时，防止文件名相同，重新修改存储文件名
   *
   * @throws IOException String
   */
  @RequestMapping(path = "/uploadImages", method = RequestMethod.POST)
  //上传的文件会转换成MultipartFile对象，file名字对应html中上传控件的name
  public BaseResponseVO uploadImages(@RequestBody MultipartFile[] files)
      throws IOException {
    if (files.length == 0) {
      return BaseResponseVO.serviceFailed("请选择要上传的文件");
    }
    List list = new ArrayList<>();
    for (MultipartFile multipartFile : files) {
      if (multipartFile.isEmpty()) {
        return BaseResponseVO.serviceFailed("文件上传失败");
      }
      byte[] fileBytes = multipartFile.getBytes();
      String filePath = IMAGE_URL;//暂时这样，需要配置
      //取得当前上传文件的文件名称
      String originalFilename = multipartFile.getOriginalFilename();
      //生成文件名
      String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "-" + originalFilename;
      FileUtils.uploadFile(fileBytes, filePath, fileName);
      //返回文件存储路径
      list.add(filePath + fileName);
    }
    return BaseResponseVO.success(list);
  }

  @RequestMapping(value = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
  @ResponseBody
  public byte[] showIamge(@RequestParam("path") String path) throws Exception {
    //String root = "/pic";
    File file = new File(path);
    FileInputStream inputStream = new FileInputStream(file);
    byte[] bytes = new byte[inputStream.available()];
    inputStream.read(bytes, 0, inputStream.available());
    return bytes;

  }

  //将图片以二进制的形式输出

  /**
   * 回显图片
   */
  @RequestMapping("/showImage")
  public void download(@RequestParam("path") String path, HttpServletResponse response) {
    try {
      response.setContentType("image/jpeg/jpg/png/gif/bmp/tiff/svg");
      File file = new File(path);
      //括号里参数为文件图片路径
      if (file.exists()) {
        InputStream in = new FileInputStream(path);
        //用该文件创建一个输入流
        OutputStream os = response.getOutputStream();
        //创建输出流
        byte[] b = new byte[1024];
        while (in.read(b) != -1) {
          os.write(b);
        }
        //in.close();
        os.flush();
        //os.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}