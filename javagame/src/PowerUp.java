import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;

public class PowerUp {
    private int x, y;
    private int size = 30; 
    private boolean collected;
    private String type; 

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.collected = false;
    }

    public void draw(Graphics g) {
        if (!collected) {
            
            if ("speed".equals(type)) {
                g.setColor(Color.YELLOW); 
            } else if ("shield".equals(type)) {
                g.setColor(Color.CYAN); 
            } else {
                g.setColor(Color.GRAY); 
            }
            
            g.fillOval(x, y, size, size); 

            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 18)); 

            
            FontMetrics metrics = g.getFontMetrics(g.getFont());

            
            String text = type.substring(0, 1).toUpperCase();
            int textWidth = metrics.stringWidth(text);
            int textHeight = metrics.getAscent();

            int textX = x + (size - textWidth) / 2;
            int textY = y + (size + textHeight) / 2 - metrics.getDescent();

            
            g.drawString(text, textX, textY);
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

    public String getType() {
        return type;
    }
}
