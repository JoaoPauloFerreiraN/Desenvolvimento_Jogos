package telas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.MeuJogo;

public class Menu implements Screen {
    private Stage stage;
    private Table table;
    private Skin skin;


    public Menu (){
        Texture t = new Texture("GatoMenu.jpg");


        stage = new Stage(new FitViewport(1920,1080));
        Gdx.input.setInputProcessor(stage);
        table = new Table();
        table.setFillParent(true);


        Pixmap roundedRectTexture = createRoundedRectTexture(200, 50, 20); // Largura: 200, Altura: 50, Raio do arredondamento: 20

        Texture teste = new Texture(roundedRectTexture);

        TextureRegion upRegion = new TextureRegion(teste);
        TextureRegion downRegion = new TextureRegion(teste);
        BitmapFont buttonFont = new BitmapFont(Gdx.files.internal("data/font50jogo.fnt"), Gdx.files.internal("data/font50jogo.png"),false);


        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.up = new TextureRegionDrawable(upRegion);
        style.down = new TextureRegionDrawable(downRegion);
        style.font = buttonFont;
        style.fontColor = new Color(Color.BLACK);

        TextButton newGameButton = new TextButton("Novo Jogo", style);
        newGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Primeira.ref.setScreen(new Loading());
            }
        });
        TextButton exitGameButton = new TextButton("Sair", style);
        exitGameButton.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                Gdx.app.exit();
            }
        });


        table.add(newGameButton).expand().pad(10);
        table.add(exitGameButton).expand().pad(10);
        stage.addActor(table);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
        skin.dispose();
    }
    public Pixmap createRoundedRectTexture(int width, int height, int cornerRadius) {
        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 1, 1, 1); // Cor branca
        pixmap.fillRectangle(0, cornerRadius, width, height - 2 * cornerRadius);
        pixmap.fillRectangle(cornerRadius, 0, width - 2 * cornerRadius, height);
        pixmap.fillCircle(cornerRadius, cornerRadius, cornerRadius);
        pixmap.fillCircle(width - cornerRadius, cornerRadius, cornerRadius);
        pixmap.fillCircle(cornerRadius, height - cornerRadius, cornerRadius);
        pixmap.fillCircle(width - cornerRadius, height - cornerRadius, cornerRadius);
//
//        Texture texture = new Texture(pixmap);
//        pixmap.dispose();
        return pixmap;
    }
    /*public void newGame(){
        Primeira.ref.setScreen( new MeuJogo());
    }*/
}
