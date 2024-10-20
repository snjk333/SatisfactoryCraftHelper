import java.time.LocalDate;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SessionWriter {
    public static void WriteSession(LocalDate date, List<String> Logs) {
        try {
            FileWriter writer = new FileWriter("Session.txt",true);
            PrintWriter printWriter = new PrintWriter(writer);
            printWriter.println(date);
            for (String log : Logs) {
                printWriter.println(log);
            }
            printWriter.close();  // Закрываем PrintWriter
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
