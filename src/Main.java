import java.io.IOException;
import java.util.*;
import java.util.List;
import java.io.File;
public class Main {
    static String Base = "ReceiptsDataBase.txt";
    static String Separator = File.separator;
    static String path = "E:" + Separator + "STUDY" + Separator + "HZWTF" + Separator + "SatisfactoryCraftHelper" + Separator + Base;
    //Аля по-умному берет через библиотеку File сепаратор системы,
    // чтобы найти путь к файлу в любой системе. Потому что в Windows путь \\,
    // а в Unix системах путь идет через // (Добавил по приколу, всё равно путь вряд-ли 1в1 будет)

    public static void main(String[] args) throws IOException {
        List<Receipt> Receipts = new ArrayList<>();
        IMenu menu = new MenuConsole();
        menu.display(Receipts, Base);
    }
}

