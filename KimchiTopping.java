public class KimchiTopping extends ToppingDecorator {
    public KimchiTopping(Food baseFood) {
        super(baseFood);
        name = "김치 " + baseFood.getName();
    }

    public String getDescription() {
        return baseFood.getDescription() + " + 김치";
    }

    public int cost() {
        return baseFood.cost() + 800;
    }
}

