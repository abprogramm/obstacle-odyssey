import java.awt.Graphics;
import java.awt.Color;

public class GameObjects {
    protected int x, y;
    protected int width, height;
    protected Color color;
    protected boolean isObjective; 

    public GameObjects(int x, int y, int width, int height, Color color, boolean isObjective) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isObjective = isObjective;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isObjective() {
        return isObjective;
    }

    public void setObjective(boolean isObjective) {
        this.isObjective = isObjective;
    }

    
    public boolean collidesWith(Player player) {
        return (x < player.getX() + player.getSize() &&
                x + width > player.getX() &&
                y < player.getY() + player.getSize() &&
                y + height > player.getY());
    }

    
    public boolean collidesWith(Coin coin) {
        return (x < coin.getX() + coin.getSize() &&
                x + width > coin.getX() &&
                y < coin.getY() + coin.getSize() &&
                y + height > coin.getY());
    }

    
    public boolean collidesWith(PowerUp powerUp) {
        return (x < powerUp.getX() + powerUp.getSize() &&
                x + width > powerUp.getX() &&
                y < powerUp.getY() + powerUp.getSize() &&
                y + height > powerUp.getY());
    }
}
