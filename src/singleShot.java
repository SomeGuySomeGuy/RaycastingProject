import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//Note: Need to make lastFire,timer,cooldown extend from weapon

import javax.imageio.ImageIO;


public class singleShot extends Weapon{
	private long lastFire;
	private long timer;
	private long cooldown;
	private boolean reloading = false;
	
	void shoot(Angle angle, Vector playerPos, ArrayList<Projectile> projectilesList) {
        cooldown = setCooldown(this.lastFire, this.timer);
        if(projectilesList.size() == this.getAmmoSize()) {
        	reloading = true;        	
        }
        else {
        	if(reloading == false) {
        		if(this.cooldown < 5) {    
            		double yComponent = -1* Math.sin(angle.getValue());
            		double xComponent = -1* Math.cos(angle.getValue());		
            		projectilesList.add(new Projectile(new Vector(playerPos.getX(),playerPos.getY()), 20, 20, "Bullet", angle, fireball,
            				10, 10, 0, 1, xComponent, yComponent));
                }
                else if(this.cooldown > this.getFireRate()) {
                	lastFire = System.currentTimeMillis();
            	    cooldown = 0;           
                }  		    		
        	}
        }
    	if (this.getReloadTime() < cooldown) {
    		reloading = false;
    		projectilesList.clear();
    	}
	}
	
	void moveProjectile(ArrayList<Projectile> projectilesList) {
	    this.timer = System.currentTimeMillis();
		for(int i = 0; i < projectilesList.size(); i++) {
				(projectilesList.get(i)).moveUp(projectilesList.get(i).getChangeY()*-projectilesList.get(i).getSpeed()); //moves the projectils on the y-axis
		        (projectilesList.get(i)).moveLeft(projectilesList.get(i).getChangeX()*-projectilesList.get(i).getSpeed()); //moves the projectils on the x-axis   
		}
	    if(projectilesList.size() > this.getAmmoSize()) {
	    	projectilesList.remove(0);
	    }
	}

	singleShot(double x, double y, int width, int height, String name, TextureManager sprite, double damage, double fireRate, int clipSize, int reloadTime) {
		super(x, y, width, height, name, sprite, damage, fireRate, clipSize, reloadTime);
		
	}

}

 
