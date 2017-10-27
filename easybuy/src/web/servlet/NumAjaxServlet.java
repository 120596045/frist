package web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biz.CarBiz;
import biz.imple.CarBizImpl;
import entity.Car;


/**
 * Servlet implementation class NumAjaxServlet
 */
public class NumAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//Ajax获取购物车商品数量信息
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("获取Ajax信息");
		
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		
		Map<String, Object> mapCar = new HashMap<String, Object>();
		mapCar.put("g_num", num);
		mapCar.put("g_id", id);
		
		CarBiz cBiz = new CarBizImpl();
		int n = cBiz.updateNum(mapCar);
		
		/*PrintWriter out = response.getWriter();
		out.write(""+flag);
		
		out.flush();
		out.close();*/
		
		//获得用户
//		String u_name = (String) request.getSession().getAttribute("u_name");
		String u_name = "AA";
		Double total = cBiz.total(u_name);
		List<Car> cList= cBiz.getCarGroupBy(u_name);
		
		request.getSession().setAttribute("cList", cList);
		request.getSession().setAttribute("total", total);
		
		response.sendRedirect("shopping.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
