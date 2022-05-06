import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;
public class LoginListen implements ActionListener{
    DBUtil db = DBUtil.getDBUtil();
    JTextField account;
    JPasswordField password;
    public void setJTextField(JTextField t){
        account = t;
    }
    public void setJPasswordField(JPasswordField t){
        password = t;
    }
    public void actionPerformed(ActionEvent e){
        String act;
        String pwd = new String(password.getPassword());
        if(account.getText().isEmpty())
        {
            act = "0000";
        }
        else{
            act = new String(account.getText());
        }
        String sql = new String("select password from students where number="+act);
        ResultSet rs = db.executeQuery(sql);
        try{
            while(rs.next()){
                if (rs.getString("password").equals(pwd)){
                    
                    new ManageFrame(act);
                }
                else{
                    JOptionPane.showMessageDialog(null, "账号密码错误", "error",JOptionPane.ERROR_MESSAGE);
                }
            }           
            db.close();
        }
        catch(SQLException f){
            JOptionPane.showMessageDialog(null, "未知错误", "error",JOptionPane.ERROR_MESSAGE);
        }
            
    }
}