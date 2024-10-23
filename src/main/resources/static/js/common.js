/* 
共通的に使用される処理がある場合はこちらに記述
*/

/* アプリ名 */
var appName = 'YWM';

/* トップページ */
const topUrl = '/top';

const logoutUrl = '/logout';
const logoutImg = '/img/logout.svg';


/* メニューの定義 */
var menuConf = {
	menu1: {
		id: 'project',
		name: '案件管理',
		href: '/top',
		role: '',
	},
	menu2: {
		id: "user",
		name: 'ユーザ管理',
		href: '/userSearch',
		role: '',
	},
	menu3: {
		id: 'role',
		name: '権限管理',
		href: '/roleSearch',
		role: '',
	}
};

// ヘッダー生成用
function headerCreate() {
	let html = '';
	// アプリ名の設定
	html = '<h1><a href="' + topUrl + '">' + appName + '</a></h1>';
	
	// メニューの作成
	html = html + '<nav class="header-nav">';
	html = html + '<ul class="header-nav-ul">';
		
	// 共通定義を配列化
	let menu =  Object.entries(menuConf) 
	for (let i = 0; menu.length > i; i++) {
		let prop = menu[i][1];
		html = html + '<li class="header-nav-li"><a href="' + prop.href + '">' + prop.name + '</a></li>';
	};
	
	html = html + '</ul>';
	html = html + '</nav>';

	// ユーザ名の取得
	let loginUser = window.sessionStorage.getItem('loginUser');
	if (loginUser == "") {
		loginUser = $('#login-user').val();
		window.sessionStorage.setItem('loginUser', loginUser);
	};
	
	html = html + '<p class="login-user"><a>' + loginUser + '</a></p>';
	html = html + '<a class="logout" href="' + logoutUrl + '"><img src="' + logoutImg + '" alt="ログアウト" height="20px"></a>';
	// htmlのセット
	document.querySelector('header').innerHTML = html;
};

// ログアウト時のポップアップアラート
$('.logout').click(function() {
	if (!confirm('ログアウトします。よろしいですか？')) {
		/* キャンセルの時の処理 */
		return false;
	} else {
		/*　OKの時の処理 */
		location.href = 'login.html';
	}
});