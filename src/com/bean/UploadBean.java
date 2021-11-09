package com.bean;

import java.io.InputStream;
import java.util.ArrayList;

public class UploadBean {
	
	private String year,guidename,groupno,branch,domain,title,filename,introduction,guide_status;
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getGuide_status() {
		return guide_status;
	}
	public void setGuide_status(String guide_status) {
		this.guide_status = guide_status;
	}
	//private ArrayList<String> introduction;
	InputStream file;
	
	public String getGuidename() {
		return guidename;
	}
	public void setGuidename(String guidename) {
		this.guidename = guidename;
	}
	public String getGroupno() {
		return groupno;
	}
	public void setGroupno(String groupno) {
		this.groupno = groupno;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public InputStream getFile() {
		return file;
	}
	public void setFile(InputStream file) {
		this.file = file;
	}
	
}
