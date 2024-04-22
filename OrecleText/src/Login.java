import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login  extends WindowAdapter{
	public static void main(String[] args) {
		Frame f = new Frame("Login");
		f.setSize(400,150);
		f.setLayout(new FlowLayout());
		
		Label lid = new Label("ID : ", Label.RIGHT);
		Label lpwd = new Label("Password : ",Label.RIGHT);		
		TextField id = new TextField(10);
		TextField pwd = new TextField(10);
		pwd.setEchoChar('*');
		Label qwer = new Label("로그인해봐", Label.RIGHT);
		
		
		
		Button b = new Button("확인");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredId = id.getText();
                String enteredPwd = pwd.getText();
                if (enteredId.equals("green") && enteredPwd.equals("ujb1234")) {
                	qwer.setText("와");
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
		
		f.addWindowListener(new Login());
	}
	public void windowClosing(WindowEvent e) {
		 System.exit(0);
	 }
		
}
