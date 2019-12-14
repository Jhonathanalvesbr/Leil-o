package projetofinal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaLotes extends JPanel {

    public TelaLotes() {
    }

    private JLabel lblProduto, lblLanceMinimo, lblLanceAtual, lblQuantidadeLances, lblStatus;
    private JButton botao;
    private JScrollPane sp = new JScrollPane();
    private String nomeProduto;
    private double lanceMinimo, lanceAtual;

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public JFrame getF() {
        return f;
    }

    public void setF(JFrame f) {
        this.f = f;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
    private int quantidadeLances, i, n = 1, z = 0;
    private boolean status;
    
    public JButton getBotao() {
        return botao;
    }

    public void setBotao(JButton botao) {
        this.botao = botao;
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

    public double getLanceAtual() {
        return lanceAtual;
    }

    public void setLanceAtual(double lanceAtual) {
        this.lanceAtual = lanceAtual;
    }

    public int getQuantidadeLances() {
        return quantidadeLances;
    }

    

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }
    private boolean Status;

    public JLabel getLblProduto() {
        return lblProduto;
    }

    public void setLblProduto(JLabel lblProduto) {
        this.lblProduto = lblProduto;
    }

    public JLabel getLblLanceMinimo() {
        return lblLanceMinimo;
    }

    public void setLblLanceMinimo(JLabel lblLanceMinimo) {
        this.lblLanceMinimo = lblLanceMinimo;
    }

    public JLabel getLblLanceAtual() {
        return lblLanceAtual;
    }

    public void setLanceAtual(String lanceAtual) {
        this.lblLanceAtual.setText(lanceAtual);
    }

    public JLabel getLblQuantidadeLances() {
        return lblQuantidadeLances;
    }

    public void setLblQuantidadeLances(JLabel lblQuantidadeLances) {
        this.lblQuantidadeLances = lblQuantidadeLances;
    }

    public JLabel getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(JLabel lblStatus) {
        this.lblStatus = lblStatus;
    }

    public JScrollPane getSp() {
        return sp;
    }

    public void setSp(JScrollPane sp) {
        this.sp = sp;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getI() {
        return i;
    }

    public TelaLotes(final Leilao leilao, int j) {
        i = j;
        botao = new JButton("Entrar");
        nomeProduto = leilao.getNomeProduto();
        lanceMinimo = leilao.getLanceMinimo();
        lanceAtual = leilao.getLanceAtual();
        quantidadeLances = leilao.getQntLances();
        status = leilao.getStatusAberto();
        
        lblProduto = new JLabel("Produto: " + nomeProduto + ".");
        lblLanceMinimo = new JLabel("Lance minimo: R$: " + leilao.format(lanceMinimo) + ".");
        lblLanceAtual = new JLabel("Lance atual: R$: " + leilao.format(lanceAtual) + ".");
        lblQuantidadeLances = new JLabel("Quantidade lances: " + quantidadeLances + ".");
        if (status) {
            lblStatus = new JLabel("Status: Aberto.");
        } else {
            lblStatus = new JLabel("Status: Fechado.");
            botao.setEnabled(false);
        }

        botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LanceTela tela = new LanceTela(leilao, TelaLotes.this);
                int i = getI() - 1;

                tela.setLote("Lote: " + String.format("%03d", getI()));
                tela.setProduto(lblProduto.getText());
                tela.setLanceMinimo(lblLanceMinimo.getText());
                tela.setVisible(true);
            }
        });
        n++;
        this.setBorder(BorderFactory.createTitledBorder("Lote: " + String.format("%03d", j)));
        GroupLayout l = new GroupLayout(this);
        this.setLayout(l);
        l.setAutoCreateGaps(true);
        l.setAutoCreateContainerGaps(true);
        l.setHorizontalGroup(l.createSequentialGroup()
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(lblProduto)
                        .addComponent(lblLanceMinimo)
                        .addComponent(lblLanceAtual)
                        .addComponent(lblQuantidadeLances)
                        .addComponent(lblStatus)
                        .addComponent(botao))
        );

        l.setVerticalGroup(l.createSequentialGroup()
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblProduto)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLanceMinimo)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblLanceAtual)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblQuantidadeLances)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblStatus)
                )
                .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(botao)
                )
        );
    }
        JFrame f = new JFrame("Leilão IFTM");
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
    public void display() {
        f.setSize(300, 300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
    }
    ArrayList<Leilao> leilao;
    public void criarLeilao(ArrayList<Leilao> leilao){
        this.leilao = leilao;
        int c = panel.getComponentCount();
        
        
            panel.add(new TelaLotes(leilao.get(c), n));
            n++;
            z++;
        
        f.getContentPane().add(scrollPane);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
    
    
    public void removeLelao(int i)
    {
        panel.remove(i);
    }
    
    public void setStatusBotao(int i, boolean b){
        
        TelaLotes temp = (TelaLotes) panel.getComponent(i);
       
    }
    
    public void atualizar(int index, String nomeProduto, boolean status, double valor){
        
        TelaLotes temp = (TelaLotes) panel.getComponent(index);
        System.out.println(nomeProduto);
        temp.lblProduto.setText("Produto: " + nomeProduto + ".");
        temp.lblLanceMinimo.setText("Lance minimo: R$: " + leilao.get(0).format(valor) + ".");
        temp.botao.setEnabled(status);
        
        
    }
    
    public void setQuantidadeLances() {
        quantidadeLances++;
        lblQuantidadeLances.setText(("Quantidade lances: " + quantidadeLances + "."));
    }
}
