package Login;

import Helper.Helper;

import javax.swing.*;
import java.sql.ResultSet;

public class LoginPage extends JFrame {
    private JPanel pnl_wrapper;
    private JPanel pnl_btmWrapper;
    private JPanel pnl_topWrapper;
    private JTextField txtFld_tcno;
    private JPasswordField txtFld_password;
    private JButton btn_login;
    private JButton btn_register;
    private JLabel lbl_tcno;
    private JLabel lbl_password;
    private JLabel lbl_haveAccount;

    public LoginPage() {
        Helper.setNimbusTheme();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(400, 400);
        setResizable(false);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);

        btn_login.addActionListener(e -> {
            login(txtFld_tcno.getText(), txtFld_password.getPassword());
        });
    }

    public static boolean login(String tcno, char[] password) {
        String pass = String.valueOf(password);
        System.out.println(pass);
        try {
            ResultSet resultSet = Helper.getResultSet("SELECT * FROM users");
            while (resultSet.next()) {
                if (resultSet.getString("tcno").equals(tcno)) {
                    if (resultSet.getString("password").equals(pass)) {
                        return true;
                    } else {
                        Helper.getMessageBox("Warning", "Wrong Password", "warning");
                        return false;
                    }
                }
            }
            Helper.getMessageBox("Warning", "User not found!", "warning");

            return false;
        } catch (Exception e) {
            System.out.println("LOGİN function has not worked!");
            System.out.println(e.getMessage());
            return false;
        }
    }

}
