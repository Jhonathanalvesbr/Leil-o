package projetofinal;

import java.util.ArrayList;

public class Leilao {
    private String nomeProduto;
    private double valorMinimo;
    private ArrayList<Lance> lance;
    private boolean statusAberto;
    private Lance ganhadorLance;
    
    public Leilao(String nomeProduto, double valorMinimo, boolean statusAberto){
        this.nomeProduto = nomeProduto;
        this.valorMinimo = valorMinimo;
        this.statusAberto = statusAberto;
        if(statusAberto = true)
            lance = new ArrayList<>();
    }
    
    public void RegistrarLance(String nomeCliente, double valorLance){
        if(valorLance > valorMinimo)
            lance.add(new Lance(nomeCliente, valorLance));
    }
    
    public void FinalizarLeilao(){
        for (Lance lance1 : lance) {
            lance1.Lances();
            if(ganhadorLance == null)
                ganhadorLance = lance1;
            if(lance1.getValorLance() > ganhadorLance.getValorLance())
                ganhadorLance = lance1;
        }
        statusAberto = false;
        System.out.println("");
        System.out.println("----------------------------");
        System.out.println("Ganhador!!!!");
        ganhadorLance.Lances();
        System.out.println("----------------------------");
    }
}
