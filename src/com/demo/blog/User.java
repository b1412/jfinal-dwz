package com.demo.blog;

import com.jfinal.plugin.activerecord.Model;

/**
 * User model.
 */
@SuppressWarnings("serial")
public class User extends Model<User> {
	public static final User dao = new User();
}