package projetofinal;

import java.awt.EventQueue;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/** @see https://stackoverflow.com/a/8504753/230513 */
public class GroupPanel extends JPanel {
	
    private JLabel label1     = new JLabel("Produto:");
    private JTextField field1 = new JTextField(16);
    private JLabel label2     = new JLabel("Lance minimo:");
    private JTextField field2 = new JTextField(16);
    private JLabel label3     = new JLabel("Status:");
    private JTextField field3 = new JTextField(16);
    JScrollPane sp = new JScrollPane();

    public GroupPanel(int n) {
        this.setBorder(BorderFactory.createTitledBorder("Lote: "+String.format("%03d", n)));
        GroupLayout l = new GroupLayout(this);          
        this.setLayout(l);
        l.setAutoCreateGaps(true);
        l.setAutoCreateContainerGaps(true);
        l.setHorizontalGroup(l.createSequentialGroup()
            .addGroup(l.createParallelGroup(GroupLayout.Alignment.TRAILING)
                .addComponent(label1)
                .addComponent(label2)
                .addComponent(label3))
            .addGroup(l.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(field1)
                .addComponent(field2)
                .addComponent(field3))
        );

        l.setVerticalGroup(l.createSequentialGroup()
            .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label1)
                .addComponent(field1))
            .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label2)
                .addComponent(field2))
            .addGroup(l.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(label3)
                .addComponent(field3))
        );

        sp.setToolTipText("test");
        sp.add(this);
    }

    private static void display() {
        JFrame f = new JFrame("GroupPanel");
        JPanel panel = new JPanel();
        JScrollPane scrollPane = new JScrollPane(panel);
        f.setSize(500, 500);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new GroupPanel(1));
        panel.add(new GroupPanel(2));
        panel.add(new GroupPanel(3));
        panel.add(new GroupPanel(4));
        panel.add(Box.createVerticalGlue());

        f.getContentPane().add(scrollPane);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                display();
            }
        });
    }
}