package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.SmbmsUser;

import service.UserService;
import util.ResultData;

@Controller
@RequestMapping("user")
@SessionAttributes({"suser"})
public class UserController {
	
	//ҵ�����
	@Autowired
	private UserService userService;
	
	//�����¼�ķ���һ
	/*@RequestMapping("/login")
	public void isLogin(String usercode,String userpassword,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		ResultData rd =new ResultData();
		rd = userService.isLogin(usercode, userpassword);
		//�����¼�ɹ�
		if(rd.getFlag()==0){
			//���û���Ϣ���浽session����
			request.getSession().setAttribute("user",rd.getData());
			//�ض�����ҳ
			response.sendRedirect(request.getContextPath()+"/jsp/frame.html");
		}else{
			request.setAttribute("result",rd);
			request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
		}
	}*/
	
	//�����¼������
	/*@RequestMapping("/login")
	public ModelAndView isLogin(String usercode,String userpassword,HttpSession session){
		ModelAndView model = new ModelAndView();
		ResultData rd = new ResultData();
		rd = userService.isLogin(usercode, userpassword);
		if(rd.getFlag()==0){
			session.setAttribute("user",rd.getData());
			model.setViewName("redirect:/jsp/frame.html");
		}else{
			model.addObject("result",rd);
			model.setViewName("login");
		}
		return model;
	}*/
	
	//�����¼������
	/*@RequestMapping("/login")
	public String isLogin(String usercode,String userpassword,Model model,HttpSession session){
		ResultData rd = new ResultData();
		rd = userService.isLogin(usercode, userpassword);
		if(rd.getFlag()==0){
			session.setAttribute("user",rd.getData());
			return "redirect:/jsp/frame.html";
		}else{
			model.addAttribute("result",rd);
			return "login";
		}
	}*/
	
	//�����¼������
	/*@RequestMapping("/login")
	public String isLogin(String usercode,String userpassword,Map<String,Object> model,HttpSession session){
		ResultData rd = new ResultData();
		rd = userService.isLogin(usercode, userpassword);
		if(rd.getFlag()==0){
			session.setAttribute("user",rd.getData());
			return "redirect:/jsp/frame.html";
		}else{
			model.put("result",rd);
			return "login";
		}
	}*/
	
	@RequestMapping("testCookie")
	public String testCookie(@CookieValue("JSESSIONID") String username){
		System.out.println(username);
		return "login";
	}
	
	@ModelAttribute
	public void testModelAttrbute(Long id,Map<String, Object> map){
		if(id!=null){
		SmbmsUser user=(SmbmsUser)userService.getUserById(id).getData();
		map.put("smbmsUser", user);
		
		}
	}
	@RequestMapping("modify")
	public String modify(SmbmsUser smbmsUser,Map<String,Object> map){
		System.out.println(smbmsUser);
		return "redirect:/user/userList";
		
	}
	
	@RequestMapping("update/{id}")
	public String update(@PathVariable("id")Long id,Map<String,Object> map){
		SmbmsUser user = (SmbmsUser)userService.getUserById(id).getData();
		map.put("smbmsUser",user);
		//����һ��map�������������û��Ա���Ϣ
		Map<String,String> sexs = new HashMap<String,String>();
		sexs.put("1","��");
		sexs.put("2","Ů");
		map.put("sexs",sexs);
		//����һ��map�������������û���ɫ��Ϣ
		Map<String,String> roles = new HashMap<String, String>();
		roles.put("1","����Ա");
		roles.put("2", "����");
		roles.put("3","Ա��");
		map.put("roles", roles);
		return "userUpdate";
	}
	
	//�����¼������
	@RequestMapping("/login")
	@ResponseBody
	public String isLogin(String usercode,String userpassword,HttpSession session){
		ResultData rd = new ResultData();
		rd = userService.isLogin(usercode, userpassword);
		if(rd.getFlag()==0){
			session.setAttribute("user",rd.getData());
		}
		String json = JSON.toJSONString(rd);
		System.out.println(json);
		return json;
	}
	
	//���������û���Ϣ
	@RequestMapping(value="userList")
	public String getUsers(Map<String, Object> model){
		ResultData rd = userService.getUserByAll();
		model.put("result",rd);
		System.out.println(rd.getData());
		return "userList";
	}
	
	//����id��ѯ�û�
	@RequestMapping(value="userRest/{id}",method=RequestMethod.GET)
	public String getUserById(@PathVariable("id")Long id,Map<String, Object> model){
		ResultData rd = userService.getUserById(id);
		model.put("result",rd);
		return "userView";
	}
	
	//����û���Ϣ
	@RequestMapping(value="userRest",method=RequestMethod.POST)
	public String addUser(SmbmsUser user,Map<String,Object> map){
		ResultData rd = new ResultData();
		rd = userService.addUser(user);
		if(rd.getFlag()==0){
			return "redirect:/user/userList";
		}else{
			map.put("result",rd);
			return "userAdd";
		}
	}
	
	//ɾ���û�
	@RequestMapping(value="userRest/{id}",method=RequestMethod.DELETE)
	public String delUser(@PathVariable("id") Long id){
		System.out.println(id);
		ResultData rd = new ResultData();
		rd = userService.delUser(id);
		if(rd.getFlag()==0){
			return "redirect:/user/userList";
		}else{
			return "redirect:/user/userRest/"+id;
		}
	}
}
