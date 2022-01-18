<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
    <p>Add new User:</p>
    <form:form method="post" modelAttribute="user">

        <form:input path="userID" type="hidden" required="required" />
        <form:errors path="userID" />

        <form:label path="firstName">First name</form:label>
        <form:input path="firstName" type="text" required="required" />
        <form:errors path="firstName" />

        <form:label path="lastName">Last name</form:label>
        <form:input path="lastName" type="text" required="required" />
        <form:errors path="lastName" />

        <form:label path="phoneNum">Phone number</form:label>
        <form:input path="phoneNum" type="text" required="required" />
        <form:errors path="phoneNum" />

        <form:label path="email">Email</form:label>
        <form:input path="email" type="text" required="required" />
        <form:errors path="email" />

        <form:label path="address">Address</form:label>
        <form:input path="address" type="text" required="required" />
        <form:errors path="address" />

        <form:label path="password">Password</form:label>
        <form:input path="password" type="text" required="required" />
        <form:errors path="password" />

        <button type="submit">OK</button>
    </form:form>
    <body>
        <p style="color:#FF0000">${status}<p>
        <p style="color:#FF0000">${reason}<p>
    </body>
</div>
<%@ include file="common/footer.jspf"%>