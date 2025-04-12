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
		let yearMonth = $("#calendar-year-day").text();
		let date = new Date(yearMonth + "/01");
		let year = date.getFullYear();
		let month = date.getMonth() + 1;

		if (month == 1) {
			// 現在の表示月が1月の場合は前年の12月を設定
			year = year - 1;
			month = 12;
		} else {
			// ひと月前を取得
			month = month - 1;

		}

		// カレンダーを再取得	
		calendar(year, month);
	});

	// カレンダーの「＞」を押したとき
	$('#btn_next').click(function() {
		// 現在表示しているカレンダーの年月を取得
		let yearMonth = $("#calendar-year-day").text().split('/');
		let date = new Date(yearMonth + "/01");
		let year = date.getFullYear();
		let month = date.getMonth() + 1;

		if (month == 12) {
			// 現在の表示月が12月の場合は次年の1月を設定
			year = year + 1;
			month = 1;
		} else {
			// ひと月次を取得
			month = month + 1;

		}

		// カレンダーを再取得
		calendar(year, month);
	});

});


// -------------- 日付と時刻の機能 -------------- 
function displayTime() {

	// 二桁で0埋めの指定
	let padZero = (value) => value.toString().padStart(2, "0");

	// 曜日算出用の配列
	let week = ["日", "月", "火", "水", "木", "金", "土"];

	// 現在日時の取得
	let now = new Date();
	let year = padZero(now.getFullYear());
	let mon = padZero(now.getMonth() + 1);
	let date = padZero(now.getDate());
	let daynum = padZero(now.getDay());
	let hour = padZero(now.getHours());
	let minute = padZero(now.getMinutes());
	let second = padZero(now.getSeconds());

	// 曜日を数字から文字列に変換
	let day = week[Number(daynum)];

	// 画面にバインドする内容を記載
	let currentTime = `${year}年${mon}月${date}日（${day}）  ${hour}:${minute}:${second}`;
	// 指定要素に日時を追加
	document.querySelector(".clock").textContent = currentTime;
};

// -------------- カレンダーを生成する機能 -------------- 
function calendar(year, month) {

	// 曜日算出用の配列
	let week = ['日', '月', '火', '水', '木', '金', '土'];

	// 日付項目の取得
	if (year == 0 && month == 0) {
		// 初期表示の場合
		let date = new Date();
		year = date.getFullYear();
		month = date.getMonth() + 1;
	}

	let startDate = new Date(year, month - 1, 1);// 月の最初の日を取得
	let endDate = new Date(year, month, 0); // 月の最後の日を取得
	let endDayCount = endDate.getDate(); // 月の末日
	let lastMonthEndDate = new Date(year, month - 1, 0); // 前月の最後の日の情報
	let lastMonthendDayCount = lastMonthEndDate.getDate();// 前月の末日
	let startDay = startDate.getDay();// 月の最初の日の曜日を取得
	let dayCount = 1; // 日にちのカウント
	let calendarHtml = ''; // HTMLを組み立てる変数

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
			// 処理中の日付
			let inputDate;

			if (w == 0 && d < startDay) {
				// 1行目で1日の曜日の前（前月の日付）
				let num = lastMonthendDayCount - startDay + d + 1
				inputDate = year + "-" + String(month - 1) + "-" + num;
				calendarHtml += '<td class="is-disabled" id="' + inputDate + '">' + num + '</td>'
			} else if (dayCount > endDayCount) {
				// 末尾の日数を超えた（次月の日付）
				let num = dayCount - endDayCount
				inputDate = year + "-" + String(month + 1) + "-" + num;
				calendarHtml += '<td class="is-disabled" id="' + inputDate + '">' + num + '</td>'
				dayCount++
			} else {
				inputDate = year + "-" + month + "-" + dayCount;
				calendarHtml += '<td class="calender-td" id="' + inputDate + '">' + dayCount + '</td>'
				dayCount++
			}

		}
		calendarHtml += '</tr>'
	}
	calendarHtml += '</table>'

	document.querySelector('#calendar').innerHTML = calendarHtml;

	// 対象月の祝日を取得
	window.sessionStorage.setItem('calendarYear', year);
	window.sessionStorage.setItem('calendarMonth', month);
	getHoliday();
	let holiday = JSON.parse(window.sessionStorage.getItem('holiday'));

	// 前後1カ月ずつに祝日がある場合
	if (holiday.length > 0) {
		for (let i = 0; holiday.length > i; i++) {
			let target = holiday[i];
			// 対象のカレンダーセルのclass名を取得
			let className = $('#' + target[0].replaceAll("/", "-")).attr('class');
			// 前月か次月の日付の場合
			if (className == "is-disabled") {
				// class名を整形
				className = className + ' dis-holiday'

			} else {
				// class名を整形
				className = className + ' holiday'
			}
			$('#' + target[0].replaceAll("/", "-")).attr('class', className)
		}
	}
};

// -------------- CSVデータの整形 -------------- 
function getData(data) {
	// 取得データを配列に変換
	let csv = [];
	csv = $.csv.toArrays(data);
	// 対象期間の前後1カ月のみに絞る
	let sYear = Number(window.sessionStorage.getItem('calendarYear'));
	let sMonth = Number(window.sessionStorage.getItem('calendarMonth'));
	let sDate = new Date(sYear, sMonth - 2, 1);
	let eDate = new Date(sYear, sMonth + 1, 1)
	// すべてのデータをループ
	let ret = [];
	// データが存在する場合
	if (csv.length > 0) {
		$(csv).each(function(i, elem) {
			if (i > 0) {
				let date = new Date(elem[0]);
				if (date >= sDate && eDate > date) {
					ret.push(elem);
				}
			}
		});
	}
	// 一覧表示でも使いたいので一旦セッションに格納
	let dataString = JSON.stringify(ret);
	window.sessionStorage.setItem('holiday', dataString);
}

// -------------- 祝日の取得 -------------- 
function getHoliday() {
	// CSVの読み込み jqueryのget関数 text型で読み込む
	holidays = $.get('./csv/syukujitsu.csv', getData, 'text');
};


