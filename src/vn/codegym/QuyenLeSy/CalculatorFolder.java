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

        System.out.println("Folder size: "+ getFolderSize(path));
    }

    public static long getFolderSize(String path) throws IOException {
        File dir = new File(path);
        long size = 0;
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName() + " " + file.length());
                size += file.length();
            } else
                size += getFolderSize(file.getCanonicalPath());
        }
        return size;
    }
}
