import { Application, Request, Response} from "express";
import delivEmpService = require("../service/delivEmpService");
import { delivEmp } from "../model/delivEmp";
 
module.exports = function(app: Application){
    app.get('/deliveryEmployees', async(req: Request, res: Response) => {
        let data: delivEmp[];
 
        try{
            data = await delivEmpService.getDelivEmps()
        }catch(e) {
            console.error(e);
        }
        res.render('list-deliveryEmployee', {delivEmps: data})
    })
    
    app.get('/deliveryEmployees/:id', async(req: Request, res: Response) => {
        let data: delivEmp;
 
        try{
            const {id} = req.params;
            data = await delivEmpService.getDelivEmpByID(parseInt(id));
        }catch(e) {
            console.error(e);
        }
 
        res.render('view-deliveryEmployee', {delivEmp: data})
    })
 
    app.get('/add-deliveryEmployee', async (req: Request, res: Response) => {
        res.render('add-deliveryEmployee')
    })
 
    app.post('/add-deliveryEmployee', async(req: Request, res: Response) => {
        let data: delivEmp = req.body
        let id: Number
 
        try{
            id = await delivEmpService.createDelivEmp(data)
 
            res.redirect('/deliveryEmployees/' + id)
        }catch(e) {
            console.error(e);
 
            res.locals.errormessage = e.message
 
            res.render('add-deliveryEmployee', req.body)
        }
    })
}