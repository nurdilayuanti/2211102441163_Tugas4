import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World {
    private int currentLevel = 1;
    private int score = 0; //Mendeklarasikan variabel Score

    public MyWorld() {
        super(600, 600, 1);
        prepare();
     }
 
    public void act() {
        // Periksa apakah level selesai
        if (getObjects(ObjectSpecial.class).isEmpty()) {
            if (currentLevel < 3) { // Ganti angka ini sesuai jumlah level
                currentLevel++;
                addObject(new LevelComplete(currentLevel), getWidth() / 2, getHeight() / 2);
                Greenfoot.delay(100);
                nextLevel();
            } else {
                showText("Game Over - You Win!", getWidth() / 2, getHeight() / 2);
                Greenfoot.stop();
            }
        }
    }
    
    public void prepare() {
        // Tambahkan inisialisasi objek dan karakter utama untuk level pertama di sini
        addObject(new Character(), getWidth() / 2, getHeight() - 30);
        addObject(new ObjectSpecial(),
        Greenfoot.getRandomNumber(getWidth()),
        Greenfoot.getRandomNumber(getHeight()));
    }
    
    public void nextLevel() {
        //Fungsi ini akan mempersiapkan level selanjutnya
        removeObjects(getObjects(ObjectSpecial.class));
        removeObjects(getObjects(LevelComplete.class));
        prepare();
    }
    
    public void checkGameOver() {
        if (score >= 100) { // Ubah nilai sesuai dengan skor maksimal
            showText("Game Over - You Win!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
        
        if (getObjects(Character.class).isEmpty()) {
            showText("Game Over - You Lose!", getWidth() / 2, getHeight() / 2);
            Greenfoot.stop();
        }
    }
}

