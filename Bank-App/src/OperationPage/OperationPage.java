package OperationPage;

import Helper.Helper;
import User.User;

import javax.swing.*;
import java.awt.*;

public class OperationPage extends JFrame {
    User user;
    private JPanel pnl_wrapper;
    private JTabbedPane tabbedPane1;
    private JLabel lbl_name;
    private JLabel lbl_surname;
    private JLabel lbl_tcno;
    private JButton btn_showpanel;
    private JPanel pnl_sidebar;

    public OperationPage(User user) {
        this.user = user;
        setContentPane(pnl_wrapper);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(400, 300));
        setSize(900, 700);
        setResizable(true);
        Helper.centralizePage(this);
        setTitle("İşlemler Menüsü");
        setVisible(true);
        refreshData();
    }

    private void refreshData() {
        lbl_name.setText("Ad: " + user.getName());
        lbl_surname.setText("Soyad: " + user.getSurname());
        lbl_tcno.setText("T.C Kimlik No: " + user.getTcno());
    }
}