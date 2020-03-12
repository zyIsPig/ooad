public class zhenzhu extends decorator {

    food food;

    public zhenzhu(food food){
        this.food=food;

    }



    @Override
    public String getDescription() {
        return this.food.getDescription()+"+zhenzhu";
    }

    @Override
    public float cost() {
        return (float) (1.5+food.cost());
    }
}
