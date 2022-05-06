import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PannelChangePwd extends JPanel{
    JTextField password;
    JButton button;
    ChangePwdListen listen;
    String number;
    public PannelChangePwd(String num)
    {
        number = num;
        init();
        setVisible(true);
    }
    void init(){
        listen = new ChangePwdListen();
        password = new JTextField(10);
        button = new JButton("确定更改");
        add(password);
        add(button);
        listen.setJTextField(password);
        listen.setString(number);
        button.addActionListener(listen);
    }
}
