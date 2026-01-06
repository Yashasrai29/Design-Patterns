package LLD;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemManagement {

    private final String BASE_URL;
    private static FileSystemManagement fileSystemManagement;

    private FileSystemManagement(String baseURL){
        this.BASE_URL = baseURL;
    }

    public static FileSystemManagement getInstance(String baseBRL){
        if(fileSystemManagement == null){
            synchronized (FileSystemManagement.class){
                if(fileSystemManagement == null){
                    fileSystemManagement = new FileSystemManagement(baseBRL);
                }
            }
        }
        return fileSystemManagement;
    }

    public static abstract class FileType{
        public abstract void work();

        public String name;
        public void setName(String name){
            this.name = name;
        }
    }

    public static class File extends FileType{
        byte [] bytes;
        public File(java.io.File file){
            super();
            setName("/"+file.getName());
            try {
                FileInputStream fl = new FileInputStream(file);
                this.bytes = fl.readAllBytes();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void work() {

        }
    }

    public static class Folder extends FileType{
        public List<FileType> folder;
        public Folder(String name){
            super();
            setName("/"+name);
            this.folder = new ArrayList<>();
        }

        public String add(FileType file){
            String path = file.name;
            file.name = "/"+ path;
            this.folder.add(file);
            return file.name;
        }

        public FileType search(FileType type, String fileName){
            if(type == null ){
                return null;
            }
            String [] path = fileName.split("/");
            FileType file = null;
            if(type instanceof File f){
                if(type.name.equals(path[1])){
                    file = f;
                }
            }
            else if(type instanceof Folder fold){
                if(!fold.folder.isEmpty()) {
                    for (FileType each : fold.folder) {
                        if(each.name.contains(path[1])) {
                            path[0] = "";
                            FileType f2 = search(each, String.join("", path));
                            if (f2 != null) {
                                file = f2;
                            }
                        }
                    }
                }
            }
            return file;
        }

        @Override
        public void work() {

        }
    }




    public static void main(String  [] args){
        Folder folder = new Folder("movies");
        File file = new File(new java.io.File("serialize.text"));
        folder.add(file);
        Folder folder1 = new Folder("dummy");
        folder1.add(folder);
        FileType f = folder.search(folder1, "serialize.text");
        try (FileOutputStream fos = new FileOutputStream("serialize2.text")) {
            fos.write(file.bytes);
            System.out.println("Data successfully written to the file using FileOutputStream.");
            File result = new File(new java.io.File("serialize2.text"));
            System.out.println("file name "+result.name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
