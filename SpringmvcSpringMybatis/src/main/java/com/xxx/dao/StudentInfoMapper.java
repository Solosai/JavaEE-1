package com.xxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xxx.model.StudentInfo;

public interface StudentInfoMapper {
	
	public StudentInfo getById(@Param("id") Integer id);
	//增加
	public void addStudent(
			@Param("studentName") String studentName,
			@Param("studentAge") String studentAge,
			@Param("studentScore") String studentScore);
	//查看所有
	public List<StudentInfo> selectAll();
	//单个删除
	public void delStudentById(@Param("id") Integer id);
	//批量删除
	public void delStudentByIds(@Param("ids") Integer[] ids);
	//修改一个
	public void updateById(
			@Param("id") Integer id,
			@Param("studentName") String studentName,
			@Param("studentAge") String studentAge,
			@Param("studentScore") String studentScore);
	//批量修改
	public void updateByIds(
			@Param("ids") Integer[] ids,
			@Param("studentName") String studentName,
			@Param("studentAge") String studentAge,
			@Param("studentScore") String studentScore);

}
