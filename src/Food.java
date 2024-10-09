public class Food extends Item {
 private int foodHp;

    public Food(String name, String description, int foodHp){
        super(name, description);
        this.foodHp = foodHp;
    }

    public int getFoodHp() {
        return foodHp;
    }
}
