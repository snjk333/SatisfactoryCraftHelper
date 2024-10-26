package Menu;

import Model.Receipt;

import java.io.IOException;
import java.util.List;

public interface IMenu {
        void display(List<Receipt> Receipts, String DataBase) throws IOException;
}
