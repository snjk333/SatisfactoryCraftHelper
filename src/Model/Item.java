package Model;

public class Item {
    private final String itemName;
    private boolean primitive = false;


    public Item(String itemName) {
        this.itemName = itemName;
    }
    public Item(String itemName, boolean primitive) {
        this(itemName);
        setPrimitive(primitive);
    }
    public Item(Item item) {
        this.itemName = item.itemName; // Явное копирование поля
        this.primitive = item.primitive; // Явное копирование поля
    }

    public String getItemName() {
        return itemName;
    }

    public boolean isPrimitive() {
        return primitive;
    }

    public void setPrimitive(boolean primitive) {
        this.primitive = primitive;
    }
}
