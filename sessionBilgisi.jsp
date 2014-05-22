<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Session</title>
</head>
<body>
<%-- bazı sayfaları import ettik  --%>
<%@ page import="java.util.Date, javax.servlet.http.*" %>

<%--önce değişkenlerimizi tanımlayalım --%>

<%! Integer accessCount;
	String id;
	Integer maxInactiveInternal;
	HttpSession session;
	Date creationTime;
	Date lastAccessTime;
	
%>

<%--daha sonra döngümüzü yazalım --%>
<%
session = request.getSession();
id = session.getId();
accessCount = (Integer) session.getAttribute("accessCount");
if(accessCount == null){
	accessCount = 0;
}
else{
	accessCount ++ ;
}
session.setAttribute("accessCount", accessCount);
maxInactiveInternal = session.getMaxInactiveInterval();

creationTime = new Date(session.getCreationTime());
lastAccessTime = new Date(session.getLastAccessedTime());

%>

<%-- son olarakta ekrana yazdırma kısmımızı yapıyoruz --%>
<%= " Access Count: " + accessCount+ "\n"%>
<%= "Session ID: " + id+ "\n" %>
<%= "Session Creation Time: " + creationTime+ "\n" %>
<%= "Session LastAccessed Time:" + lastAccessTime+ "\n" %>
<%= "Session maxInactiveInterval: " + maxInactiveInternal+ "\n" %>


</body>
</html>
