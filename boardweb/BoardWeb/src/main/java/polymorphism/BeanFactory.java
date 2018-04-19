package polymorphism;

//스프링의 ioc기능을 대행해줄.(객체생성및주입)
public class BeanFactory {
	public Object getBean(String beanName) {
	if(beanName.equals("samsung")) {
		return new SamsungTV();
	}else if(beanName.equals("lg")) {
		return new LGTV();
	}return null;
	}
}
