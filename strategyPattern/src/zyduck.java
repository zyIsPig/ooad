public class zyduck extends duck {
    public zyduck(){
        this.setSwimBehivour(new swimByFoot());
        this.setFlyBehivour(new flyWithWings());
        this.setQuackBehaviour(new quackWithMimi());
    }



}
