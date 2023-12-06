package Helper;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Helper {

    public static void centralizePage(JFrame frame) {
        int x = (Toolkit.getDefaultToolkit().getScreenSize().width - frame.getSize().width) / 2;
        int y = (Toolkit.getDefaultToolkit().getScreenSize().height - frame.getSize().height) / 2;
        frame.setLocation(x, y);
    }

    public static void setNimbusTheme() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                try {
                    UIManager.setLookAndFeel(info.getClassName());
                } catch (Exception e) {
                    System.out.println("Nimbus theme was not found in the system.");
                }
            }
        }
    }

    public static ResultSet getResultSet(String query) {
        try {
            return DBConnect.getInstance().createStatement().executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Failed Operation!");
            return null;
        }
    }

    public static void getMessageBox(String title, String message, String type) {
        switch (type) {
            case "warning" -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.WARNING_MESSAGE);
            case "info" -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
            default -> JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
        }
    }
}
