package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class Meu_jogo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("idle.gif");
	}
	int posX ,posY;
	Vector2 imgPos = new Vector2(0,0);
	Vector2 delta = new Vector2(0,0);
	Vector2 prop = new Vector2(0,0);
	float acreX, acreY;
	@Override
	public void render () {
		if (Gdx.input.isTouched()){
			posX = Gdx.input.getX();
			posY = (Gdx.graphics.getHeight() - Gdx.input.getY());
			//System.out.println (posX + "  " + posY);
		}
		delta.x = (posX - imgPos.x)/Math.abs(posX - imgPos.x);
		delta.y = (posY - imgPos.y)/Math.abs(posY - imgPos.y);
		prop.x = (posX - imgPos.x);
		prop.y = (posY - imgPos.y);
		System.out.println(delta.x + "  " + delta.y);
		System.out.println (prop.x + "  " + prop.y);

		if (prop.x > prop.y){
			acreX = 1;
			acreY = Math.abs(prop.y / prop.x);
		}else if (prop.x < prop.y) {
			acreY = 1;
			acreX = Math.abs(prop.x / prop.y);
		}else {
			acreY = acreX = 0;
		}


		if (delta.x > 0){
			imgPos.x += acreX;
		} else if (delta.x  < 0) {
			imgPos.x -= acreX;
		} else {
			acreX = 0 ;
		}

		if (delta.y > 0){
			imgPos.y += acreY;
		}else if (delta.y < 0){
			imgPos.y -= acreY;
		} else {
			acreY = 0 ;
		}

		/*if (imgPos.x == posX && imgPos.y == posY ){

			batch.draw(img, posX, posY);
		}*/




		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, imgPos.x, imgPos.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}


/*if ((posX - imgPos.x) > 0){
			imgPos.x += 1;
			System.out.println("Posi x Relativa : " +((posX - imgPos.x)/Gdx.graphics.getWidth()) );
		} else if ((posX - imgPos.x) < 0) {
			imgPos.x -= 1;
			System.out.println("Posi x Relativa : " +((posX - imgPos.x)/Gdx.graphics.getWidth()) );
		}
		if ((posY - imgPos.y) > 0){
			imgPos.y += 1;
			System.out.println("Posi y Relativa : " +((posY - imgPos.y)/Gdx.graphics.getWidth()) );
		} else if ((posY - imgPos.y) < 0) {
			imgPos.y -= 1;
			System.out.println("Posi y Relativa : " +((posY - imgPos.y)/Gdx.graphics.getWidth()) );
		}*/
