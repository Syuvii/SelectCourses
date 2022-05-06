import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class ChangePwdListen implements ActionListener{
    DBUtil db = DBUtil.getDBUtil();
    JTextField password;
    String number;
    public void setJTextField(JTextField t){
        password = t;
    }
    public void setString(String t){
        number = t;
    }
    public void actionPerformed(ActionEvent e){       
        String pwd = new String(password.getText());
        String sql = new String("update students set password = '"+pwd+"' where number = "+number);
        int rs = db.executeUpdate(sql);
        if(rs == 1){
            JOptionPane.showMessageDialog(null, "你的密码已更改为:\n"+pwd, "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "更改失败", "error",JOptionPane.ERROR_MESSAGE);
        }
        db.close();    
    }
}