<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Todos</title>
    </html>
    <body>
        <div>Welcome ${username}</div>
        <hr>
        <h1>Your Todos</h1>
        <div> Todos ${todos}</div>
        <table>
            <tr>
                <th>Username</th>
                <th>Description</th>
                <th>Target Date</th>
                <th>Is Completed?</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach items="${todos}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <td>${todo.username}</td>
                    <td>${todo.description}</td>
                    <td>${todo.dateline}</td>
                    <td>${todo.done}</td>
                    <td><button><a href="/update-todo?id=${todo.id}">Update</a></button></td>
                    <td><button><a href="/delete-todo?id=${todo.id}">Delete</a></button></td>
                </tr>
            </c:forEach>
        </table>
        <br/>
        <button><a href="/add-todo">Add Todo</a></button>
    </body>
</html>