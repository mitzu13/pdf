package com.test.pdf;

import com.test.pdf.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class HtmlService {

    @Autowired
    private TemplateEngine templateEngine;

    public String generateHtml(){
        final Context ctx = new Context(Locale.getDefault());

        ctx.setVariable("welcome", "aaaaaaaaaaaaaaaaa");

        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact();
        contact1.setContact("ion");
        contact1.setCompany("vasile");
        contact1.setCountry("romania");
        contacts.add(contact1);

        ctx.setVariable("contacts", contacts);



        ctx.setVariable("aaa", "Company Name");
        ctx.setVariable("bbb", "Contact Name");
        ctx.setVariable("ccc", "Country Name");


        final String htmlContent = this.templateEngine.process("test.html", ctx);

        return htmlContent;
    }
}
