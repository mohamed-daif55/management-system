<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Employee Form</title>
</head>
<body>
    <h1>Employee Form</h1>
    <form action="${employee.id == null ? '/employeesJSP' : '/employeesJSP/update/' + employee.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${employee.email}" required><br>

        <label for="department">Department:</label>
        <select id="department" name="department.id">
            <c:forEach var="dept" items="${departments}">
                <option value="${dept.id}" ${dept.id == employee.department.id ? 'selected' : ''}>${dept.name}</option>
            </c:forEach>
        </select><br>

        <input type="submit" value="Submit">
    </form>

    <a href="/employeesJSP">Back to Employee List</a>
</body>
</html>
