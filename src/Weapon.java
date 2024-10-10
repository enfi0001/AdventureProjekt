public abstract class Weapon extends Item {
    public Weapon(String name, String description){
        super(name, description);
    }

    public abstract boolean canUse();


    public abstract void useWeapon();

    public abstract int getDamage();
}
