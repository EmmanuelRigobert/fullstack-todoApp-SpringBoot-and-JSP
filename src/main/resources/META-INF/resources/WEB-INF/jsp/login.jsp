
<html>
    <head>
        <title>Login</title>
    </html>
    <body>
        <h1>Login Page</h1>
        <pre>
            <h3>${errorMessage}</h3>
        </pre>
        <form method="post">
<!-- default method for form is get which passes the user and password in the url which is not secure -->
            Username<input type="text" name="username" placeholder="Enter your username" value="emmanuel"><br>
            Password<input type="password" name="password" placeholder="Enter your password" value="password"><br>
            <input type="submit">
        </form>
    </body>
</html>