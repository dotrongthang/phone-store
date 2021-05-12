package com.project.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadFileUtils {

    public final String root = System.getProperty("catalina.home");

    public void writeOrUpdate(byte[] bytes, String path) {
        File file = new File(StringUtils.substringBeforeLast(root + File.separator + "assets/user" + path, "/"));
        if (!file.exists()) {
            file.mkdir();
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(new File(root + File.separator + "assets/user" + path))) {
            fileOutputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
