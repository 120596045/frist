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
 * ��Ʒ���
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
		//����һ����Ʒ���󣬽�����Ʒ���
		Goods goods = new Goods();
		String g_name = null;
		// ����FileItemFactory����
		FileItemFactory fileItemFactory = new  DiskFileItemFactory();
		// ����ServletFileUpload����
	    ServletFileUpload sfu = new ServletFileUpload(fileItemFactory);
	     //����from������
	    if(sfu.isMultipartContent(request)){//�ж��������� ���Ƿ��ǡ�multipart/form-data������
	    	try {
	    		
			List<FileItem> list =sfu.parseRequest(request);//��ȡ�����еĶ��󼯺�
			 //�������ϻ�ȡ����Ҫ���ļ��ϴ�����
			 for(FileItem f:list){
				 if(f.isFormField()){//�Ƿ���ļ���
					 if(f.getFieldName().equals("productName")){//���ݶ�����ֶν���from�����ݵ�����
						 g_name=f.getString("utf-8");//����
					 }else if(f.getFieldName().equals("productDetail")){
						 goods.setG_detail(f.getString("utf-8"));//��Ʒ����
					 }else if(f.getFieldName().equals("parentId")){
						 goods.setG_sort(f.getString("utf-8"));//��Ʒ����
					 }else if(f.getFieldName().equals("productPrice")){
						 goods.setG_price(Double.parseDouble(f.getString()));//��Ʒ�۸�
					 }else if(f.getFieldName().equals("productNumber")){
						 goods.setG_count(Integer.valueOf(f.getString()));//��Ʒ����
					 }
				 }else {
					String fileName = f.getName();//��ȡ�ϴ�ͼƬ����
					
					 
					String path=request.getRealPath("images");
					 //�����ļ���Ȼ�����·���ϴ�
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
		 GoodsBiz gDao = new GoodsImplement();//������Ʒʵ���������������Ʒ
		 gDao.addGoods(goods);
		 response.sendRedirect("product-add.jsp");
	}

}
