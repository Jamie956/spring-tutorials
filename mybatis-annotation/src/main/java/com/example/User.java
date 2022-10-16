package com.example;

public class User {
	private Long id;
	private String userName;
	private UserSex userSex;
	private String nickName;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String userName, UserSex userSex, String nickName) {
		super();
		this.id = id;
		this.userName = userName;
		this.userSex = userSex;
		this.nickName = nickName;
	}
	public User(String userName, UserSex userSex, String nickName) {
		super();
		this.userName = userName;
		this.userSex = userSex;
		this.nickName = nickName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public UserSex getUserSex() {
		return userSex;
	}
	public void setUserSex(UserSex userSex) {
		this.userSex = userSex;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userSex=" + userSex + ", nickName=" + nickName + "]";
	}
	
}