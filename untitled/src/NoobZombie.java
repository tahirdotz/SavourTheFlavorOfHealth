class NoobZombie implements HireableZombie {
    @Override
    public String getName() {
        return "Noob Zombie Scout";
    }

    @Override
    public int getHireCost() {
        return 10;
    }

    @Override
    public double getAccuracy() {
        return 0.6; 
    }

    @Override
    public Prey locatePrey(PreyFactory factory) {
        return factory.createBetterPrey(20, 50);
    }
}