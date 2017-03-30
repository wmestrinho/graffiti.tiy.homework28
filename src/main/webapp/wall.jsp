<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>








<div class="container">

    <div class="row">
        <c:forEach items="${up_load}" var="aPic">
            <div class="card col-sm-12 col-md-4">
                <h4 class="card-title"><c:out value="${aPic.name}"/></h4>
                <c:if test="${aPic.posterUrl != null && aPic.posterUrl.length() > 0}">
                    <img class="card-img-top" width="100" src="<c:out value="${aPic.posterUrl}"/>" alt="Card image cap">
                </c:if>
                <c:if test="${aPic.posterFile != null && aPic.posterFile.length() > 0}">
                    <img class="card-img-top" width="100" src="/fullOfPictures/<c:out value="${aPic.posterFileName}"/>" alt="Card image cap">
                </c:if>
                <div class="card-block">
                    <p class="card-text"><c:out value="${aPic.description}"/></p>
                    <p class="card-text"><small class="text-muted"><c:out value="${aPic.mpaaRating}"/></small></p>
                    <p class="card-text"><a class="btn btn-info" href="/secure/movie/select?id=<c:out value="${aPic.id}"/>">Edit</a> </p>
                    <p class="card-text"><a class="btn btn-danger" href="/secure/movie/delete?id=<c:out value="${aPic.id}"/>">Delete</a> </p>
                    <p class="card-text"><a class="btn btn-warning" href="/secure/user/favorites/add?id=<c:out value="${aPic.id}"/>">Add To Favorites</a> </p>
                </div>
            </div>
        </c:forEach>


    </div>
</div>