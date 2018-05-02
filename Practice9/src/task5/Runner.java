package task5;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class Runner {

    static class DirectoryProcessing extends RecursiveTask<String> {

        private File file;
        private String prefix;

        public DirectoryProcessing(File file, String prefix) {
            this.file = file;
            this.prefix = prefix;
        }

        @Override
        protected String compute() {
            if(file != null && !file.isDirectory() && file.exists()) {
                int wordsCount = 0;
                try {
                    Scanner sc = new Scanner(new FileInputStream(file));
                    while(sc.hasNextLine()) {
                        String[] words = sc.nextLine().split("\\s+");
                        for(String word : words) {
                            if(word.startsWith(prefix))
                                wordsCount++;
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(wordsCount == 0) {
                    return "";
                }
                return file.getAbsolutePath() + ": " + wordsCount + "\n";
            }
            else {
                File[] allFiles = file.listFiles();
                StringBuilder result = new StringBuilder();
                if(allFiles != null) {
                    List<DirectoryProcessing> dirTasks = new ArrayList<>();
                    List<DirectoryProcessing> fileTasks = new ArrayList<>();
                    for(File file : allFiles) {
                        if(file.isDirectory())
                            dirTasks.add(new DirectoryProcessing(file, prefix));
                        else
                            fileTasks.add(new DirectoryProcessing(file, prefix));
                    }
                    for(DirectoryProcessing task : dirTasks)
                        task.fork();
                    for(DirectoryProcessing task : fileTasks)
                        result.append(task.compute());
                    for(DirectoryProcessing task : dirTasks)
                        result.append(task.join());
                }
                return result.toString();
            }
        }
    }

    public void run() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        boolean inputCorrect = false;
        File file = null;
        Scanner sc = new Scanner(System.in);
        while(!inputCorrect) {
            System.out.print("Input pathname of directory/file: ");
            file = new File(sc.nextLine());
            if(file.exists())
                inputCorrect = true;
            else
                System.out.println("Incorrect input! File does not exists!");
        }
        System.out.print("Input prefix to search for: ");
        String prefix = sc.nextLine();
        String result = pool.invoke(new DirectoryProcessing(file, prefix));
        System.out.println(result);
        inputCorrect = false;
        while(!inputCorrect) {
            System.out.print("Input file to save data: ");
            File output = new File(sc.nextLine());
            try {
                if (!output.exists())
                    output.createNewFile();
                FileWriter fw = new FileWriter(output);
                fw.write(result);
                fw.close();
                inputCorrect = true;
            } catch (IOException e) {
                System.out.println("Error! Cannot write here!");
            }
        }
    }
}
