package telas;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;


public class Primeira extends Game{

    static Primeira ref;

    @Override
    public void create() {
        if (ref==null) {
            ref = this;
        }
        this.setScreen(Menu.ref);
    }

    public void render(){
        super.render();
    }
}

