<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<header class="p-3 bg-dark text-white">
    <div class="container">
        <c:set var="path" value="<%=request.getServletPath()%>"/>
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <%--            <a href="#" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">--%>
            <%--                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">--%>
            <%--                    <use xlink:href="#bootstrap"></use>--%>
            <%--                </svg>--%>
            <%--            </a>--%>
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">

                <c:set value="${fn:containsIgnoreCase(path,'/index')}" var="index"/>
                <c:set value="${fn:containsIgnoreCase(path,'/favorite')}" var="favorite"/>
                <c:set value="${fn:containsIgnoreCase(path,'/about')}" var="about"/>

                <li><a href="${index eq 'true'?'#':'index'}"
                       class="nav-link px-2 ${index eq 'true'?'text-secondary':'text-white'}">Online Entertainment</a>
                </li>
                <li><a href="${favorite eq 'true'?'#':'favorite'}"
                       class="nav-link px-2 ${favorite eq 'true'?'text-secondary':'text-white'}">My Favorites</a></li>
                <li><a href="${about eq 'true'?'#':'#'}"
                       class="nav-link px-2 ${about eq 'true'?'text-secondary':'text-white'}">About</a></li>
            </ul>

            <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" action="<%= request.getRequestURI().contains("favorite")? "/asm_java4/favorite": "/asm_java4/index"%>">
                <input type="search" class="form-control form-control-dark" placeholder="Search..."
                       aria-label="Search" name="keyword" value="${keyword}">
            </form>

<%--            <jsp:useBean id="auth" scope="session" class="entity.User"/>--%>
            <c:choose>
                <%--                <c:when test="${param.login eq 'true'}">--%>
                <c:when test="${auth != null}">
                    <%--                    khi ???? login r???i--%>
                    <div class="text-end">
                        <div class="dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton2"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                My Account
                            </button>
                            <ul class="dropdown-menu dropdown-menu-dark" aria-labelledby="dropdownMenuButton2">
                                <li><a class="dropdown-item" href="update-profile">Edit Profile</a></li>
                                <li><a class="dropdown-item" href="change-password">Change Password</a></li>
                                <c:if test="${auth.admin}">
                                    <li><a class="dropdown-item" href="admin/video-list">Admin Management</a></li>
                                </c:if>
                                <li>
                                    <hr class="dropdown-divider">
                                </li>
                                <li><a class="dropdown-item" href="logout">Logout</a></li>
                            </ul>
                        </div>
                    </div>
                    <%--                    <c:set value="<%= request.getPathInfo()%>" var="context"/>--%>
                </c:when>
                <%--            khi ch??a login--%>
                <c:otherwise>
                    <div class="text-end">
                        <a href="login" class="btn btn-outline-light me-2">Login</a>
                        <a href="signup" class="btn btn-warning me-2">Sign-up</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</header>
<%--</body>--%>

<%--</html>--%>
