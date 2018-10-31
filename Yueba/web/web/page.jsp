<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
	</head>
<body>
<div class="admin-table-page">
				<div id="paged" class="page">
				<div class="layui-box layui-laypage layui-laypage-default" id="layui-laypage-0">
				<a href="javascript:void(0);" class="layui-laypage-last">总记录 ${pm.sumCount} 条</a>
				<a href="javascript:void(0);" class="layui-laypage-last">[ 当前页数 : ${pm.currentPage} / ${pm.sumPage} ]</a>
				<c:if test="${pm.currentPage>1 }">
					<a href="javascript:page('${pm.currentPage-1}');" class="layui-laypage-prev" data-page="16">上一页</a>
				</c:if>
				<c:if test="${pm.currentPage>6 }">
					<a href="javascript:page('1');" class="laypage_first" data-page="1" title="首页">首页</a>
				</c:if>
				<c:if test="${pm.sumPage<=10 }">
					<c:forEach begin="1" end="${pm.sumPage}" step="1" varStatus="status">
						<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
					</c:forEach>
				</c:if>
				<c:if test="${pm.sumPage>10 }">
						<c:forEach begin="1" end="${pm.sumPage}" step="1" varStatus="status">
							<c:if test="${status.count == pm.currentPage-5}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage-4}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage-3}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage-2}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage-1}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage+1}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage+2}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage+3}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
							<c:if test="${status.count == pm.currentPage+4}">
							<a ${status.count==pm.currentPage?'style="background-color: #009688;color:#ffffff;"':''} href="javascript:page('${status.count}');" data-page="${status.count }">${status.count }</a>
							</c:if>
						</c:forEach>
					</c:if>
				<c:if test="${pm.currentPage<(pm.sumPage-4) }">
					<a href="javascript:page('${pm.sumPage}');" class="layui-laypage-last" title="尾页" data-page="19">末页</a>
				</c:if>
				<c:if test="${pm.currentPage<pm.sumPage}">
					<a href="javascript:page('${pm.currentPage+1}');" class="layui-laypage-next">下一页</a>
				</c:if>
				<a style="float: left;">
					<input style="background-color:#009688; color:#ffffff; cursor:pointer;display:inline; margin: 0 0px;padding-left: 0px;margin-left: -16px;margin-top: -1px;margin-right: -4px;" id="tiaozhuan" type="button" name="title" value="跳转">
					<input style="display:inline; margin: 0 0px;padding-left: 0px;margin-top: -1px;margin-right: -16px" type="text" name="title" placeholder="页数" id="Pages" class="layui-input">
					<input type="hidden" value=" ${pm.sumPage}" id="sumPage">
				</a>
				</div>
				<select id="pageSize" style="border: 1px solid #e2e2e2;height: 28px;line-height: 28px;margin: 0 -1px 5px 0;padding: 0 15px;vertical-align: middle;display: inline-block;">
						<option ${pm.pageSize == '5' ?'selected':' ' } value="5">5条/页</option>
						<option ${pm.pageSize == '10' ?'selected':' ' } value="10">10条/页</option>
						<option ${pm.pageSize == '20' ?'selected':' ' } value="20">20条/页</option>
						<option ${pm.pageSize == '30' ?'selected':' ' } value="30">30条/页</option>
						<option ${pm.pageSize == '40' ?'selected':' ' } value="40">40条/页</option>
						<option ${pm.pageSize == '50' ?'selected':' ' } value="50">50条/页</option>
					</select>
			</div>
		</div>
</body>
</html>