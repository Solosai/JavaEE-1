package com.xxx.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class StudentInfo implements Serializable{

	private static final long serialVersionUID = -205189814706545519L;

	private Integer[] ids;

	private Integer id;

	private String studentName;

	private String studentAge;

	private String studentScore;


}
