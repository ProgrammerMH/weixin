<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<script type="text/javascript">
	$(function() {
		var resfoodTreeData = [
				{
					"id" : 1,
					"text" : "新增素材",
					"attributes" : {
						"url" : "<iframe width='100%' height='100%' src='back/materialManager/addMaterial.jsp' />"
					}
				},
				{
					"id" : 2,
					"text" : "删除素材",
					"attributes" : {
						"url" : "<iframe width='100%' height='100%' src='' />"
					}
				}, {
					"id" : 3,
					"text" : "浏览素材",
					"attributes" : {
						"url" : ""
					}
				} ];
		var rescompositionData = [
			{
				"id" : 1,
				"text" : "群发图文",
				"attributes" : {
					"url" : "<iframe width='100%' height='100%' src='back/materialManager/editor.html' />"
				}
			}];
		var resMenuData = [
			{
				"id" : 1,
				"text" : "菜单管理",
				"attributes" : {
					"url" : "<iframe width='100%' height='100%' src='back/materialManager/editor.html' />"
				}
			}];
   
		showTree("material", resfoodTreeData);
		showTree("compositionId", rescompositionData);
		showTree("menuId", resMenuData);

	});

	function showTree(treeId, treeData) {
		$("#" + treeId).tree({
			data : treeData,
			onClick : function(node) {
				if (node && node.attributes) {
					openTab(node);
				}
			}
		});
	}
	function openTab(node) {
		if ($("#tt").tabs("exists", node.text)) {
			$("#tt").tabs("select", node.text);
		} else {
			$("#tt").tabs("add", {
				title : node.text,
				selected : true,
				closable : true,
				content : node.attributes.url,
				tools : [ {
					iconCls : 'icon-reload',
					handler : function() {
						var tab = $('#tt').tabs('getSelected');
						$('#tt').tabs('update', {
							tab : tab,
							options : {
								title : node.text,
								href : node.attributes.url
							}
						});
					}
				} ]
			});
		}
	}
</script>
<div data-options="region:'north',title:'中州笔韵',split:true" style="height:100px;">
     <h1 >书者,述也,以载道,以寄情,以解惑,以明智</h1>
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:100px;">
 
    </div>  
    <div data-options="region:'east',iconCls:'icon-reload',title:'通知',split:true" style="width:100px;" >

    </div>  
    <div data-options="region:'west',title:'导航',split:true" style="width:100px;" class="easyui-accordion">
        <div title="用户管理" >  
    </div>  
    <div title="素材管理"  >  
    <ul id="material" class="easyui-tree">
    
    
    </ul>
    </div>  
    <div title="图文管理">  
    <ul id="compositionId" class="easyui-tree">
    
    
    </ul>
    </div>  
     <div title="菜单管理">  
      <ul  id="menuId"  class="easyui-tree">
      
      </ul>
    </div>  
    <div title="管理员管理">  
    </div>  
    </div>
    <div id="tt" data-options="region:'center',title:'center title'" class="easyui-tabs" style="padding:5px;background:#eee;">
    
 


    </div>  	

<%@ include file="bottom.jsp" %>