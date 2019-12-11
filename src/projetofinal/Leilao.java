package projetofinal;

import java.util.ArrayList;

public class Leilao {
    private String nomeProduto;
    private double valorMinimo;
    private ArrayList<Lance> lance;
    private boolean statusAberto;
    private Lance ganhadorLance;
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public ArrayList<Lance> getLance() {
        return lance;
    }

    public void setLance(ArrayList<Lance> lance) {
        this.lance = lance;
    }

    public boolean getStatusAberto() {
        return statusAberto;
    }

    public void setStatusAberto(boolean statusAberto) {
        this.statusAberto = statusAberto;
    }

    public Lance getGanhadorLance() {
        return ganhadorLance;
    }

    public void setGanhadorLance(Lance ganhadorLance) {
        this.ganhadorLance = ganhadorLance;
    }
    
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
    
    public double getLanceAtual(){
        double lanceAtual = 0;
        for (Lance lance1 : lance) {
            if(lance1.getValorLance() > lanceAtual)
                lanceAtual = lance1.getValorLance();
        }
        return lanceAtual;
    }
    
    public int getQntLances(){
        int n = 0;
        for (Lance lance1 : lance) {
            n++;
        }
        return n;
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
