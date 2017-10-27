package Dao.imple;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import Dao.CarDao;
import entity.Car;
import util.MybatisUtil;

public class CarDaoImpl implements CarDao {
	
	
	//���빺�ﳵ
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

	//�����û������ҹ��ﳵ
	@Override
	public List<Car> getCarByName(String name) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		List<Car> cList= cDao.getCarByName(name);
		session.close();
		
		return cList;
	}

	//����idɾ��
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

	//�޸���Ʒ����
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

	//������ƷId����
	@Override
	public int getCarById(Integer id) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		int cList = cDao.getCarById(id);
		session.close();
		
		return cList;
	}

	//ȥ�ظ���ѯ
	@Override
	public List<Car> getCarGroupBy(String name) {
		// TODO Auto-generated method stub
		
		SqlSession session = MybatisUtil.getSqlSession();
		CarDao cDao = session.getMapper(CarDao.class);
		List<Car>cList = cDao.getCarGroupBy(name);
		session.close();
		
		return cList;
	}

	//������Ʒ���ֺ�g_numɾ��
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

	//���ﳵ�ܼ�
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
