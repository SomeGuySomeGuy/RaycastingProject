import java.awt.image.BufferedImage;

public class HealthPack extends Item {
    private int value;

    HealthPack(Vector position, int width, int height, String name, Angle angle, TextureManager sprites, int value) {
        super(position, width, height, name, angle, sprites);
        this.value = value;
    }

    public void onPickup(Player player){
        player.setHealth(player.getHealth() + value);
    }
}
