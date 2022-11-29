<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  	<title>Brand</title>
  	<c:import url="../templates/Head.jsp" />
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootsstrap.css">
</head>
<body>
  	<c:import url="../templates/Header.jsp" />
  	
  	<c:import url="../templates/cart/carts.jsp" />
  	    
  	<c:import url="../templates/Footer.jsp" />
  	
  	
	<script type="text/javascript">
        window.addEventListener("scroll", function(){
            var footer = document.querySelector("footer")
            if (window.scrollY >= document.body.scrollHeight - footer.scrollHeight - screen.height)
            {
                document.getElementById("cart-summary").style.display = "none"
            }
            else{
                document.getElementById("cart-summary").style.display = "block"
            }  
        })
	</script>
</body>
</html>
