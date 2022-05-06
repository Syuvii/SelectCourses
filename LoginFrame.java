import javax.swing.*;
import java.awt.*;
public class LoginFrame extends JFrame{
	QuitListen qt_listen;
	LoginListen lg_listen;
	Box boxH1,boxH2;
	Box boxV1,boxV2;
	JButton button1,button2;
	JLabel label1,label2;
	JTextField accountfield;
	JPasswordField passwordField;
	public LoginFrame(){
		setLayout(new FlowLayout());
		init();
		setBounds(800,200,300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	void init(){
		qt_listen = new QuitListen();
		lg_listen = new LoginListen();
		boxH1 =Box.createHorizontalBox();
		boxH2 =Box.createHorizontalBox();
		boxV1 = Box.createVerticalBox();
		boxV2 = Box.createVerticalBox();
		button1 = new JButton("登录");
		button2 = new JButton("退出");		
		label1 = new JLabel("账号:");
		label1.setFont(new Font("宋体",Font.BOLD,18));
		label2 = new JLabel("密码:");
		label2.setFont(new Font("宋体",Font.BOLD,18));
		accountfield = new JTextField(10);
		passwordField = new JPasswordField(10);

		lg_listen.setJTextField(accountfield);
		lg_listen.setJPasswordField(passwordField);

		button1.addActionListener(lg_listen);
		button2.addActionListener(qt_listen);

		boxV1.add(label1);
		boxV1.add(label2);
		boxV1.add(Box.createVerticalStrut(30));

		boxV2.add(accountfield);
		boxV2.add(passwordField);
		boxV2.add(Box.createVerticalStrut(30));

		boxH1.add(boxV1);
		boxH1.add(Box.createHorizontalStrut(60));
		boxH1.add(boxV2);

		boxH2.add(button1);
		boxH2.add(Box.createHorizontalStrut(40));
		boxH2.add(button2);
		add(boxH1);
		add(boxH2);	

	}
}