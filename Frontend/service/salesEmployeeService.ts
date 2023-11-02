import { SalesEmployee } from "../model/salesEmployee";
const axios = require('axios');

module.exports.getSalesEmployees = async function (): Promise<SalesEmployee[]> {
    try {
        const response = await axios.get('http://localhost:8080/api/all-sales-employees')
    
        return response.data
    } catch (e) {
        throw new Error('Could not get sales employees')
    }
}

module.exports.getSalesEmployeeById = async function (id: number): Promise<SalesEmployee> {
    try {
        const response = await axios.get('http://localhost:8080/api/sales-employees/' + id)
    
        return response.data
    } catch (e) {
        throw new Error('Could not get order')
    }
}