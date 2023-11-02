package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import telas.boladela.BoladeLa;
import telas.Primeira;

public class Loading implements Screen {
//    Stage stage;
    public static AssetManager loadAssets;
    public static BoladeLa bola;
    SpriteBatch batch;
//    ProgressBar.ProgressBarStyle loadBarStyle;
//    ProgressBar loadBar;


    public Loading(){
//        stage = new Stage();
        loadAssets = new AssetManager();
        loadAssets.load("boladeLa.png", Texture.class);
        loadAssets.finishLoading();
        batch = new SpriteBatch();
        bola = new BoladeLa();
//        loadBarStyle = new ProgressBar.ProgressBarStyle();
//        loadBar = new ProgressBar(0,100,1f,false,loadBarStyle);
//        loadBar.setSize(50,50);
//        loadBar.setValue(50);
//        stage.addActor(loadBar);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        batch.begin();
        bola.draw(batch,Gdx.graphics.getDeltaTime());
//        stage.act();
//        stage.draw();
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
//        stage.dispose();

    }
}
