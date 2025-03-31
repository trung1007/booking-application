<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit User</title>

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>
<body>
<div class="d-flex justify-content-center align-items-center min-vh-100">
    <div class="card p-4 shadow-lg col-10 col-md-6 col-lg-4">
        <h3 class="text-center mb-4">Edit User</h3>

        <form:form method="put" action="/admin/user/${id}" modelAttribute="user">
            <div class="mb-3">
                <label for="email" class="form-label">Email address</label>
                <form:input type="email" class="form-control" path="email" disabled="true"/>
            </div>
            <div class="mb-3">
                <label for="fullName" class="form-label">Full Name</label>
                <form:input type="text" class="form-control" path="fullName" />
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Address</label>
                <form:input type="text" class="form-control" path="address"/>
            </div>
            <div class="mb-3">
                <label for="phoneNumber" class="form-label">Phone Number</label>
                <form:input type="tel" class="form-control" path="phoneNumber"/>
            </div>
            <button type="submit" class="btn btn-warning w-100">Edit</button>
        </form:form>
    </div>
</div>
</body>
</html>
