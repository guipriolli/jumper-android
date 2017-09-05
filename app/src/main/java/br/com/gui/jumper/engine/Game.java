package br.com.gui.jumper.engine;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import br.com.gui.jumper.R;
import br.com.gui.jumper.elements.Cano;
import br.com.gui.jumper.elements.Canos;
import br.com.gui.jumper.elements.GameOver;
import br.com.gui.jumper.elements.Passaro;
import br.com.gui.jumper.elements.Pontuacao;
import br.com.gui.jumper.graphics.Tela;

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private final Context context;
    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();
    private Tela tela;
    private Bitmap background;
    private Som som;
    private Passaro passaro;
    private Canos canos;
    private Pontuacao pontuacao;

    //Construtor
    public Game(Context context) {
        super(context);

        this.context = context;
        this.tela = new Tela(context);
        this.som = new Som(context);

        inicializaElementos();
        setOnTouchListener(this);
    }

    //Inicializa os elementos do jogo
    private void inicializaElementos() {
        //Instância os objetos do jogo
        pontuacao = new Pontuacao(som);
        passaro = new Passaro(tela, context, som);
        canos = new Canos(tela, pontuacao, context);

        //Define background do jogo
        background = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(background, background.getWidth(), tela.getAltura(), false);
    }

    @Override
    public void run() {
        //Fica rodando enquanto estiver true
        while (isRunning) {

            if (!holder.getSurface().isValid()) {
                continue;
            }

            //Instância o canvas para desenhar os objetos
            Canvas canvas = holder.lockCanvas();

            //Coloca a imagem de fundo
            canvas.drawBitmap(background, 0, 0, null);

            //Desenha o pássaro
            passaro.desenha(canvas);
            //Pássaro começa a cair
            passaro.cai();

            //Desenha os canos
            canos.desenha(canvas);
            //Canos começam a se mover
            canos.move();

            //Escreve a pontuação
            pontuacao.desenha(canvas);

            //Verifica se ocorreu colisão entre o pássaro e algum cano
            if(new VerificadorColisao(passaro, canos).temColisao()) {
                //Toca o áudio de colisão
                som.tocar(Som.COLISAO);
                //Escreve o game over na tela
                new GameOver(tela).desenha(canvas);
                //Para o jogo
                stop();
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    //Inicia o jogo
    public void start() {
        isRunning = true;
    }

    //Para o jogo
    public void stop() {
        isRunning = false;
    }

    @Override
    //Ao tocar na tela
    public boolean onTouch(View v, MotionEvent event) {
        //O pássaro pula
        passaro.jump();
        return false;
    }
}
