package ReceiptService;

import Model.Receipt;

import java.util.*;

public interface IReceiptReader {
    void readFile(String path, List<Receipt> List);
}
