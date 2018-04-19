package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LGTV implements TV{
	
	//@Autowired //클래스타입을 찾아 감
	//@Qualifier("apple") //id걊으로 ..
	//@Resource(name="sony")
	Speaker speaker;
	
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void powerOn() {
		System.out.println("LGTV powerOn");
	}
	public void powerDown() {
		System.out.println("LGTV powerDown");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}
