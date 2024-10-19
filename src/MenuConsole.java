import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuConsole implements IMenu {
    @Override
    public void display(List<Receipt> Receipts, String DataBase) {
        IReceiptReader Reader = new ReceiptReaderTXT();
        Scanner scanner = new Scanner(System.in);
        Reader.readFile(DataBase,Receipts); // прочитало файл
        System.out.println("Hi. I'm your receipt helper. Today is " + LocalDate.now());
        boolean Active = true;
        List<String> Requests = new ArrayList<>();
        while (Active) {
            System.out.println("Choose what do you want to do? ");
            System.out.println("1 - Find a receipt ");
            System.out.println("0 - Exit"+'\n');
            int Choice = scanner.nextInt();
            scanner.nextLine();
            switch (Choice) {
                case 1:
                    System.out.println("Enter the item name for getting a receipt");
                    String Request = scanner.nextLine();
                    Requests.add(Request);
                    //бла бла бла находит рецепт, выдает
                    break;
                case 0:
                    System.out.println("Goodbye");
                    SessionWriter.WriteSession(LocalDate.now(),Requests);
                    Active = false;
                    break;
                default:
                    System.out.println("You wrote incorrect option");
            }

        }

    }

}
