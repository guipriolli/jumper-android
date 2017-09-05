package br.com.gui.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import br.com.gui.jumper.graphics.Cores;
import br.com.gui.jumper.graphics.Tela;

//Game Over
public class GameOver {

    private final Tela tela;
    private static final Paint VERMELHO = Cores.getCorGameOver();

    public GameOver(Tela tela) {
        this.tela = tela;
    }

    //Escreve o Game Over na tela
    public void desenha(Canvas canvas) {
        String gameOver = "Game Over";
        int centroHorizontal = centralizaTexto(gameOver);
        canvas.drawText(gameOver, centroHorizontal, tela.getAltura() / 2, VERMELHO);
    }

    //Centraliza o texto dinamicamente
    private int centralizaTexto(String texto) {
        Rect limiteDoTexto = new Rect();
        VERMELHO.getTextBounds(texto, 0, texto.length(), limiteDoTexto);
        int centroHorizontal = tela.getLargura()/2 - (limiteDoTexto.right - limiteDoTexto.left)/2;
        return centroHorizontal;
    }

}