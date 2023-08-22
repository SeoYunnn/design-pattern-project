public final class RamenFactory implements FoodFactory {
    public Food createFood() {
        return new Ramen();
    }
}
