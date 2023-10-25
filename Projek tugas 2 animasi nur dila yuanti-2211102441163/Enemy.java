import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Enemy extends Actor {
    public Enemy() {
        setImage("Musuh.png");
    }
 
    public void act() {
        move(10);
        if (isAtEdge()) {
            getWorld().removeObject(this);
         }
    }
}