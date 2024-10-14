
$(document).ready(() => {
    const logoutButton = document.getElementById('logout-button');
    if (logoutButton) {
        logoutButton.onclick = function () {
            alert('로그아웃 되었습니다.');
            window.location.href = "/logout";
        };
    }
    let provinces = [];

    // JSON 파일 로드
    function loadProvinces() {
        $.ajax({
            url: '/js/regionData.json', // JSON 파일 경로
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                provinces = data;
                renderProvinceList(); // 리스트 렌더링
            },
            error: function () {
                console.error('Error loading provinces JSON');
            }
        });
    }
    let lastClickedLi = null;
    // province 리스트 렌더링
    function renderProvinceList() {
        const provinceListElement = $('#provinceList');
        provinceListElement.empty(); // 이전 내용을 지웁니다.

        provinces.forEach(item => {
            const li = $('<li></li>')
                .text(item.province)
                .data('nx', item.nx)
                .data('ny', item.ny)
                .on('click', function() { // 화살표 함수 대신 일반 함수 사용
                    // 이전에 클릭한 항목의 색상을 원래대로 돌림
                    if (lastClickedLi) {
                        lastClickedLi.css('background-color', ''); // 기본 배경색으로 복원
                    }

                    // 현재 클릭한 항목의 색상을 변경
                    $(this).css('background-color', 'lightblue'); // 클릭한 항목 색상 변경
                    lastClickedLi = $(this); // 현재 항목을 lastClickedLi로 설정

                    // 데이터 서버에 전송
                    sendDataToServer(item.nx, item.ny);
                });
            provinceListElement.append(li);
        });
    }

    // 선택한 province의 nx, ny 값을 Controller로 전송
    function sendDataToServer(nx, ny) {
        $.ajax({
            url: '/weather', // Controller URL
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({nx, ny}),
            success:  (result)=> {
                const weatherHtml = `
            <p>온도: ${result.temperature}</p>
            <p>습도: ${result.humidity}</p>
            <p>바람 속도: ${result.windSpeed}</p>
            <p>1시간 강수량: ${result.oneHourPrecipitation}</p>
            <p>바람 방향: ${result.windDirection}</p>
            <p>강수 종류: ${result.precipitationType}</p>
        `;

                // #weather-info 요소에 날씨 정보 삽입
                $('.weather-details').html(weatherHtml);


                const temperature = parseFloat(result.temperature);
                const thermometerHeight = (temperature + 40) * (200 / 80); // 예: -40도에서 +40도까지의 범위를 200px로 매핑
                $('#thermometer-fill').css('height', `${thermometerHeight}px`);
                $('#current-temperature').text(`온도: ${result.temperature}℃`);
            },
            error: function () {
                console.error('Error sending data to server');
            }
        });
    }

    loadProvinces(); // 페이지 로드 시 JSON 파일 로드

});