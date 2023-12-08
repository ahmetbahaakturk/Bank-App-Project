package LoginPage;

import Helper.Helper;
import Helper.Operation;
import RegisterPage.RegisterPage;

import javax.swing.*;


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
    private JLabel lbl_status;

    public LoginPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(400, 400);
        setResizable(false);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);

        btn_login.addActionListener(e -> {
            if (Operation.login(txtFld_tcno.getText(), txtFld_password.getPassword(), lbl_status)) {
                dispose();
            }
        });
        btn_register.addActionListener(e -> {
            dispose();
            new RegisterPage();
        });
    }


}