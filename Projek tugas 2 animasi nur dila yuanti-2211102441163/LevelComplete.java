import greenfoot.*;

public class LevelComplete extends Actor {
    private boolean gameComplete = false; // Menandai apakah permainan telah selesai
    private int objectSpecialCount = 0; // Menandai jumlah ObjectSpecial yang telah dimakan
    private int score = 0; // Skor pemain

    public LevelComplete(int level) {
        setImage("level" + level + "level1.JPEG");
    }

    public void act() {
        if (!gameComplete) {
            checkCharacterCollision();
        }
    }

    public void checkCharacterCollision() {
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null) {
            objectSpecialCount++; // Tambahkan jumlah ObjectSpecial yang telah dimakan
            score += 10; // Tambahkan skor saat karakter memakan ObjectSpecial
            getWorld().showText("Score: " + score, 50, 25); // Tampilkan skor di layar
            if (objectSpecialCount >= 10) {
                gameComplete = true; // Menandai bahwa permainan telah selesai
                getWorld().showText("Level Complete!", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
                Greenfoot.stop();
            }
        }
    }
}
