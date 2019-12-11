package projetofinal;

import java.util.ArrayList;

public class ProjetoFinal {

    public static void main(String[] args) {
        ArrayList<Leilao> leilao = new ArrayList();
        leilao.add(new Leilao("Bicicleta", 100.00, true));
        leilao.get(0).RegistrarLance("Jhonathan", 300.00);
        leilao.get(0).RegistrarLance("Izabela", 150.00);
        leilao.get(0).FinalizarLeilao();
        leilao.add(new Leilao("Carro", 1500.00, true));
        TelaLotes tela = new TelaLotes();
        tela.display(leilao);
        
    }
    
}
