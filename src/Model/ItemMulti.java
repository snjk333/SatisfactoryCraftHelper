package Model;

public class ItemMulti extends Item{
    private int count;

    // Основной конструктор
    public ItemMulti(String itemName, boolean primitive, int count) {
        super(itemName, primitive);
        this.count = count;
    }

    public ItemMulti(Item item, int count) {
        this(item.getItemName(), item.isPrimitive(), count);
    }

    public ItemMulti(String itemName, int count) {
        this(itemName, false, count); // По умолчанию primitive = false
    }

    public ItemMulti(String itemName, boolean primitive) {
        this(itemName, primitive, 1);
    }

    public ItemMulti(Item item) {
        this(item.getItemName(), item.isPrimitive(), 1);
    }

    public ItemMulti(String itemName) {
        this(itemName, false, 1);
    }

    public int getCount() {
        return count;
    }

    public void MultipleCount(int count) {
        this.count *= count;
    }
}
