package spaceshooter.dom;

/**
 * Weapon used by player.
 *
 */
public class PlayerWeapon extends Weapon {

    /**
     * Constructor for PlayerWeapon.
     *
     * @param obj Weapons parent object.
     * @param firerate Weapons firerate.
     * @param damage Weapons damage.
     */
    public PlayerWeapon(GameObject obj, int firerate, int damage) {
        super(obj, firerate, damage);
    }

    @Override
    public void spawnProjectiles(Level level) {
        float x = this.getParent().getPosX() + 16;
        float y = this.getParent().getPosY() - 10;
        level.addObject(new PlayerProjectile(x, y, 0, -10, 10, 10, this.getDamage()));
        if (this.getUpgrades() > 0) {
            level.addObject(new PlayerProjectile(x, y, -2, -10, 10, 10, this.getDamage()));
        }
        if (this.getUpgrades() > 1) {
            level.addObject(new PlayerProjectile(x, y, 2, -10, 10, 10, this.getDamage()));
        }
    }

}
