interface HireableZombie {
    String getName();
    int getHireCost();
    double getAccuracy();
    Prey locatePrey(PreyFactory factory);
}