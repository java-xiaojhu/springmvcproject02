//读取配置文件获取webSocketurl
var websocket1 = null;
// 判断当前浏览器是否支持WebSocket
if('WebSocket' in window) {
	/* 连接所有 */
	websocket1 = new WebSocket("ws://127.0.0.1:8080/springmvcproject02/WSHello");
} else {
	alert('当前浏览器 Not support websocket');
}

// 连接发生错误的回调方法
websocket1.onerror = function() {
	/* alert("WebSocket连接发生错误"); */
};

// 连接成功建立的回调方法
websocket1.onopen = function() {	
	receive();
}

// 接收到消息的回调方法
websocket1.onmessage = function(event) {
	// 业务处理逻辑
	
};

// 连接关闭的回调方法
websocket1.onclose = function() {
	/* alert("WebSocket连接关闭"); */
	window.clearInterval(timer);
}

// 监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function() {
	closeWebSocket1();
}
// 关闭WebSocket连接
function closeWebSocket1() {
	websocket1.close();
}
function receive(){	
	$.getJSON(`/springmvcproject02/api/ChatServlet/receive/${messageApp.users.employeeId}`, function(Stu) {
		console.log(Stu)
		messageApp.open3(Stu);
	});
}
var user=JSON.parse(window.sessionStorage.getItem("user"));
console.log(window.sessionStorage.getItem("user")+"===========")
	var messageApp=new Vue({
		data:{
			users:JSON.parse(window.sessionStorage.getItem("user")),
		},
		    methods: {
		    	onclick(suser){
		    		if(suser.isTrusted){
		    			location.href="/springmvcproject02/ui/message/TakenMessage.html";
		    		}
		    	},
		      open3(message) {
		    	  const h = this.$createElement;
		    	  let _this=this;
		    	  $.each(message,function (i,obj){
		    		  _this.instance = _this.$notify.info({
				          title:`${obj.userName}`,
				          message: h('a',{on:{click:_this.onclick}},'你有一条未读信息。')
				        });
		    	  })
		      }
		    }
	}).$mount(".main");
