class ZombieFactory {
    public HireableZombie createZombie(Zombie type) {
        return (type == Zombie.NOOB) ? new NoobZombie() : new ProZombie();
    }
}