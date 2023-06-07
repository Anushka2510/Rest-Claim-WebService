package com.allstate.restclaimwebservice.service;
import com.allstate.restclaimwebservice.model.PolicyDetailsRequest;
import com.allstate.restclaimwebservice.model.PolicyDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;


@Component
public class PolicyDetailsService {
    private final WebServiceTemplate webServiceTemplate;

    @Autowired
    public PolicyDetailsService(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    public PolicyDetailsResponse getPolicyDetails(PolicyDetailsRequest request) throws Exception{
        PolicyDetailsResponse policyDetailsResponse;
        try{
            policyDetailsResponse = (PolicyDetailsResponse) webServiceTemplate.marshalSendAndReceive(request);
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return policyDetailsResponse;
    }
}
