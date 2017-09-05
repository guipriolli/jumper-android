package br.com.gui.jumper.graphics;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

//Pega as dimensões da tela do celular
public class Tela {

    private final DisplayMetrics metrics;

    public Tela(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        metrics = new DisplayMetrics();
        display.getMetrics(metrics);
    }

    //Pega a altura
    public int getAltura() {
        return metrics.heightPixels;
    }

    //Pega a largura
    public int getLargura() {
        return metrics.widthPixels;
    }
}
