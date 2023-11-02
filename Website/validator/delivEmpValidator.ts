import { delivEmp } from "../model/delivEmp";

module.exports.validateDelivEmp = function ( delivEmp: delivEmp): string {

    console.log(delivEmp.fName.length);
    if(delivEmp.fName.length > 50){
        return "Forename must be no grater than 50 characters";
    }

    // if(delivEmp.lName.length > 50){
    //     return "Surname must be no grater than 50 characters";
    // }

    // if(delivEmp.bankAccountNo.length == 16){
    //     return "Bank account number must be 16 digits long";
    // }

    // if(delivEmp.niNum.length == 9){
    //     return "National insurance number must be 9 characters long";
    // }

    // if(delivEmp.salary > 0 && delivEmp.salary < 1000000){
    //     return "Salary must be above 0 and belove 1,000,000";
    // }

    return null
}