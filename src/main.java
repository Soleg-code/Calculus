package src;

import javax.swing.JFrame;

public class main {
    public static void main(String[] args) {
        Calculus qcmInterface = new Calculus();
        qcmInterface.setExtendedState(JFrame.MAXIMIZED_BOTH);
        qcmInterface.setVisible(true);
    }
}
