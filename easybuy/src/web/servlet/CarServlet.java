package web.servlet;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class CarServlet
 */
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//url���β���
		String opr =  request.getParameter("opr");
		//����û�
//		String u_name = (String) request.getSession().getAttribute("u_name");
		GoodsBiz gBiz = new GoodsImplement();
		CarBiz cBiz = new CarBizImpl();
		
		if("CarSelectById".equals(opr)){
			//ͨ����Ʒid��ѯ��Ʒ
			String  id = request.getParameter("id");
			String u_name = "AA";
			
			if(id != null){
				int ggNum = 1;
				
				//�鿴���ﳵ���Ƿ��Ѿ��и���Ʒ
				int gNum= cBiz.getCarById(Integer.valueOf(id));
				if(gNum > 0){
					
					ggNum = gNum + 1;
//					request.getSession().setAttribute("ggNum", ggNum);
					
				}
					Goods goods = gBiz.foundById(Integer.valueOf(id));
					
					
					//����ѯ����Ʒ��ͼƬ�����֡��۸���뵽���ﳵ��
					Map<String, Object> mapGoods = new HashMap<String, Object>();
					mapGoods.put("u_name", u_name);
					mapGoods.put("g_id", goods.getG_id());
					mapGoods.put("g_name", goods.getG_name());
					mapGoods.put("g_picture", goods.getG_picture());
					mapGoods.put("g_price", goods.getG_price());
					mapGoods.put("g_num", ggNum);
					
					cBiz.save(mapGoods);
			}
				//�����û������ҹ��ﳵ�ŵ�session��
				List<Car> cList= cBiz.getCarGroupBy(u_name);
				//���ﳵ�ܼ�
				Double total = cBiz.total(u_name);
				
				request.getSession().setAttribute("cList", cList);
				request.getSession().setAttribute("total", total);
				
				response.sendRedirect("shopping.jsp");
//			request.getRequestDispatcher("shopping.jsp").forward(request, response);
		}else if("del".equals(opr)){
			//���idɾ��
			String id = request.getParameter("id");
			
			
//			int n= cBiz.delCarByMap(gname);
			int n = cBiz.del(Integer.valueOf(id));
			System.out.println(n);
			String u_name = "AA";
			List<Car> cList= cBiz.getCarGroupBy(u_name);
			Double total = cBiz.total(u_name);
			request.getSession().setAttribute("cList", cList);
			request.getSession().setAttribute("total", total);
			response.sendRedirect("shopping.jsp");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
