package web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import sun.security.krb5.Config;

/**
 * Servlet Filter implementation class Enconding
 * 字符编码过滤器
 */
public class Encoding implements Filter {


	private String characterEncoding;//编码格式，可以在web中设置编码格式  
	
	private boolean enabled;//是否进行过滤
    
	public Encoding(){
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		//初始化编码方式
		characterEncoding = fConfig.getInitParameter("characterEncoding"); 
		//启用
		enabled = "true".equalsIgnoreCase(fConfig.getInitParameter("enabled").trim());		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  if(enabled ||characterEncoding !=null){  //只有web配置文件传参，才能初始化才赋值，才不为空，因此依据判断是否启动过滤编码设置
			  request.setCharacterEncoding(characterEncoding);
			  response.setCharacterEncoding(characterEncoding);
		  }
		  
		  chain.doFilter(request, response);//继续向下执行 
	}
	//过滤器销毁
	public void destroy() {
		characterEncoding = null;//销毁清空资源
	}
     
}
