package view;

import javax.swing.*;

public class SistemaFlix {
    public static void main(String[] args) {
        String resultado;
        FlixJanelaPrincipal flixmenuPrincipal = new FlixJanelaPrincipal();
        int op=1;
        try {
            do {
//                op = Integer.parseInt(JOptionPane.showInputDialog("<1> Tabela de Controle\n<2> Movimentação\n<0> Sair"));
//
//                switch (op){
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                    case 0:
//                        JOptionPane.showMessageDialog(null,"Obrigado por utilizar nosso sistema!");
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(null,"Escola a opção <1> ou <2>");
//                }

            } while (op != 0);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Processo finalizado!");
        }
    }
}
