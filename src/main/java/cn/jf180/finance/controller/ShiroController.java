package cn.jf180.finance.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import test.TestRedisPhone;

import javax.annotation.Resource;
import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.net.Authenticator;
import java.nio.file.Paths;
import java.util.List;

/**

 * @author Administrator

 * @create 2018-03-26 14:34

 * @desc ShiroController

 **/
@Controller
public class ShiroController {

	@Resource
	private Environment evn;

	@Resource
	private ResourceLoader resourceLoader = null;

	//	}
	//		return array.toJSONString();
	//		}
	//			}
	//				array.add(s);
	//			if (b){
	//			boolean b = redisPhone.addPhone(s);
	//		for (String s : phone) {
	//		JSONArray array = new JSONArray();
	//		List<String> phone = redisPhone.findPhone(str);
	//		TestRedisPhone redisPhone = new TestRedisPhone();
	//	public String add(String str){
	////	@RequiresRoles("admin")
	//	@ResponseBody
//	@RequestMapping("/add/redis")


	@RequestMapping("/hello")
	@RequiresRoles("admin")
	@ResponseBody
	public String hello(HttpServletRequest request){
		return "1";
	}

	@RequestMapping("/login")
	@ResponseBody
	public String login(HttpServletRequest request,String username,String password){
		Subject subject = SecurityUtils.getSubject();//获取当前用户对象
		//生成令牌(传入用户输入的账号和密码)
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		//认证登录
		try {
			//这里会加载自定义的realm
			subject.login(token);//把令牌放到login里面进行查询,如果查询账号和密码时候匹配,如果匹配就把user对象获取出来,失败就抛异常
			Object user= subject.getPrincipal();//获取登录成功的用户对象(以前是直接去service里面查)
			Session subjectSession = subject.getSession();
			Serializable id = subjectSession.getId();
			System.out.println(id);
			request.getSession().setAttribute("user",user);
			subjectSession.setAttribute("user",user);
			return "index";
		} catch (Exception e) {
			//认证登录失败抛出异常
			return "login";
		}
	}


	@RequestMapping(method = RequestMethod.GET, value = "/filename:{filename:.+}")
	@ResponseBody
	public ResponseEntity<?> getFile(@PathVariable String filename) {

		try {

			String path = "/Users/wangluyao/" + filename;
//			"file:" + Paths.get("/Users/wangluyao/", filename).toString())
			System.out.println(path);
			return ResponseEntity.ok(resourceLoader.getResource("file:"+path.replace("-","/")));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}



}
