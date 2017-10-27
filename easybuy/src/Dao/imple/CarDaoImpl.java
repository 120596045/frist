package Dao.imple;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import Dao.CarDao;
import entity.Car;
import util.MybatisUtil;

public class CarDaoImpl implements CarDao {
	
	
	//插入购物车
	@Override
	public int insert(Map<String, Object> mapGoods) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int n = cDao.insert(mapGoods);
		session.commit();
		session.close();
		
		return n;
	}

	//根据用户名查找购物车
	@Override
	public List<Car> getCarByName(String name) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		List<Car> cList= cDao.getCarByName(name);
		session.close();
		
		return cList;
	}

	//根据id删除
	@Override
	public int del(Integer id) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int n = cDao.del(id);
		session.commit();
		session.close();
		
		return n;
	}

	//修改商品数量
	@Override
	public int update(Map<String, Object> mapCar) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int n = cDao.update(mapCar);
		session.commit();
		session.close();
		
		return n;
	}

	//根据商品Id查找
	@Override
	public int getCarById(Integer id) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int cList = cDao.getCarById(id);
		session.close();
		
		return cList;
	}

	//去重复查询
	@Override
	public List<Car> getCarGroupBy(String name) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		List<Car>cList = cDao.getCarGroupBy(name);
		session.close();
		
		return cList;
	}

	//根据商品名字和g_num删除
	@Override
	public int delCarByMap(String gname) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int n = cDao.delCarByMap(gname);
		session.commit();
		session.close();
		return n;
	}

	//购物车总计
	@Override
	public Double total(String name) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		Double n = cDao.total(name);
		session.commit();
		session.close();
		
		return n;
	}

	
}
