package Dao;

import java.util.List;
import entity.News;
import entity.ObjPage;

public interface NewsDao {
	
			// 查找所有新闻
			public List<News> getAllNews();

			// 添加新闻
			public int saveNews(News news);

			// 修改
			public int updateNews(News news);

			// 删除
			public int delNews(Integer id);
			
			//按主键查询
			public News getNewsById(Integer id);
			
			//当前页的新闻
			public List<News> getNewsByPage(ObjPage page);
		
			//总记录数
			public int getCount();
}
