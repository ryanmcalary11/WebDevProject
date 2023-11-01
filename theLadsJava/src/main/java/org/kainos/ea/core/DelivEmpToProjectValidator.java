package org.kainos.ea.core;

import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.Project;

public class DelivEmpToProjectValidator {

    public String isDelivEmpToProjectValid(Project project, DelivEmployee delivEmp){
        if(project.getProjectId() < 0){
            return "Project Id cannot be less than 0";
        }
        if(delivEmp.getDelivEmpId() < 0) {
            return "delivery employee Id cannot be less than 0";
        }

        return null;
    }


}
