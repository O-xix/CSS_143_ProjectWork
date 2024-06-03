import java.io.*;
import java.util.Stack;

public class FileSearch {

    public static void main(String[] args) {
        //Tested with my files.
        String directoryPath = ("c:\\");
        String targetFileName = "hw3.zip"; 

        System.out.println(searchFiles(new File(directoryPath), targetFileName));
    }
    
    public static String searchFiles(File path, String target) {
        Stack<File> stack = new Stack<>();
        stack.push(path);

        while (!stack.isEmpty()) {
            File currentDirectory = stack.pop();

            if (currentDirectory.isDirectory()) {
                File[] files = currentDirectory.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            stack.push(file);
                        } else if (file.getName().equals(target)) {
                            return ("File found."); 
                        }
                    }
                }
            }
        }
        return ("File not found.");
    }

    public static String recursiveFiles(File path, String target) {
        if (path.isDirectory()) {
            File[] files = path.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        if (recursiveFiles(file, target).equals("File found.")) {
                            return ("File found."); 
                        }
                    } else if (file.getName().equals(target)) {
                        return ("File found."); 
                    }
                }
            }
        }
        return ("File not found."); 
    }
}