import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;


public class Game extends JPanel implements Runnable, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private Thread gameThread;
    private boolean running;
    private boolean gameOver;
    private boolean gameWin;
    private Player player;
    private List<GameObjects> objects;
    private List<Coin> coins;
    private List<PowerUp> powerUps;
    private int score;
    private int level;
    private boolean levelComplete;
    private JButton restartButton;
    private Timer delayTimer;

    public Game() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(null); 
        player = new Player(100, 100);
        objects = new ArrayList<>();
        coins = new ArrayList<>();
        powerUps = new ArrayList<>();
        level = 1;
        score = 0;
        levelComplete = false;
        gameOver = false;
        gameWin = false;
        initLevel();

        
        restartButton = new JButton("Restart");
        restartButton.setBounds(350, 400, 100, 50); 
        restartButton.setFont(new Font("SourceSans", Font.BOLD, 20));
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartGame();
            }
        });
        add(restartButton);
        restartButton.setVisible(false); 

        addKeyListener(this);
        setFocusable(true);
    }

    private void startMovingObjectsDelay() {
        if (delayTimer != null) {
            delayTimer.stop(); 
        }

        
        delayTimer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (GameObjects obj : objects) {
                    if (obj instanceof MovingObject) {
                        ((MovingObject) obj).startMoving(); 
                    }
                }
                delayTimer.stop(); 
            }
        });

        delayTimer.setRepeats(false); 
        delayTimer.start(); 
    }

    private void initLevel() {
        objects.clear();
        coins.clear();
        powerUps.clear();
        
        if (level == 1) {
            
            objects.add(new GameObjects(300, 300, 50, 50, Color.GREEN, true));
            objects.add(new GameObjects(200, 200, 60, 20, Color.RED, false));
            objects.add(new GameObjects(400, 400, 60, 20, Color.RED, false));
            coins.add(new Coin(150, 150)); 
            coins.add(new Coin(500, 500)); 
            powerUps.add(new PowerUp(350, 350, "speed")); 
        } else if (level == 2) {
            
            objects.add(new GameObjects(500, 300, 50, 50, Color.GREEN, true));
            objects.add(new GameObjects(200, 200, 60, 20, Color.RED, false));
            objects.add(new GameObjects(400, 250, 60, 20, Color.RED, false));
            objects.add(new GameObjects(300, 400, 60, 20, Color.RED, false));
            coins.add(new Coin(100, 100)); 
            coins.add(new Coin(600, 500)); 
            powerUps.add(new PowerUp(250, 250, "shield")); 
        } else if (level == 3) {
            
            objects.add(new GameObjects(400, 300, 50, 50, Color.GREEN, true));
            objects.add(new GameObjects(100, 100, 80, 20, Color.RED, false));
            objects.add(new GameObjects(300, 150, 80, 20, Color.RED, false));
            objects.add(new GameObjects(500, 300, 80, 20, Color.RED, false));
            objects.add(new GameObjects(200, 400, 80, 20, Color.RED, false));
            objects.add(new GameObjects(400, 500, 80, 20, Color.RED, false));
            coins.add(new Coin(200, 200)); 
            coins.add(new Coin(600, 400)); 
            coins.add(new Coin(300, 100)); 
            powerUps.add(new PowerUp(450, 450, "speed")); 
        } else if (level == 4) {
            
            objects.add(new GameObjects(300, 300, 50, 50, Color.GREEN, true));
            objects.add(new MovingObject(100, 100, 60, 20, Color.RED, 2, 2, WIDTH, HEIGHT));
            objects.add(new MovingObject(500, 200, 60, 20, Color.RED, -2, -2, WIDTH, HEIGHT));
            objects.add(new GameObjects(200, 200, 60, 20, Color.RED, false));
            objects.add(new GameObjects(400, 300, 60, 20, Color.RED, false));
            coins.add(new Coin(150, 150)); 
            coins.add(new Coin(500, 500)); 
            powerUps.add(new PowerUp(350, 250, "shield")); 
        } else if (level == 5) {
            
            objects.add(new GameObjects(400, 400, 50, 50, Color.GREEN, true));
            objects.add(new GameObjects(200, 100, 100, 20, Color.RED, false));
            objects.add(new GameObjects(500, 200, 20, 100, Color.RED, false));
            objects.add(new MovingObject(150, 150, 60, 20, Color.RED, 3, 3, WIDTH, HEIGHT));
            objects.add(new MovingObject(400, 400, 20, 60, Color.RED, -3, -3, WIDTH, HEIGHT));
            objects.add(new MovingObject(300, 300, 100, 20, Color.RED, 2, -2, WIDTH, HEIGHT));
            coins.add(new Coin(100, 200)); 
            coins.add(new Coin(600, 400)); 
            coins.add(new Coin(300, 500)); 
            powerUps.add(new PowerUp(300, 300, "speed")); 
        }
        else if (level == 6) {
            
            objects.add(new GameObjects(300, 200, 60, 60, Color.GREEN, true)); 
            objects.add(new MovingObject(100, 100, 60, 20, Color.RED, 3, 3, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(500, 300, 60, 20, Color.RED, -3, -3, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(400, 200, 60, 20, Color.RED, 5, -5, WIDTH, HEIGHT)); 
            objects.add(new GameObjects(200, 300, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(600, 100, 80, 20, Color.RED, false)); 
            coins.add(new Coin(200, 200)); 
            coins.add(new Coin(500, 400)); 
            powerUps.add(new PowerUp(350, 250, "speed")); 
            powerUps.add(new PowerUp(450, 350, "shield")); 
        }
        else if (level == 7) {
            
            objects.add(new GameObjects(400, 300, 60, 60, Color.GREEN, true)); 
            objects.add(new MovingObject(200, 200, 60, 20, Color.RED, 4, 4, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(500, 400, 60, 20, Color.RED, -4, -4, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(300, 100, 60, 20, Color.RED, 4, -4, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(600, 500, 60, 20, Color.RED, -4, 4, WIDTH, HEIGHT)); 
            objects.add(new GameObjects(300, 300, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(500, 100, 80, 20, Color.RED, false)); 
            coins.add(new Coin(150, 150)); 
            coins.add(new Coin(550, 200)); 
            coins.add(new Coin(400, 450)); 
            powerUps.add(new PowerUp(200, 250, "speed")); 
            powerUps.add(new PowerUp(600, 400, "shield")); 
        }
        else if (level == 8) {
            
            objects.add(new GameObjects(500, 400, 60, 60, Color.GREEN, true)); 
            objects.add(new MovingObject(100, 100, 60, 20, Color.RED, 6, 6, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(300, 300, 60, 20, Color.RED, -6, -6, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(500, 200, 60, 20, Color.RED, 6, -6, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(200, 500, 60, 20, Color.RED, -6, 6, WIDTH, HEIGHT)); 
            objects.add(new GameObjects(150, 300, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(450, 100, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(600, 300, 80, 20, Color.RED, false)); 
            coins.add(new Coin(200, 200)); 
            coins.add(new Coin(500, 100)); 
            coins.add(new Coin(300, 450)); 
            powerUps.add(new PowerUp(400, 300, "speed")); 
            powerUps.add(new PowerUp(600, 200, "shield")); 
        }
        else if (level == 9) {
            
            objects.add(new GameObjects(200, 200, 60, 60, Color.GREEN, true)); 
            objects.add(new MovingObject(100, 100, 60, 20, Color.RED, 7, 7, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(400, 400, 60, 20, Color.RED, -7, -7, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(600, 200, 60, 20, Color.RED, 7, -7, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(300, 500, 60, 20, Color.RED, -7, 7, WIDTH, HEIGHT)); 
            objects.add(new GameObjects(200, 300, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(500, 150, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(600, 400, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(300, 100, 80, 20, Color.RED, false)); 
            coins.add(new Coin(150, 150)); 
            coins.add(new Coin(500, 200)); 
            coins.add(new Coin(350, 450)); 
            powerUps.add(new PowerUp(300, 250, "speed")); 
            powerUps.add(new PowerUp(600, 350, "shield")); 
        }
        else if (level == 10) {
            
            objects.add(new GameObjects(400, 300, 60, 60, Color.GREEN, true)); 
            objects.add(new MovingObject(100, 100, 60, 20, Color.RED, 8, 8, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(500, 100, 60, 20, Color.RED, -8, -8, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(300, 500, 60, 20, Color.RED, 8, -8, WIDTH, HEIGHT)); 
            objects.add(new MovingObject(600, 300, 60, 20, Color.RED, -8, 8, WIDTH, HEIGHT)); 
            objects.add(new GameObjects(200, 200, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(400, 400, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(600, 100, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(300, 300, 80, 20, Color.RED, false)); 
            objects.add(new GameObjects(500, 300, 80, 20, Color.RED, false)); 
            coins.add(new Coin(100, 150)); 
            coins.add(new Coin(550, 200)); 
            coins.add(new Coin(400, 450)); 
            coins.add(new Coin(300, 100)); 
            powerUps.add(new PowerUp(200, 200, "speed")); 
            powerUps.add(new PowerUp(600, 400, "shield")); 
            powerUps.add(new PowerUp(400, 200, "speed")); 
            powerUps.add(new PowerUp(500, 500, "shield")); 
        }
                                         

        
        placePlayerAtSafePosition();
        startMovingObjectsDelay();

    }

    private void placePlayerAtSafePosition() {
        int startX = 100;
        int startY = 100;
        boolean positionSafe = false;

        while (!positionSafe) {
            positionSafe = true;
            
            for (GameObjects obj : objects) {
                if (playerCollidesWith(obj, startX, startY)) {
                    positionSafe = false;
                    
                    startX += 50; 
                    startY += 50; 
                    break;
                }
            }
            
            for (Coin coin : coins) {
                if (playerCollidesWith(coin, startX, startY)) {
                    positionSafe = false;
                    
                    startX += 50; 
                    startY += 50; 
                    break;
                }
            }
        }
        player.setX(startX);
        player.setY(startY);
    }

    private boolean playerCollidesWith(GameObjects obj, int x, int y) {
        return (x < obj.getX() + obj.getWidth() &&
                x + player.getSize() > obj.getX() &&
                y < obj.getY() + obj.getHeight() &&
                y + player.getSize() > obj.getY());
    }

    private boolean playerCollidesWith(Coin coin, int x, int y) {
        return (x < coin.getX() + coin.getSize() &&
                x + player.getSize() > coin.getX() &&
                y < coin.getY() + coin.getSize() &&
                y + player.getSize() > coin.getY());
    }

    private void restartGame() {
        score = 0;
        level = 1;
        levelComplete = false;
        gameOver = false;
        player.setX(100); 
        player.setY(100); 
        player.setSpeed(20); 
        player.setShieldActive(false); 
        player.setSpeedBoostActive(false);
        initLevel();
        restartButton.setVisible(false);
        if (gameThread == null || !gameThread.isAlive()) {
            running = true; 
            gameThread = new Thread(this);
            gameThread.start();
        }
        repaint(); 
    }

    @Override
    public void addNotify() {
        super.addNotify();
        if (gameThread == null) {
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            if (!gameOver && !gameWin) {
                update();
                repaint();
                try {
                    Thread.sleep(16); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void update() {
        if (levelComplete) {
            if (level < 10) {
                level++;
                initLevel();
                player.resetSpeed(); 
                player.setSpeedBoostActive(false); 
                player.setShieldActive(false); 
                levelComplete = false;
            } else {
                System.out.println("You win!");
                gameWin = true;
                running = false; 
                return;
            }
        }
    
        player.update();
        for (GameObjects obj : objects) {
            if (obj instanceof MovingObject) {
                ((MovingObject) obj).updatePosition(); 
            }
            if (player.collidesWith(obj)) {
                if (obj.isObjective()) {
                    levelComplete = true;
                } else {
                    if (!player.isShieldActive()) {
                    System.out.println("Collision with obstacle!");
                    player.setShieldActive(false);
                    gameOver = true;
                    running = false; 
                    restartButton.setVisible(true); 
                    } else {
                        placePlayerAtSafePosition();
                        player.setShieldActive(false);
                    }
                }
            }
        }
    
        
        for (Coin coin : coins) {
            if (coin.collidesWith(player)) {
                if (!coin.isCollected()) {
                    coin.collect();
                    score += 10; 
                    System.out.println("Coin collected! Score: " + score);
                }
            }
        }
    
        
        for (PowerUp powerUp : powerUps) {
            if (powerUp.collidesWith(player)) {
                if (!powerUp.isCollected()) {
                    powerUp.collect();
                    applyPowerUp(powerUp);
                    System.out.println("Power-up collected: " + powerUp.getType());
                }
            }
        }
    }
    
    
    

    private void applyPowerUp(PowerUp powerUp) {
        if (powerUp.getType().equals("speed")) {
            
            player.setSpeed(player.getSpeed() + 20); 
            player.setSpeedBoostActive(true);
        } else if (powerUp.getType().equals("shield")) {
            
            player.setShieldActive(true); 
        }
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT); 
            g.setColor(Color.RED);
            g.setFont(new Font("SourceSans", Font.BOLD, 60));
            g.drawString("GAME OVER", WIDTH / 4, HEIGHT / 2 - 30);
            restartButton.setVisible(true);
            g.setFont(new Font("SourceSans", Font.BOLD, 30));
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 50, 60); 
            g.drawString("Level: " + level, 600, 60); 
        } 

        else if (gameWin) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT); 
            g.setColor(Color.YELLOW);
            g.setFont(new Font("SourceSans", Font.BOLD, 60));
            g.drawString("YOU WIN!", WIDTH / 4, HEIGHT / 2 - 30);
            g.setFont(new Font("SourceSans", Font.BOLD, 30));
            g.setColor(Color.WHITE);
            g.drawString("Score: " + score, 50, 60); 
            g.drawString("Level: " + level, 600, 60); 
        }
        
        else {
            
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            player.draw(g);
            for (GameObjects obj : objects) {
                obj.draw(g);
            }
            for (Coin coin : coins) {
                coin.draw(g);
            }
            for (PowerUp powerUp : powerUps) {
                powerUp.draw(g);
            }
            if (!levelComplete) {
                g.setColor(Color.WHITE);
                g.setFont(new Font("SourceSans", Font.BOLD, 20));
                g.drawString("Score: " + score, 10, 20);
                g.drawString("Level: " + level, WIDTH - 100, 20);
                
                
                if (player.isSpeedBoostActive()) {
                    g.setColor(Color.YELLOW);
                    g.drawString("Speed Boost Active", 10, HEIGHT - 40);
                }
                if (player.isShieldActive()) {
                    g.setColor(Color.CYAN);
                    g.drawString("Shield Active", 10, HEIGHT - 20);
                }
            }
        }
    }
    


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            if (player.getX() > 0) {
                player.setX(player.getX() - player.getSpeed());
            }
        } else if (key == KeyEvent.VK_RIGHT) {
            if (player.getX() < WIDTH - player.getSize()) {
                player.setX(player.getX() + player.getSpeed());
            }
        } else if (key == KeyEvent.VK_UP) {
            if (player.getY() > 0) {
                player.setY(player.getY() - player.getSpeed());
            }
        } else if (key == KeyEvent.VK_DOWN) {
            if (player.getY() < HEIGHT - player.getSize()) {
                player.setY(player.getY() + player.getSpeed());
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }
}
