import java.util.*;
public class Receipt extends Item{
    private final List<ItemMulti> Ingredients;

    public Receipt(String itemName, boolean primitive, List<ItemMulti> ingredients) {
        super(itemName, primitive);
        Ingredients = ingredients;
    }

    public Receipt(String itemName, List<ItemMulti> ingredients) {
        super(itemName);
        Ingredients = ingredients;
    }

    public Receipt(Item item, List<ItemMulti> ingredients) {
        super(item);
        Ingredients = ingredients;
    }
    public List<ItemMulti> getIngredients() {
        return Ingredients;
    }

}
