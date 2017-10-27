package biz;

import java.util.List;

import entity.News;
import entity.ObjPage;

public interface NewsBiz {

public List<News> showAllNews();//显示所有新闻业务
	
	public int delNews(Integer id);
	
	public int addNews(News news);
	
	//按主键显示
	public News showNewsById(Integer id);
	
	public int updateNews(News news);
	
	public List<News> showNewsByPage(ObjPage page);
}
