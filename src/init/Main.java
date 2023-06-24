package init;

import javax.swing.SwingUtilities;

import view.InterfaceAluno;
 
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                InterfaceAluno interfaceAluno = new InterfaceAluno();
                interfaceAluno.setVisible(true);
            }
        });
    }
}

