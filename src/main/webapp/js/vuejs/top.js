Vue.component('topdao', {
	template:`<div>
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
					<a class="navbar-brand" href="index.html"><i class="fa" style="background: url(../assets/img/logo.png) no-repeat; background-size: 100% 100%; width: 21px; height: 24px; vertical-align: middle;"></i>
						<strong>DJ办公管理系统</strong></a>
				</div>

				<ul class="nav navbar-top-links navbar-right">
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false"> <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
						</a>
						<ul class="dropdown-menu dropdown-user">
							<li class="divider"></li>
							<li>
								<a href="/springmvcproject02/c/EmployeeServlet/xiaohui"><i class="fa fa-sign-out fa-fw"></i> 登出
								</a>
							</li>
						</ul>
					
					</li>
			
				</ul>
	</div>`
});