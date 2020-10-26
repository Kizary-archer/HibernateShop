<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="template/header.jsp"/>
<div class="p-3">
    <div class="accordion" id="accordion">
        <div class="card">
            <div class="card-header bg-info" id="headingOne" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <h5 class="mb-0">
                    <button class="btn" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        Список заказов
                    </button>
                </h5>
            </div>

            <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordion">
                <div class="card-body">
                    <jsp:include page="template/UserOrderTempl/DTOrder.jsp"/>
                    </div>
            </div>
        </div>
    </div>
</div>
    <script type="text/javascript">
    $(document).ready( function () {
    $('#table').DataTable();
    });
    </script>
</body>
</html>