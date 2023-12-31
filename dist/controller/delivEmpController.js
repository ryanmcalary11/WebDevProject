"use strict";
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
var __generator = (this && this.__generator) || function (thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (g && (g = 0, op[0] && (_ = 0)), _) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
};
Object.defineProperty(exports, "__esModule", { value: true });
var delivEmpService = require("../service/delivEmpService");
module.exports = function (app) {
    var _this = this;
    app.get('/deliveryEmployees', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        var data, e_1;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    _a.trys.push([0, 2, , 3]);
                    return [4 /*yield*/, delivEmpService.getDelivEmps()];
                case 1:
                    data = _a.sent();
                    return [3 /*break*/, 3];
                case 2:
                    e_1 = _a.sent();
                    console.error(e_1);
                    return [3 /*break*/, 3];
                case 3:
                    res.render('list-deliveryEmployee', { delivEmps: data });
                    return [2 /*return*/];
            }
        });
    }); });
    app.get('/deliveryEmployees/:id', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        var data, id, e_2;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    _a.trys.push([0, 2, , 3]);
                    id = req.params.id;
                    return [4 /*yield*/, delivEmpService.getDelivEmpByID(parseInt(id))];
                case 1:
                    data = _a.sent();
                    return [3 /*break*/, 3];
                case 2:
                    e_2 = _a.sent();
                    console.error(e_2);
                    return [3 /*break*/, 3];
                case 3:
                    res.render('view-deliveryEmployee', { delivEmp: data });
                    return [2 /*return*/];
            }
        });
    }); });
    app.get('/add-deliveryEmployee', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            res.render('add-deliveryEmployee');
            return [2 /*return*/];
        });
    }); });
    app.post('/add-deliveryEmployee', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        var data, id, e_3;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    data = req.body;
                    _a.label = 1;
                case 1:
                    _a.trys.push([1, 3, , 4]);
                    return [4 /*yield*/, delivEmpService.createDelivEmp(data)];
                case 2:
                    id = _a.sent();
                    res.redirect('/deliveryEmployees/' + id);
                    return [3 /*break*/, 4];
                case 3:
                    e_3 = _a.sent();
                    console.error(e_3);
                    res.locals.errormessage = e_3.message;
                    res.render('add-deliveryEmployee', req.body);
                    return [3 /*break*/, 4];
                case 4: return [2 /*return*/];
            }
        });
    }); });
    app.get('/update-deliveryEmployee-firstName', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            // req.session.regenerate(function(err) {
            //     // New session here
            //   })
            // HackSplaining code for session generation, (session fixation)
            if (!req.session.delivEmp) {
                req.session.delivEmp = {};
            }
            res.render('update-deliveryEmployee-surname');
            return [2 /*return*/];
        });
    }); });
    app.put('/update-deliveryEmployee-surname', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            req.session.delivEmp["lName"] = req.body.lName;
            res.redirect('/n');
            return [2 /*return*/];
        });
    }); });
    app.get('/update-deliveryEmployee-salary', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            res.render('update-deliveryEmployee-salary');
            return [2 /*return*/];
        });
    }); });
    app.put('/update-deliveryEmployee-salary', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            req.session.delivEmp["salary"] = req.body.salary;
            res.redirect('/update-deliveryEmployee-nationalInsuranceNumber');
            return [2 /*return*/];
        });
    }); });
    app.get('/update-deliveryEmployee-nationalInsuranceNumber', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            res.render('update-deliveryEmployee-nationalInsuranceNumber');
            return [2 /*return*/];
        });
    }); });
    app.put('/update-deliveryEmployee-nationalInsuranceNumber', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            req.session.delivEmp["niNum"] = req.body.niNum;
            res.redirect('/update-deliveryEmployee-bankAccountNumber');
            return [2 /*return*/];
        });
    }); });
    app.get('/update-deliveryEmployee-bankAccountNumber', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            res.render('update-deliveryEmployee-bankAccountNumber');
            return [2 /*return*/];
        });
    }); });
    app.put('/update-deliveryEmployee-bankAccountNumber', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            req.session.delivEmp["bankAccountNo"] = req.body.bankAccountNo;
            res.redirect('/update-deliveryEmployee-confirm');
            return [2 /*return*/];
        });
    }); });
    app.get('/update-deliveryEmployee-confirm', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        return __generator(this, function (_a) {
            res.render('update-deliveryEmployee-confirm', req.session.delivEmp);
            return [2 /*return*/];
        });
    }); });
    app.put('/update-deliveryEmployee-confirm', function (req, res) { return __awaiter(_this, void 0, void 0, function () {
        var data, id, e_4;
        return __generator(this, function (_a) {
            switch (_a.label) {
                case 0:
                    data = req.session.delivEmp;
                    _a.label = 1;
                case 1:
                    _a.trys.push([1, 3, , 4]);
                    return [4 /*yield*/, delivEmpService.createDelivEmp(data)
                        //console.log(id)
                        //console.log("still on stack")
                    ];
                case 2:
                    id = _a.sent();
                    //console.log(id)
                    //console.log("still on stack")
                    req.session.delivEmp = undefined;
                    res.redirect('/deliveryEmployee/' + id);
                    return [3 /*break*/, 4];
                case 3:
                    e_4 = _a.sent();
                    console.log(e_4);
                    res.locals.errormessage = e_4.message;
                    res.render('update-deliveryEmployee-firstName', req.session.delivEmp);
                    return [3 /*break*/, 4];
                case 4: return [2 /*return*/];
            }
        });
    }); });
};
//# sourceMappingURL=delivEmpController.js.map