package Dao;

import java.util.List;

import entity.Goods;
import entity.ObjPage;


public interface GoodsDao {
  /**
   * ��ҳ��ѯ����
   */
	public List<Goods> selAll(ObjPage goodsPage); 
   /**
    * �����Ʒ	
    */
	public int add(Goods goods);
	/**
	 * �����Ʒ����
	 */
	public int addCalss(Goods goods);
	/**
	 * ͨ��id��ѯ��Ʒ
	 */
     Goods selectById(Integer id);
}
