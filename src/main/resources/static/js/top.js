/* 
* トップ画面関連の制御
*/
jQuery(function($) {

	// -------------- 画面読み込み時に呼び出し -------------- 
	// ====== 日付時計の設定 ======
	displayTime();
	// 1000ミリ秒間隔で以下関数を実行
	setInterval(displayTime, 1000);

	// ====== カレンダーの設定 ======
	calendar(0, 0);


	//  -------------- ボタンごとの制御 -------------- 
	// カレンダーの「＜」を押したとき
	$('#btn_prev').click(function() {
		// 現在表示しているカレンダーの年月を取得
		var yearMonth = $("#calendar-year-day").text().split('/');
		var year = Number(yearMonth[0])
		var month = Number(yearMonth[1]) - 1;
		calendar(year, month);
	});

	// カレンダーの「＞」を押したとき
	$('#btn_next').click(function() {
		// 現在表示しているカレンダーの年月を取得
		var yearMonth = $("#calendar-year-day").text().split('/');
		var year = Number(yearMonth[0])
		var month = Number(yearMonth[1]) + 1;
		calendar(year, month);
	});

});


// -------------- 日付と時刻の機能 -------------- 
function displayTime() {

	// 二桁で0埋めの指定
	var padZero = (value) => value.toString().padStart(2, "0");

	// 曜日算出用の配列
	var week = ["日", "月", "火", "水", "木", "金", "土"];

	// 現在日時の取得
	var now = new Date();
	var year = padZero(now.getFullYear());
	var mon = padZero(now.getMonth() + 1);
	var date = padZero(now.getDate());
	var daynum = padZero(now.getDay());
	var hour = padZero(now.getHours());
	var minute = padZero(now.getMinutes());
	var second = padZero(now.getSeconds());

	// 曜日を数字から文字列に変換
	var day = week[Number(daynum)];

	// 画面にバインドする内容を記載
	var currentTime = `${year}年${mon}月${date}日（${day}）  ${hour}:${minute}:${second}`;
	// 指定要素に日時を追加
	document.querySelector(".clock").textContent = currentTime;
};

// -------------- カレンダーを生成する機能 -------------- 
function calendar(year, month) {

	// 曜日算出用の配列
	var week = ['日', '月', '火', '水', '木', '金', '土'];

	// 日付項目の取得
	if (year == 0 && month == 0) {
		// 初期表示の場合
		var date = new Date();
		year = date.getFullYear();
		month = date.getMonth() + 1;
	}

	var startDate = new Date(year, month - 1, 1);// 月の最初の日を取得
	var endDate = new Date(year, month, 0); // 月の最後の日を取得
	var endDayCount = endDate.getDate(); // 月の末日
	var lastMonthEndDate = new Date(year, month - 1, 0); // 前月の最後の日の情報
	var lastMonthendDayCount = lastMonthEndDate.getDate();// 前月の末日
	var startDay = startDate.getDay();// 月の最初の日の曜日を取得
	let dayCount = 1; // 日にちのカウント
	let calendarHtml = ''; // HTMLを組み立てる変数

	// 対象月の祝日を取得
	//getHoliday(year, month);

	calendarHtml += '<h1 id="calendar-year-day" style="margin-top:10px; margin-left:48px;">' + year + '/' + month + '</h1>'
	calendarHtml += '<table class="calendar-table">';

	// 曜日の行を作成
	for (let i = 0; i < week.length; i++) {
		calendarHtml += '<td class="calender-td">' + week[i] + '</td>'
	}

	// ひとまず6行の表
	for (let w = 0; w < 6; w++) {
		calendarHtml += '<tr>'

		for (let d = 0; d < 7; d++) {
			if (w == 0 && d < startDay) {
				// 1行目で1日の曜日の前
				let num = lastMonthendDayCount - startDay + d + 1
				calendarHtml += '<td class="calender-td" id="is-disabled">' + num + '</td>'
			} else if (dayCount > endDayCount) {
				// 末尾の日数を超えた
				let num = dayCount - endDayCount
				calendarHtml += '<td class="calender-td" id="is-disabled">' + num + '</td>'
				dayCount++
			} else {
				calendarHtml += '<td class="calender-td">' + dayCount + '</td>'
				dayCount++
			}
		}
		calendarHtml += '</tr>'
	}
	calendarHtml += '</table>'

	document.querySelector('#calendar').innerHTML = calendarHtml;
};

// -------------- 祝日の取得 -------------- 
function getHoliday(year, month) {

	var holidays = [];
	// CSVの読み込み jqueryのget関数 text型で読み込む
	//$.get(window.location.origin + './csv/syukujitsu.csv', CSV_parser, 'text');
	$.get('./csv/syukujitsu.csv', CSV_parser, 'text');
	
	var holidays = $.csv.toArrays(data);
	
	/** 
	$.ajax({
	  url: './csv/syukujitsu.csv'
	}).done(function(data, textStatus, jqXHR){
	  holidays = $.csv.toArrays(data);
	  console.log(csv);
	}).fail(function(jqXHR, textStatus, errorThrown){
	  console.log(errorThrown);
	});
	*/
	
	
	/**
	//祝日読み取り
	var holidays = [];
	let req = new XMLHttpRequest();
	req.open("get", "syukujitsu.csv", true);
	req.overrideMimeType('text/plain; charset=Shift_JIS');
	req.send();

	req.onload = function() {
		// csvを配列に変換
		holidays = convertCSVtoArray(req.responseText);
	}

	//csvを配列化
	function convertCSVtoArray(str) {
		let tmp = str.split("\n");
		tmp.shift();
		let result = [];
		let date = "";

		for (let i = 0; i < tmp.length; i++) {
			if (!tmp[i]) continue;
			result[i] = tmp[i].split(',');
			date = new Date(result[i][0]);
			result[i][0] = getDayStr(date)
		}

		return result;
		
	}*/

	//日付をcsvのフォーマットに合わせる（yy/mm/dd）
	function getDayStr(date) {
		let yy = date.getFullYear();
		let mm = ("0" + (date.getMonth() + 1)).slice(-2);
		let dd = ("0" + date.getDate()).slice(-2);
		return yy + '/' + mm + '/' + dd;
	}
	
	alert(holidays);
	return holidays;
};


