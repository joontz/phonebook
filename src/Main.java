
import java.sql.SQLException;

import controllers.LoginController;
import myutils.Util;
import views.LoginView;

public class Main {

	public static void main(String args[]) throws SQLException {

		LoginView loginView = new LoginView();
		LoginController loginController = new LoginController(loginView);
		loginView.setVisible(true);
		Util.getConnection();

//		RegisterView rv = new RegisterView();
//		RegisterContoller rc = new RegisterContoller(rv);
//		rv.setVisible(true);
	}
}
