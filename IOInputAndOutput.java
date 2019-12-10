import java.io.*;

public class IOInputAndOutput {
    private File temp  = null;
    public static void main(String[] args) {
        File file = new File("E:\\test");
        //先找到文件
        IOInputAndOutput io = new IOInputAndOutput();
        File f2 = io.findFile(file, "aaa.txt");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[5];
        //从e盘读取数据并且写入到f盘
        try {
            fis = new FileInputStream(f2.getAbsoluteFile());
            int count = fis.read(bytes);
            fos = new FileOutputStream("F://ttttt//bbb");
            while (count != -1) {
                fos.write(bytes,0,count);
                io.mesge(bytes);
                count = fis.read(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //查找文件
    private File findFile(File file, String name) {
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (File f : files) {
                temp = findFile(f, name);
            }
        }
        if (name.equals(file.getName()) && file.isFile()) {
            return file;
        }
        return temp;
    }
    //信息加密
    private void mesge(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) ((bytes[i] + 3) * 12);
        }
    }
}
