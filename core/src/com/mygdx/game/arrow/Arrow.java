package com.mygdx.game.arrow;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.game.MeuJogo;

public class Arrow extends Sprite {

    public Arrow(){
        super((Texture) MeuJogo.manager.get("arrow.png"));
    }

    public void update(float delta){
        this.setX(this.getX() + 150*delta);
    }

    public boolean isOutOfScreen(){
        return this.getX() > Gdx.graphics.getWidth();
    }

}
