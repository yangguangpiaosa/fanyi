seajs.config({
	charset: 'utf-8',
	base: '/matrix/js',
	alias: {
		'jquery': 'comn/jquery-sea'
	},
	preload: ['jquery'],
	map: [[/^(.*\.(?:css|js))(.*)$/i, '$1?v=20160622']]  //map,批量更新时间戳
});