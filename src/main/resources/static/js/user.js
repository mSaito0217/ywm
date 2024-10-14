/* 
ユーザ登録・更新関連の制御
*/

jQuery(function($) {

	var id = $('#userId').val();
	var sError = $('#error-msg').text();

	if (sError == "") {
		// sessionに画面遷移時の値を格納
		window.sessionStorage.setItem(['oldUserId'], [id]);
	}

	// ユーザIDの入力からフォーカスが外れた時のアクション
	$('form').find('#userId').on('change blur', function() {
		// 入力後の値を取得
		var val = $(this).val();
		// セッションから入力前の値を取得
		var old = window.sessionStorage.getItem(['oldUserId']);

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
});