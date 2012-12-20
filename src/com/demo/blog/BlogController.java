package com.demo.blog;

import java.util.List;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.render.DwzRender;
import com.jfinal.upload.UploadFile;

/**
 * BlogController
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
	// @Before(CacheInterceptor.class)
	// @CacheName(value = "list")

	private BlogService blogService = new BlogService();

	@Before(BlogPageInfo.class)
	public void index() {
		BlogPageInfo pageInfo = getAttr("pageInfo");
		setAttr("page", blogService.paginate(pageInfo));
		render("page.html");
	}

	@Before(BlogValidator.class)
	public void save() {
		Blog model = getModel(Blog.class);
		if (model.getInt("id") == null) {
			model.save();
		} else {
			model.update();
		}
		render(DwzRender.closeCurrentAndRefresh("pageBlog"));
	}

	public void edit() {
		int id = getParaToInt(0,-1);
		Blog blog = Blog.dao.findById(id);
		if (id == -1) {
			blog = new Blog();
		} else if (blog == null) {
			render(DwzRender.error("该记录已被删除，请您先刷新列表"));
		}
		setAttr("blog", blog);
	}

	public void delete() {
		Blog.dao.deleteById(getParaToInt());
		render(DwzRender.success());
	}

	public void upload() {
		List<UploadFile> files = getFiles();
		System.out.println(getPara("text"));
		System.out.println(files);
	}

	public void download() {
		renderFile("/upload/JFinal-1.0.8-手册.pdf");
	}

}
