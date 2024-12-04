<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department List</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 8px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>Department List</h1>

    <c:if test="${empty departments}">
        <p>No departments found.</p>
    </c:if>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="department" items="${departments}">
                <tr>
                    <td>${department.id}</td>
                    <td>${department.name}</td>
                    <td>
                        <a href="/departmentsJSP/id/${department.id}">View</a> |
                        <a href="/departmentsJSP/edit/${department.id}">Edit</a> |
                        <a href="/departmentsJSP/delete/${department.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="/departmentsJSP/add">Add New Department</a>
</body>
</html>
