package com.spring.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 上传控制器
 */
@Controller
public class UploadController extends BaseController{

    /**
     * 上传文件
     * @param fujian
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload_re")
    public String Upload(MultipartFile fujian) throws Exception
    {
        String fileName = fujian.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffixName;
        String filePath = getFolder("upload");
//        String filePath="upload/20210423/";
        try{

            File file = new File( getPhysicalPath(filePath)+"/"+fileName);
            //将资源保存到本地文件夹下
            String localPath ="bysj-server/src/main/webapp/upload/20210423";

            File localFile=new File(localPath);
            if(!localFile.exists()){
                localFile.mkdirs();
            }
            //获取本地路径
            File localStaticFile=new File(localFile.getAbsolutePath()+"\\"+fileName);
            System.out.println("localStaticFile====>"+localStaticFile);
            System.out.println("本地存储真实位置："+localFile.getAbsolutePath()+"\\"+fileName);
            FileUtils.copyInputStreamToFile(fujian.getInputStream(),localStaticFile);
            fujian.transferTo(file);
            System.out.println("setAttributefilePath=====fileName:"+filePath+"/"+fileName);
            request.setAttribute("url",filePath+fileName);
            if(isAjax())
            {
                return jsonResult(request.getAttribute("url"));
            }
            return "upload";
        }catch (Exception e){
            return showError(e.getMessage());
        }
    }

    private String getFolder(String path) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMdd");
        path += "/" + "20210423" +"/";
        File dir = new File(this.getPhysicalPath(path));

        if (!dir.exists()) {
            try {
                dir.mkdirs();
            } catch (Exception e) {
                return "";
            }
        }
        return path;
    }

    /**
     * 根据传入的虚拟路径获取物理路径
     *
     * @param path
     * @return
     */
    private String getPhysicalPath(String path) {
        String servletPath = this.request.getServletPath();
        System.out.println("servletPath===>"+servletPath);
        String realPath = this.request.getSession().getServletContext()
                .getRealPath(servletPath);
        System.out.println("realPath===>"+realPath);
        return new File(realPath).getParent() +"/" +path;
    }
}
