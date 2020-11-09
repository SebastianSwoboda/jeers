package ch.bbc.uek223.jeers.web;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import ch.bbc.uek223.jeers.ejb.service.HelloService;

@ManagedBean(name = "helloBean")
@RequestScoped
public class HelloWorldBean {

	@EJB
	private HelloService helloService;

	public String getGreeting() {
		return helloService.sayHello();
	}
}