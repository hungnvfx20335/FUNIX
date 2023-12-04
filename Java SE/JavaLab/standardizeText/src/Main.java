import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder inputText = readTextFiles();
        System.out.println("Văn bản đầu vào:");
        System.out.println(inputText);
        standardizeContentFiles(inputText);
    }
    public static StringBuilder readTextFiles() throws IOException {
        FileReader fileReader = new FileReader("D:\\Java Lap\\standardizeText\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        String text;
        while ((text = bufferedReader.readLine()) != null) {
            stringBuilder.append(text);
        }
        return stringBuilder;
    }
    public static void standardizeContentFiles(StringBuilder inputText) throws IOException {
        StringBuilder outputText = new StringBuilder(String.valueOf(String.valueOf(inputText)));
        outputText = new StringBuilder(outputText.toString().trim());
        outputText = new StringBuilder(outputText.toString().toLowerCase());
        outputText = new StringBuilder(outputText.toString().replaceAll("\\\"\\s+", "\\\""));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\s+\"", "\\\""));

        outputText = new StringBuilder(outputText.toString().replaceAll("\\.", ". "));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\,", ", "));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\:", ": "));

        outputText = new StringBuilder(outputText.toString().replaceAll("\\s+", " "));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\s\\.", "."));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\s\\,", ","));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\s\\:", ":"));
        outputText = new StringBuilder(outputText.toString().replaceAll("\\A" + outputText.charAt(0), String.valueOf(outputText.charAt(0)).toUpperCase()));
        outputText = new StringBuilder(outputText.toString().concat("."));
        String[] temp = outputText.toString().split("\\. ");

        outputText = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            outputText.append(String.valueOf(temp[i].charAt(0)).toUpperCase()).append(temp[i].substring(1));
            if (i < temp.length - 1) {
                outputText.append(". ");
            }
        }
        outputText = new StringBuilder(outputText.toString().replaceAll("\\.\\s\\.", "."));
        FileWriter fileWriter = new FileWriter("D:\\Java Lap\\standardizeText\\output.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(outputText.toString());
        bufferedWriter.close();
        System.out.println("Văn bản đầu ra:");
        System.out.println(outputText);
    }
}