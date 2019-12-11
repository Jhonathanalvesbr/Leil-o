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

    private JLabel txtProduto;
    private JLabel txtLanceMinimo;
    private JLabel txtLanceAtual;
    private JLabel txtQuantidadeLances;
    private JLabel txtStatus;
    private ArrayList<JButton> botao = new ArrayList();
    JScrollPane sp = new JScrollPane();
    private int i = 0;
    int n = 1;

    public JLabel getTxtProduto() {
        return txtProduto;
    }

    public void setTxtProduto(JLabel txtProduto) {
        this.txtProduto = txtProduto;
    }

    public JLabel getTxtLanceMinimo() {
        return txtLanceMinimo;
    }

    public void setTxtLanceMinimo(JLabel txtLanceMinimo) {
        this.txtLanceMinimo = txtLanceMinimo;
    }

    public JLabel getTxtLanceAtual() {
        return txtLanceAtual;
    }

    public void setLanceAtual(String lanceAtual) {
        this.txtLanceAtual.setText(lanceAtual);
    }

    public JLabel getTxtQuantidadeLances() {
        return txtQuantidadeLances;
    }

    public void setTxtQuantidadeLances(JLabel txtQuantidadeLances) {
        this.txtQuantidadeLances = txtQuantidadeLances;
    }

    public JLabel getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(JLabel txtStatus) {
        this.txtStatus = txtStatus;
    }

    public ArrayList<JButton> getBotao() {
        return botao;
    }

    public void setBotao(ArrayList<JButton> botao) {
        this.botao = botao;
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
    
    public int getI(){
        return i;
    }
    
    public TelaLotes(Leilao leilao, int j) {
            i = j;
            System.out.println(j);
            JButton temp = new JButton("Entrar ");
            
            botao.add(temp);
            txtProduto = new JLabel("Produto: " + leilao.getNomeProduto() + ".");
            txtLanceMinimo = new JLabel("Lance minimo: R$: " + leilao.getValorMinimo() + ".");
            txtLanceAtual = new JLabel("Lance atual: R$: " + leilao.getLanceAtual() + ".");
            txtQuantidadeLances = new JLabel("Quantidade lances: " + leilao.getQntLances() + ".");
            if (leilao.getStatusAberto()) {
                txtStatus = new JLabel("Status: Aberto.");
            } else {
                txtStatus = new JLabel("Status: Fechado.");
                temp.setEnabled(false);
            }
            
            temp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LanceTela tela = new LanceTela(leilao,TelaLotes.this);
                int i = getI()-1;
                
                tela.setLote("Lote: " + String.format("%03d", getI()));
                tela.setProduto(txtProduto.getText());
                tela.setLanceMinimo(txtLanceMinimo.getText());
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
                            .addComponent(txtProduto)
                            .addComponent(txtLanceMinimo)
                            .addComponent(txtLanceAtual)
                            .addComponent(txtQuantidadeLances)
                            .addComponent(txtStatus)
                            .addComponent(botao.get(n-2)))
            );

            l.setVerticalGroup(l.createSequentialGroup()
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtProduto)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLanceMinimo)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtLanceAtual)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantidadeLances)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStatus)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(botao.get(n-2))
                    )
            );

            sp.setToolTipText("test");
            sp.add(this);
        

    }

    public void display(ArrayList<Leilao> leilao) {
        JFrame f = new JFrame("Leilão IFTM");
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
        f.setSize(300, 300);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Leilao leilao1 : leilao) {
            panel.add(new TelaLotes(leilao1, n));
            n++;
        }
        panel.add(Box.createVerticalGlue());
        f.getContentPane().add(scrollPane);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    
    
}
