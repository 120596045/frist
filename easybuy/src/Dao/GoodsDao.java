package Dao;

import java.util.List;

import entity.Goods;
import entity.ObjPage;


public interface GoodsDao {
  /**
   * 分页查询所有
   */
	public List<Goods> selAll(ObjPage goodsPage); 
   /**
    * 添加商品	
    */
	public int add(Goods goods);
	/**
	 * 添加商品分类
	 */
	public int addCalss(Goods goods);
	/**
	 * 通过id查询商品
	 */
     Goods selectById(Integer id);
}
