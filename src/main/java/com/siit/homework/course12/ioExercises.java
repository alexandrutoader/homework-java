package com.siit.homework.course12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ioExercises {
    public static void main(String[] args) throws IOException {
        getAllFilesFromDirectory("./.idea");
        getSpecificFilesFromSpecifiedFolder("./.idea");
        checkIfAFileOrDirectoryByPathnameExists("./.idea/vcs.xml");
        checkIfFileOrDirectoryHasReadAndWritePermission("./.idea/vcs.xml");
        checkIfPathNameIsFileOrDirectory("./.idea/vcs.xml");
        compareTwoFilesLexicographically("./.idea/vcs.xml", "./.idea/vcss.xml");
        getLastModifiedTimeOfFile("./.idea");
        getFileSizeInBytesKbAndMb("./.idea/vcs.xml");
        readContentsFromFileIntoByteArray("./.idea/vcs.xml");
        readFileContentLineByLine("./files/output.txt");
        readPlainTextFile("./files/output.txt");
        readFileLineByLineAndStoreItIntoAVariable("./files/output.txt");
        readFileLineByLineAndStoreItIntoArray("./files/output.txt");
        writeAndReadAPlainTextFile("./files/output.txt", "./files/written_file.txt");
        appendTextToAFile("okkkkkkkkkk", "./files/written_file.txt");
        readFirstThreeLinesFromFile("./files/output.txt");
        findTheLongestWordInATextFile("./files/output.txt");
        terminalCmd();
    }

    public static void print(String print) {
        System.out.println(print);
    }

    public static boolean isEmpty(String parameter) {
        return parameter.equals("");
    }

    public static void brakeAfterEachExercise() {
        print("\n==========================================================");
    }

    public static void getAllFilesFromDirectory(String path) throws IOException {
        if (isEmpty(path)) {
            throw new IllegalArgumentException("The file path is empty!");
        }

        print("\n1. Implement a method to get a list of all file/directory names from the given:");
        Path projectRoot = Paths.get(path);

        Files.walk(projectRoot, 1)
                .map(Path::normalize)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);

        brakeAfterEachExercise();
    }

    public static void getSpecificFilesFromSpecifiedFolder(String folderPath) throws IOException {
        if (isEmpty(folderPath)) {
            throw new IllegalArgumentException("The folder path is empty!");
        }

        print("\n2. Implement a method to get specific files by extensions from a specified folder:");
        Path projectRoot = Paths.get(folderPath);
        Files.walk(projectRoot, 1)
                .filter(Files::isRegularFile)
                .map(Path::normalize)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);

        brakeAfterEachExercise();
    }

    public static void checkIfAFileOrDirectoryByPathnameExists(String pathName) throws IOException {
        if (isEmpty(pathName)) {
            throw new IllegalArgumentException("The pathname is empty!");
        }

        print("\n3. Implement a method to check if a file or directory specified by pathname exists or not.");
        File my_file_dir = new File(pathName);

        if (my_file_dir.exists()) {
            print("The directory or file exists.");
        } else {
            print("The directory or file does not exist.");
        }
        brakeAfterEachExercise();
    }

    public static void checkIfFileOrDirectoryHasReadAndWritePermission(String pathName) throws IOException {
        print("\n4. Implement a method to check if a file or directory has read and write permission.");

        if (isEmpty(pathName)) {
            throw new IllegalArgumentException("The pathname is empty!");
        }

        File my_file_dir = new File(pathName);

        if (my_file_dir.exists()) {
            if (my_file_dir.canWrite()) {
                print(my_file_dir.getAbsolutePath() + " can write.");
            } else {
                print(my_file_dir.getAbsolutePath() + " cannot write.");
            }

            if (my_file_dir.canRead()) {
                print(my_file_dir.getAbsolutePath() + " can read.");
            } else {
                System.out.println(my_file_dir.getAbsolutePath() + " cannot read.");
            }
        } else {
            print("The file doesn't exists!");
        }
        brakeAfterEachExercise();
    }

    public static boolean checkIfPathNameIsFileOrDirectory(String pathname) {
        print("\n5. Implement a method to check if given pathname is a directory or a file.");

        if (isEmpty(pathname)) {
            throw new IllegalArgumentException("The pathname is empty!");
        }

        File file = new File(pathname);

        if (file.isDirectory()) {
            print("The pathname is a directory.");
            brakeAfterEachExercise();
            return file.isDirectory();
        }

        if (file.isFile()) {
            print("The pathname is a file.");
            brakeAfterEachExercise();
            return file.isFile();
        }

        print("The pathname is incorrect or does not exists!");
        brakeAfterEachExercise();
        return false;
    }

    public static boolean compareTwoFilesLexicographically(String firstPath, String secondPath) {
        print("\n6. Implement a method to compare two files lexicographically.");

        File file1 = new File(firstPath);
        File file2 = new File(secondPath);

        if (file1.compareTo(file2) == 0) {
            System.out.println("Both paths are lexicographically equal.");
            brakeAfterEachExercise();
            return true;
        } else {
            System.out.println("The paths are not equal lexicographically: \n" + firstPath + "\n" + secondPath);
            brakeAfterEachExercise();
            return false;
        }
    }

    public static String getLastModifiedTimeOfFile(String filePath) {
        print("\n7. Implement a method to get last modified time of a file.");
        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);

        boolean fileExists = false;
        if (file.isDirectory()) {
            fileExists = true;
        }

        if (file.isFile()) {
            fileExists = true;
        }

        if (!fileExists) {
            print("The pathname is incorrect or does not exists!");
            brakeAfterEachExercise();
            return "The pathname is incorrect or does not exists!";
        }

        long lastModified = file.lastModified();
        Date date = new Date(lastModified);

        System.out.println("Given file was last modified at: ");
        System.out.println(date);

        brakeAfterEachExercise();
        return date.toString();
    }

    public static String getLastModifiedTimeOfFileScanner() {
        print("\n7. Implement a method to get last modified time of a file.");
        Scanner scanner = new Scanner(System.in);
        String filePath = scanner.next();

        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);

        boolean fileExists = false;
        if (file.isDirectory()) {
            fileExists = true;
        }

        if (file.isFile()) {
            fileExists = true;
        }

        if (!fileExists) {
            print("The pathname is incorrect or does not exists!");
            brakeAfterEachExercise();
            return "The pathname is incorrect or does not exists!";
        }

        long lastModified = file.lastModified();
        Date date = new Date(lastModified);

        System.out.println("Given file was last modified at: ");
        System.out.println(date);

        brakeAfterEachExercise();
        return date.toString();
    }

    public static String getFileSizeInBytesKbAndMb(String filePath) {
        print("\n9. Implement a method to get file size in bytes, kb, mb.");

        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);
        long fileSize = file.length();

        print("File size in bytes is: " + fileSize);
        print("File size in KB is: " + (double) fileSize / 1024);
        print("File size in MB is: " + (double) fileSize / (1024 * 1024));

        brakeAfterEachExercise();
        return "File size in bytes, KB and MB is: " + fileSize + ", " + (double) fileSize / 1024 + ", " + (double) fileSize / (1024 * 1024);
    }

    public static void readContentsFromFileIntoByteArray(String filePath) throws IOException {
        print("\n10. Implement a method to read contents from a file into byte array.");

        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);

        if (file.isDirectory()) {
            throw new FileNotFoundException("The filepath " + filePath + " is a directory!");
        }

        byte[] byteFile = new byte[(int) filePath.length()];

        FileInputStream fileInput = new FileInputStream(filePath);
        fileInput.read(byteFile);
        fileInput.close();
        for (byte b : byteFile) {
            System.out.print((char) b);
        }
        brakeAfterEachExercise();
    }

    private static void readFileContentLineByLine(String filePath) throws IOException {
        print("\n11. Implement a method to read a file content line by line. ");

        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);

        if (file.isDirectory()) {
            throw new FileNotFoundException("The filepath " + filePath + " is a directory!");
        }

        Stream<String> stream = Files.lines(Paths.get(filePath));
        stream.forEach(System.out::println);
        brakeAfterEachExercise();
    }

    private static void readPlainTextFile(String filePath) throws IOException {
        print("\n12. Implement a method to read a plain text file. ");

        if (isEmpty(filePath)) {
            throw new IllegalArgumentException("The filepath is empty!");
        }

        File file = new File(filePath);

        if (file.isDirectory()) {
            throw new FileNotFoundException("The filepath " + filePath + " is a directory!");
        }

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = br.readLine()) != null) {
            print(line);
        }
        brakeAfterEachExercise();
    }

    public static void readFileLineByLineAndStoreItIntoAVariable(String filePath) {
        print("\n13. Implement a method to read a file line by line and store it into a variable.  ");
        String strLine = "";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while (strLine != null) {
                sb.append(strLine);
                strLine = br.readLine();
            }
            System.out.println(sb);
            br.close();
            brakeAfterEachExercise();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }

    public static void readFileLineByLineAndStoreItIntoArray(String filePath) {
        print("\n14. Implement a method to read a file line by line and store it into a variable.  ");
        String strLine = "";
        List<String> arrayList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while (strLine != null) {
                if (!strLine.equals("")) {
                    arrayList.add(strLine);
                }
                strLine = br.readLine();
            }
            System.out.println(arrayList.toString());
            br.close();
            brakeAfterEachExercise();
        } catch (FileNotFoundException e) {
            System.err.println("File not found.");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }

    public static void writeAndReadAPlainTextFile(String fileReader, String fileWriter) throws IOException {
        print("\n15. Implement a method to write and read a plain text file. ");

        File file = new File(fileWriter);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.createNewFile();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileReader)), 10000000);
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileWriter, true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
                System.out.println(line);
            }

            brakeAfterEachExercise();
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public static void appendTextToAFile(String text, String filePath) {
        print("\n16. Implement a method to append text to an existing file. ");

        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write("\n" + text + "\n");
            fw.close();

            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            brakeAfterEachExercise();
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    public static void readFirstThreeLinesFromFile(String filePath) {
        print("\n17. Implement a method to read first 3 lines from a file.");
        String strLine = "";
        try {
            LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(filePath), UTF_8));
            while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= 3) {
                System.out.println(strLine);
            }
            reader.close();
            brakeAfterEachExercise();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
    }

    public static String findTheLongestWordInATextFile(String textFile) throws FileNotFoundException {
        print("\n18. Implement a method to find the longest word in a text file. ");

        String longestWord = "";
        String current;
        Scanner sc = new Scanner(new File(textFile));

        while (sc.hasNext()) {
            current = sc.next();
            if (current.length() > longestWord.length()) {
                longestWord = current;
            }
        }

        print("The longest word from the text file is: \n" + longestWord + "\n");
        brakeAfterEachExercise();

        return longestWord;
    }

    public static void terminalCmd() throws IOException {
        print("\n19. Implement a terminal (cmd) in Java using IO operations.");
        Scanner scanner = new Scanner(System.in);
        print("Please type what do you want to do:");
        print("1 - ls; 2 - pwd; 3 - touch; 4 - mkdir; 5 - ll");

        int actionType = scanner.nextInt();
        print("Please type the path: Ex -> ./files");
        String path = scanner.next();

        action(scanner, actionType, path);
    }

    private static void action(Scanner scanner, int actionType, String path) throws IOException {
        boolean isActiveFlag = true;
        while (isActiveFlag) {
            if (actionType == 1) {
                lsTerminalCommand(path);
            }

            if (actionType == 2) {
                pwdCommand(path);
            }

            if (actionType == 3) {
                print("Please provide the name of the file:");
                String inputFileName = scanner.next();

                if (inputFileName.equals("")) {
                    print("The input file cannot be empty!");
                } else {
                    touchCommand(path, inputFileName);
                }
            }

            if (actionType == 4) {
                print("Please provide the name of the directory:");
                String inputFileName = scanner.nextLine();

                if (inputFileName.equals("")) {
                    print("The input file cannot be empty!");
                } else {
                    mkdirCommand(path, inputFileName);
                }
            }

            if (actionType == 5) {
                llCommand(path);
            }

            boolean confirmAction = confirm(scanner);

            if (!confirmAction) {
                isActiveFlag = false;
            }

            if (confirmAction) {
                print("Please type what do you want to do:");
                print("1 - ls; 2 - pwd; 3 - touch; 4 - mkdir; 5 - ll");
                actionType = scanner.nextInt();
                print("Please type the path: Ex -> ./files");
                path = scanner.next();
            }
        }
    }

    public static void lsTerminalCommand(String folderPath) throws IOException {
        if (isEmpty(folderPath)) {
            throw new IllegalArgumentException("The folder path is empty!");
        }

        Path projectRoot = Paths.get(folderPath);

        if (projectRoot.getParent() == null) {
            print("The provided path doesn't exists!");
            return;
        }

        Files.walk(projectRoot, 1)
                .filter(Files::isRegularFile)
                .map(Path::normalize)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);

        brakeAfterEachExercise();
    }

    public static boolean confirm(Scanner scanner) {
        print("Do you want to do another action? Y / N");
        String confirm = scanner.next();
        confirm = confirm.toUpperCase();

        return confirm.equals("Y");
    }

    public static void pwdCommand(String path) throws IOException {
        if (isEmpty(path)) {
            throw new IllegalArgumentException("The folder path is empty!");
        }

        Path projectRoot = Paths.get(path);

        if (projectRoot.getParent() == null) {
            print("The provided path doesn't exists!");
            return;
        }

        Files.walk(projectRoot, 1)
                .map(Path::getParent)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println)
        ;

        brakeAfterEachExercise();
    }

    public static void touchCommand(String path, String fileName) throws IOException {
        File file = new File(path + "/" + fileName);
        if (file.createNewFile()) {
            System.out.println("File created: " + file.getName());
        } else {
            System.out.println("File already exists.");
        }
    }

    public static void mkdirCommand(String path, String directoryName) throws IOException {
        File directory = new File(path);
        boolean bool = directory.mkdir();

        if (directory.createNewFile()) {
            if (bool) {
                System.out.println("Directory created successfully" + directory.getName());
            } else {
                System.out.println("Couldn’t create specified directory");
            }
        } else {
            System.out.println("File already exists.");
        }
    }

    public static void llCommand(String path) throws IOException {
        if (isEmpty(path)) {
            throw new IllegalArgumentException("The file path is empty!");
        }

        Path projectRoot = Paths.get(path);

        Files.walk(projectRoot, 1)
                .map(Path::normalize)
                .map(Path::toAbsolutePath)
                .forEach(System.out::println);

        brakeAfterEachExercise();
    }
}
