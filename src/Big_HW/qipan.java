package Big_HW;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class qipan extends JFrame implements ActionListener {
    private zhixing cbBoard;

    //棋盘规格 默认使用7*6
    private int C_specifications = 0;
    private JMenu menu1 = new JMenu("游戏");
    private JMenu menu1_1 = new JMenu("棋盘选择");
    private JMenuItem item1_1_1 = new JMenuItem("7*6");
    private JMenuItem item1_1_2 = new JMenuItem("8*7");
    private JMenuItem item1_2 = new JMenuItem("退出");
    private JMenuBar bar = new JMenuBar();
    private JLabel jlbl_1 = new JLabel("玩家一：");
    private JLabel jlbl_2 = new JLabel("玩家二：");
    protected JTextField jtxt_1 = new JTextField();
    protected JTextField jtxt_2 = new JTextField();
    private JButton jbtn_play = new JButton("Play");
    private JLabel jlbl_win = new JLabel("获胜");
    protected JTextField jtxt_win = new JTextField();

    //确定现手 默认玩家1
    private int first = 1;

    public qipan() {
        super("四子棋");

        item1_1_1.addActionListener(this);
        item1_1_2.addActionListener(this);
        item1_2.addActionListener(this);
        menu1_1.add(item1_1_1);
        menu1_1.add(item1_1_2);
        menu1.add(item1_2);
        menu1.add(menu1_1);
        bar.add(menu1);
        this.setJMenuBar(bar);
        this.setBounds(0, 0, 738, 685);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlbl_1.setSize(55,30);
        jlbl_1.setLocation(20, 0);
        add(jlbl_1);
        jlbl_2.setSize(55,30);
        jlbl_2.setLocation(200, 0);
        add(jlbl_2);
        jtxt_1.setSize(80,30);
        jtxt_1.setLocation(80, 0);
        add(jtxt_1);
        jtxt_2.setSize(80,30);
        jtxt_2.setLocation(260, 0);
        add(jtxt_2);

        jtxt_win.setSize(80,30);
        jtxt_win.setLocation(620, 250);
        jtxt_win.setEditable(false);
        add(jtxt_win);
        jlbl_win.setSize(50, 30);
        jlbl_win.setLocation(700,250);
        add(jlbl_win);

        jbtn_play.setSize(60, 30);
        jbtn_play.setLocation(400, 0);
        jbtn_play.setEnabled(true);
        jbtn_play.setVisible(true);
        jbtn_play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//监听button，监听事件是一个线程，程序运行是在另一个线程。本方法是在监听线程，传入this是相当于传入button对象，如果要传入当前类对象，需要当前类的名称.this
                jbtn_play.setEnabled(false);
                String msg = "";
                if (jtxt_1.getText().equals("") && jtxt_2.getText().equals("")) {
                    msg = "必须存在一个玩家名！";
                    jbtn_play.setEnabled(true);
                    JOptionPane.showMessageDialog(qipan.this, msg, "提示", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    jtxt_1.setEditable(false);
                    jtxt_2.setEditable(false);
                    //开启人人对战
                    if (!jtxt_1.getText().equals("") && !jtxt_2.getText().equals("")) {
                        cbBoard = new zhixing(C_specifications, qipan.this, 0, first);
                    } else {
                        //开启人机对战
                        if (jtxt_1.getText().equals("")) {
                            first = 2;
                            jtxt_1.setText("电脑");
                        } else {
                            jtxt_2.setText("电脑");
                        }
                        cbBoard = new zhixing(C_specifications, qipan.this, 1, first);
                    }

                    qipan.this.add(cbBoard);
                    qipan.this.repaint();
                }
            }
        });
        add(jbtn_play);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
       if (source == item1_2) {
            System.exit(0);
        } else if (source == item1_1_1) {
            qipan.this.C_specifications = 0;
        } else if (source == item1_1_2) {
            qipan.this.C_specifications = 1;
        }
    }
}
