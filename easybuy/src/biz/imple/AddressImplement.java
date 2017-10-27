package biz.imple;

import Dao.AddressDao;
import Dao.imple.AddressImpl;
import biz.AddressBiz;
import entity.Address;

public class AddressImplement implements AddressBiz {
      AddressDao aDao = new AddressImpl(); 
	@Override
	public int addAds(Address address) {
		
		return aDao.addAds(address);
	}

}
