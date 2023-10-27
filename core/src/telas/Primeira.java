package telas;
//import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.mygdx.game.MeuJogo;


public class Primeira extends Game{

    public static Primeira ref;

    @Override
    public void create() {
        if (ref==null) {
            ref = this;
        }
        this.setScreen(new Menu());
    }

    public void render(){
        super.render();
    }
}

