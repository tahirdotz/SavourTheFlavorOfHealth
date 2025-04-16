class ProZombie implements HireableZombie {
    @Override
    public String getName() {
        return "Pro Zombie Scout";
    }

    @Override
    public int getHireCost() {
        return 40;
    }

    @Override
    public double getAccuracy() {
        return 0.9;
    }

    @Override
    public Prey locatePrey(PreyFactory factory) {
        return factory.createBetterPrey(50, 100);
    }
}