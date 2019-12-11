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

    private JLabel produto;
    private JLabel lanceMinimo;
    private JLabel lanceAtual;
    private JLabel qntLances;
    private JLabel status;
    private ArrayList<JButton> botao = new ArrayList();
    JScrollPane sp = new JScrollPane();
    private int i = 0;
    int n = 1;
    
    public int getI(){
        return i;
    }
    
    public TelaLotes(Leilao leilao, int j) {
            i = j;
            System.out.println(j);
            JButton temp = new JButton("Entrar ");
            
            botao.add(temp);
            produto = new JLabel("Produto: " + leilao.getNomeProduto() + ".");
            lanceMinimo = new JLabel("Lance minimo: R$: " + leilao.getValorMinimo() + ".");
            lanceAtual = new JLabel("Lance atual: R$: " + leilao.getLanceAtual() + ".");
            qntLances = new JLabel("Quantidade lances: " + leilao.getQntLances() + ".");
            if (leilao.getStatusAberto()) {
                status = new JLabel("Status: Aberto.");
            } else {
                status = new JLabel("Status: Fechado.");
                temp.setEnabled(false);
            }
            
            temp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LanceTela tela = new LanceTela();
                int i = getI()-1;
                
                tela.setLote("Lote: " + String.format("%03d", getI()));
                tela.setProduto(produto.getText());
                tela.setLanceMinimo(lanceMinimo.getText());
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
                            .addComponent(produto)
                            .addComponent(lanceMinimo)
                            .addComponent(lanceAtual)
                            .addComponent(qntLances)
                            .addComponent(status)
                            .addComponent(botao.get(n-2)))
            );

            l.setVerticalGroup(l.createSequentialGroup()
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(produto)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lanceMinimo)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(lanceAtual)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(qntLances)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(status)
                    )
                    .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(botao.get(n-2))
                    )
            );

            sp.setToolTipText("test");
            sp.add(this);
        

    }

    public void display(ArrayList<Leilao> leilao) {
        JFrame f = new JFrame("GroupPanel");
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
