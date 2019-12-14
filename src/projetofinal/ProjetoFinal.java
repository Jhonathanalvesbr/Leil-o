package projetofinal;

import java.util.ArrayList;

public class ProjetoFinal {

    public static void main(String[] args) {
        TelaLotes  tela = new TelaLotes();
        TelaAdm telaAdm = new TelaAdm(tela);
        
        telaAdm.setVisible(true);
    }
    
}
