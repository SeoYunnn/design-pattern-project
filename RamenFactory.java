public class RamenFactory implements FoodFactory {
    public Food createFood() {
        return new Ramen();
    }
}
