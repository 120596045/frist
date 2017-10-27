package web.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class NewsFilter
 */
public class NewsFilter implements Filter {

	private String characterEncoding;//编码 方式，配置在web.xml 中
	private boolean enabled; //是否启用该Filter,配置在web.xml中
	
    /**
     * Default constructor. 
     */
    public NewsFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		characterEncoding=null;//销毁时清空资源
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(enabled || characterEncoding!=null){//如果启用该Filter
			request.setCharacterEncoding(characterEncoding);//设置request编码
			response.setCharacterEncoding(characterEncoding);//设置response编码
		}
		chain.doFilter(request, response);//doFilter,执行下一个Filter或者Servlet
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//初始化时加载参数
		characterEncoding=fConfig.getInitParameter("characterEncoding");//编码格式
		//启用
		enabled="true".equalsIgnoreCase(fConfig.getInitParameter("enabled").trim());
		
	}

}
