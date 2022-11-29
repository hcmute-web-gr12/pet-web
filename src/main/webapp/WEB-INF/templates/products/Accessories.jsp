<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Petshop - Phụ kiện pet</title>
    <%@ include file="../../templates/head.html" %>
    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
    <%@ include file="../../templates/Header.jsp" %>
    <!-- <div class="h-screen"></div> -->

    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center p-2">
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Trang chủ</a></p>
                <p class="m-0 px-2">></p>
                <p class="m-0">Phụ kiện chó mèo</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->

    <!-- Products Start -->
    <div class="container-fluid py-5">
        <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Phụ kiện chó mèo</span></h2>
        </div>
        <div class="row px-xl-5 pb-3">
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
            <%@include file="template/accessories_detail.jsp" %>
        </div>
    </div>
    <!-- Products End -->
    
    <%@ include file="../../templates/Footer.jsp" %>
</body>
</html>