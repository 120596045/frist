package cn.yunhe.until;

import org.apache.log4j.Logger;

public  class Logger4 {

	public static Logger log(Class cls){	
		
		Logger log = Logger.getLogger(cls);
		
		return log;
		
	}
     
}
