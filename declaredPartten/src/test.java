public class test {


    public static void main(String[] args) {


        naicha naicha=new naicha();



        System.out.println(naicha.cost());
        System.out.println(naicha.getDescription());

        food naicha1=new naicha();
        System.out.println(naicha1.getDescription());

        naicha1=new zhenzhu(naicha1);

        System.out.println(naicha1.cost());
        System.out.println(naicha1.getDescription());





    }
}
