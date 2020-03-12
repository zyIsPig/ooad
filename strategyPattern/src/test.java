public class test {


    public static void main(String[] args) {
        duck duck1=new zyduck();


        duck1.fly();
        duck1.swim();
        duck1.quack();

        System.out.println(".............");

        duck1.setFlyBehivour(new flyByRocket());


        duck1.fly();
    }
}
