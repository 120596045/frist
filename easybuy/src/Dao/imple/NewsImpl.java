package Dao.imple;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import Dao.NewsDao;
import entity.News;
import entity.ObjPage;
import util.MybatisUtil;



public class NewsImpl implements NewsDao {

	@Override
	public List<News> getAllNews() {
		SqlSession session=MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		return nDao.getAllNews();
	}

	@Override
	public int saveNews(News news) {

		SqlSession session=MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		int i=nDao.saveNews(news);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public int updateNews(News news) {
		SqlSession session=MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		int i=nDao.updateNews(news);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public int delNews(Integer id) {
		SqlSession 	session=MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		int i=nDao.delNews(id);
		session.commit();
		session.close();
		return i;
	}
   /**
    * 通过id查询新闻
    */
	@Override
	public News getNewsById(Integer id) {

		SqlSession session=MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		return nDao.getNewsById(id);
	}

	@Override
	public List<News> getNewsByPage(ObjPage page) {
		SqlSession session = MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		return nDao.getNewsByPage(page);
	}

	@Override
	public int getCount() {
		SqlSession	session = MybatisUtil.getSqlSession();
		NewsDao nDao=session.getMapper(NewsDao.class);
		int i=nDao.getCount();
		session.commit();
		session.close();
		return i;
	}

}
