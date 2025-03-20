<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <title>Update Todo</title>
    </html>
    <body>
        <div>Welcome ${username}</div>
        <hr>
        <h1>Update Todo</h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset>
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" placeholder="Enter your description"  required="required"/><br>
                <form:errors path="description" cssClass="error"/><br>
            </fieldset>
            <br/>
            <fieldset>
                <form:label path="dateline">Dateline</form:label>
                <form:input type="date" path="dateline" placeholder="Enter your target date" /><br>
                <form:errors path="dateline" cssClass="error"/><br>
            </fieldset>
            <br/>
            <form:input type="hidden" path="id"/>
            <form:input type="hidden" path="done" value="false"/>
            <input type="submit">
        </form:form>
    </body>
</html>