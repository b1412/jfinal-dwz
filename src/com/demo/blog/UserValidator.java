package com.demo.blog;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class UserValidator extends Validator {

	protected void validate(Controller controller) {
		validateEqualString("user.pwd", "rePwd", "pwdErrMsg", "密码不一致");
	}

	protected void handleError(Controller controller) {
		controller.keepModel(User.class);
		String actionKey = getActionKey();
		if (actionKey.equals("/user/save"))
			controller.render("add.jsp");
		else if (actionKey.equals("/user/update"))
			controller.render("edit.jsp");
	}
}
