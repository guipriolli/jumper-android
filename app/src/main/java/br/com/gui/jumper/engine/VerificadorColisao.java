package br.com.gui.jumper.engine;

import br.com.gui.jumper.elements.Canos;
import br.com.gui.jumper.elements.Passaro;

//Auxilia na verificação de colisão
public class VerificadorColisao {

    private final Passaro passaro;
    private final Canos canos;

    public VerificadorColisao(Passaro passaro, Canos canos) {
        this.passaro = passaro;
        this.canos = canos;
    }

    //Verifica se houve colisão
    public boolean temColisao() {
        return canos.temColisaoCom(passaro);
    }

}
