package com.xxx.service;

import java.util.List;

import com.xxx.model.StudentInfo;

public interface IStudentInfoService {
	
	/**
	 * 根据店铺的编码和密码查询店铺信息
	 * @param shopNo 店铺编码
	 * @param password 密码
	 * @return 店铺信息
	 * @throws Exception 
	 */
	public StudentInfo getStudentById(Integer id) throws Exception;
	//增加产品
	public void addStudentInfo(StudentInfo studentInfo) throws Exception;
	//查看所有
	public List<StudentInfo> showAll() throws Exception;
	//单个删除
	public void delById(Integer id) throws Exception;
	//批量删除
	public void delByIds(Integer[] ids) throws Exception;
	public void updateById(StudentInfo studentInfo) throws Exception;
	public void updateByIds(StudentInfo studentInfo)throws Exception;

}
