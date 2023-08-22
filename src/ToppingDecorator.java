public abstract class ToppingDecorator extends Food {
    protected Food baseFood; // 토핑을 추가할 기본 음식

    public ToppingDecorator(Food baseFood) {
        this.baseFood = baseFood;
    }

    public abstract String getDescription(); // 토핑 추가에 대한 설명을 반환하는 추상 메서드
}
