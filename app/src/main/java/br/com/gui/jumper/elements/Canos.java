package br.com.gui.jumper.elements;

import android.content.Context;
import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import br.com.gui.jumper.graphics.Tela;

//Cria vários canos na tela
public class Canos {

    private static final int QUANTIDADE_DE_CANOS = 5;
    private static final int DISTANCIA_ENTRE_CANOS = 400;

    private final List<Cano> canos = new ArrayList<Cano>();
    private final Pontuacao pontucao;
    private final Context context;
    private Tela tela;

    public Canos(Tela tela, Pontuacao pontuacao, Context context) {

        this.tela = tela;
        this.pontucao = pontuacao;
        this.context = context;

        int posicaoInicial = 200;

        //Inicia o jogo com alguns canos pré-definidos
        for (int i = 0; i < QUANTIDADE_DE_CANOS; i++) {
            posicaoInicial += DISTANCIA_ENTRE_CANOS;
            canos.add(new Cano(tela, posicaoInicial, context));
        }
    }

    //Desenha cada cano na tela
    public void desenha(Canvas canvas) {
        for (Cano cano : canos) {
            cano.desenha(canvas);
        }
    }

    //Movimenta os canos
    public void move() {

        //Usa o iterator para facilitar a inserção e remoção de novos canos
        ListIterator<Cano> iterator = canos.listIterator();
        while (iterator.hasNext()) {

            //Pega o cano atual e move
            Cano cano = (Cano) iterator.next();
            cano.move();

            //Se o cano saiu da tela, remove ele e cria outro após o último
            if (cano.saiuTela()) {
                pontucao.aumenta();
                iterator.remove();
                Cano novoCano = new Cano(tela, getMaximo() + DISTANCIA_ENTRE_CANOS, context);
                iterator.add(novoCano);
            }
        }
    }

    //Pega a distância do último cano
    private int getMaximo() {
        int maximo = 0;
        for (Cano cano : canos) {
            maximo = Math.max(cano.getPosicao(), maximo);
        }
        return maximo;
    }

    //Verifica se algum dos canos teve colisão com o pássaro
    public boolean temColisaoCom(Passaro passaro) {
        for (Cano cano : canos) {
            //Verifica colisão horizontal e vertical
            if (cano.temColisaoHorizontalCom(passaro)
                    && cano.temColisaoVerticalCom(passaro)) {
                return true;
            }
        }
        return false;
    }
}
