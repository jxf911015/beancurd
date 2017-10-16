package com.xiangfei.beancurd.pojo;

import java.util.Date;

public class Admin {
    private Integer id;

    private String avatar;

    private String admname;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private String admnum;

    private Integer fans;

    private Date createTime;

    private Date updateTime;

    private String introduction;

    private String introduce;

    private String outaddress;

    private String inaddress;

    private String telenumber;

    private String returnpolicy;

    private Integer indormer;

    private String nickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getAdmname() {
        return admname;
    }

    public void setAdmname(String admname) {
        this.admname = admname == null ? null : admname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getAdmnum() {
        return admnum;
    }

    public void setAdmnum(String admnum) {
        this.admnum = admnum == null ? null : admnum.trim();
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public String getOutaddress() {
        return outaddress;
    }

    public void setOutaddress(String outaddress) {
        this.outaddress = outaddress == null ? null : outaddress.trim();
    }

    public String getInaddress() {
        return inaddress;
    }

    public void setInaddress(String inaddress) {
        this.inaddress = inaddress == null ? null : inaddress.trim();
    }

    public String getTelenumber() {
        return telenumber;
    }

    public void setTelenumber(String telenumber) {
        this.telenumber = telenumber == null ? null : telenumber.trim();
    }

    public String getReturnpolicy() {
        return returnpolicy;
    }

    public void setReturnpolicy(String returnpolicy) {
        this.returnpolicy = returnpolicy == null ? null : returnpolicy.trim();
    }

    public Integer getIndormer() {
        return indormer;
    }

    public void setIndormer(Integer indormer) {
        this.indormer = indormer;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", avatar=" + avatar + ", admname="
				+ admname + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", question=" + question + ", answer="
				+ answer + ", role=" + role + ", admnum=" + admnum + ", fans="
				+ fans + ", createTime=" + createTime + ", updateTime="
				+ updateTime + ", introduction=" + introduction
				+ ", introduce=" + introduce + ", outaddress=" + outaddress
				+ ", inaddress=" + inaddress + ", telenumber=" + telenumber
				+ ", returnpolicy=" + returnpolicy + ", indormer=" + indormer
				+ ", nickname=" + nickname + "]";
	}
    
    
}