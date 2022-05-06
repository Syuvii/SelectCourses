import java.awt.event.*;
import javax.swing.JOptionPane;
public class DropListen implements ActionListener { 
    static String DropNumber;
    void setString(String num){
        DropNumber = num;
    }
    public void actionPerformed(ActionEvent e) {
        DBUtil db = DBUtil.getDBUtil();
        String [] info = e.getActionCommand().split("\\s+");
        // for(int i =0;i<info.length;i++){
        //     System.out.println(info[i]);
        // }
        String sql = String.format("delete from class.choose where studentnumber = '%s' and courseid = '%s'",DropNumber,info[0]);
        int rs = db.executeUpdate(sql);
        if(rs == 1){
            JOptionPane.showMessageDialog(null, "退课成功,请刷新页面", "提示",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "退课失败,请刷新", "error",JOptionPane.ERROR_MESSAGE);
        }
        db.close();
   }
}

