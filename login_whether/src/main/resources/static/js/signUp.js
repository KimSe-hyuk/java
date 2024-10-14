
$(document).ready(() => {

    $('#signup').click(() => {

        let userId = $('#user_id').val();
        let password = $('#password').val();
        let userName = $('#user_name').val();

        let formData = {
            userId : userId,
            password : password,
            userName : userName
        }
        if (!formData.userId || !formData.password || !formData.userName) {
            alert('모든 필드를 입력하세요.');
            window.location.href = '/member/join';
        }

        $.ajax({
            type: 'POST',
            url: '/join', // 서버의 엔드포인트 URL
            data: JSON.stringify(formData), // 데이터를 JSON 형식으로 변환
            contentType: 'application/json; charset=utf-8',
            dataType: 'json', // 서버에서 받을 데이터의 타입
            success: function(response) {

                alert('회원가입이 성공했습니다.\n로그인해주세요.')

                window.location.href = response.url;
            },
            error: function(error) {
                // 실패 시 실행될 콜백 함수
                console.error('오류 발생:', error);
                alert('회원가입 중 오류가 발생했습니다.');
            }
        });

    });



});