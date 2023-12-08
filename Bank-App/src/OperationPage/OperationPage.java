package OperationPage;

import Helper.Helper;
import User.User;

import javax.swing.*;
import java.awt.*;

public class OperationPage extends JFrame {
    User user;
    private JPanel pnl_wrapper;
    private JTabbedPane tabbedPane1;
    private JButton btn_yokArtik;

    public OperationPage(User user) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setContentPane(pnl_wrapper);
        setMinimumSize(new Dimension(1280, 720));
        setSize(1280, 720);
        Helper.centralizePage(this);
        setTitle("Sıradan Bank");
        setVisible(true);

        btn_yokArtik.addActionListener(e -> System.out.println("Yok artık"));
    }
}