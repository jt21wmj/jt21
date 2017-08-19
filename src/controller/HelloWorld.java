package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorld {
	
	/**
	 * 使用@RequestMapping注解来映射请求的URL
	 * 返回值会通过视图解析器解析为实际的物理视图，对InternalResourceViewResolver视图解析器，会做如下解析：
	 * 通过prefix+返回值+suffix 这样的方式得到实际的物理视图，然会做转发操作
	 * @return
	 */
	@RequestMapping(value="helloString",method=RequestMethod.GET,params={"id=1","age!=20"})
	public String execute(@RequestParam("id") Integer oid,@RequestParam(value="ename",required=false,defaultValue="bbb") String ename){
		System.out.println(oid);
		System.out.println(ename);
		return "redirect:HelloWorld.jsp";
	}
	
	@RequestMapping("test/{id}/{age}/{a}/{b}/{c}/{d}/{e}")
	public String test(@PathVariable("a") Integer id,@PathVariable("age") Integer age){
		System.out.println("id:"+id+",age:"+age);
		return "redirect:/HelloWorld.jsp";
	}
}
