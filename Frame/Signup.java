package Frame;
import java.lang.*;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import Entity.*;
import Repository.*;

public class Signup extends JFrame implements ActionListener


{
	private JLabel UserId,Name ,Pass;
	private JTextField UserIdTF,NameTF,PassTF;
	private JButton signupBtn,refreashBtn,loginBtn;
	private JPanel panel;
	public Signup()
	{
		super("Signup");

		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		panel = new JPanel();
		panel.setLayout(null);


		UserId = new JLabel("User ID : ");
		UserId.setBounds(200, 50, 80, 50);
		panel.add(UserId);

		Name = new JLabel("NAME : ");
		Name.setBounds(200, 150, 80, 50);
		panel.add(Name);


		/*Pass = new JLabel("PASSWORD : ");
		Pass.setBounds(200, 240, 80, 50);
		panel.add(Pass);*/

		UserIdTF = new JTextField();
		UserIdTF.setBounds(335, 50, 200, 50);
		UserIdTF.setBackground(Color.CYAN);
		panel.add(UserIdTF);

		NameTF = new JTextField();
		NameTF.setBounds(335, 150, 200, 50);
		NameTF.setBackground(Color.CYAN);
		panel.add(NameTF);

		/*PassTF = new JTextField();
		PassTF.setBounds(335, 240, 200, 50);
		PassTF.setBackground(Color.CYAN);
		panel.add(PassTF);*/

		signupBtn = new JButton("SIGNUP");
		signupBtn.setBounds(250, 270, 100, 50);
		signupBtn.setBackground(Color.RED);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);

		refreashBtn = new JButton("REFREASH");
		refreashBtn.setBounds(370, 270, 100, 50);
		refreashBtn.setBackground(Color.RED);
		refreashBtn.addActionListener(this);
		panel.add(refreashBtn);

		loginBtn = new JButton("LOGIN");
		loginBtn.setBounds(680, 20, 80, 30);
		loginBtn.setBackground(Color.RED);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		this.add(panel);

	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(refreashBtn.getText().equals(command))
		{
			UserIdTF.setText("");
			//PassTF.setText("");
			NameTF.setText("");
		}
		else if(command.equals(loginBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if (signupBtn.getText().equals(command))
		{
			CustomerRepo cr = new CustomerRepo();
			Customer c=new Customer();
			//Customer customer = cr.getUser(userTF.getText(), passPF.getText());
			c. setCustomerId(UserIdTF.getText());
			c.setName(NameTF.getText());
			cr .insertInDB(c);

			UserRepo ur = new UserRepo();
            Random rd = new Random();
			User u = new User();
			u.setUserId(c.getCustomerId());
			String x =rd.nextInt(899999)+"";
			u.setPassword(x);
			u.setStatus(1);
			ur.insertUser(u);
			JOptionPane.showMessageDialog(this,"PASSWORD: "+x);

			


		}
	}


}