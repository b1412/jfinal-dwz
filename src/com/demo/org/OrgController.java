package com.demo.org;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.blog.User;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.render.DwzRender;

public class OrgController extends Controller {

	public void index() {
		System.out.println(getParaToInt("numPerPage"));
		String orgNum = getPara("orgNum");
		String orgName = getPara("orgName");
		String orgParentNum = getPara("orgParentNum");
		String leader = getPara("leader");
		System.out.println(orgNum+"," + orgName+"," +orgParentNum+"," +leader);
		Page<Org> page = Org.dao.paginate(getParaToInt("pageNum", 1), getParaToInt("numPerPage", 20), "select *",
				"from org  order by id asc");
		setAttr("page", page);
//		int lookup = getParaToInt("lookup", -1);
		setAttr("lookup", getParaToInt("lookup", -1));
//		render("page.html");
		renderFreeMarker("page.html");
	}

	public void save() {
		Org org = getModel(Org.class);
		List<User> users = new ArrayList<User>();
		int size = getAttrForInt("users.size");
		for (int i = 0; i < size; i++) {
			User user = getModel(User.class, "users[" + i + "]");
			if (user != null) {
				users.add(user);
			}
		}
		System.out.println("org:" + org + "\n" + " users:" + Arrays.toString(users.toArray()) + "\nsize:" + size);
		org.save();
		for (Model user : users) {
			user.save();
		}
		render(DwzRender.closeCurrentAndRefresh("page"));
	}
}
