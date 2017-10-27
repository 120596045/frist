package biz;

import entity.Goods;

public interface GoodsBiz {

	/**
	 * 商品添加
	 */
	public int addGoods(Goods goods);
   
	/**
	 * 通过id查询商品
	 */
	
 Goods foundById(Integer id);
}
