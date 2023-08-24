package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class MeuInputProcessor implements InputProcessor {
    int posX ,posY;
    Vector2 delta = new Vector2(0,0);
    Vector2 prop = new Vector2(0,0);
    float acreX, acreY;
    boolean movimenta;
    Vector2 imgPos = new Vector2(0,0);

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.W){
            System.out.println("W");
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (Gdx.input.isTouched()){
            posX = Gdx.input.getX();
            posY = (Gdx.graphics.getHeight() - Gdx.input.getY());
        }
        delta.x = (posX - imgPos.x)/Math.abs(posX - imgPos.x);
        delta.y = (posY - imgPos.y)/Math.abs(posY - imgPos.y);
        prop.x = (posX - imgPos.x);
        prop.y = (posY - imgPos.y);
        //System.out.println(delta.x + "  " + delta.y);
        //System.out.println (prop.x + "  " + prop.y);
        if (prop.x > prop.y){
            acreX = 1;
            acreY = Math.abs(prop.y / prop.x);
        }else if (prop.x < prop.y) {
            acreY = 1;
            acreX = Math.abs(prop.x / prop.y);
        }else {
            acreY = acreX = 0;
        }

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
