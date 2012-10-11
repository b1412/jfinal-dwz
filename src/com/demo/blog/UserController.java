package com.demo.blog;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class UserController extends Controller {
	private User userDao = User.dao;

	public void index() {
		Page<User> pageBlog = userDao.paginate(1, 10, "select *", " from user order by id asc");
		setAttr("page", pageBlog);
		setAttr("list", pageBlog.getList());
		render("user.jsp");
	}

	public void add() {

	}

	@Before(UserValidator.class)
	public void save() {
		User model = getModel(User.class);
		System.out.println(model);
		System.out.println(getPara("rePwd"));
		model.save();
		index();
	}

	public void edit() {
	}

	public void update() {
	}

	public void delete() {
		String para = getPara("user.id");
		userDao.deleteById(para);
		index();
	}

}
