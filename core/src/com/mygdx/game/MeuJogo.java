package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.arrow.ArrowController;
import com.mygdx.game.ballon.Ballon;
import com.mygdx.game.ballon.BallonController;
import com.mygdx.game.bow.Bow;



public class MeuJogo implements Screen {
	static MeuJogo ref;

	SpriteBatch batch;
	public static Bow bow;
	public static int score;
	public static int timer;
	public static Music music;
	public static Ballon ballon;
	public static Sound soundBallon;
	public static AssetManager manager;
	public static InputMultiplexer multiplexer;

	public static void addInputProcessor(InputProcessor inputProcessor){
		if (multiplexer == null) multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);
	}

	public void create () {
		if (ref == null){
			ref = this;
		}
		timer = 0;
		score = 0;
		batch = new SpriteBatch();
		manager = new AssetManager();
		manager.load("bow.png", Texture.class);
		manager.load("arrow.png", Texture.class);
		manager.load("chicken.png", Texture.class);
		manager.load("sons/sons/GameBGM.mp3", Music.class);
		manager.load("sons/sons/LANG_JPN_0017.wav",Sound.class);
		manager.finishLoading();//trava o jogo
		music = manager.get("sons/sons/GameBGM.mp3", Music.class);
		soundBallon = manager.get("sons/sons/LANG_JPN_0017.wav", Sound.class);
		music.play();
		bow = new Bow();
		ballon = new Ballon();
		BallonController.init();
		ArrowController.init();
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond()+"");
		batch.begin();

		bow.draw(batch, Gdx.graphics.getDeltaTime());
		ArrowController.draw(batch, Gdx.graphics.getDeltaTime());
		BallonController.draw(batch,Gdx.graphics.getDeltaTime());
		batch.end();

		timer++;
		if (timer >= 500){
			BallonController.set((float) (Math.random() * Gdx.graphics.getWidth()), 0);
			timer = 0;
		}

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}


