package org.kainos.ea.core;

import org.kainos.ea.cli.ProjectRequest;

public class ProjectValidator {
    public String isValidProject(ProjectRequest projectRequest) {
        if(projectRequest.getProjectName().length() > 500){
            return "The project name is greater than 500";
        }
        if(projectRequest.getProjectValue() < 0 ){
            return "Value can not be less than 0";
        }

        return null;
    }
}
