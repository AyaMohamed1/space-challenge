public class U1 extends Rocket{
    U1(){
        this(0);
    }

    U1(int currentWeight){
        cost = 100;
        rocketWeight = 10;
        maxWeight = 18;
        this.currentWeight = currentWeight;
    }


    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = (5.0 / 100) * ((double) currentWeight / maxWeight);
        double randomNum = Math.random();
        if(randomNum > chanceOfLaunchExplosion)
            return false;
        else
            return true;
    }

    @Override
    public boolean land() {
        chanceOfLandingCrash = (1.0 / 100) * ((double) currentWeight / maxWeight);
        double randomNum = Math.random();
        if(randomNum > chanceOfLandingCrash)
            return false;
        else
            return true;
    }
}
