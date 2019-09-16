package com.cryptal.ark.arkcreditmanager.manager;

import cn.com.gome.page.plugins.upload.FileUploadPlugin;
import org.springframework.stereotype.Component;

@Component
public class CommonFileUploadPlugin implements FileUploadPlugin {
    @Override
    public String fileUpload(byte[] bytes) {
        return null;
    }
}
