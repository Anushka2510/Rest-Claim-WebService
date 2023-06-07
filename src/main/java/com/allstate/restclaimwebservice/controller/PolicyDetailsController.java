package com.allstate.restclaimwebservice.controller;
import com.allstate.restclaimwebservice.model.PolicyDetailsRequest;
import com.allstate.restclaimwebservice.model.PolicyDetailsResponse;
import com.allstate.restclaimwebservice.model.PolicyDetails;
import com.allstate.restclaimwebservice.service.PolicyDetailsService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PolicyDetailsController{

    @Autowired
    private PolicyDetailsService policyDetailsService;
    @GetMapping(value = "/policy/{claimNumber}")
    public PolicyDetails getPolicyDetails(@PathVariable int claimNumber) throws Exception {
        PolicyDetailsRequest request = new PolicyDetailsRequest();
        request.setClaimNumber(claimNumber);
        PolicyDetailsResponse response = policyDetailsService.getPolicyDetails(request);
        return response.getPolicyDetails();
    }

    }




