package RegisterPage;

import Helper.*;
import LoginPage.LoginPage;

import javax.swing.*;
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

    public RegisterPage() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setSize(400, 260);
        setResizable(false);
        Helper.centralizePage(this);
        setTitle("Kayıt Ol");
        setVisible(true);
        btn_register.addActionListener(e -> {
            register();
        });
    }

    private void register() {
        try {
            if (Operation.findUser(txtfld_tcno.getText()) == null) {
                if (!txtfld_name.getText().isEmpty() && !txtfld_surname.getText().isEmpty() && !String.valueOf(txtfld_password.getPassword()).isEmpty()) {
                    String name = txtfld_name.getText();
                    String surname = txtfld_surname.getText();
                    String tcno = txtfld_tcno.getText();
                    String password = String.valueOf(txtfld_password.getPassword());

                    String query = "INSERT INTO users (name, surname, tcno, password) VALUES (?, ?, ?, ?)";
                    PreparedStatement pr = DBConnect.getInstance().prepareStatement(query);
                    pr.setString(1, name);
                    pr.setString(2, surname);
                    pr.setString(3, tcno);
                    pr.setString(4, password);
                    pr.executeUpdate();
                    Helper.getMessageBox("Kayıt Başarılı", "Kaydınız Başarılı Bir Şekilde Açılmıştır", "");
                    dispose();
                    new LoginPage();
                } else {
                    Helper.getMessageBox("Hey Sen!", "Birtakım Bilgiler Eksik!", "warning");
                }
            } else {
                Helper.getMessageBox("Warning", "Girilen T.C Kimlik Numarasına Kayıtlı Kullanıcı Bulunmaktadır", "warning");
            }
        } catch (Exception e) {
            Helper.getMessageBox("Uyarı", "Bilgilerin Hepsini Girdiğinizden Emin Olun!", "warning");
        }
    }
}