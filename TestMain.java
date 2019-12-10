import java.io.File;
import java.io.IOException;

public class TestMain {
    public static void main(String[] args) {
        File file = new File("E:\\Test");
        CopyModifile cp = new CopyModifile();
        cp.copyModifile(file, "F:");
//        CopyModifile of = new CopyModifile();
//        //of.copyFile(new File("C://js实现照片墙.zip"),"D://test");
//        //of.jiaMiFile(new File("C://js实现照片墙.zip"),"D://test");
//        of.superCopyFile(new File("E:\\Test"),"F:");
    }
}
