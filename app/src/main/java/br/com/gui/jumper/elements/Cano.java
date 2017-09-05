package br.com.gui.jumper.elements;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import br.com.gui.jumper.R;
import br.com.gui.jumper.graphics.Cores;
import br.com.gui.jumper.graphics.Tela;

//Desenha o cano e implementa as ações dele
public class Cano {

    private Tela tela;
    private final Bitmap canoInferior;
    private final Bitmap canoSuperior;

    private int alturaInferior;
    private int alturaSuperior;
    private static final int TAMANHO_CANO = 700;
    private static final int LARGURA_CANO = 150;

    private int posicao;

    public Cano(Tela tela, int posicao, Context context) {

        this.tela = tela;
        this.posicao = posicao;
        alturaInferior = tela.getAltura() - TAMANHO_CANO - random();
        alturaSuperior = 0 + TAMANHO_CANO + random();

        Bitmap bp = BitmapFactory.decodeResource(context.getResources(), R.drawable.cano);
        this.canoInferior = Bitmap.createScaledBitmap(bp, LARGURA_CANO, alturaInferior, false);
        this.canoSuperior = Bitmap.createScaledBitmap(bp, LARGURA_CANO, alturaSuperior, false);
    }

    //Gera um número aleatório para variar os tamanhos dos canos
    private int random() {
        return (int) (Math.random() * 400);
    }

    //Desenha o cano superior e inferior
    public void desenha(Canvas canvas) {
        //Cano inferior
        canvas.drawBitmap(canoInferior, posicao, alturaInferior, null);

        //Cano superior
        canvas.drawBitmap(canoSuperior, posicao, 0, null);
    }

    //Move o cano
    public void move() {
        this.posicao -= 5;
    }

    //Verifica se o cano saiu da tela
    public boolean saiuTela() {
        return posicao + LARGURA_CANO < 0;
    }

    public int getPosicao() {
        return this.posicao;
    }

    //Verifica colisão horizontal com o pássaro
    public boolean temColisaoHorizontalCom(Passaro passaro) {
        return this.posicao - passaro.getX() < passaro.getRAIO();
    }

    //Verifica colisão vertical com o pássaro
    public boolean temColisaoVerticalCom(Passaro passaro) {
        return passaro.getAltura() - passaro.getRAIO() < this.alturaSuperior || passaro.getAltura() + passaro.getRAIO() > this.alturaInferior;
    }
}
