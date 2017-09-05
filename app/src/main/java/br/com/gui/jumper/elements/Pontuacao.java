package br.com.gui.jumper.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.gui.jumper.engine.Som;
import br.com.gui.jumper.graphics.Cores;

//Conta os pontos do jogo
public class Pontuacao {

    private static final Paint BRANCO = Cores.getCorPontuacao();
    private final Som som;
    private int pontos = 0;

    public Pontuacao(Som som) {
        this.som = som;
    }

    //Escreve a pontuação na tela
    public void desenha(Canvas canvas) {
        canvas.drawText(String.valueOf(pontos), 100, 100, BRANCO);
    }

    //Aumenta os pontos e toca o áudio
    public void aumenta() {
        som.tocar(Som.PONTOS);
        this.pontos++;
    }
}
