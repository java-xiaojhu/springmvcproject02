Vue.component('hm',{
	template:`<ul class="nav" id="main-menu">
					<li><a href="#"><i class="fa fa-sitemap"></i> 请假模块<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="/springmvcproject02/ui/addLeave.html">请假</a></li>
							<li><a href="/springmvcproject02/ui/showLeave.html">查看请假</a></li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-sitemap"></i> 报销模块<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="/springmvcproject02/ui/Reimburse/addReimburse.html">新增报销单</a></li>
							<li><a href="/springmvcproject02/ui/Reimburse/showReimburse.html">查看报销单</a></li>
						</ul>
					</li>
					<li v-if="user.positionId==0 || user.positionId==3"><a href="#"><i class="fa fa-sitemap"></i> 统计模块<span
							class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="/springmvcproject02/ui/ReportForms/MonthList.html">报销单月度统计</a></li>
							<li><a href="/springmvcproject02/ui/ReportForms/YearList.html">报销单年度统计</a></li>
						</ul></li>
				</ul>`,
	props:["user"]

});