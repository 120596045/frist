package biz;

import entity.Goods;

public interface GoodsBiz {

	/**
	 * ��Ʒ���
	 */
	public int addGoods(Goods goods);
   
	/**
	 * ͨ��id��ѯ��Ʒ
	 */
	
 Goods foundById(Integer id);
}
