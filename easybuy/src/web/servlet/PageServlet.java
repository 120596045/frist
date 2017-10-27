package web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao.NewsDao;
import Dao.imple.NewsImpl;
import biz.NewsBiz;
import biz.imple.NewsImplement;
import entity.News;
import entity.ObjPage;

/**
 * Servlet implementation class PageServlet
 */
public class PageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//创建session对象
		HttpSession session=request.getSession();
		
		//创建out对象
		PrintWriter out = response.getWriter();
		
		//防止乱码
		response.setContentType("text/html;charset=utf-8");
		
		
		String opr =null;
		opr=request.getParameter("opr");
		
		
		
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fu=new ServletFileUpload(factory);
		
		NewsBiz biz = new NewsImplement();
		if("pages".equals(opr)){
				int pageIndex=1;
				int pageSize=3;
				String in=request.getParameter("i");//定义的页码
				if(in!=null){
					pageIndex=Integer.valueOf(in);
				}
				
				ObjPage<News> page2= new ObjPage<News>();
				page2.setPageIndex((pageIndex-1)*pageSize);
				page2.setPageSize(pageSize);
				
				
				NewsDao nda=new NewsImpl();//获取总记录数
				int ok=nda.getCount();
				NewsImplement impl=new NewsImplement();
				List<News> list=impl.showNewsByPage(page2);//获取news集合 
				ObjPage<News> page= new ObjPage<News>();
				page.setPageIndex(pageIndex);
				page.setPageSize(pageSize);
				
				page.setCount(ok);  //查询下总新闻条数
				
				int pageTotal=0;
				if(ok%pageSize==0){
					pageTotal=ok/pageSize;
				}else{
					pageTotal=ok/pageSize+1;
				}
				page.setPageTotal(pageTotal);
				page.setPageObj(list);
				session.setAttribute("pageObjns", page);
				response.sendRedirect("news.jsp");
				//request.getRequestDispatcher("manage/news.jsp").forward(request, response);
				
				}
	}

}
