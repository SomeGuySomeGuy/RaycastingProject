import java.awt.image.BufferedImage;
import java.awt.Graphics;

class Projectile extends Entity {
    
    private double changeX;
    private double changeY;
    
    private boolean running = true;
    
    
    public boolean keepRunning(){
        return this.running == true;
    }
    
    public void stopRunning(){
        this.running = false;
    }
    
    public double getChangeX() {
        return this.changeX;
    }
    
    public double getChangeY() {
        return this.changeY;
    }
    
    public void draw(Graphics g, double offSetX, double offSetY) {
        //System.out.println("drawing projectile");
        g.fillRect((int) (getPosition().getX() - getWidth() / 2 + offSetX), (int) (getPosition().getY() - getHeight() / 2 + offSetY), getWidth(), getHeight()); //draw the projectile
    }
    
    public void move(){
        moveUp(this.getChangeY());
        moveLeft(this.getChangeX());
    }
    
    public void run(){
        System.out.println("projectile created");
        while(keepRunning()){
            move();
        }
    }
    
    Projectile(Vector position, int width, int height, String name, Angle angle, BufferedImage sprite, 
               double health, double speed, double spriteZOffset, double spriteScale, double changeX, double changeY) {
        super(position, width, height, name, angle, sprite, health, speed, spriteZOffset, spriteScale);
        this.changeX = changeX;
        this.changeY = changeY;
    }
    
}