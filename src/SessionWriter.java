import java.time.LocalDate;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionWriter {
    public static void WriteSession(LocalDate date, List<String> LogsReceipts, List<String> LogsIngredients) throws IOException {
            FileWriter writer = new FileWriter("Session.txt",true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(date);
            for (String log : LogsReceipts) {
                printWriter.println("Receipt Log: " + log);
            }
            for (String log : LogsIngredients) {
                printWriter.println("Ingredient Log: " + log);
            }
            printWriter.close();  // Закрываем PrintWriter
    }
}
