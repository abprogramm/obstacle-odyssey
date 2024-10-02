import java.awt.Color;
import java.awt.Graphics;

public class Player {
    private int x, y;
    private int size = 30; 
    private boolean shieldActive = false; 
    private int speed = 20; 
    private boolean speedBoostActive = false; 

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        if (shieldActive) {
            g.setColor(Color.CYAN); 
        } 
        else if (speedBoostActive) {
            g.setColor(Color.YELLOW);
        } 
        else {
            g.setColor(Color.BLUE);
        }
        g.fillRect(x, y, size, size);
    }

    public void update() {
        
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
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

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setShieldActive(boolean active) {
        this.shieldActive = active;
    }

    public boolean isShieldActive() {
        return shieldActive;
    }

    public void setSpeedBoostActive(boolean active) {
        this.speedBoostActive = active;
        if (!active) {
            resetSpeed(); 
        }
    }

    public boolean isSpeedBoostActive() {
        return speedBoostActive;
    }

    public void resetSpeed() {
        this.speed = 20; 
    }

    public boolean collidesWith(GameObjects obj) {
        return (x < obj.getX() + obj.getWidth() &&
                x + size > obj.getX() &&
                y < obj.getY() + obj.getHeight() &&
                y + size > obj.getY());
    }
}


