package OperationPage;

import Helper.Helper;
import User.User;

import javax.swing.*;
import java.awt.*;

public class OperationPage extends JFrame {
    User user;
    private JPanel pnl_wrapper;
    private JPanel pnl_innerWrapper;
    private JTabbedPane tbdpane_sidebar;
    private JLabel lbl_userInfo;
    private JLabel lbl_surname;
    private JLabel lbl_tcno;
    private JList list_sidebar;
    private JButton button1;
    private JButton openMenuButton;

    public OperationPage(User user) {
        this.user = user;
        loadData();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setMinimumSize(new Dimension(1280, 720));
        setSize(1280, 720);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);
    }

    private void loadData() {
        lbl_userInfo.setText("Ad: " + user.getName() + "\nSoyad: " + user.getSurname() + "\nT.C. Kimlik No: " + user.getTcno());
    }
}