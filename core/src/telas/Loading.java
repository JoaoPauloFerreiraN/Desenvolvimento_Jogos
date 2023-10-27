package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import telas.boladela.BoladeLa;
import telas.Primeira;

public class Loading implements Screen {

    public static AssetManager loadAssets;
    public static BoladeLa bola;
    SpriteBatch batch;



    public Loading(){
        loadAssets = new AssetManager();
        loadAssets.load("boladeLa.png", Texture.class);
        loadAssets.finishLoading();
        batch = new SpriteBatch();
        bola = new BoladeLa();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        bola.draw(batch,Gdx.graphics.getDeltaTime());
        batch.end();
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
    public void dispose() {
        batch.dispose();

    }
}
