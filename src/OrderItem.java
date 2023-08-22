public class OrderItem {
    private Food food;
    private int quantity;

    public OrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getName( ) {
        return food.getName();
    }

    public String getDescription() {
        return food.getDescription();
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalCost() {
        return food.cost() * quantity;
    }
}
