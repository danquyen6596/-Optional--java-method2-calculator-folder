package vn.codegym.QuyenLeSy;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CalculatorFolder {
    public static void main(String[] args) throws IOException {
        System.out.println("The program calculator size of file or folder.");
        System.out.print("Input file or folder: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        File dir = getDirectory(path);

        if(!dir.exists()){
            System.out.println("File or folder not exists!");
        }
        else
            System.out.println(getSize(dir));
    }

    public static File getDirectory(String path){
        File dir = new File(path);
        return dir;
    }

    public static long getSize(File file) throws IOException {
        long size = 0;
        if (file.isDirectory()){
            File[] list = file.listFiles();
            if (list != null){
                for (File f : list){
                    if (f.isDirectory()){
                        getSize(getDirectory(f.getCanonicalPath()));
                    }
                    else size += file.length();
                }
                return size += file.length();

            }
            else return 0;
        }
        else return size += file.length();
    }
}
