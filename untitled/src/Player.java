class Player {
    private final String name;
    private int health;
    private int money;
    private int points;
    private int remainingTurns;
    private final int targetPoints;

    public Player(String name, int health, int money, int remainingTurns) {
        this.name = name;
        this.health = health;
        this.money = money;
        this.points = 0;
        this.remainingTurns = remainingTurns;
        this.targetPoints = 300;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public int getPoints() {
        return points;
    }

    public int getRemainingTurns() {
        return remainingTurns;
    }

    public int getTargetPoints() {
        return targetPoints;
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public void increaseMoney(int amount) {
        this.money += amount;
    }

    public void decreaseMoney(int amount) {
        this.money -= amount;
        if (this.money < 0) {
            this.money = 0;
        }
    }

    public void increasePoints(int amount) {
        this.points += amount;
    }

    public void decrementTurns() {
        this.remainingTurns--;
    }

    public boolean isAlive() {
        return this.health > 0;
    }
}