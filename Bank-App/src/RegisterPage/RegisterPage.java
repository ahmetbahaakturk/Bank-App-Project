package RegisterPage;

import Helper.*;
import LoginPage.LoginPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class RegisterPage extends JFrame {
    private JPanel pnl_wrapper;
    private JPanel pnl_topWrapper;
    private JPanel pnl_bottomWrapper;
    private JTextField txtfld_name;
    private JTextField txtfld_surname;
    private JTextField txtfld_tcno;
    private JPasswordField txtfld_password;
    private JButton btn_register;
    private JLabel lbl_warning;
    private JButton geriDönButton;

    public RegisterPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(400, 400);
        setResizable(false);
        Helper.centralizePage(this);
        setTitle("Kayıt Ol");
        setVisible(true);
        btn_register.addActionListener(e -> register());
        geriDönButton.addActionListener(e -> {
            new LoginPage();
            dispose();
        });
    }

    private void register() {
        try {
            if (Operation.findUser(txtfld_tcno.getText()) == null) {
                if (!txtfld_name.getText().isEmpty() && !txtfld_surname.getText().isEmpty() && !String.valueOf(txtfld_password.getPassword()).isEmpty() && !txtfld_tcno.getText().isEmpty()) {
                    String name = txtfld_name.getText();
                    String surname = txtfld_surname.getText();
                    String tcno = txtfld_tcno.getText();
                    String password = String.valueOf(txtfld_password.getPassword());

                    String query = "INSERT INTO users (name, surname, tcno, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement pr = DBConnect.getConnection().prepareStatement(query);
                    pr.setString(1, name);
                    pr.setString(2, surname);
                    pr.setString(3, tcno);
                    pr.setString(4, password);
                    pr.executeUpdate();
                    pr.close();
                    Helper.getMessageBox("Kayıt Başarılı", "Kaydınız Başarılı Bir Şekilde Açılmıştır", "");
                    dispose();
                    new LoginPage();
                } else {
                    lbl_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
                }
            } else {
                lbl_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
            }
        } catch (Exception e) {
            lbl_warning.setText("Birtakım Bilgiler Eksik Girildi veya Yanlış!");
        }
    }
}