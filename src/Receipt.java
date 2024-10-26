import java.util.*;
public class Receipt{
    private final List<ItemMulti> Ingredients;
    private final Item item;

    public Receipt(Item item, List<ItemMulti> ingredients) {
        this.item = item;
        Ingredients = ingredients;
    }
    public Item getItem() {
        return item;
    }
    public List<ItemMulti> getIngredients() {
        return Ingredients;
    }
  //
}
