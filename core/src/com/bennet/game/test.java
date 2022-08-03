package com.bennet.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Vector;

public class test extends ApplicationAdapter {
	public static SpriteBatch batch;
	Texture img;
	Texture gras;
	OrthographicCamera Kamera;
	ArrayList<Gebäude> GebäudeListe = new ArrayList<>();
	Class[] liste = {Bank.class,Feld.class};
	int ausgewählt  = 0;
	@Override
	public void create () {
		batch = new SpriteBatch();
		Kamera = new OrthographicCamera(1280, 768);
		gras = new Texture("gras.png");

	}


	@Override
	public void render () {
		batch.setProjectionMatrix(Kamera.combined);
		if (Gdx.input.isButtonJustPressed(Input.Buttons.FORWARD)){
			ausgewählt++;
			if (ausgewählt == 2){
				ausgewählt = 0;
			}

		}
		if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
			Vector3 maus = Kamera.unproject(new Vector3(Gdx.input.getX(),Gdx.input.getY(),0));
			try {
				GebäudeListe.add((Gebäude) liste[ausgewählt].getConstructor(int.class,int.class).newInstance((int)maus.x,(int)maus.y));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			Kamera.position.y+= Gdx.graphics.getDeltaTime()*200;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)){
			Kamera.position.y-= Gdx.graphics.getDeltaTime()*200;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)){
			Kamera.position.x-= Gdx.graphics.getDeltaTime()*200;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			Kamera.position.x+= Gdx.graphics.getDeltaTime()*200;
		}
		Kamera.update();
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.gl.glClearColor(0, 0, 0, 1); // Clear the screen with black
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Clear the screen

		batch.enableBlending(); // Enable alpha
		batch.begin();
		for (int y = 0;y<100;y++) {
			for (int x = 0; x < 100; x++) {
				batch.draw(gras, x * 64, y*64, 64, 64);
			}
		}
		for(Gebäude gebäude: GebäudeListe){
			gebäude.Render();
		}
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}


