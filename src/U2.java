public class U2 extends Rocket {
    U2(){
       this(0);
    }

    U2(int currentWeight){
        cost = 120;
        rocketWeight = 18;
        maxWeight = 29;
        this.currentWeight = currentWeight;
    }

    @Override
    public boolean launch() {
        chanceOfLaunchExplosion = (4.0 / 100) * ((double) currentWeight / maxWeight);
        double randomNum = Math.random();
        if(randomNum > chanceOfLaunchExplosion)
            return false;
        else
            return true;
    }

    @Override
    public boolean land() {
        chanceOfLandingCrash = (8.0 / 100) * ((double) currentWeight / maxWeight);
        double randomNum = Math.random();
        if(randomNum > chanceOfLandingCrash)
            return false;
        else
            return true;
    }

}
