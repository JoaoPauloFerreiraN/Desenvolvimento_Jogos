package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.arrow.ArrowController;
import com.mygdx.game.ballon.Ballon;
import com.mygdx.game.ballon.BallonController;
import com.mygdx.game.personagem.Personagem;

public class MeuJogo implements Screen {
	static MeuJogo ref;

	SpriteBatch batch;
	public static Personagem personagem;
	public static int score;
	public static int timer;
	public static Music music;
	public static Ballon ballon;
	public static Sound soundBallon;
	public static AssetManager manager;
	public static InputMultiplexer multiplexer;
	private OrthographicCamera camera;

	public MeuJogo(){
		Stage stage = new Stage(new FitViewport(1920, 1080));
	}



	public static void addInputProcessor(InputProcessor inputProcessor){
		if (multiplexer == null) multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(inputProcessor);
		Gdx.input.setInputProcessor(multiplexer);
	}

	@Override
	public void show () {
		if (ref == null){
			ref = this;
		}

		/*Setar Camera*/
		camera = new OrthographicCamera();
		camera.setToOrtho(false, camera.viewportWidth, camera.viewportHeight);
		//-----------------------------------

		/*Setando Assets*/
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
		personagem = new Personagem();
		ballon = new Ballon();
		//----------------------------------
		
		BallonController.init();
		ArrowController.init();
	}


	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ScreenUtils.clear(1, 0, 0, 1);
		Gdx.graphics.setTitle(Gdx.graphics.getFramesPerSecond()+"");
		batch.begin();

		personagem.draw(batch, Gdx.graphics.getDeltaTime());
		ArrowController.draw(batch, Gdx.graphics.getDeltaTime());
		BallonController.draw(batch,Gdx.graphics.getDeltaTime());
		batch.end();

		timer++;
		if (timer >= 500){
			BallonController.set((float) (Math.random() * Gdx.graphics.getWidth()), 0);
			timer = 0;
		}
		batch.setProjectionMatrix(camera.combined);
		this.update(delta);
	}

	@Override
	public void resize(int width, int height) {
		camera.setToOrtho(false, width, height);
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

	public void update(float delta){
		cameraUpdate(delta);
	}

	public void cameraUpdate(float delta){
		Vector3 position = camera.position;
		position.x = personagem.getX();
		position.y = personagem.getY();
		System.out.printf(position.x+" "+ position.y);
		camera.position.set(position);
		camera.update();
	}

}


