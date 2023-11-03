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

    app.get('/update-deliveryEmployee-firstName', async (req: Request, res: Response) => {
        
        // req.session.regenerate(function(err) {
        //     // New session here
        //   })
        // HackSplaining code for session generation, (session fixation)
          

        if(!req.session.delivEmp){
            req.session.delivEmp = {}
        }

        res.render('update-deliveryEmployee-surname')

    })

    app.put('/update-deliveryEmployee-surname', async (req: Request, res: Response) => {
  
        req.session.delivEmp["lName"] = req.body.lName

        res.redirect('/n')
    })

    app.get('/update-deliveryEmployee-salary', async (req: Request, res: Response) => {

        res.render('update-deliveryEmployee-salary')

    })

    app.put('/update-deliveryEmployee-salary', async (req: Request, res: Response) => {
  
        req.session.delivEmp["salary"] = req.body.salary

        res.redirect('/update-deliveryEmployee-nationalInsuranceNumber')

    })

    app.get('/update-deliveryEmployee-nationalInsuranceNumber', async (req: Request, res: Response) => {

        res.render('update-deliveryEmployee-nationalInsuranceNumber')

    })

    app.put('/update-deliveryEmployee-nationalInsuranceNumber', async (req: Request, res: Response) => {
  
        req.session.delivEmp["niNum"] = req.body.niNum

        res.redirect('/update-deliveryEmployee-bankAccountNumber')

    })

    app.get('/update-deliveryEmployee-bankAccountNumber', async (req: Request, res: Response) => {

        res.render('update-deliveryEmployee-bankAccountNumber')

    })

    app.put('/update-deliveryEmployee-bankAccountNumber', async (req: Request, res: Response) => {
  
        req.session.delivEmp["bankAccountNo"] = req.body.bankAccountNo

        res.redirect('/update-deliveryEmployee-confirm')

    })

    app.get('/update-deliveryEmployee-confirm', async (req: Request, res: Response) => {

        res.render('update-deliveryEmployee-confirm', req.session.delivEmp)

    })

    app.put('/update-deliveryEmployee-confirm', async (req: Request, res: Response) => {
  
        let data: delivEmp = req.session.delivEmp
        let id: Number

        try{

            id = await delivEmpService.createDelivEmp(data)
            //console.log(id)
            //console.log("still on stack")

            req.session.delivEmp = undefined

            res.redirect('/deliveryEmployee/' + id)
        }
        catch(e){
            console.log(e)

            res.locals.errormessage = e.message

            res.render('update-deliveryEmployee-firstName', req.session.delivEmp)

        }

    })
}