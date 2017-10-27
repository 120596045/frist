package Dao.imple;

import org.apache.ibatis.session.SqlSession;

import Dao.AddressDao;
import entity.Address;
import util.MybatisUtil;


public class AddressImpl implements AddressDao {

	/**
	 * 添加地址信息
	 */
	@Override
	public int addAds(Address address) {
		SqlSession session = MybatisUtil.getSqlSession();
		AddressDao aDao = session.getMapper(AddressDao.class);
		int i = aDao.addAds(address);
		session.commit();
		session.close();
		return i;
	}


	
}
