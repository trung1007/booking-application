<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>User Detail</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5 d-flex justify-content-center">
    <div class="card shadow-lg rounded-4" style="width: 50%;">
        <div class="card-header bg-primary text-white text-center fw-bold fs-4">
            User Information
        </div>
        <div class="card-body">
            <div class="mb-3">
                <label class="form-label fw-bold">ID</label>
                <input type="text" class="form-control" value="${user.id}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Email</label>
                <input type="email" class="form-control" value="${user.email}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Full Name</label>
                <input type="text" class="form-control" value="${user.fullName}" disabled>
            </div>
            <div class="mb-3">
                <label class="form-label fw-bold">Phone Number</label>
                <input type="text" class="form-control" value="${user.phoneNumber}" disabled>
            </div>
        </div>
        <div class="card-footer text-center">
            <a href="/admin/user" class="btn btn-success px-4">Back</a>
            <button class="btn btn-primary px-4">Edit</button>
            <button class="btn btn-danger px-4">Delete</button>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
