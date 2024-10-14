/* 
共通的に使用される処理がある場合はこちらに記述
*/

// テスト
//$(function() {
	//$('#header').load('/common/header.html');
	//alert("jQueryが正常に動作しています！");
//});

// ログアウト時のポップアップアラート
$('.logout').click(function(){
    if(!confirm('ログアウトします。よろしいですか？')){
        /* キャンセルの時の処理 */
        return false;
    }else{
        /*　OKの時の処理 */
        location.href = 'login.html';
    }
});