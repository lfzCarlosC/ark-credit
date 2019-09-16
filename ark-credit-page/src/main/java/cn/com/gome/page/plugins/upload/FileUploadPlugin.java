package cn.com.gome.page.plugins.upload;

/**
 * 文件上传插件接口
 */
public interface FileUploadPlugin {

    /**
     * 文件上传
     * @param bytes
     * @return
     */
    String fileUpload(byte[] bytes);

}
