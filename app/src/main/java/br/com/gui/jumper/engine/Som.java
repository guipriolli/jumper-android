package br.com.gui.jumper.engine;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import br.com.gui.jumper.R;

//Manipular sons do jogo
public class Som {

    private final SoundPool soundPool;
    public static int PULO;
    public static int PONTOS;
    public static int COLISAO;

    public Som(Context context) {
        //Instância o objeto dizendo que vai trabalhar com audio
        soundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
        //Define os áudios
        PULO = soundPool.load(context, R.raw.pulo, 0);
        PONTOS = soundPool.load(context, R.raw.pontos, 0);
        COLISAO = soundPool.load(context, R.raw.colisao, 0);
    }

    //Dá o play no áudio
    public void tocar(int som) {
        soundPool.play(som, 1, 1, 1, 0, 1);
    }
}
