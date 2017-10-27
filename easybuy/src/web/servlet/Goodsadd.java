package web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import biz.GoodsBiz;
import biz.imple.GoodsImplement;
import entity.Goods;

/**
 * Servlet implementation class Goodsadd
 * 商品添加
 */
public class Goodsadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Goodsadd() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建一个商品对象，进行商品添加
		Goods goods = new Goods();
		String g_name = null;
		// 创建FileItemFactory对象
		FileItemFactory fileItemFactory = new  DiskFileItemFactory();
		// 创建ServletFileUpload对象
	    ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
	     //解析from表单数据
	    if(sfu.isMultipartContent(request)){//判断请求内容 ，是否是“multipart/form-data”类型
	    	try {
	    		
			List<FileItem> list =sfu.parseRequest(request);//获取请求中的对象集合
			 //遍历集合获取到想要的文件上传数据
			 for(FileItem f:list){
				 if(f.isFormField()){//是否非文件域
					 if(f.getFieldName().equals("productName")){//根据对象的字段解析from表单传递的数据
						 g_name=f.getString("utf-8");//名字
					 }else if(f.getFieldName().equals("productDetail")){
						 goods.setG_detail(f.getString("utf-8"));//商品详情
					 }else if(f.getFieldName().equals("parentId")){
						 goods.setG_sort(f.getString("utf-8"));//商品分类
					 }else if(f.getFieldName().equals("productPrice")){
						 goods.setG_price(Double.parseDouble(f.getString()));//商品价格
					 }else if(f.getFieldName().equals("productNumber")){
						 goods.setG_count(Integer.valueOf(f.getString()));//商品数量
					 }
				 }else {
					String fileName = f.getName();//获取上传图片名字
					
					 
					String path=request.getRealPath("images");
					 //建立文件，然后根据路径上传
					//request.getContextPath();
					
					 File file = new File(path+"/product",fileName);
					 //File file = new File("F:\\picture",fileName);
					 f.write(file);
					 goods.setG_picture("images/product"+fileName);
				 }
				
			}

			} catch (Exception e) {
			
				e.printStackTrace();
			}
	    } 
	     goods.setG_name(g_name);
		 GoodsBiz gDao = new GoodsImplement();//创建商品实现类对象进行添加商品
		 gDao.addGoods(goods);
		 response.sendRedirect("product-add.jsp");
	}

}
