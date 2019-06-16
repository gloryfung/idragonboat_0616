package cn.idragonboat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.idragonboat.service.SendMailService;


@Controller
public class SendMailController {
	
	@Autowired
	private SendMailService sendMailService;
	 
		@RequestMapping("/mail/send")
		@ResponseBody
	    public Object sendMail(){
	        Object sendMail = sendMailService.sendMail();
	        return sendMail;
	    }

	}
