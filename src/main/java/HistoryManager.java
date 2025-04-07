import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HistoryManager {
    private static final String FILE_NAME = "history.csv";

    public static void saveHistory(String line) throws IOException {
        try(FileWriter fw = new FileWriter(FILE_NAME,true)){
            fw.write((line + "\n"));
        }
    }

    public static void displayHistory(){
        System.out.println("\n---Conversion History---");
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("No history available.");;
        }
    }
}
