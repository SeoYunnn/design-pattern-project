public class CheeseTopping extends ToppingDecorator {
    public CheeseTopping(Food baseFood) {
        super(baseFood);
        name = "치즈 " + baseFood.getName();
    }

    public String getDescription() {
        return baseFood.getDescription() + " + 치즈 토핑";
    }

    public int cost() {
        return baseFood.cost() + 500;
    }
}