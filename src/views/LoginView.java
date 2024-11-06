package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {

	private JTextField usernameField;
	private JPasswordField passwordField;

	private JButton loginButton, registerButton;

	public LoginView() {
		setTitle("Login");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Initialize the components
		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);

		// create panel object with grid layout
		JPanel panel = new JPanel(new GridLayout(4, 2));

		// add the labels and corresponding fields
		panel.add(new JLabel("Username: "));
		panel.add(usernameField);
		panel.add(new JLabel("Password: "));
		panel.add(passwordField);

		// add the buttons to the panel
		registerButton = new JButton("Register");
		loginButton = new JButton("Login");

		panel.add(registerButton);
		panel.add(loginButton);

		add(panel); // add panel to the window

		setVisible(true); // make the window visible
	}

	public String getUsernameField() {
		return new String(usernameField.getText());
	}

	public void setUsernameField(JTextField usernameField) {
		this.usernameField = usernameField;
	}

	public String getPasswordField() {
		return new String(passwordField.getText());
	}

	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	// Add an action listener to the login button
	public void addLoginButtonListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}

	public void addRegisterButtonListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}
}
