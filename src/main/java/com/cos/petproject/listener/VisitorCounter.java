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

		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {     
	}

}

