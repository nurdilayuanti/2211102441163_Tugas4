import greenfoot.*;

public class Character extends Actor {
    private int score = 0;
    private int lives = 3; // Jumlah nyawa karakter
    private int speed = 2; // Kecepatan karakter
    private GreenfootImage[] characterImages;
    private int animationIndex = 0;
    private boolean gameOver = false; // Menandai apakah permainan berakhir

    public Character() {
        GreenfootImage characterImage = new GreenfootImage("images/Attacking/Golem_01.png");
        characterImage.scale(200, 200);
        setImage(characterImage);
    }

    public void act() {
        if (!gameOver) {
            moveCharacter();
            checkForCollision();
            checkGameOver();
        }
    }

    public void checkForCollision() {
        Actor object = getOneIntersectingObject(ObjectSpecial.class);
        if (object != null) {
            increaseScore();
            getWorld().removeObject(object);
        }

        Actor enemy = getOneIntersectingObject(Enemy.class);
        if (enemy != null) {
            loseLife();
            getWorld().removeObject(enemy);
        }
    }

    public void moveCharacter() {
        if (Greenfoot.isKeyDown("left") && getX() > 0) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("right") && getX() < getWorld().getWidth()) {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("up") && getY() > 0) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("down") && getY() < getWorld().getHeight()) {
            setLocation(getX(), getY() + speed);
        }
    }

    public void increaseScore() {
        score += 10;
        getWorld().showText("Score: " + score, 50, 25);
    }

    public void loseLife() {
        lives--;
        getWorld().showText("Lives: " + lives, 50, 50);
        if (lives <= 0) {
            gameOver = true; // Menandai bahwa permainan berakhir
            World world = getWorld();
            world.showText("Game Over - You Lose!", world.getWidth() / 2, world.getHeight() / 2);
            Greenfoot.stop();
        }
    }

    public void checkGameOver() {
        if (score >= 100) {
            gameOver = true; // Menandai bahwa permainan berakhir
            getWorld().showText("Game Over - You Win!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            Greenfoot.stop();
        }
    }
}
