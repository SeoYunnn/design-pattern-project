public class OrderItem {
    private Food food; // 주문된 음식을 나타내는 Food 객체
    private int quantity; // 주문된 음식의 수량

    public OrderItem(Food food, int quantity) {
        this.food = food;
        this.quantity = quantity;
    }

    public String getName() {
        return food.getName(); // 음식 이름 반환
    }

    public String getDescription() {
        return food.getDescription();
    } // 음식 설명 반환

    public int getQuantity() {
        return quantity;
    } // 음식 수량 반환

    public int getTotalCost() {
        return food.cost() * quantity;
    } // 음식의 총 가격 반환
}
