package com.allstate.restclaimwebservice.controller

import com.allstate.restclaimwebservice.model.PolicyDetails
import com.allstate.restclaimwebservice.service.PolicyDetailsService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import spock.lang.Specification

import static org.mockito.ArgumentMatchers.any

//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*

import static org.mockito.Mockito.when

@WebMvcTest(PolicyDetailsController)
class PolicyDetailsControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    @MockBean
    PolicyDetailsService policyDetailsService;

    def 'should return policy details for a valid claim number'() {
        given:
        int claimNumber = 123
        PolicyDetails policyDetails = new PolicyDetails()
        policyDetails.setHolderName("HolderOne")
        policyDetails.setPolicyNumber(1234)
        policyDetails.setCoverageLimit(40000)
        policyDetails.setCoverageName("Health")
        policyDetails.setDeductible(2000)

        PolicyDetailsResponse response = new PolicyDetailsResponse()
        response.setPolicyDetails(policyDetails)
        when(policyDetailsService.getPolicyDetails(any(PolicyDetailsRequest))).thenReturn(response)

        when:
        def result = mvc.perform(MockMvcRequestBuilders.get("/policy/{claimNumber}", claimNumber))

        then:
        result.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().response;
    }

    def "should throw exception for an invalid claim number"() {
        given:
        int claimNumber = 12
        when(policyDetailsService.getPolicyDetails(any(PolicyDetailsRequest))).thenThrow(new Exception())

        when:
        def result = mvc.perform(MockMvcRequestBuilders.get("/policy/{claimNumber}", claimNumber))

        then:
        result.andExpect(MockMvcResultMatchers.status().isNotFound())
    }
}