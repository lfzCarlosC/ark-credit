package cn.com.gome.page.plugins.upload;

import cn.com.gome.page.excp.PageException;
import org.springframework.stereotype.Component;

@Component
public class EmptyUploadPlugin implements FileUploadPlugin{

    @Override
    public String fileUpload(byte[] bytes) {
        throw new PageException("不支持文件上传");
    }
}
