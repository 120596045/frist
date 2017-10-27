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

	private String characterEncoding;//���� ��ʽ��������web.xml ��
	private boolean enabled; //�Ƿ����ø�Filter,������web.xml��
	
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
		characterEncoding=null;//����ʱ�����Դ
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		if(enabled || characterEncoding!=null){//������ø�Filter
			request.setCharacterEncoding(characterEncoding);//����request����
			response.setCharacterEncoding(characterEncoding);//����response����
		}
		chain.doFilter(request, response);//doFilter,ִ����һ��Filter����Servlet
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		//��ʼ��ʱ���ز���
		characterEncoding=fConfig.getInitParameter("characterEncoding");//�����ʽ
		//����
		enabled="true".equalsIgnoreCase(fConfig.getInitParameter("enabled").trim());
		
	}

}
