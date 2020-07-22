package com.couyis.base.file.bean;

import org.springframework.util.StringUtils;

import com.couyis.common.web.bean.PageBean;

public class FileBean extends PageBean {
	private String fileName;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String fieldConvert(String field) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field)) {
			switch (field) {
			case "fileName":
				return "FILE_NAME";
			case "path":
				return "PATH";
			case "group":
				return "GROUP";
			case "size":
				return "SIZE_";
			case "download":
				return "DOWNLOAD";
			case "createTime":
				return "CREATE_TIME";
			default:
				return "";
			}
		}
		return "";
	}

}
