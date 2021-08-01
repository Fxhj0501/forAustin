package Big_HW;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class zhixing extends JPanel {
    //引入主类
    private qipan cb;

    private int ROW = 6;
    private int Col = 7;
    //默认使用7*6棋盘
    private int[][] chesses = new int[ROW][Col];//棋盘情况
    //棋盘格局
    private int C_specifications = 0;

    public static final int BLACK = 1;
    public static final int WHITE = -1;
    public static final int NONE = 0;

    private int whitchColor = BLACK;

    private boolean flag = false;

//    人人对战默认玩家1先手 人机对战人先手
    private int first;
    //人人对战 0 人机对战 1
    private int mode;

    private int width = 70;
    private int hight = 60;

    //当前棋子的行和列
    private int currRow;
    private int currCol;

    //表示赢家的颜色，初始为空
    private int winner = NONE;

    private BufferedImage whiteImage = null;
    private BufferedImage blackImage = null;

    private JButton jbtn_1 = new JButton("1");
    private JButton jbtn_2 = new JButton("2");
    private JButton jbtn_3 = new JButton("3");
    private JButton jbtn_4 = new JButton("4");
    private JButton jbtn_5 = new JButton("5");
    private JButton jbtn_6 = new JButton("6");
    private JButton jbtn_7 = new JButton("7");
    private JButton jbtn_8 = new JButton("8");

    private int playerOneColor;
    private int playerTwoColor;
    private int AIColor;

    public zhixing(int c_specifications, qipan cb, int mode, int first) {
        this.C_specifications = c_specifications;
        this.cb = cb;
        this.mode = mode;
        this.first = first;
        setSize(565, 500);
        setLocation(20, 40);
        setVisible(true);
        jbtn_1.setSize(64, 35);
        jbtn_1.setLocation(3, 0);
        jbtn_2.setSize(64, 35);
        jbtn_2.setLocation(73, 0);
        jbtn_3.setSize(64, 35);
        jbtn_3.setLocation(143, 0);
        jbtn_4.setSize(64, 35);
        jbtn_4.setLocation(213, 0);
        jbtn_5.setSize(64, 35);
        jbtn_5.setLocation(283, 0);
        jbtn_6.setSize(64, 35);
        jbtn_6.setLocation(353, 0);
        jbtn_7.setSize(64, 35);
        jbtn_7.setLocation(423, 0);
        jbtn_8.setSize(64, 35);
        jbtn_8.setLocation(493, 0);
        this.add(jbtn_1);
        this.add(jbtn_2);
        this.add(jbtn_3);
        this.add(jbtn_4);
        this.add(jbtn_5);
        this.add(jbtn_6);
        this.add(jbtn_7);
        this.add(jbtn_8);

        jbtn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][0] != NONE) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][0] == NONE) {
                        chesses[i][0] = whitchColor;
                        goOneStep(i, 0, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }

                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][1] != NONE) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][1] == NONE) {
                        chesses[i][1] = whitchColor;
                        goOneStep(i, 1, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][2] != NONE) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][2] == NONE) {
                        chesses[i][2] = whitchColor;
                        goOneStep(i, 2, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][3] != NONE && !flag) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][3] == NONE) {
                        chesses[i][3] = whitchColor;
                        goOneStep(i, 3, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][4] != NONE && !flag) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][4] == NONE) {
                        chesses[i][4] = whitchColor;
                        goOneStep(i, 4, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][5] != NONE && !flag) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][5] == NONE) {
                        chesses[i][5] = whitchColor;
                        goOneStep(i, 5, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][6] != NONE && !flag) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][6] == NONE) {
                        chesses[i][6] = whitchColor;
                        goOneStep(i, 6, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });
        jbtn_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chesses[0][7] != NONE && !flag) {
                    JOptionPane.showMessageDialog(zhixing.this, "当前列已满！", "提示", JOptionPane.INFORMATION_MESSAGE);
                }
                for (int i = ROW - 1; i >=0; i--) {
                    if (chesses[i][7] == NONE) {
                        chesses[i][7] = whitchColor;
                        goOneStep(i, 7, whitchColor);
                        whitchColor = -whitchColor;
                        break;
                    }
                }
                if (mode == 1 && !flag) {
                    aiGoOneStep();
                }
            }
        });

        if (this.C_specifications == 0) {
            jbtn_8.setEnabled(false);
        } else {
            zhixing.this.ROW = 7;
            zhixing.this.Col = 8;
            chesses = new int[ROW][Col];
        }

        try {
            blackImage = ImageIO.read(zhixing.class.getResourceAsStream("/Big_HW/b.jpg"));
            whiteImage = ImageIO.read(zhixing.class.getResourceAsStream("/Big_HW/w.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }//ImageIO.read方法可能会抛出异常，所以为了让用户能够处理，这里用了try_catch语句。

        //人_人模式，玩家一先手
        if (mode == 0) {
            playerOneColor = BLACK;
            playerTwoColor = WHITE;
            AIColor = NONE;
            //人机玩家先手
        } else {
            if (first == 2) {
                playerOneColor = NONE;
                playerTwoColor = BLACK;
                AIColor = WHITE;
            } else {
                playerOneColor = BLACK;
                playerTwoColor = NONE;
                AIColor = WHITE;
            }
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        //画横线
        for(int i = 0; i <= 8; i++)
        {
            g.drawLine(0, i * 60 + 40, 560,i * 60 + 40);
        }
        //画竖线
        for(int i = 0; i <= 9; i++)
        {
            g.drawLine(i * 70, 40, i * 70 , 460);
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < Col; j++) {
                if (chesses[i][j] == BLACK) {
                    luozi(i, j, blackImage, g);
                } else if (chesses[i][j] == WHITE) {
                    luozi(i, j, whiteImage, g);
                }
            }
        }
    }

    private void luozi(int row, int col, BufferedImage image, Graphics g)//在指定行和列画棋子
    {
        int x = col * 70 + 3;
        int y = row * 60 + 43;
        g.drawImage(image, x, y, this);
    }



    private void goOneStep(int row, int col, int color)//生成一步棋，并判断是否有玩家胜出
    {
        chesses[row][col] = color;
        currRow = row;
        currCol = col;
        cb.repaint();
        this.repaint();
        flag = isWin(currRow, currCol, color);
        if (flag) {
            winner = color;
            String msg;
            if(winner == AIColor) {
                cb.jtxt_win.setText("电脑");
            } else if(winner == playerOneColor) {
                cb.jtxt_win.setText(cb.jtxt_1.getText());
            } else {
                cb.jtxt_win.setText(cb.jtxt_2.getText());
            }
//            cb.repaint();
            jbtn_1.setEnabled(false);
            jbtn_2.setEnabled(false);
            jbtn_3.setEnabled(false);
            jbtn_4.setEnabled(false);
            jbtn_5.setEnabled(false);
            jbtn_6.setEnabled(false);
            jbtn_7.setEnabled(false);
            jbtn_8.setEnabled(false);
        }

        if (isFull()) {
            jbtn_1.setEnabled(false);
            jbtn_2.setEnabled(false);
            jbtn_3.setEnabled(false);
            jbtn_4.setEnabled(false);
            jbtn_5.setEnabled(false);
            jbtn_6.setEnabled(false);
            jbtn_7.setEnabled(false);
            jbtn_8.setEnabled(false);
            JOptionPane.showMessageDialog(zhixing.this, "平局", "提示", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isWin(int row, int col, int color)//判断当前点是否有4连的情况
    {
        int max = 0;
        int temp = 0;
        //纵向
        for (int i = 0; i < Col; i++) {
            if (chesses[row][i] == color) {
                temp++;
                if (max < temp) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }
        if (max >= 4) {
            return true;
        }
        //判断横向
        temp = 0;
        max = 0;
        for (int i = 0; i < ROW; i++) {
            if (chesses[i][col] == color) {
                temp++;
                if (max < temp) {
                    max = temp;
                }
            } else {
                temp = 0;
            }
        }
        if (max >= 4) {
            return true;
        }
        //判断斜向的棋子
        int x = row, y = col;
        max = 0;
        while (x >= 0 && x < ROW && y >= 0 && y < Col && chesses[x][y] == color) {
            x--;
            y--;
        }
        x++;
        y++;
        while (x >= 0 && x < ROW && y >= 0 && y < Col && chesses[x][y] == color) {
            max++;
            x++;
            y++;
        }
        if (max >= 4) {
            return true;
        }

        x = row;
        y = col;
        max = 0;
        while (x >= 0 && x < ROW && y >= 0 && y < Col && chesses[x][y] == color) {
            x--;
            y++;
        }
        x++;
        y--;
        while (x >= 0 && x < ROW && y >= 0 && y < Col && chesses[x][y] == color) {
            max++;
            x++;
            y--;
        }
        if (max >= 4) {
            return true;
        }
        return false;
    }

    private void aiGoOneStep()//电脑走一步棋的方法
    {
        jbtn_1.setEnabled(false);
        jbtn_2.setEnabled(false);
        jbtn_3.setEnabled(false);
        jbtn_4.setEnabled(false);
        jbtn_5.setEnabled(false);
        jbtn_6.setEnabled(false);
        jbtn_7.setEnabled(false);
        jbtn_8.setEnabled(false);
        int cal=0;
        int row = 0;
        do {
            cal = new Random().nextInt(Col);
        } while (chesses[0][cal] != NONE);

        for (int i = ROW - 1; i >= 0; i--) {
            if (chesses[i][cal] == NONE) {
                chesses[i][cal] = AIColor;
                row = i;
                break;
            }
        }
        whitchColor = -whitchColor;
        goOneStep(row, cal, AIColor);
        if (!flag) {
            jbtn_1.setEnabled(true);
            jbtn_2.setEnabled(true);
            jbtn_3.setEnabled(true);
            jbtn_4.setEnabled(true);
            jbtn_5.setEnabled(true);
            jbtn_6.setEnabled(true);
            jbtn_7.setEnabled(true);
            if (C_specifications == 1) {
                jbtn_8.setEnabled(true);
            }
        }
    }

    //判断棋盘是否已满 平局
    private boolean isFull() {
        for (int i = 0; i < Col; i++) {
            if (chesses[0][i] == NONE) {
                return false;
            }
        }
        return true;
    }
}
