//required libraries - first time remember to "npm install express fs mongodb dotenv"
const Express = require("express");
const fs = require('fs');
const cors = require("cors");
 
//use dotenv config file to keep connection strings etc. private
require('dotenv').config();
 
//these are all defined in the .env file (for security reasons, the .env file never goes in a repo!)
const HOST = process.env.HOST;
const PORT = process.env.PORT;
 
//create the app (new instance of ExpressJs, a minimalist framework) https://expressjs.com/
var app = Express();
 
//neccessary in order to access request.body.xxxx properties
app.use(Express.json());
app.use(Express.urlencoded({ extended: true }));
app.use(cors());

const http = require("http").createServer(app);

http.listen(PORT, () => {
    console.log("listening on http port " + PORT + " on " + HOST);
});

app.get("/test", (require, response) => {
    response.send("App is up and running " + new Date());
});

app.get("/api/dashboard", (request, response) => {
    
    fs.readFile(
        "data.json",
        (error, file_content) => {

            if (error) throw error;
            response.statusCode = 200;
            response.setHeader ("Content-type", "application/json");
            response.json(JSON.parse(file_content));
            response.end();


        }
    );
});