<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="../templates/PageHeader.jsp"/>

<!-- Cart Start -->
<div class="container-fluid w-full pt-5">
    <div class="row px-xl-5">
        <div class="table-responsive mb-5">
            <table class="table table-bordered text-center mb-0">
                <thead class="bg-2ndary text-dark">
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Giá</th>
                        <th>Số lượng</th>
                        <th>Tổng</th>
                        <th>Xóa</th>
                    </tr>
                </thead>
                <tbody class="align-middle">
                    <tr>
                        <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
                   <tr>
                       <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
                   <tr>
                       <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
                   <tr>
                       <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
                   <tr>
                       <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
                   <tr>
                       <c:import url="../templates/cart/template/cart_item.jsp"/>
                   </tr>
               </tbody>
           </table>
       </div>
       	<c:import url="../templates/cart/template/cart_summary.jsp"/>
    </div>
</div>
<!-- Cart End -->

<!-- Fixed Cart Summary Start -->
<div class="container-fluid w-full pt-5 position-fixed" style="top: 350px; z-index: 10" id="cart-summary">
 	<div class="row px-xl-5">
    	<c:import url="../templates/cart/template/cart_summary.jsp"/>
    </div>
</div>
<!-- Fixed Cart Summary End -->


