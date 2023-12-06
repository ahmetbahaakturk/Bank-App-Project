package Helper;

import User.User;
import OperationPage.OperationPage;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Operation {
    public static boolean login(String tcno, char[] password) {
        try {
            String pass = String.valueOf(password);
            ResultSet rs = findUser(tcno);

            if (rs != null) {
                while (rs.next()) {
                    if (rs.getString("password").equals(pass)) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String surname = rs.getString("surname");
                        new OperationPage(new User(id, name, surname, tcno));
                        return true;
                    } else {
                        Helper.getMessageBox("Uyarı", "Hatalı Şifre", "warning");
                        return false;
                    }
                }
            } else {
                Helper.getMessageBox("Uyarı", "Girilen T.C Kimlik Numarasına Kayıtlı Kullanıcı Bulunmamaktadır!", "warning");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Hata mata");
            return false;
        }
        return false;
    }

    public static ResultSet findUser(String tcno) {
        try {
            String query = "SELECT * FROM users WHERE tcno = ?";
            PreparedStatement pr = DBConnect.getInstance().prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            pr.setString(1, tcno);
            ResultSet rs = pr.executeQuery();


            if (rs.next()) {
                rs.beforeFirst();
                return rs;
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("Login function has not worked!");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
