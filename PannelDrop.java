import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.sql.*;
public class PannelDrop extends JPanel{
    JButton button,buttonx;
    JLabel label;
    Box box;
    DBUtil db = DBUtil.getDBUtil();
    String number,sql;
    ResultSet rs;
    DropListen listen;
    public PannelDrop(String num)
    {
        number = num;
        init();
        setVisible(true);
    }
    void init(){
        listen = new DropListen();
        listen.setString(number);
        button = new JButton("刷新");
        box = Box.createVerticalBox();
        box.add(new JLabel("课程号    课程名    任课教师"));
        box.add(Box.createVerticalStrut(10));
        sql = "select courseid,coursename,courseteacher from choose where studentnumber = "+number;
        try{
            rs = db.executeQuery(sql);
            while(rs.next()){
                // label.setText(rs.getString("id")+"    "+rs.getString("name")+"    "+rs.getString("teacher"));
               
                buttonx = new JButton(rs.getString("courseid")+"    "+rs.getString("coursename")+"    "+rs.getString("courseteacher"));
                buttonx.addActionListener(listen);
                box.add(buttonx);
                box.add(Box.createVerticalStrut(20));
            }
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    removeAll();
                    updateUI();
                    init();
                    repaint();                   
                }
            });
            box.add(button);
            add(box);
        }
        catch(SQLException e){

        }
        
    }
}
