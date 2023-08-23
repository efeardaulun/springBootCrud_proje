package com.example.efe.Controller;

import com.example.efe.Service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {


    @Autowired
    EmailSenderService emailSenderService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody EmailSenderService emailSenderService) {
        emailSenderService.sendEmail("ulune@mef.edu.tr","project","basardımmm");
        return "mail gitti";
    }

    @PostMapping("/send-mail-attachment")
    public String sendMailWithAttachment(){
        emailSenderService.sendMailWithAttachment("ulune@mef.edu.tr","project","basardımmm","/Users/efeardaulun/eclipse-workspace/deneme/files/48_kasko_police.pdf");
        return "mail with pdf";
    }
}
