/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceshooter.dom;

/**
 *
 * @author Aleksi
 */
public class EnemyWeapon extends Weapon {

    public EnemyWeapon(GameObject obj, int firerate, int damage) {
        super(obj, firerate, damage);
    }

    @Override
    public void spawnProjectiles(Level level) {
        Player p = level.getPlayer();
        float velX = (p.getPosX() - this.getParent().getPosX()) / 30;
        float velY = (p.getPosY() - this.getParent().getPosY()) / 30;
        level.addObject(new EnemyProjectile(this.getParent().getPosX(), this.getParent().getPosY(),
                velX, velY, 10, 10, this.getDamage()));
    }
}
