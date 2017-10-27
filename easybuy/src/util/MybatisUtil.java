package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
 * ∂¡»°mybitis≈‰÷√Œƒº˛
 */

public class MybatisUtil {

	
		private static SqlSessionFactory factory;

		static {
			Reader reader = null;
			try {
				reader = Resources.getResourceAsReader("Mybatis.xml");
				factory = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null)
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}

		public static SqlSession getSqlSession() {
			return factory.openSession();
		
	}
}
