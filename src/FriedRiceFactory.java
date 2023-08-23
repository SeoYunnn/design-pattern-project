public final class FriedRiceFactory implements FoodFactory {
    @Override
    public Food createFood() {
        return new FriedRice();
    }
}
