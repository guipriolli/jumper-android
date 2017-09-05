package br.com.gui.jumper.graphics;

import android.graphics.Paint;
import android.graphics.Typeface;

//Auxilia na manipulação dos textos e cores
public class Cores {

    //Define texto da pontuação
    public static Paint getCorPontuacao() {
        Paint paint = new Paint();
        paint.setColor(0xFFFFFFFF);
        paint.setTextSize(100);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(3, 5, 5, 0xFF000000);
        return paint;
    }

    //Define texto do Game Over
    public static Paint getCorGameOver() {
        Paint paint = new Paint();
        paint.setColor(0xFFFF0000);
        paint.setTextSize(200);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setShadowLayer(2, 3, 3, 0xFF000000);
        return paint;
    }
}
