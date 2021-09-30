<%-- 
    Document   : viewnote
    Created on : Sep 30, 2021, 10:55:34 AM
    Author     : 786821
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <div>
            <b>Title:</b> ${note.title}
        </div>
        <br>
        <div>
            <b>Contents: </b>
            <br> 
            ${note.contents}
        </div>
        <br>
        <div>
            <a href="note?edit">Edit</a>
        </div>
    </body>
</html>
