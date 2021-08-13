public class Rocket implements SpaceShip{
    int maxWeight, currentWeight, rocketWeight, cost;
    double chanceOfLaunchExplosion, chanceOfLandingCrash;
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        if(item.weight + currentWeight <= maxWeight)
            return true;
        else
            return false;
    }

    @Override
    public void carry(Item item) {

        currentWeight += item.weight;
    }
}
