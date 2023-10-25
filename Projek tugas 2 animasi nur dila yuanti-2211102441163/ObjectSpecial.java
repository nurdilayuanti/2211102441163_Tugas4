import greenfoot.*;

public class ObjectSpecial extends Actor {
    private int speed = 5;
    public ObjectSpecial() {
        GreenfootImage enemyImage = new GreenfootImage("Musuh.png");
        enemyImage.scale(200, 200);
        setImage(enemyImage);
    }

    public void act() {
        moveAwayFromCharacter();
    }

    public void moveAwayFromCharacter() {
        Actor character = getOneIntersectingObject(Character.class);
        if (character != null) {
            getWorld().removeObject(this); // Hapus objek saat dimakan
            spawnNewObjectSpecial(); // Panggil metode untuk menciptakan objek baru
        }
    }

    public void spawnNewObjectSpecial() {
        // Buat objek baru dari kelas ObjectSpecial dan tambahkan ke World
        ObjectSpecial newObject = new ObjectSpecial();
        getWorld().addObject(newObject, Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
    }
}
