package com.helpshift.util;

import java.io.File;

public class FileUtil {
    public static final int BUFFER_SIZE = 8192;

    public static boolean deleteFile(String str) {
        File validateAndCreateFile = validateAndCreateFile(str);
        return validateAndCreateFile != null && validateAndCreateFile.delete();
    }

    public static boolean doesFilePathExistAndCanRead(String str) {
        File validateAndCreateFile = validateAndCreateFile(str);
        return validateAndCreateFile != null && validateAndCreateFile.canRead();
    }

    public static File validateAndCreateFile(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        return null;
    }
}
