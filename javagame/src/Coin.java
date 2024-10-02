import java.awt.Graphics;
import java.awt.Color;

public class Coin {
    private int x, y;
    private int size = 20; 
    private boolean collected;

    public Coin(int x, int y) {
        this.x = x;
        this.y = y;
        this.collected = false;
    }

    public void draw(Graphics g) {
        if (!collected) {
            g.setColor(Color.YELLOW); 
            g.fillOval(x, y, size, size); 
        }
    }

    public boolean isCollected() {
        return collected;
    }

    public void collect() {
        collected = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    
    public boolean collidesWith(Player player) {
        return player.getX() < x + size &&
               player.getX() + player.getSize() > x &&
               player.getY() < y + size &&
               player.getY() + player.getSize() > y;
    }
}
