sad
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
    private JLabel lbl_name;
    private JLabel lbl_userInfo;
    private JLabel lbl_surname;
    private JLabel lbl_tcno;
    private JPanel pnl_userInfo;
    private JPanel pnl_siradanBank;
    private JList list2;
    private JPanel pnl_balance_trans;
    private JScrollPane pnl_balance;
    private JScrollPane pnl_transaction;
    private JTree tree1;
    private JList list_sidebar;
    private JButton button1;
    private JButton openMenuButton;

    public OperationPage(User user) {
        this.user = user;
        loadData();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setMinimumSize(new Dimension(1280, 300));
        setSize(1280, 720);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);
    }

    private void loadData() {
        lbl_name.setText("Ad: " + user.getName());
        lbl_surname.setText("Soyad: " + user.getSurname());
        lbl_tcno.setText("T.C. Kimlik No: " + user.getTcno());
    }
}
