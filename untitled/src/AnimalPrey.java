class AnimalPrey implements Prey {
    private final String name;
    private final int healthRating;
    private final int pointValue;
    private final int moneyValue;
    private final int healthValue;

    public AnimalPrey(String name, int healthRating, int pointValue, int moneyValue, int healthValue) {
        this.name = name;
        this.healthRating = healthRating;
        this.pointValue = pointValue;
        this.moneyValue = moneyValue;
        this.healthValue = healthValue;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealthRating() {
        return healthRating;
    }

    @Override
    public int getPointValue() {
        return pointValue;
    }

    @Override
    public int getMoneyValue() {
        return moneyValue;
    }

    @Override
    public int getHealthValue() {
        return healthValue;
    }
}