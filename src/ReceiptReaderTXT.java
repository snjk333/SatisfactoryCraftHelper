import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReceiptReaderTXT implements IReceiptReader {

    @Override
    public void readFile(String path, List<Receipt> receiptsList) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
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
                        String[] words = line.split(" ");
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

//Голова кипит надо выбрать рабочую версию из 2, нижняя полностью моя, верхнюю чат гпт переделал, что-то поменял.

/* import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ReceiptReaderTXT implements IReceiptReader{

    @Override
    public void readFile(String path, List<Receipt> List) {
        File file = new File(path);
        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNextLine()) {
                List<ItemMulti> newItems = new ArrayList<>();
                String Line = scanner.nextLine();
                Item newItem = new Item(ItemNameCheck.CheckName(Line));
                Line = scanner.nextLine();
                if(!Objects.equals(Line, "NEXT")){
                    newItem.setPrimitive(true);
                    do {
                        Line = scanner.nextLine();
                        String[] words = Line.split(" ");
                        newItems.add(new ItemMulti(ItemNameCheck.CheckName(words[1]),Integer.getInteger(words[0])));
                    }while(!Objects.equals(Line, "NEXT"));
                }
                else if(Line.equals("NEXT")){
                    newItems = null;
                    newItem.setPrimitive(false);
                }
                List.add(new Receipt(newItem,newItems));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}*/
