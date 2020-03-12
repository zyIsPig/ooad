public class duck {
    private flyBehivour flyBehivour;

    private quackBehaviour quackBehaviour;

    private  swimBehivour swimBehivour;




    public flyBehivour getFlyBehivour() {
        return flyBehivour;
    }

    public void setFlyBehivour(flyBehivour flyBehivour) {
        this.flyBehivour = flyBehivour;
    }

    public quackBehaviour getQuackBehaviour() {
        return quackBehaviour;
    }

    public void setQuackBehaviour(quackBehaviour quackBehaviour) {
        this.quackBehaviour = quackBehaviour;
    }

    public swimBehivour getSwimBehivour() {
        return swimBehivour;
    }

    public void setSwimBehivour(swimBehivour swimBehivour) {
        this.swimBehivour = swimBehivour;
    }



    public void swim(){
        swimBehivour.swim();
    }

    public void quack(){
        quackBehaviour.quack();
    }

    public void fly(){
        flyBehivour.fly();
    }

}
