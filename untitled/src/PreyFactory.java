import java.util.Random;

class PreyFactory {
    private final Random random = new Random();

    public Prey createRandomSimplePrey() {
        String[] animalTypes = {"Rat", "Squirrel", "Cat", "Dog", "Rabbit"};
        String animal = animalTypes[random.nextInt(animalTypes.length)];

        int healthRating = 10 + random.nextInt(30);
        int pointValue = 5 + random.nextInt(20);
        int moneyValue = 2 + random.nextInt(8);
        int healthValue = 5 + random.nextInt(10);

        return new AnimalPrey(animal, healthRating, pointValue, moneyValue, healthValue);
    }

    public Prey createBetterPrey(int minHealth, int maxHealth) {

        boolean isHuman = random.nextDouble() > 0.3;

        if (isHuman) {
            String[] humanTypes = {"Survivor", "Athlete", "Doctor", "Soldier"};
            String[] names = {"Alex", "Jamie", "Sam", "Taylor"};

            String occupation = humanTypes[random.nextInt(humanTypes.length)];
            String name = names[random.nextInt(names.length)];

            int healthRating = minHealth + random.nextInt(maxHealth - minHealth + 1);
            int pointValue = healthRating + random.nextInt(20);
            int moneyValue = healthRating / 2 + random.nextInt(20);
            int healthValue = healthRating / 3 + random.nextInt(15);

            return new HumanPrey(name, healthRating, pointValue, moneyValue, healthValue, occupation);
        } else {
            String[] strongAnimals = {"Wild Boar", "Bull", "Bear", "Wolf"};
            String animal = strongAnimals[random.nextInt(strongAnimals.length)];

            int healthRating = minHealth + random.nextInt(maxHealth - minHealth + 1);
            int pointValue = healthRating + random.nextInt(15);
            int moneyValue = healthRating / 3 + random.nextInt(10);
            int healthValue = healthRating / 4 + random.nextInt(10);

            return new AnimalPrey(animal, healthRating, pointValue, moneyValue, healthValue);
        }
    }
}