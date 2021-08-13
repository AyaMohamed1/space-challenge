public interface SpaceShip {
    //indicating if the launch was successful or if the rocket has crashed.
    boolean launch();
    // the success of the landing.
    boolean land();
    //takes an Item as an argument and returns true if the rocket can carry such item
    // or false if it will exceed the weight limit.
    boolean canCarry(Item item);
    //takes an Item object and updates the current weight of the rocket.
    void carry(Item item);

}
