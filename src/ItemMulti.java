public class ItemMulti extends Item{
    private int count;

    public ItemMulti(String itemName, boolean primitive, int count) {
        super(itemName, primitive);
        this.count = count;
    }

    public ItemMulti(Item item, int count) {
        super(item);
        this.count = count;
    }

    public ItemMulti(String itemName, int count) {
        super(itemName);
        this.count = count;
    }
    public ItemMulti(String itemName, boolean primitive) {
        super(itemName, primitive);
        this.count = 1;
    }

    public ItemMulti(Item item) {
        super(item);
        this.count = 1;
    }

    public ItemMulti(String itemName) {
        super(itemName);
        this.count = 1;
    }

    public int getCount() {
        return count;
    }

    public void MultipleCount(int count) {
        this.count *= count;
    }
}
