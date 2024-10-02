import java.awt.Color;
import java.awt.Graphics;

public class MovingObject extends GameObjects {
    private int dx, dy;
    private int panelWidth;
    private int panelHeight;
    private boolean moving = false; 

    public MovingObject(int x, int y, int width, int height, Color color, int dx, int dy, int panelWidth, int panelHeight) {
        super(x, y, width, height, color, false);
        this.dx = dx;
        this.dy = dy;
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
    }

    public void startMoving() {
        this.moving = true; 
    }

    public void updatePosition() {
        if (moving) {
            x += dx;
            y += dy;

            
            if (x < 0 || x > panelWidth - width) dx = -dx;
            if (y < 0 || y > panelHeight - height) dy = -dy;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
}
