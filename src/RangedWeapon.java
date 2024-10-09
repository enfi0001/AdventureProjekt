public class RangedWeapon extends Weapon {

    private int ammo;

    public RangedWeapon(String name, String description, int ammo) {
        super(name, description);
        this.ammo = ammo;

    }


    @Override
    public boolean canUse() {
        return ammo > 0;
    }

    @Override
    public void useWeapon() {
        if (canUse()) {
            ammo--;
        }
    }


    @Override
    public String toString() {
        return "you have " + ammo + " arrows remaining" ;
    }
}
