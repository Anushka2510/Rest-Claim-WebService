package com.allstate.restclaimwebservice.service


import org.springframework.ws.client.core.WebServiceTemplate
import spock.lang.Specification

class PolicyDetailsServiceSpec extends Specification{

    def webServiceTemplate = Mock(WebServiceTemplate)


    def "should return policy details response"() {
        given:

        def policyDetailsService = new PolicyDetailsService(webServiceTemplate)
        def request = new PolicyDetailsRequest()
        def expectedResponse = new PolicyDetailsResponse()

        when:
        def result = policyDetailsService.getPolicyDetails(request)

        then:
        1 * webServiceTemplate.marshalSendAndReceive(request) >> expectedResponse
        result == expectedResponse
    }

    def "should throw exception when claim number does not exist"() {
        given:
        PolicyDetailsService service = new PolicyDetailsService(webServiceTemplate)
        PolicyDetailsRequest request = new PolicyDetailsRequest()

        webServiceTemplate.marshalSendAndReceive(request) >> { throw new Exception("Claim Number Does not exist exception") }

        when:
        service.getPolicyDetails(request)

        then:
        Exception e = thrown()
        e.message == "Claim Number Does not exist exception"
    }

}
