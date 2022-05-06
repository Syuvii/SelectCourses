import java.awt.event.*;
import javax.swing.JOptionPane;
import java.sql.*;
public class SelectListen implements ActionListener { 
    boolean ok = true;
    static String SelectNumber;
    ResultSet rSet;
    void setString(String num){
        SelectNumber = num;
    }
    public void actionPerformed(ActionEvent e) {
        DBUtil db = DBUtil.getDBUtil();
        String [] info = e.getActionCommand().split("\\s+");
        try{
            rSet = db.executeQuery("select courseid from choose where studentnumber = "+SelectNumber);
            while(rSet.next()){
                if(rSet.getString("courseid").equals(info[0])){
                    JOptionPane.showMessageDialog(null, "选课失败,已经选了这门课,请刷新", "error",JOptionPane.ERROR_MESSAGE);
                    ok = false;
                }
            }
        }
        catch(SQLException f){
        }
        if(ok){
            String sql = String.format("insert into class.choose (studentnumber,courseid,coursename,courseteacher) values('%s','%s','%s','%s');",SelectNumber,info[0],info[1],info[2]);
            int rs = db.executeUpdate(sql);
            if(rs == 1){
                JOptionPane.showMessageDialog(null, "选课成功,请刷新页面", "提示",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null, "选课失败", "error",JOptionPane.ERROR_MESSAGE);
            }

        }
        db.close();
   }
}

