import Menu.IMenu;
import Menu.MenuConsole;
import Model.Receipt;
import ReceiptService.Config;

import java.io.IOException;
import java.util.*;
import java.util.List;

public class Main {
    static String path;
    // static String Separator = File.separator;
    // static String path = "E:" + Separator + "STUDY" + Separator + "HZWTF" + Separator + "SatisfactoryCraftHelper" + Separator + Base;
    //Аля по-умному берет через библиотеку File сепаратор системы,
    // чтобы найти путь к файлу в любой системе. Потому что в Windows путь \\,
    // а в Unix системах путь идет через // (Добавил по приколу, всё равно путь вряд-ли 1в1 будет)

    public static void main(String[] args) throws IOException {
        Config config = new Config("config.properties");
        path = config.getProperty("database.path");
        List<Receipt> Receipts = new ArrayList<>();
        IMenu menu = new MenuConsole();
        menu.display(Receipts, path);
    }
}

