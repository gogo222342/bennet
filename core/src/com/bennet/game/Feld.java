package com.bennet.game;

import com.badlogic.gdx.graphics.Texture;

public class Feld extends Gebäude{
    static Texture texture = new Texture("feld.jpg");
    static int höhe = 128;
    static int breite = 128;
    public Feld(int x, int y) {
        super(x, y);
    }

    @Override
    public void Render(){
        super.Render(texture,höhe,breite);
    }
}
