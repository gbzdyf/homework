

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import leader05.service.MyTransService;
@RunWith(SpringRunner.class) 
@ContextConfiguration("classpath:applicationContext5.xml") 
@ActiveProfiles("unit_test")
@Transactional
public class Test51 {

	@Autowired
	private MyTransService tranSrv;
	
	@Test
//	@Sql("classpath:test.sql")
	public void test1()
	{
		System.out.println("MyTransService "+tranSrv.getClass().getName());
		tranSrv.doTransBusiness();
	}
	
	
}
