package web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
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
 * Servlet implementation class NewsServlet
 */
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsServlet() {
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
		//创建session对象
		HttpSession session=request.getSession();		
		//创建out对象
		PrintWriter out = response.getWriter();
		//防止乱码
		response.setContentType("text/html;charset=utf-8");
		String opr =null;
		opr=request.getParameter("opr");
		String abc=null;
		abc=request.getParameter("abc");
		
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fu=new ServletFileUpload(factory);
		if(fu.isMultipartContent(request)){
			opr="add";
		}
		 NewsBiz biz = new NewsImplement();
		 if ("getOne".equals(opr)) {
			String id=request.getParameter("id");
			News news=biz.showNewsById(Integer.valueOf(id));
			session.setAttribute("oneNews", news);
			response.sendRedirect("news-view.jsp");
			
			
			
			 //response.sendRedirect("manage/news.jsp");
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if ("getAll".equals(abc)) {
			List<News> list = biz.showAllNews();
			session.setAttribute("newss", list);
			 //response.sendRedirect("manage/news.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if("getAll".equals(opr)) {
		List<News> list = biz.showAllNews();
		session.setAttribute("news", list);
		//response.sendRedirect("manage/news.jsp");
		request.getRequestDispatcher("manage/news.jsp").forward(request, response);
		}else if("del".equals(opr)){
		String id=request.getParameter("id");//要删除的新闻编号 
	 	int i=biz.delNews(Integer.valueOf(id));
		if(i>0){
			out.print("<script>alert('删除成功！');location.href='manage/news.jsp'</script>");
			
		}
		
	}else if("add".equals(opr)){	
		addNews(fu,request, out, biz);	
	}else if("toUpdate".equals(opr)){
		String id=request.getParameter("id");
		News news=biz.showNewsById(Integer.valueOf(id));
		session.setAttribute("objNews", news);
		response.sendRedirect("manage/news-modify.jsp");
	}else if("update".equals(opr)){
		String nid=request.getParameter("n_id");
		String title =request.getParameter("n_title");
		String date = request.getParameter("n_create_date");
		String content=request.getParameter("n_content");
		News news=new News();
		news.setN_id(Integer.valueOf(nid));
		news.setN_title(title);
		news.setN_create_date(new Date(new java.util.Date().getTime()));
		news.setN_content(content);
		//执行保存业务
		if(biz.updateNews(news)>0){
			out.print("<script>alert('修改成功！');location.href='manage/manage-result.jsp'</script>");

		}
	}else if("page".equals(opr)){
		int pageIndex=1;
		int pageSize=2;
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
		session.setAttribute("pageObjn", page);
		response.sendRedirect("index.jsp");
		
		}
	}

	
	
	private void addNews(ServletFileUpload fu,HttpServletRequest request, PrintWriter out, NewsBiz biz) {
		Integer id=null;//request.getParameter("n_id");
		String title =null; //request.getParameter("n_title");
		String date =null; //request.getParameter("n_create_date");
		String content=null;//request.getParameter("n_content");
		String name=null;//request.getParameter("u_name");
		
		
		String fileName=null;
		try {
			List<FileItem> items=fu.parseRequest(request);
			
			for(FileItem item:items){
				if(item.isFormField()){
					if(item.getFieldName().equals("n_title")){
						title=item.getString("utf-8");
					}
					if(item.getFieldName().equals("n_create_date")){
						date=item.getString("utf-8");
					}
					if(item.getFieldName().equals("n_content")){
						content=item.getString("utf-8");
					}
				}else{
					fileName=item.getName();
					
					String ext=fileName.substring(fileName.lastIndexOf('.')+1);
					
					fileName=new Date(new java.util.Date().getTime())+"."+ext;
					
				}
			}
			
			
			
			News news=new News();
			news.setN_title(title);
			news.setN_create_date(new Date(new java.util.Date().getTime()));
			news.setN_content(content);
			
			//执行保存业务
			int i=biz.addNews(news);
			if(i>0){
				out.print("<script>alert('添加成功！');location.href='manage/manage-result.jsp'</script>");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//构造News对象
		
	}

	

}
