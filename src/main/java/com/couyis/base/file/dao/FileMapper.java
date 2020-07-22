package com.couyis.base.file.dao;

import java.util.List;

import com.couyis.base.file.bean.FileBean;
import com.couyis.base.file.pojo.File;

public interface FileMapper {
	Integer findCount(FileBean fileBean);

	List<File> findPage(FileBean fileBean);

	List<File> findAll();

	File findById(String id);

	int deleteById(String id);

	int save(File file);

	int update(File file);
}
