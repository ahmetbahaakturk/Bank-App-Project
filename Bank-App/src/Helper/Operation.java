package Helper;

import User.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import OperationPage.OperationPage;

import javax.swing.*;

public class Operation {
    public static final Connection connect = DBConnect.getInstance();
    public static boolean login(String tcno, char[] password, JLabel lbl_status) {
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
                        lbl_status.setText("Girdiğiniz Bilgiler Yanlış!");
                        return false;
                    }
                }
            } else {
                lbl_status.setText("Girdiğiniz Bilgiler Yanlış!");
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
            PreparedStatement pr = connect.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
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
