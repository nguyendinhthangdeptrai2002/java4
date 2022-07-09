<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div
        class="vh-100 sticky-top d-flex flex-column flex-shrink-0 p-3 text-white bg-dark"
        style="width: 280px">
    <a href="#"
            class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none"
    >
        <i class="bi bi-apple mx-3"></i>
        <span class="fs-5">Administration Tool</span>
    </a>
    <hr/>
    <c:set var="uri" value="<%=request.getRequestURI()%>"/>
    <c:set var="video" value="${fn:containsIgnoreCase(uri, '/video-')}"/>
    <c:set var="user" value="${fn:containsIgnoreCase(uri, '/user-')}"/>
    <c:set var="report" value="${user eq 'false' and video eq 'false'}"/>

    <ul class="nav nav-pills flex-column mb-auto fs-5">
        <li class="nav-item">
<%--            <a href="#" class="nav-link active" aria-current="page">--%>
<%--                <i class="bi bi-house-door-fill"></i>--%>
<%--                <span class="mx-1">Home</span>--%>
<%--            </a>--%>
        </li>
        <li class="${video eq 'true'?'bg-warning':''}">
            <a href="${video eq 'true'?'#':'video-list'}" class="nav-link ${video eq 'true'?'text-black':'text-white'}">
                <i class="bi bi-play-btn"></i>
                <span class="mx-1">Video</span>
            </a>
        </li>

        <li class="${user eq 'true'?'bg-warning':''}">
            <a href="${user eq 'true'?'#':'user-list'}" class="nav-link ${user eq 'true'?'text-black':'text-white'}">
                <i class="bi bi-person-circle"></i>
                <span class="mx-1">User</span>
            </a>
        </li>
        <li class="${report eq 'true'?'bg-warning':''}">
            <a href="${report eq 'true'?'#':'favorite'}" class="nav-link ${report eq 'true'? 'text-black':'text-white'}">
                <i class="bi bi-file-earmark-bar-graph"></i>
                <span class="mx-1">Report</span>
            </a>
        </li>
    </ul>
    <hr/>
    <div class="dropdown">
        <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
            id="dropdownUser1"
            data-bs-toggle="dropdown"
            aria-expanded="false">
            <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2"/>
            <strong>${auth == null? "Guest": auth.id}</strong>
        </a>
        <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
            <li><a class="dropdown-item" href="/asm_java4/update-profile">Profile</a></li>
            <li><a class="dropdown-item" href="/asm_java4/change-password">Change Password</a></li>
            <li><a class="dropdown-item" href="/asm_java4/index">Client Page</a></li>
            <li>
                <hr class="dropdown-divider"/>
            </li>
            <li><a class="dropdown-item" href="/asm_java4/logout">Sign out</a></li>
        </ul>
    </div>
</div>