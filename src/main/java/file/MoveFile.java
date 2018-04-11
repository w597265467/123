package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**

 * @author Administrator

 * @create 2018-03-15 17:12

 * @desc 移动文件

 **/
public class MoveFile {
	public static void main(String[] arg) throws IOException {
		File file = new File("E:\\123\\src\\main\\html\\4\\5_files");
		if (file.isDirectory()){
			File[] files = file.listFiles();
			for (File f : files) {
				if (f.getName().endsWith(".下载")){
					FileUtils.moveFile(f,new File(f.getAbsolutePath().replace(".下载","")));
				}
			}
		}
	}

}
