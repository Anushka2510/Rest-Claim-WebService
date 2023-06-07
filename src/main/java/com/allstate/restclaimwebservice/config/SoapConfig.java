package com.allstate.restclaimwebservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

@Configuration
public class SoapConfig {
    @Bean
    public WebServiceTemplate webServiceTemplate(SaajSoapMessageFactory messageFactory,
                                                 WebServiceMessageSender messageSender, Jaxb2Marshaller marshaller) {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller);
        webServiceTemplate.setDefaultUri("http://localhost:8081/ws"); // SOAP service endpoint URL
        webServiceTemplate.setMessageFactory(messageFactory);
        webServiceTemplate.setMessageSender(messageSender);
        return webServiceTemplate;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.allstate.restclaimwebservice.model"); // Set the package where your generated JAXB classes are located
        return marshaller;
    }


    @Bean
    public SaajSoapMessageFactory messageFactory() {
        SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
        messageFactory.setSoapVersion(SoapVersion.SOAP_11); // Specify SOAP version if needed
        return messageFactory;
    }

    @Bean
    public WebServiceMessageSender messageSender() {
        return new HttpComponentsMessageSender();
    }

}