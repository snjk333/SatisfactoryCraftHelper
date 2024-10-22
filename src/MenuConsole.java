import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuConsole implements IMenu {
    @Override
    public void display(List<Receipt> Receipts, String DataBase) throws IOException {
        IReceiptReader Reader = new ReceiptReaderTXT();
        Scanner scanner = new Scanner(System.in);
        Reader.readFile(DataBase,Receipts); // прочитало файл
        System.out.println("Hi. I'm your receipt helper. Today is " + LocalDate.now());
        boolean Active = true;
        List<String> RequestsReceipts = new ArrayList<>();
        List<String> RequestsIngredients = new ArrayList<>();
        while (Active) {
            System.out.println("Choose what do you want to do? ");
            System.out.println("1 - Find a receipt by name");
            System.out.println("2 - Find a receipt by ingredient ");
            System.out.println("0 - Exit"+'\n');
            String Choice = scanner.nextLine();
            switch (Choice) {
                case "1":
                    System.out.println("Enter the item name for getting a receipt");
                    String RequestReceipt = scanner.nextLine();
                    RequestsReceipts.add(RequestReceipt);
                    ReceiptFinder.FindReceipts(Receipts, RequestReceipt);
                    break;
                case "2":
                    System.out.println("Enter the ingredient name for getting a info what u can cook");
                    String RequestIngredient = scanner.nextLine();
                    RequestsIngredients.add(RequestIngredient);
                    ReceiptFinder.FindReceiptsByIngredient(Receipts, RequestIngredient);
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
