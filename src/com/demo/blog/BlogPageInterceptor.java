package com.demo.blog;

import com.jfinal.ext.interceptor.PageInfoInterceptor;

public class BlogPageInterceptor extends PageInfoInterceptor {

    @Override
    public void config() {
        setModel(Blog.class).addRelation(User.class, "blog.userid = user.id");
    }

}
