package com.cos.petproject.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.cos.petproject.domain.visitor.Visitor;
import com.cos.petproject.domain.visitor.VisitorRepository;

@WebListener
public class VisitorCounter implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession(); // 세션을 만든다.

		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext()); //등록되어있는 빈을 사용할수 있도록 설정해준다
		
		VisitorRepository visitorRepository = (VisitorRepository) wac.getBean("visitorRepository"); // 등록되어 있는 visitorRepository를 사용가능하게 설정
		
		visitorRepository.mInsertVisitor();
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {     
	}

}

