package file;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class MoveDIR {
	public static void main(String[] arg) throws IOException {
		String srcDir = "D:\\Program Files\\feiq\\Recv Files\\GTA5";
		String destDir = "F:\\GTA5_2";
		FileUtils.moveDirectory(new File(srcDir),new File(destDir));
	}
}
