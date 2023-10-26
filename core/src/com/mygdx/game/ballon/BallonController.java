package com.mygdx.game.ballon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MeuJogo;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BallonController {
    private static ConcurrentLinkedQueue<Ballon> aliveBallons;
    private static ConcurrentLinkedQueue<Ballon> deadBallons;
    private static double timer;

    public static void init(){
        aliveBallons = new ConcurrentLinkedQueue<Ballon>();
        deadBallons = new ConcurrentLinkedQueue<Ballon>();
        Ballon b = new Ballon();
        aliveBallons.add(b);
    }

    public static void set(float x, float y){
        Ballon b;
        if (!deadBallons.isEmpty()){
            b = deadBallons.remove();
        }else {
            b = new Ballon();
        }
        aliveBallons.add(b);
        b.setX(x);
        b.setY(y);
    }

    public static void draw(SpriteBatch batch, float delta){
        if (timer >= 5){
            timer -= 5;
        }
        timer = Gdx.graphics.getDeltaTime();

        BallonController.set(2000, 0);
        for (Ballon b : aliveBallons){
            b.draw(batch);
            b.update(delta);

            if(b.isOutOfScreen()){
                aliveBallons.remove(b);
                deadBallons.add(b);
            }
            if(b.colidiu()){
                aliveBallons.remove(b);
                deadBallons.add(b);
                MeuJogo.score++;
                System.out.printf("Score: " + MeuJogo.score + "\n");
            }
        }
    }


}
