package Menu;

import Model.Receipt;
import ReceiptService.IReceiptReader;
import ReceiptService.ReceiptFinder;
import ReceiptService.ReceiptReaderTXT;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
import Session.SessionWriter;
public class MenuConsole implements IMenu {
    @Override
    public void display(List<Receipt> receipts, String database) throws IOException {
        IReceiptReader Reader = new ReceiptReaderTXT();
        Scanner scanner = new Scanner(System.in);
        Reader.readFile(database,receipts); // прочитало файл
        System.out.println("Hi. I'm your receipt helper. Today is " + LocalDate.now());
        boolean Active = true;
        List<String> RequestsReceipts = new ArrayList<>();
        List<String> RequestsIngredients = new ArrayList<>();
        while (Active) {
            MenuConsoleOptionsWriter.WriteOptions();
            String Choice = scanner.nextLine();
            switch (Choice) {
                case "1":
                    System.out.println("Enter the item name for getting a receipt");
                    String RequestReceipt = scanner.nextLine();
                    RequestsReceipts.add(RequestReceipt);
                    ReceiptFinder.FindReceipts(receipts, RequestReceipt);
                    break;
                case "2":
                    System.out.println("Enter the ingredient name for getting a info what u can cook");
                    String RequestIngredient = scanner.nextLine();
                    RequestsIngredients.add(RequestIngredient);
                    ReceiptFinder.FindReceiptsByIngredient(receipts, RequestIngredient);
                    break;
                case "0":
                    System.out.println("Goodbye");
                    SessionWriter.WriteSession(LocalDate.now(),RequestsReceipts, RequestsIngredients);
                    Active = false;
                    break;
                default:
                    System.out.println("You wrote incorrect option");
            }

        }

    }

}
