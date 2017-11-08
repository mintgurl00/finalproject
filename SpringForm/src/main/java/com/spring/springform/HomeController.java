package com.spring.springform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping(value = "inputform.bo")
	public String home(Model model){			//사실, 뷰 만 반환하는 경우, model 객체 필요 없다.
		return "forminput";		
	}
	
/*
 * 위 아래 같은 것 
 * 
	@RequestMapping(value ="inputprocess.bo")
	public ModelAndView processForm(ServletRequest request){	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		ModelAndView mv = new ModelAndView();
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			pstmt = con.prepareStatement("select ename from emp order by ename asc");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String ename = rs.getString("ename");		//emp 테이블에 있는 ename 조회 -> list 에 저장 ??????????? 
				list.add(ename);
			}
			mv.setViewName("resultform");	// setViewName 뷰이름. : 뷰 저장 
			mv.addObject("list", list);		//데이터 : addObject  list 객체를 list 이름으로 저장. 
		}
		catch(Exception e){
			
		}
		return mv;			// model and view 를 반환. modeland view 안에있는 resultform 을 반환 (servlet-context.xml)이용해서 ..
	}
*/	
	
	@RequestMapping(value ="inputprocess.bo")
	public String processForm(ServletRequest request, Model model){	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		String id = null;
		String pw = null;
		
		try {
			String driver = "oracle.jdbc.driver.OracleDriver";
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "scott", "123456");
			pstmt = con.prepareStatement("select ename from emp order by ename asc");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				String ename = rs.getString("ename");		//emp 테이블에 있는 ename 에 저장  
				list.add(ename);			//ename 들을 list 객체에 저장 
			}
			
			model.addAttribute("id",request.getParameter("id"));		// request 객체에 있는 id 를 id 라는 이름으로 모델에 저장. 
			model.addAttribute("pw",request.getParameter("pw"));
			model.addAttribute("list", list);					//list 객체에 있는 것들을 모델에 저장. 
		}
		catch(Exception e){
			
		}
		return "resultform";			// model and view 를 반환. resultform.jsp 파일로 찾아감 (servlet-context.xml)이용해서 ..
	}
	
	
}
