package views;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView extends JFrame {

	// controls or components needed
	private JTextField usernameField;
	private JPasswordField passwordField, confirmPassword;
	private JButton registerButton, loginButton;

	public RegisterView() {

		setTitle("Register");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// initialize the components
		usernameField = new JTextField(10);
		passwordField = new JPasswordField(10);
		confirmPassword = new JPasswordField(10);
		registerButton = new JButton("Register");
		loginButton = new JButton("Login");

		JPanel panel = new JPanel(new GridLayout(5, 2));
		panel.add(new JLabel("Username: "));
		panel.add(usernameField);

		panel.add(new JLabel("Password: "));
		panel.add(passwordField);

		panel.add(new JLabel("Confirm password: "));
		panel.add(confirmPassword);

		panel.add(loginButton);
		panel.add(registerButton);

		add(panel);

		setVisible(true);
	}

	public void addLoginButtonListener(ActionListener listener) {
		loginButton.addActionListener(listener);
	}

	public void addRegisterButtonListener(ActionListener listener) {
		registerButton.addActionListener(listener);
	}

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return new String(passwordField.getText());
	}

	public String getConfirmPassword() {
		return new String(confirmPassword.getText());
	}
}