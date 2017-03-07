package com.xxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xxx.controller.valueobject.ShopInfoVO;
import com.xxx.controller.valueobject.StudentInfoVo;
import com.xxx.model.SmiShopInfo;
import com.xxx.model.StudentInfo;
import com.xxx.service.ISmiShopInfoService;
import com.xxx.service.IStudentInfoService;

/**
 * 影院店铺信息action
 * 
 * @author author
 * @date 2016/02/16
 */
@Controller
//@RequestMapping(value = "/pages")
public class ShopInfoAction {

	private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ISmiShopInfoService smiShopInfoService;
	
	@Autowired
	private IStudentInfoService studentInfoService;
	
	private Integer[] upIds;
	
	StudentInfoVo vo= new StudentInfoVo();

	private String studentName;

	private String studentAge;
	

	private String studentScore;
	
	/**
	 * 用户登录
	 * 
	 * @ResponseBody 设置该参数，指定response的type为比如json或xml，本文采用json序列化方式传输数据
	 * 
	 * @param request
	 * @param response
	 * @param shopNo
	 * @param password
	 * @return
	 * @throws Exception
	 */
	//登录成功jsp页面
	@RequestMapping(value = "/success.do")
	public String inputProduct(HttpServletRequest request) {
		request.setAttribute("vo", vo);
		logger.info("show！");
		return "redirect:/list.do";
	}
	//登录页面
	@RequestMapping(value = "/login.do")
	public @ResponseBody ShopInfoVO login(HttpServletRequest request,HttpServletResponse response,String shopNo,String password) throws Exception {
		
		SmiShopInfo shopInfo = smiShopInfoService.getShopByNoAndPwd(shopNo, password);
		if(null==shopInfo||"".equals(shopInfo)){
			
			logger.warn(shopNo+"：登录失败，用户名或密码错误");
			return null;
		}else{
			ShopInfoVO vo = new ShopInfoVO();
			vo.setId(shopInfo.getId());
			vo.setShopNo(shopInfo.getShopNo());
			vo.setShopName(shopInfo.getShopName());
			vo.setShopPassword("");//密码不传输到页面
			vo.setShopType(shopInfo.getShopType());
			vo.setNote(shopInfo.getNote());
			
			logger.info(shopInfo.getShopName()+"["+shopNo+"]：登录成功");
			return vo;
		}
		
	}
	
	//增加学生信息
	@RequestMapping(value = "/add.do",method=RequestMethod.POST)
	public String addStudentInfoVo(StudentInfoVo studentInfoVo,HttpServletRequest request) throws Exception{
		logger.info("addStudentInfoVo被调用！");
		
		StudentInfo studentInfo=new StudentInfo();
		studentInfo.setStudentName(studentInfoVo.getStudentName());
		studentInfo.setStudentAge(studentInfoVo.getStudentAge());
		studentInfo.setStudentScore(studentInfoVo.getStudentScore());
		
		studentInfoService.addStudentInfo(studentInfo);
		
		return "redirect:/list.do";
		
	}
	// 查看所有信息
		@RequestMapping(value = "/list.do")
		public String showProduct(HttpServletRequest request) throws Exception {
			List<StudentInfo> voList = studentInfoService.showAll();
			request.setAttribute("voList", voList);
			return "success";
		}

		// 根据id删除产品
		@RequestMapping(value = "/delById.do")
		public String delStuductById(@RequestParam Integer id, HttpServletRequest request) throws Exception {
			studentInfoService.delById(id);
			return "redirect:/list.do";
		}

		// 根据ids删除学生信息
		@RequestMapping(value = "/delByIds.do")
		public String delStudentByIds(@RequestParam("checked") Integer[] ids, HttpServletRequest request) throws Exception {
			studentInfoService.delByIds(ids);

			return "redirect:/list.do";
		}

		// 修改页面跳转
		@RequestMapping(value = "/updateOne.do")
		public String updateOne(@RequestParam Integer id, HttpServletRequest request) throws Exception {
			StudentInfo studentInfo = studentInfoService.getStudentById(id);
			vo.setId(studentInfo.getId());
			vo.setStudentName(studentInfo.getStudentName());
			vo.setStudentAge(studentInfo.getStudentAge());
			vo.setStudentScore(studentInfo.getStudentScore());
			request.setAttribute("vo", vo);
			return "update";
		}

		// 修改一条数据
		@RequestMapping(value = "/updateById.do")
		public @ResponseBody StudentInfo updateById(HttpServletRequest request, Integer id, String studentName, String studentAge,
				String studentScore) throws Exception {
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setId(id);
			studentInfo.setStudentName(studentName);
			studentInfo.setStudentAge(studentAge);
			studentInfo.setStudentScore(studentScore);
			studentInfoService.updateById(studentInfo);
			//logger.info(studentInfo.getStudentName() + "[" + studentName + "]：修改成功");
			return studentInfo;
		}

		//批量修改页面跳转
		@RequestMapping(value = "/updateMore.do")
		public String updateMore(@RequestParam("checked") Integer[] ids, HttpServletRequest request) throws Exception {
			upIds=ids;
			logger.info("ids成功");
			return "update";
		}
		//批量修改
		@RequestMapping(value = "/updateByIds.do")
		public String updateByIds(HttpServletRequest request,String shopNo, String shopName,
				String shopType, String note) throws Exception {
			if ((""==shopName||"".equals(shopName))&&(""==shopNo||"".equals(shopNo))&&(""==note||"".equals(note))&&(""==shopType||"".equals(shopType))) {
				return "请至少修改一项";
			}
			StudentInfo studentInfo = new StudentInfo();
			studentInfo.setIds(upIds);
			studentInfo.setStudentName(studentName);
			studentInfo.setStudentAge(studentAge);
			studentInfo.setStudentScore(studentScore);
			studentInfoService.updateByIds(studentInfo);
			logger.info("批量修改成功");
			return "redirect:/list.do";
	
		}
}
