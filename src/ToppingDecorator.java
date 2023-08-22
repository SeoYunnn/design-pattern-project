public abstract class ToppingDecorator extends Food {
    protected Food baseFood;

    public ToppingDecorator(Food baseFood) {
        this.baseFood = baseFood;
    }

    public abstract String getDescription( );
}
