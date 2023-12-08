package Helper;

import javax.swing.*;
import java.awt.*;

public class Helper {

    public static void centralizePage(JFrame frame) {
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
    }

    public static void getMessageBox(String title, String message, String type) {
        switch (type) {
            case "warning" -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
            case "info" -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
            default -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
