public class Item {
    private String itemName;
    private boolean primitive = false;

    public Item(String itemName, boolean primitive) {
        this.itemName = itemName;
        this.primitive = primitive;
    }
    public Item() {
    }
    public Item(String itemName) {
        this.itemName = itemName;
    }
    public Item(Item item) {
        this.itemName = item.getItemName();
        this.primitive = item.isPrimitive();
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
