<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Add Todo</title>
    </html>
    <body>
        <div>Welcome ${username}</div>
        <hr>
        <h1>Add Todo</h1>
        <form:form method="post" modelAttribute="todo">
            Description <form:input type="text" path="description" placeholder="Enter your description" value="Learn AI" required="required"/><br>
                <form:errors path="description" cssClass="error"/><br>
            <br/>
            Dateline <form:input type="date" path="dateline" placeholder="Enter your target date" value="2025-09-30"/><br>
            <br/>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done" value="false"/>
            <input type="submit">
        </form:form>
    </body>
</html>