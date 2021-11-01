package com.cos.petproject.service;

import java.util.Random;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cos.petproject.handler.MailHandler;
import com.cos.petproject.handler.exception.MyAsyncNotFoundException;
import com.cos.petproject.web.dto.AuthEmailReqDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MailService {
	private JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "hyopin258@gamil.com";
	
	// 인증메일 보내기
	public String sendAuthMail(AuthEmailReqDto dto) {
		// 6자리 난수 인증번호 생성
		String authKey = getKey(6);

		try {
			MailHandler mailHandler = new MailHandler(mailSender);

			// 받는 사람
			mailHandler.setTo(dto.getEmail());
			// 보내는 사람
			mailHandler.setFrom(MailService.FROM_ADDRESS);
			// 제목
			String TitleContent = "이메일 인증";
			mailHandler.setSubject(TitleContent);
			
			String htmlContent = "<h1>[이메일 인증]</h1><p>해당 인증 번호을 인증번호 확인란에 기입하여 주세요.</p>";
			htmlContent += "<p>" + authKey + "</p>";

			mailHandler.setText(htmlContent, true);

            mailHandler.send();
        }
        catch(Exception e){
            throw new MyAsyncNotFoundException("이메일을 찾지 못했습니다.");
        }
		
		return authKey;
	}

       	// 인증키 생성
	    private String getKey(int size) {
		    return getAuthCode(size);
    	}
    	// 인증코드 난수 발생
	    private String getAuthCode(int size) {
		    Random random = new Random();
		    StringBuffer buffer = new StringBuffer();
		    int num = 0;

     		while (buffer.length() < size) {
	     		num = random.nextInt(10);
		     	buffer.append(num);
		}

		return buffer.toString();
	}
}
      