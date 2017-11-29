package com.example.demo.domain;

public class JwtUser {
	private long id;
    private String userName;
    private String password;
    private String role;

    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

	@Override
	public String toString() {
		return "JwtUser [id=" + id + ", userName=" + userName + ", password=" + password + ", role=" + role + "]";
	}
}
