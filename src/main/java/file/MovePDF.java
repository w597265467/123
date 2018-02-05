package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MovePDF {
    public static void main(String[] arg) throws IOException {
//        moveFile("E:\\");
//        moveFile("D:\\");
//        moveFile("F:\\");
//        moveFile("G:\\");
        moveFile("E:\\pdf\\学习资料");
    }
    public static void moveFile(String path) throws IOException {
        File file = new File(path);
        if (file.exists()){
            if (file.isDirectory()){
                File[] fs = file.listFiles();
                for (File f : fs) {
                    moveFile(f.getAbsolutePath());
                }
            }else if (file.isFile()){
                if (file.getName().endsWith("pdf")){
                    String fileName = file.getName();
                    try {
                        if (fileName.contains("学习资料")){
                            File parentFile = file.getParentFile();
                            String absolutePath = parentFile.getAbsolutePath();
                            File destFile = new File(absolutePath+"/"+fileName.replace("学习资料",""));
                            FileUtils.moveFile(file,destFile);
                        }
                    } catch (IOException e) {
                        FileUtils.deleteQuietly(file);
                    }

                }
            }
        }


    }
}
