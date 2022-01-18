<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
    <H2>All users:</H2>
    <table border="1">
        <thead>
        <tr>
            <th>UserID</th><th>FirstName</th><th>LastName</th>
            <th>PhoneNum</th><th>Email</th><th>Address</th>
            <th>Password</th><th>Update</th><th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.userID}</td>
                <td>${u.firstName}</td>
                <td>${u.lastName}</td>
                <td>${u.phoneNum}</td>
                <td>${u.email}</td>
                <td>${u.address}</td>
                <td>${u.password}</td>
                <td><a type="button" href="/update-user/${u.userID}">UPDATE</a></td>
                <td><a type="button" href="/delete-user/${u.userID}">DELETE</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

    <div>
        <a href="add-user">Add new User</a>
    </div>
</div>
<%@ include file="common/footer.jspf"%>