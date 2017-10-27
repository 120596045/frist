package biz.imple;

import java.util.List;

import Dao.NewsDao;
import Dao.imple.NewsImpl;
import biz.NewsBiz;
import entity.News;
import entity.ObjPage;

public class NewsImplement implements NewsBiz {

	NewsDao ndao= new NewsImpl();
	
	@Override
	public List<News> showAllNews() {
		// TODO Auto-generated method stub
		return ndao.getAllNews();
	}

	@Override
	public int delNews(Integer id) {
		// TODO Auto-generated method stub
		return ndao.delNews(id);
	}

	@Override
	public int addNews(News news) {
		// TODO Auto-generated method stub
		return ndao.saveNews(news);
	}

	@Override
	public News showNewsById(Integer id) {
		// TODO Auto-generated method stub
		return ndao.getNewsById(id);
	}

	@Override
	public int updateNews(News news) {
		// TODO Auto-generated method stub
		return ndao.updateNews(news);
	}

	@Override
	public List<News> showNewsByPage(ObjPage page) {
		return ndao.getNewsByPage(page);
	}

}
