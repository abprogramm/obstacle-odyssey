import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame("Obstacle Odyssey");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setContentPane(new Game());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
