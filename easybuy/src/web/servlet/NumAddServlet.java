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
import biz.GoodsBiz;
import biz.imple.CarBizImpl;
import biz.imple.GoodsImplement;
import entity.Car;
import entity.Goods;



/**
 * Servlet implementation class NumAjaxServlet
 */
public class NumAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NumAddServlet() {
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
		
		GoodsBiz gBiz = new GoodsImplement();
		CarBiz cBiz = new CarBizImpl();
		
		//获得用户
//		String u_name = (String) request.getSession().getAttribute("u_name");
		String u_name = "AA";
		
		String num = request.getParameter("num");
		String id = request.getParameter("id");
		String oldNum = request.getParameter("oldNum");
		
		int numI = Integer.valueOf(num);
		int oldNumI = Integer.valueOf(oldNum);
		Goods goods = gBiz.foundById(Integer.valueOf(id));
		
		for(int i=oldNumI+1; i<=numI; i++){
			
			//将查询的商品的图片、名字、价格插入到购物车里
			Map<String, Object> mapGoods = new HashMap<String, Object>();
			mapGoods.put("u_name", u_name);
			mapGoods.put("g_id", goods.getG_id());
			mapGoods.put("g_name", goods.getG_name());
			mapGoods.put("g_picture", goods.getG_picture());
			mapGoods.put("g_price", goods.getG_price());
			mapGoods.put("g_num", i);
			
			cBiz.save(mapGoods);
		}
		
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
