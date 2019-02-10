package com.mygdx.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.awt.*;


public class Enemy {
    Sound die= Gdx.audio.newSound(Gdx.files.internal("Assets/Sound/kill.mp3"));
    Sound bomb=Gdx.audio.newSound(Gdx.files.internal("Assets/Sound/kill2.mp3"));
    private Sprite sprite;
    private Texture blueship;
    private Texture yellowship;
    private Texture redship;
    private boolean dead = false;
    private Rectangle rect;
    private int speed = 1;
    private int pointValue;
    //initialization code


    public Enemy(String type, int x, int y) {
        blueship = new Texture("Assets/Enemies/2.png");
        redship = new Texture("Assets/Enemies/0.png");
        yellowship = new Texture("Assets/Enemies/1.png");

        if (type.equals("yellow")) {
            sprite = new Sprite(yellowship);
            pointValue = 20;
        } else if (type.equals("red")) {
            sprite = new Sprite(redship);
            pointValue = 40;
        } else if (type.equals("blue")) {
            sprite = new Sprite(blueship);
            pointValue = 10;
        }
        sprite.setX(50 + x * 100);
        sprite.setY(Main.HEIGHT - 200 - (75 * y));
        rect = new Rectangle((int) sprite.getX(), (int) sprite.getY(), (int) sprite.getWidth(), (int) sprite.getHeight());
    }


    public void render(SpriteBatch batch) {
        rect = new Rectangle((int) sprite.getX(), (int) sprite.getY(), (int) sprite.getWidth(), (int) sprite.getHeight());
        sprite.draw(batch);
    }

    public void update(SpriteBatch batch) {
        if (this.isDead()) {
            sprite.setAlpha(0);
        }
        sprite.setX(sprite.getX() + speed);
        this.render(batch);
    }

    public boolean isCollidingWith(Bullet bullet) {
        die.play();
        return bullet.getRect().intersects(this.getRect()) && !this.isDead();
    }

    public boolean isCollidingWith(SpiritBomb spiritBomb) {
        bomb.play();
        return spiritBomb.getRect().intersects(this.getRect()) && !this.isDead();
    }

    public Rectangle getRect() {
        return rect;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void inverseSpeed(){
        speed *= -1;
    }

    public void setY(int y){
        sprite.setY(y);
    }

    public int getPointValue() {
        return pointValue;
    }
}

