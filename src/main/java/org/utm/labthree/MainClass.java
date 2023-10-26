package org.utm.labthree;
import java.io.File;


public class MainClass {
    public static void main(String[] args){
        String folderPath = "C:\\Users\\andre\\OneDrive\\Desktop\\againfolder\\src\\main\\java\\TestFolder";
        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        for(File file:files){
            if(file.isFile()){
                System.out.println("Files -> "+file.getName());
            }
        }
    }
}
