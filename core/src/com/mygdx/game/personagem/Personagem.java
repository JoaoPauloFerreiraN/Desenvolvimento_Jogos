package com.mygdx.game.personagem;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MeuJogo;
import com.mygdx.game.personagem.PersonagemInputProcessor;

public class Personagem  extends Sprite {
    PersonagemInputProcessor personagemInputProcessor;

    public Personagem(){
        super(MeuJogo.manager.<Texture>get("bow.png"));
        personagemInputProcessor = new PersonagemInputProcessor();
        MeuJogo.addInputProcessor(personagemInputProcessor);
    }

    public void draw(SpriteBatch batch, float delta){
        super.draw(batch);
        update(delta);
    }

    public void update(float delta){

        if (personagemInputProcessor.up){
            this.setX(this.getX() - 150*delta);
        }
        if (personagemInputProcessor.down){
            this.setX(this.getX() + 150*delta);
        }
        if (personagemInputProcessor.jump){
            float deltaY;
            this. setY(this.getY() + 550*delta);
        }
    }

}
