package org.kainos.ea.core;

import org.kainos.ea.cli.DelivEmployee;
import org.kainos.ea.cli.DeliveryProject;
import org.kainos.ea.cli.Project;

public class DelivEmpToProjectValidator {

    public static String isDelivEmpToProjectValid(int deliveryProjectId,int projectId){
        if(deliveryProjectId < 0){
            return "Project Id cannot be less than 0";
        }
        if(projectId < 0) {
            return "delivery employee Id cannot be less than 0";
        }

        return null;
    }


}
