package com.java;
import javax.swing.*;
import java.awt.*;

public class JProcessBar extends JFrame {

    // 得到显示器屏幕的宽高
    public static int width = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int height = Toolkit.getDefaultToolkit().getScreenSize().height;
    // 定义窗体的宽高
    public static int windowsWedth = 600;
    public static int windowsHeight = 600;

    private static final long serialVersionUID = 1L;

    private JProgressBar progressBar = new JProgressBar();


    private boolean state = false;
    private int count = 0;

    // 工作线程workThead
    private Thread workThead = null;
    private Runnable run = null;


    public static void main(String[] args) {

        JProcessBar jp = new JProcessBar();
        jp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jp.setVisible(true);
    }

    /**
     * Create the application.
     */
    public JProcessBar() {

        initialize();
    }
    JLabel lblNewLabel_1 = new JLabel("");
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setTitle("\u52A0\u8F7D\u4E2D");
        this.setBounds((width - windowsWedth) / 2, (height - windowsHeight) / 2, 545, 186);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);
        progressBar.setForeground(Color.BLACK);
        progressBar.setStringPainted(true);
        progressBar.setOpaque(false);
        progressBar.setBounds(73, 103, 434, 24);
        this.getContentPane().add(progressBar);

        JLabel lblNewLabel = new JLabel("\u8FDB\u5EA6\u52A0\u8F7D\uFF1A");
        lblNewLabel.setBounds(10, 106, 68, 15);
        this.getContentPane().add(lblNewLabel);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBounds(73, 80, 235, 24);
        getContentPane().add(lblNewLabel_1);

        if (workThead == null) {
            state = true;
            workThead = new WorkThead();
            workThead.start();
        }
    }
    class WorkThead extends Thread {

        public void run() {

            while (count < 100) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                if (state) {
                    count++;
                    SwingUtilities.invokeLater(new Runnable() {

                        @Override
                        public void run() {
                            // TODO Auto-generated method stub
                            // 更新操作通过事件派发线程完成（一般实现Runnable()接口）
                            progressBar.setValue(count);
                            if(count==5){
                                lblNewLabel_1.setText("loading api-ms-win-core-xstate-l1-1-0.dll");
                            }else if(count==10){
                                lblNewLabel_1.setText("loading MaxxAudioAPO5064.dll");
                            }else if(count==20){
                                lblNewLabel_1.setText("loading MetroIntelGenericUIFramework.dll");
                            }else if(count==30){
                                lblNewLabel_1.setText("loading microsoft-windows-kernel-power-events.dll");
                            }else if(count==40){
                                lblNewLabel_1.setText("miguiresource.dll");
                            }else if(count==80){
                                lblNewLabel_1.setText("loading mfvdsp.dll");
                            }else if(count==90){
                                lblNewLabel_1.setText("loading miguiresource.dll");
                            }else if(count==100){
                                lblNewLabel_1.setText("loading end");
                                Thread.currentThread();
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    // TODO 自动生成的 catch 块
                                    e.printStackTrace();
                                }

                            }
                        }
                    });
                }
            }
        }

    }
}