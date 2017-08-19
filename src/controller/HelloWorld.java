package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorld {
	
	/**
	 * ʹ��@RequestMappingע����ӳ�������URL
	 * ����ֵ��ͨ����ͼ����������Ϊʵ�ʵ�������ͼ����InternalResourceViewResolver��ͼ���������������½�����
	 * ͨ��prefix+����ֵ+suffix �����ķ�ʽ�õ�ʵ�ʵ�������ͼ��Ȼ����ת������
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
