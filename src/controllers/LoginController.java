package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.UserDataAccess;
import views.LoginView;
import views.RegisterView;

public class LoginController {

	LoginView loginView;

	public LoginController(LoginView loginView) {

		this.loginView = loginView;

		loginView.addRegisterButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginView.setVisible(false);
				RegisterView rv = new RegisterView();
				RegisterContoller rc = new RegisterContoller(rv);
				rv.setVisible(true);
			}
		});

		loginView.addLoginButtonListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog(null, "Login successful");
				String user = loginView.getUsernameField();
				String password = loginView.getPasswordField();
				UserDataAccess userDataAccess = new UserDataAccess();

				if (userDataAccess.loginUser(user, password)) {
					JOptionPane.showMessageDialog(null, "Login successful");
//					lv.setVisible(true);
//					registerView.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, "Login failure");
				}
			}
		});
	}
}