import java.util.List;
import java.util.ArrayList;

public class ReceiptFinder {

    public static List<Receipt> FindByName(List<Receipt> receiptList, String receiptName) {
        List<Receipt> Receipts = new ArrayList<>();

        for (Receipt receipt : receiptList) {
            if (receipt.getItemName().equalsIgnoreCase(receiptName)) {
                Receipts.add(receipt);
            }
        }
        return Receipts;
    }

    public static void FindItemReceipt(List<Receipt> receiptList, ItemMulti item, String soutHelper) {
        List<Receipt> receipts = FindByName(receiptList, item.getItemName());
        soutHelper = soutHelper + "+";

        if (!receipts.isEmpty()) {
            for (Receipt receipt : receipts) {
                FindFinalReceipt(receiptList, receipt, soutHelper);
            }
        } else {
            System.out.println(soutHelper + "Primitive: " + item.getItemName());
        }
    }

    public static void FindFinalReceipt(List<Receipt> receiptList, Receipt receipt, String soutHelper) {
        System.out.println(soutHelper + "Receipt: " + receipt.getItemName());

        for (ItemMulti item : receipt.getIngredients()) {
            System.out.println(soutHelper + item.getItemName());
            FindItemReceipt(receiptList, item, soutHelper);
        }
    }

    public static void FindReceipts(List<Receipt> receiptList, String receiptName) {
        List<Receipt> receipts = FindByName(receiptList, receiptName);
        String soutHelper = "+";

        for (Receipt receipt : receipts) {
            System.out.println("Receipt for: " + receipt.getItemName());
            FindFinalReceipt(receiptList, receipt, soutHelper);
            System.out.println();
        }
    }
}
