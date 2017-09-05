package br.com.gui.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.gui.jumper.R;
import br.com.gui.jumper.engine.Som;
import br.com.gui.jumper.graphics.Cores;
import br.com.gui.jumper.graphics.Tela;

//Desenha o pássaro e implementa as ações dele
public class Passaro {

    private Tela tela;
    private Som som;
    private final Bitmap passaro;

    private final int X = 100;
    private static final int RAIO = 100;
    private int altura;

    public Passaro(Tela tela, Context context, Som som) {
        this.altura = tela.getAltura() / 2;
        this.tela = tela;
        this.som = som;

        //Pega a imagem do pássaro
        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.passaro);
        this.passaro = Bitmap.createScaledBitmap(bp, RAIO*2, RAIO*2, false);
    }

    public int getX() {
        return X;
    }

    public static int getRAIO() {
        return RAIO;
    }

    public int getAltura() {
        return altura;
    }

    //Desenha a imagem do pássaro
    public void desenha(Canvas canvas) {
        canvas.drawBitmap(passaro, RAIO, altura - RAIO, null);
    }

    //Queda do pássaro
    public void cai() {
        boolean chegouNoChao = altura + RAIO > tela.getAltura();

        //Se não chegou no chão, continua caindo
        if(!chegouNoChao) {
            this.altura += 5;
        }
    }

    //Pulo do pássaro
    public void jump() {
        //Se não chegou no topo, pula
        if(altura > RAIO) {
            som.tocar(Som.PULO);
            altura -= 150;
        }
    }
}
