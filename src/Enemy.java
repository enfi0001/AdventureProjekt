public class Enemy {
    private String name;
    private String description;
    private int enemyHp;
    private Weapon enemyWeapon;


    public Enemy(String name, String description, int enemyHp, Weapon enemyWeapon){
        this.name = name;
        this.description = description;
        this.enemyHp = enemyHp;
        this.enemyWeapon = enemyWeapon;
    }


    public String getName(){
        return name;
    }public String getDescription(){
        return description;
    }public int getEnemyHp(){
        return enemyHp;
    }public Weapon getEnemyWeapon(){
        return enemyWeapon;
    }

    public void takeEnemyDamage(int damage){
        enemyHp -= damage;
        if (enemyHp < 0){
            enemyHp = 0;
        }
    }

    public int enemyAttack(){
        if (enemyWeapon!= null){
            enemyWeapon.useWeapon();
            int damage = enemyWeapon.getDamage();
            return damage;
        }
        return 0;
    }


    public boolean isAlive(){
        return enemyHp > 0;
    }

    public Weapon dropWeapon(){
        return enemyWeapon;
    }

    @Override
    public String toString() {
        return getName() +  " --> " + getDescription();
    }
}
