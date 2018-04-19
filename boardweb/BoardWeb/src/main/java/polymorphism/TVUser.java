package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
	//	BeanFactory factory = new BeanFactory();
	//	TV tv = (TV)factory.getBean(args[0]);
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		TV tv = (TV)factory.getBean(LGTV.class);
		
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerDown();

	}

}
