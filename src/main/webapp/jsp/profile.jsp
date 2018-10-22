<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>

<head>

    <!-- http://getbootstrap.com/ -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">

    <link href="resources/css/styles.css" rel="stylesheet"/>

    <title>CRUD App</title>

</head>

<body>
<nav class="navbar navbar-expand-md navbar-light bg-light border">
    <a class="navbar-brand" href=""><span class="red">CRUD App</span></a>
    <button aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler"
            data-target="#navbar" data-toggle="collapse" type="button">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar">
        <ul class="navbar-nav ml-auto mt-2">
            <li class="nav-item"><a class="nav-link" href="delete">Delete</a></li>
            <li class="nav-item"><a class="nav-link" href="logout">Log Out</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div id="top">
    </div>
    <div id="middle">
        <main class="container p-5">

            <form action="profileUpdate" method="post">
                <fieldset>
                    <div class="form-group">
                        <input autocomplete="off" autofocus class="form-control" name="username" value="${p.username}" type="text"/>
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="hash" value="${p.hash}" type="password"/>
                    </div>
                    <div class="form-group">
                        <input class="form-control" name="confirmation" value="${p.hash}" type="password"/>
                    </div>
                    <div class="form-group">
                        <input autocomplete="off" autofocus class="form-control" name="firstName"
                               value="${p.firstName}" type="text"/>
                    </div>
                    <div class="form-group">
                        <input autocomplete="off" autofocus class="form-control" name="lastName" value="${p.lastName}"
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <input autocomplete="off" autofocus class="form-control" name="address" value="${p.address}"
                               type="text"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-default" type="submit">
                            <span aria-hidden="true" class="glyphicon glyphicon-log-in"></span>
                            Update
                        </button>
                    </div>
                </fieldset>
            </form>
        </main>
    </div>
</div>
</body>
</html>