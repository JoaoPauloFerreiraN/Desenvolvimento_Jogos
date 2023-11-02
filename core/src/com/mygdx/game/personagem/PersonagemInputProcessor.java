package com.mygdx.game.personagem;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class PersonagemInputProcessor implements InputProcessor {
    boolean up, down, jump;

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.A){
            up = true;
        }
        if (keycode == Input.Keys.D){
            down = true;
        }
        if (keycode == Input.Keys.SPACE) {
            jump = true;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.A) {
            up = false;
        }
        if (keycode == Input.Keys.D) {
            down = false;
        }
        if (keycode == Input.Keys.SPACE) {
            jump = false;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }
}
