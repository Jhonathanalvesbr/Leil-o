package projetofinal;

public class Lance {
    private double valorLance;
    private String nomeCliente;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public Lance(String nomeCliente, double valorLance){
        this.valorLance = valorLance;
        this.nomeCliente = nomeCliente;
    }
    
    public void Lances(){
        System.out.println("Nome cliente: " + nomeCliente);
        System.out.println("R$: " + valorLance);
    }

    public double getValorLance() {
        return valorLance;
    }
}
