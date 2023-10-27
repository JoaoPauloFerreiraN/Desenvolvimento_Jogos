package telas.boladela;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MeuJogo;
import telas.Loading;
import telas.Primeira;

public class BoladeLa extends Sprite {
    public BoladeLa(){
        super(Loading.loadAssets.<Texture>get("boladeLa.png"));
    }
    public void draw(SpriteBatch batch, float delta){
        super.draw(batch);
        update(delta);
    }

    public void update(float delta){
        if (!isOutOfScreen()) {
            this.setX(this.getX() + 150 * delta);
            System.out.printf(this.getScaleX() + "  " + this.getScaleY());
            this.setScale((this.getScaleX()- ((float) 0.06*delta)),this.getScaleY()- ((float) 0.06*delta));
        }else{
            Primeira.ref.setScreen(new MeuJogo());
        }
    }
    public boolean isOutOfScreen(){
        return this.getX() > Gdx.graphics.getWidth();
    }
}
