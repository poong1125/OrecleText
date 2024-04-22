package d0418_Login;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class Button1 extends WindowAdapter {
	public Button1() {
		Frame f = new Frame("Login");
		f.setSize(400,150);
		f.setLayout(new FlowLayout());
		
		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ",Label.RIGHT);		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		Label qwer = new Label("로그인 시도해", Label.RIGHT);
		
		Button b = new Button("확인");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = id.getText();
                String enteredPwd = pwd.getText();
                   
                InfoDAO1 dao = new InfoDAO1();
        		ArrayList<InfoVo1> list = dao.list();
        		InfoVo1 data = (InfoVo1)list.get(0);
            	String ID = data.getId();
            	String PWD = data.getPwd();
            	
            	
            	if (enteredId.equals(ID) && enteredPwd.equals(PWD)) {
                	qwer.setText("한화 우승");
                	System.out.println("한화 우승");
                } else {
                	qwer.setText("로그인 실패");
                	System.out.println("로그인 실패");
                }
                
            }
        });
        
		
		
		f.add(lid);
		f.add(id);
		f.add(lpwd);
		f.add(pwd);
		f.add(b);
		f.add(qwer);
		f.setVisible(true);
		f.addWindowListener(this);
	}
	public void windowClosing(WindowEvent e) {
		 System.exit(0);
	 }
}
