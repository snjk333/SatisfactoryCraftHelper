package ReceiptService;

import Model.ItemMulti;
import Model.Receipt;

import java.util.List;
import java.util.ArrayList;

public class ReceiptFinder {

    public static List<Receipt> FindByName(List<Receipt> receiptList, String receiptName) {
        List<Receipt> Receipts = new ArrayList<>();

        for (Receipt receipt : receiptList) {
            if (receipt.getItem().getItemName().equalsIgnoreCase(receiptName)) {
                Receipts.add(receipt);
            }
        }
        return Receipts;
    }

    public static void FindItemReceipt(List<Receipt> receiptList, ItemMulti item, String soutHelper) {
        if (item.isPrimitive()) {
            return;
        }
        //У того айтема есть кол-во, нам нужно воссоздать его тем элементам
        List<Receipt> receipts = FindByName(receiptList, item.getItemName());
        soutHelper += "+";

        if (!receipts.isEmpty()) {
            for (Receipt receipt : receipts) {
                for(ItemMulti itemMulti : receipt.getIngredients()){
                    itemMulti.MultipleCount(item.getCount());
                }
                FindFinalReceipt(receiptList, receipt, soutHelper);
            }
        }
    }

//откзаться от null, пустые списки лучше, посмотреть про опшион

    public static void FindFinalReceipt(List<Receipt> receiptList, Receipt receipt, String soutHelper) {
      //  System.out.println(soutHelper + receipt.getItemName());
        if(!receipt.getIngredients().isEmpty()) {
            for (ItemMulti item : receipt.getIngredients()) {
                if(item!=null) {
                System.out.println(soutHelper +item.getCount() + " " + item.getItemName());
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
                System.out.println("Receipt for: " + receipt.getItem().getItemName());
                FindFinalReceipt(receiptList, receipt, soutHelper);
                System.out.println();
            }
            }
        else{
            System.out.println("Element don't have receipt: " + receiptName);
        }
    }

    public static List<String> FindByIngredient(List<Receipt> receiptList, String ingridientName){
        List<String> Variants = new ArrayList<>();
        for(Receipt receipt : receiptList){
            if(receipt.getIngredients()!=null) {
                for (ItemMulti item : receipt.getIngredients()) {
                    if(item!=null) {
                        if(item.getItemName().equalsIgnoreCase(ingridientName)&&(!Variants.contains(receipt.getItem().getItemName()))) {
                            Variants.add(receipt.getItem().getItemName());
                        }
                    }
                }
            }
        }
        return Variants;
    }

    public static void FindReceiptsByIngredient(List<Receipt> receiptList, String ingridientName) {
        List<String> Variants = FindByIngredient(receiptList, ingridientName);
        if(!Variants.isEmpty()){
            for (String Variant : Variants) {
                System.out.println("From this ingridient u can cook: " + Variant);
            }
        }
        else{
            System.out.println("I dont know what u can cook from: " + ingridientName);
        }
    }
}
