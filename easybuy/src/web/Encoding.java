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
 * �ַ����������
 */
public class Encoding implements Filter {


	private String characterEncoding;//�����ʽ��������web�����ñ����ʽ  
	
	private boolean enabled;//�Ƿ���й���
    
	public Encoding(){
		
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		//��ʼ�����뷽ʽ
		characterEncoding = fConfig.getInitParameter("characterEncoding"); 
		//����
		enabled = "true".equalsIgnoreCase(fConfig.getInitParameter("enabled").trim());		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		  if(enabled ||characterEncoding !=null){  //ֻ��web�����ļ����Σ����ܳ�ʼ���Ÿ�ֵ���Ų�Ϊ�գ���������ж��Ƿ��������˱�������
			  request.setCharacterEncoding(characterEncoding);
			  response.setCharacterEncoding(characterEncoding);
		  }
		  
		  chain.doFilter(request, response);//��������ִ�� 
	}
	//����������
	public void destroy() {
		characterEncoding = null;//���������Դ
	}
     
}
