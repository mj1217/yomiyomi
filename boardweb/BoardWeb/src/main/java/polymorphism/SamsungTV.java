package polymorphism;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("samsung")
public class SamsungTV implements TV {
	
	@Autowired
	private Speaker speaker;
	private int price;
	
	
	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	


	public void initMethod() {
		System.out.println("SamsungTV 초기화");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn");
	}
	
	@Override
	public void powerDown() {
		System.out.println("SamsungTV powerDown");
	}
	
	@Override
	public void volumeUp() {
		System.out.println("SamsungTV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("SamsungTV volumeDown");
	}
}
