import { Application, Request, Response } from "express";
import { SalesEmployee } from "../model/salesEmployee";
const salesEmployeeService = require('../service/salesEmployeeService')

module.exports = function(app: Application){

    app.get('/sales-employees', async (req: Request, res: Response) => {
        let data: SalesEmployee[]

        try {
            data = await salesEmployeeService.getSalesEmployees()
        } catch (e) {
            console.error(e);
        }

        res.render('list-sales-employees', { salesEmployees: data } )
    })


    app.get('/sales-employees/:id', async (req: Request, res: Response) => {
        let data: SalesEmployee

        try {
            data = await salesEmployeeService.getSalesEmployeeById(req.params.id)
        } catch (e) {
            console.error(e);
        }

        res.render('view-sales-employee', { salesEmployee: data} )
    })
}