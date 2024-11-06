package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.UserDataAccess;
import views.LoginView;
import views.RegisterView;

public class RegisterContoller {

	private RegisterView registerView;

	public RegisterContoller(RegisterView rv) {
		this.registerView = rv;
		LoginView lv = new LoginView();
		LoginController lc = new LoginController(lv);

		registerView.addRegisterButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String user = rv.getUsername();
				String password = rv.getPassword();
				String passwordConfirm = rv.getConfirmPassword();

				if (!password.equals(passwordConfirm)) {
					JOptionPane.showMessageDialog(null, "Passwords do not match");
				} else {
					UserDataAccess userDataAccess = new UserDataAccess();

					if (userDataAccess.registerUser(user, password)) {
						JOptionPane.showMessageDialog(null, "Registered successfully");
						lv.setVisible(true);
						registerView.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, "Register failure");
					}
				}
			}
		});

		registerView.addLoginButtonListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lv.setVisible(true);

				registerView.setVisible(false);
			}
		});
	}

}