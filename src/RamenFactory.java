public final class RamenFactory implements FoodFactory {
    @Override
    public Food createFood() {
        return new Ramen();
    }
}
