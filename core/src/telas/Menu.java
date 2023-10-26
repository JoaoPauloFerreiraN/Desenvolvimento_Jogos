package telas;

import com.badlogic.gdx.Screen;
import com.mygdx.game.MeuJogo;

public class Menu implements Screen {
    static Menu ref;

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        this.newGame();

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

    }

    public void newGame(){
        Primeira.ref.setScreen( new MeuJogo());
    }
}
