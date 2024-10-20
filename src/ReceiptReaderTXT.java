import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptReaderTXT implements IReceiptReader {

    @Override
    public void readFile(String path, List<Receipt> receiptsList) {
        //Path pathS = Path.of(path);
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            //Scanner scanner = new Scanner(Files.createFile(pathS));
            while (scanner.hasNextLine()) {
                List<ItemMulti> newItems = new ArrayList<>();
                String line = scanner.nextLine();
                Item newItem = new Item(ItemNameCheck.CheckName(line));

                if (scanner.hasNextLine()) {
                    line = scanner.nextLine();
                }

                if (!line.equals("NEXT")) {
                    newItem.setPrimitive(false);  // Составной предмет, рецепт
                    do {
                        String[] words = line.split(" "); //лучше через запятую
                        if (words.length == 2) {
                            newItems.add(new ItemMulti(ItemNameCheck.CheckName(words[1]), Integer.parseInt(words[0])));
                        }
                        else{
                            newItems.add(new ItemMulti(ItemNameCheck.CheckName(words[0]), 1));
                        }
                        line = scanner.nextLine();
                    } while (!line.equals("NEXT"));
                } else {
                    newItems = null;  // Примитивный предмет
                    newItem.setPrimitive(true);
                }

                receiptsList.add(new Receipt(newItem, newItems));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in the file.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
