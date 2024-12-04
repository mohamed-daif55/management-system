<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Department Form</title>
</head>
<body>
    <h1>${department.id == null ? 'Add Department' : 'Edit Department'}</h1>
    <form action="${department.id == null ? '/departmentsJSP' : '/departmentsJSP/update/' + department.id}" method="post">
        <label for="name">Department Name:</label>
        <input type="text" id="name" name="name" value="${department.name}" required><br>

        <input type="submit" value="Submit">
    </form>

    <a href="/departmentsJSP">Back to Department List</a>
</body>
</html>
