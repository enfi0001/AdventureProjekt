public class MeleeWeapon extends Weapon{
    public MeleeWeapon(String name, String description){
        super(name, description);
    }


    @Override
    public boolean canUse() {
        return true;
    }



    @Override
    public void useWeapon() {

    }
}
