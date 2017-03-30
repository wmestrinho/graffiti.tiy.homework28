<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>UPLOAD</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <style>
            .carousel-inner > .item > img,
            .carousel-inner > .item > a > img {
                width: 70%;
                margin: auto;
            }
        </style>
    </head>
<body>
<table style="width:100%">
    <tr>
        <th></th>
        <th></th>
        <th></th>

        <th><h2>GRAFFITI WALL</h2></th>
        <th></th>
    </tr>
</table>
<div class="container">
    <br>
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <c:forEach items="${pictures}" var="picture">
                <li data-target="#myCarousel" data-slide-to="<c:out value="${picture.id - 1}"/>" class="${(picture.id == 1)?'active':''}"></li>
            </c:forEach>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <c:forEach items="${pictures}" var="picture">
            <div class="item <c:out value="${(picture.id == 1)?'active':''}"/>">
                <img src="/fullOfPictures/<c:out value="${picture.pictureFileName}"/>" alt="1" width="460" height="345">
            </div>
            </c:forEach>
        </div>

        <!-- Left and right controls -->
        <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>
<div class="row">
    <form action="/posting" enctype="multipart/form-data"  method="post">
<table style="width:100%">
    <tr>
        <th><div class="form-group">
            <div class="col-xs-4">
                <label for="pictureUrl">Poster URL:</label>
                <input type="text" class="form-control" id="pictureUrl" name="pictureUrl">
            </div>
        </div>
        </th>
        <th><div class="form-group">
            <div class="col-xs-4">
                <label for="pictureFile">Poster Image:</label>
                <input type="file" class="form-control" id="pictureFile" name="pictureFile">
            </div>
        </div>
        </th>
        <th><button type="submit" class="btn btn-default">Submit</button></th>
        </tr>
    </table>
    </form>
    </div>

</body>
</html>
