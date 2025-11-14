package working_with_files;

import java.io.File;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException {
        String FILE_PATH = "src/main/java/working_with_files/files/new.txt";
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();
        file.createNewFile();

        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());
    }
}
