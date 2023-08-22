public final class ShrimpTopping extends ToppingDecorator {
    public ShrimpTopping(Food baseFood) {
        super(baseFood);
        name = "새우 " + baseFood.getName();
    }

    public String getDescription() {
        return baseFood.getDescription() + " + 새우";
    }

    public int cost() {
        return baseFood.cost() + 1000;
    }
}
