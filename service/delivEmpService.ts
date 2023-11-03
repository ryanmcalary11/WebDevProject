import { delivEmp } from "../model/delivEmp";
const delivEmpValidor = require("../validator/delivEmpValidator");
const axios = require('axios');
 
export async function getDelivEmps(): Promise<delivEmp[]>{
    try{
        const response = await axios.get('http://localhost:8080/api/deliveryEmployees')
 
        return response.data
    }catch(e){
        throw new Error('Could not get delivery employees')
    }
}
 
export async function getDelivEmpByID (id: number): Promise<delivEmp> {
    try{
        const response = await axios.get('http://localhost:8080/api/deliveryEmployee/' + id)
 
        return response.data
    }catch(e){
        throw new Error('Could not get delivery employee')
    }
}
 
export async function createDelivEmp (delivEmp: delivEmp): Promise<number> {
    
    const error: string = delivEmpValidor.validateDelivEmp(delivEmp)
    
    if(error){
        throw new Error(error)
    }
 
    try{
        const response = await axios.post('http://localhost:8080/api/deliveryEmployees/', delivEmp)
 
        return response.data
    }catch(e){
        throw new Error('Could not create delivery employee')
    }
}