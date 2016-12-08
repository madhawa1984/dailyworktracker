package com.oriansolution.dwt.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by madhawa on 11/14/16.
 * This AppStatus class will be a singleton class.
 */

@Component
@EnableConfigurationProperties(ApplicationProperties.class)
public class AppStatus {

    @Autowired
    private ApplicationProperties applicationProperties;

    public ApplicationProperties getApplicationProperties() {
        return applicationProperties;
    }


    public String getApplicationStatus() {
        // logic to check the entire application status
        applicationStatus = "Pending";
        return applicationStatus;
    }


    public String getDbConnectionStatus() {
        // logic to check the entire dbConnection Status
        // dbConnectionStatus = "Pending serverurl:- "+dbprops.getDbconnectionProps().get("dburl");
        dbConnectionStatus = "Pending";
        return dbConnectionStatus;
    }

    public String getUpmServiceStatus() {
        // logic to check the entire upmService Status
        upmServiceStatus = "Pending";
        return upmServiceStatus;
    }

    public String getCurrentExecutionProfile() {
        return currentExecutionProfile;
    }

    @Value("${application.execution.profile}")
    public void setCurrentExecutionProfile(String executionProfile) {
        currentExecutionProfile = executionProfile;
    }
    public String getApplicationName() {
        return applicationName;
    }


    /* spring does not allow to inject property values into static member variables.instead that static member
    accessed via setter method and inject values via it.
    for static member will runt
    for static member variables with having public methods */

    @Value("${application.name}")
    public void setApplicationName(String appName) {
        applicationName = appName;

    }

    private static String dbConnectionStatus;
    private static String upmServiceStatus;
    private static String currentExecutionProfile;
    private static String applicationStatus;
    private static String applicationName;


}
