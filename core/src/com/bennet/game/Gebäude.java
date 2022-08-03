package com.bennet.game;

import com.badlogic.gdx.graphics.Texture;

import static com.bennet.game.test.batch;

public class Gebäude {
    int x;
    int y;


    public Gebäude(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void Render(Texture texture,int breite,int höhe){
        batch.draw(texture,x,y,breite,höhe);
    }
    public void Render(){

    }
}


