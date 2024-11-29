// AJAX 요청을 처리하는 함수
    $(document).ready(function() {

    $('#orderForm').on('submit', function(event) {
        event.preventDefault(); // 폼이 제출되지 않도록 막음

        // ISBN과 수량을 가져옵니다.
        var isbn = $('#isbn').val();
        var quantity = $('#quantity').val();

        // JSON 데이터 형식으로 준비
        var data = {
            "isbn": isbn,
            "quantity": quantity
        };

        // AJAX 요청
        $.ajax({
            url: '/api/orders',  // 서버의 URL (이 부분은 실제 API 엔드포인트로 수정)
            type: 'POST',
            contentType: 'application/json',  // JSON 형식으로 전송
            data: JSON.stringify(data),  // 객체를 JSON 문자열로 변환
            success: function(response) {
                // 성공시 응답 처리
                $('#response1').html('Order successfully placed: ' + JSON.stringify(response));
            },
            error: function(xhr, status, error) {
                // 오류 발생 시
                $('#response1').html('Error: ' + error);
            }
        });
    });
        $('#getOrdersBtn').on('click', function() {
            $.ajax({
                url: '/api/orders',  // GET 요청을 보낼 URL
                type: 'GET',  // GET 요청
                success: function(response) {
                    // 서버에서 받은 응답을 화면에 표시
                    let ordersHtml = '<ul>';
                    response.forEach(order => {
                        ordersHtml += `
                                <li>
                                    <strong>ISBN:</strong> ${order.bookIsbn}<br>
                                    <strong>Book Name:</strong> ${order.bookName}<br>
                                    <strong>Price:</strong> ${order.bookPrice}<br>
                                    <strong>Quantity:</strong> ${order.quantity}<br>
                                    <strong>Status:</strong> ${order.status}<br>
                                    <strong>Created Date:</strong> ${order.createdDate}<br>
                                    <strong>Last Modified:</strong> ${order.lastModifiedDate}<br><br>
                                </li>
                            `;
                    });
                    ordersHtml += '</ul>';

                    // 가져온 데이터를 화면에 표시
                    $('#response').html(ordersHtml);
                },
                error: function(xhr, status, error) {
                    // 오류 발생 시
                    $('#response').html('Error: ' + error);
                }
            });
        });
});