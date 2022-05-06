import java.awt.BorderLayout;
import javax.swing.*;
public class ManageFrame extends JFrame{
    JTabbedPane p;
    JScrollPane s1,s2;
    PannelDrop drop;
    PannelSelect select;
    PannelChangePwd changePwd;
    String number;
    public ManageFrame(String num){
        number = num;
        init();
        setBounds(200, 200, 400, 400);
        setTitle("选课系统");
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    void init(){
        select = new PannelSelect(number);
        drop = new PannelDrop(number);
        s1 = new JScrollPane(select);
        s2 = new JScrollPane(drop);
        
        changePwd = new PannelChangePwd(number);
        p = new JTabbedPane();
        p.add("选课",s1);
        p.add("退课",s2);
        p.add("更改密码", changePwd);
        add(p,BorderLayout.CENTER);
    }
}
