package com.yc.wexin.bean;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author SFYX
 *
 */
public class User {
	private Integer id;
	private String userName;
	private String passWord;
	private String safeQuestion;
	private String safeAnswer;

	private Set<String> likeBook;

	public User(Integer id, String uName, String passWord, Set likeBook) {
		super();
		this.id = id;
		this.userName = uName;
		this.passWord = passWord;
		this.likeBook = likeBook;
	}

	public String getSafeQuestion() {
		return safeQuestion;
	}

	public void setSafeQuestion(String safeQuestion) {
		this.safeQuestion = safeQuestion;
	}

	public String getSafeAnswer() {
		return safeAnswer;
	}

	public void setSafeAnswer(String safeAnswer) {
		this.safeAnswer = safeAnswer;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getuName() {
		return userName;
	}

	public void setuName(String uName) {
		this.userName = uName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Set getLikeBook() {
		return likeBook;
	}

	public void setLikeBook(Set<String> likeBook) {
		this.likeBook = likeBook;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", passWord=" + passWord + ", safeQuestion=" + safeQuestion
				+ ", safeAnswer=" + safeAnswer + ", likeBook=" + likeBook + "]";
	}

}
