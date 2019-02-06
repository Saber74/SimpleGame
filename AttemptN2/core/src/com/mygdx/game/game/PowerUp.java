package com.mygdx.game.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.Random;

public class PowerUp {
    private int x, y, type, fallSpeed, width, height;
    private final static int SPIRITBOMB = 0;
    private final static int INVINCIBLE = 1;
    private static final int MIRROR=2;
    private Random rand = new Random();
    private Texture powerup_sprite;
    private Sprite powerup;

    Rectangle rect;

    public PowerUp() {
        Texture[] powerups = {new Texture("Assets/spiritBomb.png"), new Texture("Assets/invincible.png"), new Texture("Assets/Mirror.png")};
        type = rand.nextInt(powerups.length);
        powerup_sprite = powerups[type];
        powerup = new Sprite(powerup_sprite);
        fallSpeed = rand.nextInt(5) + 1;
        x = rand.nextInt(Main.WIDTH - powerup_sprite.getWidth());
        y = Main.HEIGHT;
        powerup.setX((float) x);
        powerup.setY((float) y);
        rect = new Rectangle((int) powerup.getX(), (int) powerup.getY(), (int) powerup.getWidth(), (int) powerup.getHeight());
    }

//    private void powerupON(){//upon collecting the powerup this is called
//        if(powerType==mirror){
//            mirror_sprite=new Texture("Assets/Mirror/0.png");
//        }

//    }
    public void render(SpriteBatch batch) {
        powerup.draw(batch);
}

    public void update(SpriteBatch batch) {
        powerup.setY(powerup.getY() - fallSpeed);
        rect = new Rectangle((int) powerup.getX(), (int) powerup.getY(), (int) powerup.getWidth(), (int) powerup.getHeight());
        this.render(batch);
    }

    public Rectangle getRect() {
        return rect;
    }

    public int getType() {
        return type;
    }
    private void powerupActivate(){
        if(type==SPIRITBOMB){
            //BOOOOOM
            System.out.println("booooooooooom");
        }
        else if(type==INVINCIBLE){
            System.out.println("can't kill me ");
        }
//        else if(type==MIRROR){
//            Mirror block =new Mirror();
//        }
    }

}
