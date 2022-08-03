package com.bennet.game;

import com.badlogic.gdx.graphics.Texture;

public class Bank extends Gebäude{
    static Texture texture = new Texture("bank.png");
    static int höhe = 64;
    static int breite = 64;
    public Bank(int x, int y) {
        super(x, y);
    }

    @Override
    public void Render(){
        super.Render(texture,höhe,breite);
    }
}
