package OperationPage;

import Helper.Helper;
import User.User;

import javax.swing.*;
import java.awt.*;

public class OperationPage extends JFrame {
    User user;
    private JPanel pnl_wrapper;
    private JTabbedPane tbdpane_sidebar;

    public OperationPage(User user) {
        this.user = user;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setMinimumSize(new Dimension(1280, 720));
        setSize(1280, 720);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);
    }
}