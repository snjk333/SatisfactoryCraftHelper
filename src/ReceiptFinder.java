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
        if (item.isPrimitive()) {
            return;
        }

        List<Receipt> receipts = FindByName(receiptList, item.getItemName());
        soutHelper += "+";

        if (!receipts.isEmpty()) {
            for (Receipt receipt : receipts) {
                FindFinalReceipt(receiptList, receipt, soutHelper);
            }
        }
    }

//откзаться от null, пустые списки лучше, посмотреть про опшион

    public static void FindFinalReceipt(List<Receipt> receiptList, Receipt receipt, String soutHelper) {
      //  System.out.println(soutHelper + receipt.getItemName());
        if(receipt.getIngredients()!=null) {
            for (ItemMulti item : receipt.getIngredients()) {
                if(item!=null) {
                System.out.println(soutHelper + item.getItemName());
                FindItemReceipt(receiptList, item, soutHelper);
                }
            }
        }
    }

    public static void FindReceipts(List<Receipt> receiptList, String receiptName) {
        List<Receipt> receipts = FindByName(receiptList, receiptName);
        String soutHelper = "+";
        if(!receipts.isEmpty()){
            for (Receipt receipt : receipts) {
                System.out.println("Receipt for: " + receipt.getItemName());
                FindFinalReceipt(receiptList, receipt, soutHelper);
                System.out.println();
            }
            }
        else{
            System.out.println("Element don't have receipt: " + receiptName);
        }
    }
}
