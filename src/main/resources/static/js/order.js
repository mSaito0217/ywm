/* 
* トップ画面関連の制御
*/
jQuery(function($) {

	// -------------- 画面読み込み時に呼び出し -------------- 

	//  -------------- ボタンごとの制御 -------------- 
	// 類似注文検索用
	$("#product-btn").click(function() {
		$("#product-dl").dialog({
			modal: true,
			title: "類似注文検索",
			buttons: { "閉じる": function() { $(this).dialog("close"); } },
			height: 500,
			width: 800
		});
	});

});