import java.io.*;

public class CopyModifile {
    public void copyModifile(File modiFile, String position) {
        //读取数据时需要的数组
        byte[] bytes = new byte[1024];
        int count = 0;
        //只要能进来就创建文件夹
        String oldName = modiFile.getAbsolutePath();
        String newName = position + "\\" + oldName.split(":")[1];
        System.out.println(newName);
        //创建一个新的对象来对应要复制的文件夹
        File newFile = new File(newName);
        //创建input和output管道
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //获取到所有的子文件
        File[] files = modiFile.listFiles();
        //只要文件夹有元素就继续递归查看并且创建对应的文件夹
        if (files != null) {
            newFile.mkdir();
            System.out.println(newFile.getName());
            if (files.length != 0) {
                for (File f : files) {
                    this.copyModifile(f, position);
                }
            }
        } else {
            //能走到这里就说明是文件
            try {
                fis = new FileInputStream(modiFile);
                fos = new FileOutputStream(newFile);
                count = fis.read(bytes);
                while (count != -1) {
                    fos.write(bytes,0,count);
                    count = fis.read(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public void superCopyFile(File file,String newPath){
        //获取file的绝对路径  拼串的方式获取新文件的名字
        String oldFilePath = file.getAbsolutePath();//   C://aaa//bbb文件夹--->D://test//aaa//bbb
        String newFilePath = newPath+oldFilePath.split(":")[1];
        //创建一个新的file对象
        File newFile = new File(newFilePath);
        //判断当前传递进来的file是个文件还是文件夹  isFile isDirectory listFiles
        File[] files = file.listFiles();//获取当前传递进来的file对象所有子元素
        if(files!=null){//file是一个文件夹  才有数组对象
            //通过新的file对象操作 在硬盘上创建一个文件夹
            newFile.mkdir();
            System.out.println(newFile.getName()+"文件夹复制完毕");
            //里面的元素
            if(files.length!=0){
                for(File f:files){
                    this.superCopyFile(f,newPath);
                }
            }
        }else{//file是一个文件  没有子元素  不需要数组对象
            //创建两个文件流 分别读取旧的file和写入新的newFile
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                byte[] b = new byte[1024];
                int count = fis.read(b);
                while(count!=-1){
                    fos.write(b,0,count);
                    fos.flush();
                    count = fis.read(b);//别忘了再读一遍
                }
                System.out.println(newFile.getName()+"文件复制完毕");
            } catch (IOException e) {
                e.printStackTrace();
            }
//            finally {
//                try {
//                    if(fis!=null) {
//                        fis.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                try {
//                    if(fos!=null) {
//                        fos.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}


