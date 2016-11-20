package presentation.loginWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class LoginWindow extends JFrame {
	private static final long serialVersionUID = 1L;
    private Point origin; // 用于移动窗体
	// 用来设定窗体不规则样式的图片，这里只用它来创建窗体形状
	private BufferedImage img; 
	//用它来显示这张图片
	private ImageIcon background;
	//用户名输入框
	private JTextField userText = new JTextField(30);
	//密码输入框
	private JPasswordField passwordText = new JPasswordField(30);
	private JLabel userLabel = new JLabel("账 号:");
	private JLabel passwordLabel = new JLabel("密 码: ");
	private JButton okbtn = new JButton("确定");
    private JButton resert = new JButton("重置");
    private JButton register = new JButton("注册");
	
	
	public static void main(String[] args){
		LoginWindow login=new LoginWindow();
	
	}
	
	
	
	private void initialize() throws IOException{
		// 窗体初始化
	    // 设定窗体大小和图片一样大
	    this.setSize(img.getWidth(null), img.getHeight(null));
	    // 设定禁用窗体装饰，这样就取消了默认的窗体结构
	    this.setUndecorated(true);
	    // 初始化用于移动窗体的原点
	    this.origin = new Point();

	    

	    this.setLocationRelativeTo(null);
	    this.setAlwaysOnTop(true);
	    // 由于取消了默认的窗体结构，所以我们要手动设置一下移动窗体的方法
	    this.addMouseListener(new OwnListener());
	    //监听鼠标移动事件
	    addMouseMotionListener(new MouseMotionAdapter() {
	        public void mouseDragged(MouseEvent e) {
	            Point p = getLocation();
	            setLocation(p.x + e.getX() - origin.x,
	            		    p.y + e.getY() - origin.y);
	        }
	    });
	}
	
	
	
	
	public LoginWindow() {
	    super();

	    

	    background = new ImageIcon("C:\\Users\\Chris\\Desktop\\大二上\\loginFrame.png");
	    JLabel back = new JLabel(background);
	    back.setBounds(0, 0, background.getIconWidth(),
	            background.getIconHeight());
	    /*
	     * 首先初始化一张图片，我们可以选择一张有透明部分的不规则图片
	     *  (要想图片能够显示透明，必须使用PNG格式的图片)
	     */
	    MediaTracker mt = new MediaTracker(this);

	    try {
	        img = ImageIO.read(new File("C:\\Users\\Chris\\Desktop\\大二上\\loginFrame.png"));
	    } catch (IOException e1) {
	    	e1.printStackTrace();
	    }

	    mt.addImage(img, 0);

	    try {
	        mt.waitForAll(); // 开始加载由此媒体跟踪器跟踪的所有图像
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	    try {
	        initialize(); // 窗体形状初始化
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    addMenu();
	    this.add(back);
	    this.setVisible(true);
	}
	
	public void addMenu() {
        this.setLayout(null);
        //设置字体
        Font font = new Font("", 0, 18);
        userLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);
        userLabel.setFont(font);
        passwordLabel.setFont(font);
        passwordText.setEchoChar('*');

        userLabel.setBounds(80, 120, 100, 50);
        passwordLabel.setBounds(80, 160, 100, 50);
        userText.setBounds(140, 130, 170, 30);
        passwordText.setBounds(140, 170, 170, 30);
        okbtn.setBounds(81, 210, 60, 25);
        resert.setBounds(166, 210, 60, 25);
        register.setBounds(251, 210, 60, 25);

        this.add(userLabel);
        this.add(userText);
        this.add(passwordLabel);
        this.add(passwordText);
        this.add(okbtn);
        this.add(resert);
        this.add(register);

        okbtn.addMouseListener(new OwnListener());
        resert.addMouseListener(new OwnListener());
        register.addMouseListener(new OwnListener());
        userText.addKeyListener(new KeyOwnListener());
        passwordText.addKeyListener(new KeyOwnListener());

        userText.setText("20160601");
        passwordText.setText("84878323");
    }
	
	private class OwnListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e) {
	        origin.x = e.getX();
	        origin.y = e.getY();
	    }

	    
	    
	    boolean temp;
	    // 窗体上单击鼠标右键关闭程序
	    public void mouseClicked(MouseEvent e) {
	        //如果点击的区域位于右上角红色按钮，则关闭程序
	        if (temp) {
	            System.exit(0);
	        } else if (e.getSource() == okbtn) {
	            //验证用户是否合法，并打开主程序
	        } else if (e.getSource() == resert) {
	            userText.setText("");
	            passwordText.setText("");
	        } else if (e.getSource() == register) {
	            //打开注册页面 }
	        }

	        
	    }

}
	
	
	 private class KeyOwnListener extends KeyAdapter {
	        public void keyPressed(KeyEvent e) {
	            if (10 == e.getKeyCode()) {
	                //验证用户是否合法，合法打开主程序
	            }
	        }
	    }
}
