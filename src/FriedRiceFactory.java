public final class FriedRiceFactory implements FoodFactory {
    public Food createFood() {
        return new FriedRice();
    }
}
