package com.demo.common;

import com.jfinal.core.Controller;
import com.jfinal.ext.render.CaptchaRender;

/**
 * CommonController
 */
public class CommonController extends Controller {

	private static final String RANDOM_CODE_KEY = "1";

	public void index() {
		renderFreeMarker("/index.html");
	}

	public void login() {
		String inputRandomCode = getPara("inputRandomCode");
		boolean loginSuccess = CaptchaRender.validate(this, inputRandomCode, RANDOM_CODE_KEY);
		if (loginSuccess) {
			render("/common/index.jsp");
		}else{
			index();
		}
	}

	public void img() {
		CaptchaRender img = new CaptchaRender(RANDOM_CODE_KEY);
		render(img);

	}
}
