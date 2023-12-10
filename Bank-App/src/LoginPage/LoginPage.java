package LoginPage;

import Helper.*;

import javax.swing.*;
import java.sql.PreparedStatement;


public class LoginPage extends JFrame {
    private JPanel pnl_wrapper;
    private JTextField txtFld_tcno;
    private JPasswordField txtFld_password;
    private JButton btn_login;
    private JButton btn_register;
    private JLabel lbl_status;
    private JPanel pnl_btmWrapper;
    private JPanel pnl_topWrapper;
    private JLabel lbl_tcno;
    private JLabel lbl_password;
    private JLabel lbl_haveAccount;
    private JPanel pnl_loginWrapper;
    private JPanel pnl_registerWrapper;
    private JPanel pnl_register_topWrapper;
    private JPanel pnl_register_buttomWrapper;
    private JTextField txtfld_register_surname;
    private JTextField txtfld_register_name;
    private JTextField txtfld_register_tcno;
    private JPasswordField txtfld_register_password;
    private JButton btn_register_register;
    private JButton btn_register_goback;
    private JLabel lbl_register_surname;
    private JLabel lbl_register_warning;

    public LoginPage() {
        pnl_registerWrapper.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(350, 350);
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
            lbl_status.setText("");
            pnl_loginWrapper.setVisible(false);
            pnl_registerWrapper.setVisible(true);
        });

        btn_register_goback.addActionListener(e -> {
            pnl_registerWrapper.setVisible(false);
            pnl_loginWrapper.setVisible(true);
        });

        btn_register_register.addActionListener(e -> register());
    }

    private void register() {
        try {
            if (Operation.findUser(txtfld_register_tcno.getText()) == null) {
                if (!txtfld_register_name.getText().isEmpty() && !lbl_register_surname.getText().isEmpty() && !String.valueOf(txtfld_register_password.getPassword()).isEmpty() && !txtfld_register_tcno.getText().isEmpty()) {
                    String name = txtfld_register_name.getText();
                    String surname = txtfld_register_surname.getText();
                    String tcno = txtfld_register_tcno.getText();
                    String password = String.valueOf(txtfld_register_password.getPassword());

                    String query = "INSERT INTO users (name, surname, tcno, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement pr = DBConnect.getConnection().prepareStatement(query);
                    pr.setString(1, name);
                    pr.setString(2, surname);
                    pr.setString(3, tcno);
                    pr.setString(4, password);
                    pr.executeUpdate();
                    pr.close();
                    Helper.getMessageBox("Kayıt Başarılı", "Kaydınız Başarılı Bir Şekilde Açılmıştır", "");
                    pnl_registerWrapper.setVisible(false);
                    pnl_loginWrapper.setVisible(true);
                } else {
                    lbl_register_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
                }
            } else {
                lbl_register_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
            }
        } catch (Exception e) {
            lbl_register_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
        }
    }

}