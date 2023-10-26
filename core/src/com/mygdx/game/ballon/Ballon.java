package com.mygdx.game.ballon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MeuJogo;
import com.mygdx.game.arrow.Arrow;
import com.mygdx.game.arrow.ArrowController;

import static com.mygdx.game.MeuJogo.soundBallon;

public class Ballon extends Sprite {
    BallonInputProcessor ballonInputProcessor;

    public Ballon(){
        super((Texture) MeuJogo.manager.get("chicken.png"));
        ballonInputProcessor = new BallonInputProcessor();
        MeuJogo.addInputProcessor(ballonInputProcessor);
    }

//    public void draw(SpriteBatch batch, float delta){
//        super.draw(batch);
//        update(delta);
//    }

    public void update(float delta){
        this.setY(this.getY()+250*delta);

    }

    public boolean isOutOfScreen(){
        return this.getY() > Gdx.graphics.getHeight();
    }

    public boolean colidiu(){
        Vector2 tiroHBox = new Vector2(0,0);
        for(Arrow a : ArrowController.aliveArrows){
            tiroHBox.set(a.getX() + a.getWidth(), a.getY() + a.getHeight());
            if (tiroHBox.x >= this.getX() && tiroHBox.x <= this.getX() + this.getWidth() && tiroHBox.y >= this.getY() && tiroHBox.y <= this.getY() + this.getHeight()) {
                soundBallon.play(1.0f);
                ArrowController.aliveArrows.remove(a);
                ArrowController.deadArrows.add(a);
                return true;
            }
        }
        return false;
    }
}

