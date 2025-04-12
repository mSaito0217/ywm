/* 
ユーザ登録・更新関連の制御
*/

jQuery(function($) {

	// -------------- 画面読み込み時に呼び出し -------------- 

	let viewName = $('#user-view-name').val();

	if (viewName == 'edit') {
		// -------------- 編集画面の制御 -------------- 
		var id = $('#userId').val();
		var sError = $('#error-msg').text();

		if (sError == "") {
			// sessionに画面遷移時の値を格納
			window.sessionStorage.setItem('oldUserId', id);
		}
	} else if (viewName == 'search') {
		// -------------- 検索画面の制御 --------------

		// 権限の設定
		//roleCreate();

	}

});

// -------------- 編集画面の制御 -------------- 
// ユーザIDの入力からフォーカスが外れた時のアクション
$('form').find('#userId').on('change blur', function() {
	// 入力後の値を取得
	var val = $(this).val();
	// セッションから入力前の値を取得
	var old = window.sessionStorage.getItem('oldUserId');

	if (val != old) {
		// 入力値が元の値と異なった場合

		// エラーメッセージがない場合
		if ($('#userid-error').val() == null) {
			$('#userId').after('<a id="userid-error" style="margin-left:10px; color: red; font-size: 12px;">ユーザIDは変更できません。</a>');
		}

		// 変更前の値を設定しなおす
		$(this).val(old);
	}
});

$('form').find('input').on('change blur', function() {
	// 入力系のアクションを行った際にエラーメッセージをクリアする
	if (sError != "") {
		$('#error-msg').text("");
	}
});

// -------------- 検索画面の制御 --------------
function roleCreate() {
	var role = JSON.parse($('#role-list').val());
	for (let i = 0; role.length > i; i++) {
		let data = Object.entries(role[i]);
		for (let j = 0; data.length > j; j++) {
			//roleName
			for (let l = 0; data[j].length > l; l++) {
				if (data[j][l] == "roleName") {
					//console.log(data[j][1]);
					// 使わない処理になりました。
				}

			}
		}
	}
};