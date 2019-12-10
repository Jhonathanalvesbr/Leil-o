package projetofinal;

public class ProjetoFinal {

    public static void main(String[] args) {
        Leilao leilao = new Leilao("Bicicleta", 100.00, true);
        leilao.RegistrarLance("Jhonathan", 300.00);
        leilao.RegistrarLance("Izabela", 150.00);
        leilao.FinalizarLeilao();
    }
    
}
