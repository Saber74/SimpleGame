package com.mygdx.game.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    //stores x loc (start at 240)
    private int x = 240;
    //stores y loc (start at 167)
    private int y = 167;
    //texture for our character
    public Texture player_img = new Texture("Assets/SPRITES/Megaman/0.png");
    //speed for our character in pixels/s

    private String name;

    //defining constants for direction
    static final int LEFT = -1;
    static final int RIGHT = 1;
    static final int STANDING = 0;
    int direction = LEFT;

    //initialization code
    public Player(String name){
        this.name = name;
//        Main.acr.add(this);
        Main.players.add(this);
    }

    //updates character's position
    public void render(){
        Main.batch.draw(player_img, x, y, player_img.getWidth() * 2, player_img.getHeight() * 2);

    }

    public void update(int direction){
        if (direction == RIGHT){
            x += 10;
        }else if (direction == LEFT){
            x -= 10;
        }
    }

    //changes the character direction to right
    public void goRight(){
        direction = RIGHT;
    }

    //changes character direction to left
    public void goLeft(){
        direction = LEFT;
    }

    //changes character direction to standing
    public void setStanding(){
        direction = STANDING;
    }

    public String getName() {
        return name;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getDirection(){
        return direction;
    }
}

