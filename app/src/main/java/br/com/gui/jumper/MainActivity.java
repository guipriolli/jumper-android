package br.com.gui.jumper;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

import br.com.gui.jumper.engine.Game;

public class MainActivity extends Activity {

    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout container = (FrameLayout) findViewById(R.id.container);

        //Instancia o jogo
        game = new Game(this);
        container.setFocusable(true);
        container.addView(this.game);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Inicia o jogo
        game.start();
        new Thread(this.game).start();
    }

    @Override
    protected void onPause() {
        //Finaliza o jogo
        super.onPause();
        game.stop();
    }
}
