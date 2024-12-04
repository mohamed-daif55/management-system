<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
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
    <h1>Employee List</h1>

    <c:if test="${empty employees}">
        <p>No employees found.</p>
    </c:if>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employees}">
                <tr>
                    <td>${employee.id}</td>
                    <td>${employee.name}</td>
                    <td>${employee.email}</td>
                    <td>${employee.department != null ? employee.department.name : 'No Department'}</td>
                    <td>
                        <a href="/employeesJSP/id/${employee.id}">View</a> |
                        <a href="/employeesJSP/edit/${employee.id}">Edit</a> |
                        <a href="/employeesJSP/delete/${employee.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="/employeesJSP/add">Add New Employee</a>
</body>
</html>




