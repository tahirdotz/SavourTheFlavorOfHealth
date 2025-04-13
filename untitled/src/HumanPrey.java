class HumanPrey implements Prey {
    private final String name;
    private final int healthRating;
    private final int pointValue;
    private final int moneyValue;
    private final int healthValue;
    private final String occupation;

    public HumanPrey(String name, int healthRating, int pointValue, int moneyValue, int healthValue, String occupation) {
        this.name = name;
        this.healthRating = healthRating;
        this.pointValue = pointValue;
        this.moneyValue = moneyValue;
        this.healthValue = healthValue;
        this.occupation = occupation;
    }

    @Override
    public String getName() {
        return name + " (" + occupation + ")";
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