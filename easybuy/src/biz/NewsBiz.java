package biz;

import java.util.List;

import entity.News;
import entity.ObjPage;

public interface NewsBiz {

public List<News> showAllNews();//��ʾ��������ҵ��
	
	public int delNews(Integer id);
	
	public int addNews(News news);
	
	//��������ʾ
	public News showNewsById(Integer id);
	
	public int updateNews(News news);
	
	public List<News> showNewsByPage(ObjPage page);
}
