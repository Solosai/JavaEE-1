package com.xxx.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.StudentInfoMapper;
import com.xxx.model.StudentInfo;
import com.xxx.service.IStudentInfoService;



@Service("studentInfoService")
public class StudentInfoService implements IStudentInfoService{
	
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public StudentInfoMapper studentInfoMapper;

	//获取学生信息通过id
	@Override
	public StudentInfo getStudentById(Integer id) throws Exception {
	
		return studentInfoMapper.getById(id);
	}
//增加商店信息
	@Override
	public void addStudentInfo(StudentInfo studentInfo) throws Exception {
		String studentName=studentInfo.getStudentName();
		String studentAge=studentInfo.getStudentAge();
		String studentScore=studentInfo.getStudentScore();
		studentInfoMapper.addStudent(studentName, studentAge, studentScore);
	}
//获取所有信息
	@Override
	public List<StudentInfo> showAll() throws Exception {
		
		return studentInfoMapper.selectAll();
	}
//删除单个
	@Override
	public void delById(Integer id) throws Exception {
		
		studentInfoMapper.delStudentById(id);
	}
//删除多个
	@Override
	public void delByIds(Integer[] ids) throws Exception {
		
		studentInfoMapper.delStudentByIds(ids);
	}
//修改一个
	@Override
	public void updateById(StudentInfo studentInfo) throws Exception {
		Integer id=studentInfo.getId();
		String studentName=studentInfo.getStudentName();
		String studentAge=studentInfo.getStudentAge();
		String studentScore=studentInfo.getStudentScore();
		studentInfoMapper.updateById(id, studentName, studentAge, studentScore);
		
	}
//修改多个
	@Override
	public void updateByIds(StudentInfo studentInfo) throws Exception {
		Integer[] upIds = studentInfo.getIds();
		String studentName=studentInfo.getStudentName();
		String studentAge=studentInfo.getStudentAge();
		String studentScore=studentInfo.getStudentScore();
		studentInfoMapper.updateByIds(upIds, studentName, studentAge, studentScore);
		
	}

}
