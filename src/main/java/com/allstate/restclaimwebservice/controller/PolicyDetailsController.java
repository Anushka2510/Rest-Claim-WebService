package com.allstate.restclaimwebservice.controller;
import com.allstate.restclaimwebservice.model.PolicyDetailsRequest;
import com.allstate.restclaimwebservice.model.PolicyDetailsResponse;
import com.allstate.restclaimwebservice.model.PolicyDetails;
import com.allstate.restclaimwebservice.service.PolicyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PolicyDetailsController{

    @Autowired
    private PolicyDetailsService policyDetailsService;
    @GetMapping(value = "/policy/{claimNumber}")
    public PolicyDetails getPolicyDetails(@PathVariable int claimNumber){
        PolicyDetailsRequest request = new PolicyDetailsRequest();
        request.setClaimNumber(claimNumber);
        PolicyDetailsResponse response = policyDetailsService.sendSoapRequest(request);
        return response.getPolicyDetails();
    }

    }




