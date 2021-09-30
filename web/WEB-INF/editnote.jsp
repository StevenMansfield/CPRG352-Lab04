<%-- 
    Document   : editnote
    Created on : Sep 30, 2021, 10:55:44 AM
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
        <h2>Edit Note</h2>
        <form method="POST" action="note">
            <div>
                <label>Title:</label>
                <input type="text" name="title" value="${note.title}">
            </div>
            <div>
                <label>Contents:</label>
                <textarea name="contents">
                    ${note.contents}
                </textarea>
            </div>
            <div>
                <input type="submit" name="Save">
            </div>
        </form>
    </body>
</html>
