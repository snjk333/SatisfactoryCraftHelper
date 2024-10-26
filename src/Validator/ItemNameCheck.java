package Validator;

public final class ItemNameCheck {
    private ItemNameCheck() {}
    public static String CheckName(String name){
        return name.toUpperCase().replace(" ","");
    }
}