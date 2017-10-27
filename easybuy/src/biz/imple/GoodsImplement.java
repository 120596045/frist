package biz.imple;

import org.apache.ibatis.session.SqlSession;

import Dao.GoodsDao;
import Dao.imple.GoodsImp;
import biz.GoodsBiz;
import entity.Goods;
import util.MybatisUtil;

public class GoodsImplement implements GoodsBiz {
   /**
    * 商品添加
    */
	GoodsDao gDao = new GoodsImp();
	@Override
	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return gDao.add(goods);
	}
	/**
	 * 通过id查询商品
	 */
	@Override
	public Goods foundById(Integer id) {
		// TODO Auto-generated method stub
		 return gDao.selectById(id);
	}

}
