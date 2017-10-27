package Dao.imple;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import Dao.GoodsDao;
import entity.Goods;
import entity.ObjPage;
import util.MybatisUtil;

public class GoodsImp implements GoodsDao {

	 /**
	  * 分页查询所有商品然后存储到GoodsPage中
	  */	
	@Override
	public List<Goods> selAll(ObjPage goodsPage) {
		SqlSession session = MybatisUtil.getSqlSession();
		GoodsDao  gDao= session.getMapper(GoodsDao.class);
		return gDao.selAll(goodsPage);
	}

	  /**
	    * 添加商品	
	    */
	@Override
	public int add(Goods goods) {
		SqlSession session = MybatisUtil.getSqlSession();
		GoodsDao  gDao= session.getMapper(GoodsDao.class);
		int i=gDao.add(goods);
		session.commit();
		session.close();
		return i;
	}
	/**
	 * 添加商品分类
	 */
	@Override
	public int addCalss(Goods goods) {
		SqlSession session = MybatisUtil.getSqlSession();
		GoodsDao  gDao= session.getMapper(GoodsDao.class);
		int i=gDao.add(goods);
		session.commit();
		session.close();
		return i;
	}

	@Override
	public Goods selectById(Integer id) {
		SqlSession session = MybatisUtil.getSqlSession();
		GoodsDao  gDao= session.getMapper(GoodsDao.class);
		return gDao.selectById(id);
	}



}
