package com.demo.blog;

import com.jfinal.plugin.activerecord.Page;

public class BlogService {
	public Page<Blog> paginate(BlogPageInfo pi) {
		Page<Blog> pageBlog = Blog.dao.paginate(pi.pageNum, pi.numPerPage,
				"select b.*,u.name uname",
				"from blog b left join user u on(b.userId=u.id) "
						+ addCriteria(pi) + "order by " + pi.orderName + " "
						+ pi.orderType);
		return pageBlog;
	}

	private String addCriteria(BlogPageInfo pi) {
		StringBuffer criteriaSql = new StringBuffer(" where 1=1 ");
		if (pi.title!=null) {
			criteriaSql.append(" and b.title like '%"+pi.title.trim()+"%' ");
		}
		if (pi.content!=null) {
			criteriaSql.append(" and b.content like '%"+pi.content.trim()+"%' ");
		}
		return criteriaSql.toString();
	}

}
