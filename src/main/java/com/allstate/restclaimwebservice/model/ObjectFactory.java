//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.08 at 12:56:45 PM IST 
//


package com.allstate.restclaimwebservice.model;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.allstate.soapclaimwebservice.model package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.allstate.soapclaimwebservice.model
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PolicyDetailsRequest }
     */
    public PolicyDetailsRequest createGetPolicyDetailsRequest() {
        return new PolicyDetailsRequest();
    }

    /**
     * Create an instance of {@link PolicyDetailsResponse }
     */
    public PolicyDetailsResponse createGetPolicyDetailsResponse() {
        return new PolicyDetailsResponse();
    }

    /**
     * Create an instance of {@link PolicyDetails }
     */
    public PolicyDetails createPolicyDetails() {
        return new PolicyDetails();
    }

}
