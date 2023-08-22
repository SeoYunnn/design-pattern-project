public final class EggTopping extends ToppingDecorator {
    public EggTopping(Food baseFood) {
        super(baseFood);
        name = "계란 " + baseFood.getName();
    }

    public String getDescription() {
        return baseFood.getDescription() + " + 계란 토핑";
    }

    public int cost() {
        return baseFood.cost() + 500;
    }
}
