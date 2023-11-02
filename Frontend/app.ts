import { Request, Response } from "express"
import session = require("express-session");

const express = require('express');
const path = require('path');
const nunjucks = require('nunjucks')
const dateFilter = require('nunjucks-date-filter');

const app = express();

var appViews = path.join(__dirname, '/views/')

var nunjucksConfig = {
    autoescape: true,
    noCache: true,
    express: app
}

let config = nunjucks.configure(appViews, nunjucksConfig)
config.addFilter('date', dateFilter);

app.set('view engine', 'html')

app.use('/public', express.static(path.join(__dirname, 'public')))

app.use(express.json())

app.use(express.urlencoded({ extended: true }));

app.use(session({ secret: 'NOT HARDCODED SECRET', cookie: { maxAge: 60000}}))

declare module 'express-session' {
    interface SessionData {
    }
}

app.listen(3000, () => {
    console.log('Server listening on port 3000');
})

app.get('/', (req: Request, res: Response) => {
    res.render('template.html')
})

app.get('/hr-team.html', async (req: Request, res: Response) => {
    res.render('hr-team.html')
})

app.get('/management-team.html', async (req: Request, res: Response) => {
    res.render('management-team.html')
})

app.get('/sales-team.html', async (req: Request, res: Response) => {
    res.render('sales-team.html')
})

//add require paths here!
require('./controller/salesEmployeeController')(app);