package projetofinal;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Leilao {
    private String nomeProduto;
    private double lanceMinimo;
    private ArrayList<Lance> lance;
    private boolean statusAberto;
    private Lance ganhadorLance;
    private NumberFormat formatar = new DecimalFormat("#,##0.00");     
    
    public String format(double formatar){
        return this.formatar.format(formatar);
    }   
    
    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getLanceMinimo() {
        return lanceMinimo;
    }

    public void setLanceMinimo(double lanceMinimo) {
        this.lanceMinimo = lanceMinimo;
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
        this.lanceMinimo = valorMinimo;
        this.statusAberto = statusAberto;
        if(statusAberto = true)
            lance = new ArrayList<>();
    }
    
    public void RegistrarLance(String nomeCliente, double valorLance){
        if(valorLance > lanceMinimo)
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
