package com.cryptal.ark;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

public class ImageUploadTest {


    // endpoint
    private String endpoint = "oss-cn-beijing.aliyuncs.com";

    // accessKey
    private String accessKeyId = "LTAI4Fx36HdmB3g4KyR8dWxJ";

    private String accessKeySecret = "HobPTtHrgCgx0E1BlhQvIJYxWIGIWs";

    // 空间
    private static String bucketName = "yang7551735";

    // 文件存储目录
    private String fileDir = "credit";

    private OSSClient ossClient;

    @Before
    public void before(){
        ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }


    @Test
    public void test_upload(){

        File file = new File("G://1.png");

        URL url = null;
        //初始化OSSClient
        try {
            InputStream is = new FileInputStream(file);
            String path = file.getName();
            String fileName = path.substring(path.lastIndexOf("\\")+1);
            String type = path.substring(path.lastIndexOf(".")+1);
            int random = (int)(Math.random()*900)+10000;
            String newFileName = fileName.replace(fileName, String.valueOf(System.currentTimeMillis())+String.valueOf(random)+"."+type);

            String filePath = fileDir + "/" + newFileName;

            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(is.available());
            metadata.setCacheControl("no-cache");
            metadata.setHeader("Pragma", "no-cache");
            metadata.setContentEncoding("utf-8");
            metadata.setContentType(getContentType(newFileName));
            metadata.setContentDisposition("filename/filesize=" + newFileName + "/" + file.length() + "Byte.");
            ossClient.putObject(bucketName, filePath, is, metadata);
            ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            System.out.println("https://" + bucketName + "." + endpoint + "/" + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static URL getUrl(OSSClient ossClient,String key) {
        Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
        return url;
    }

    /**
     * 通过文件名判断并获取OSS服务文件上传时文件的contentType
     * @param fileName 文件名
     * @return 文件的contentType
     */
    private static  String getContentType(String fileName){
        //文件的后缀名
        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
        if(".bmp".equalsIgnoreCase(fileExtension)) {
            return "image/bmp";
        }
        if(".gif".equalsIgnoreCase(fileExtension)) {
            return "image/gif";
        }
        if(".jpeg".equalsIgnoreCase(fileExtension) || ".jpg".equalsIgnoreCase(fileExtension)  || ".png".equalsIgnoreCase(fileExtension) ) {
            return "image/jpeg";
        }
        if(".html".equalsIgnoreCase(fileExtension)) {
            return "text/html";
        }
        if(".txt".equalsIgnoreCase(fileExtension)) {
            return "text/plain";
        }
        if(".vsd".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.visio";
        }
        if(".ppt".equalsIgnoreCase(fileExtension) || "pptx".equalsIgnoreCase(fileExtension)) {
            return "application/vnd.ms-powerpoint";
        }
        if(".doc".equalsIgnoreCase(fileExtension) || "docx".equalsIgnoreCase(fileExtension)) {
            return "application/msword";
        }
        if(".xml".equalsIgnoreCase(fileExtension)) {
            return "text/xml";
        }
        //默认返回类型
        return "image/jpeg";
    }


}
