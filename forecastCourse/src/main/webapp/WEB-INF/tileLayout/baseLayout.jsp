<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<title>Myway</title>
</head>
<body>
     <tiles:insertAttribute name="header"/>        
     <tiles:insertAttribute name="menu" />
     
     <tiles:insertAttribute name="body" />                                                  
    
 
     <tiles:insertAttribute name="footer" />
</body>
</html>


