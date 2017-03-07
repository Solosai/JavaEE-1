package com.xxx.controller.valueobject;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Getter;
import lombok.Setter;
/**
 * 影院店铺信息vo
 * 
 * @author author
 * @date 2016/02/16
 */
@Component
@JsonSerialize
@Setter@Getter
public class StudentInfoVo {
	
	private Integer id;

	private String studentName;

	private String studentAge;

	private String studentScore;


}
