<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>Processes</h1>
	<%@ include file="/jsp/includes/messages.jspf"%>
	<table border="1" style="empty-cells: show;">
		<thead>
			<tr>
				<th>Key</th>
				<th>Name</th>
				<th>Version</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<s:iterator value="processList" status="status">
				<tr <s:if test="#status.even == true">class="lightRow"</s:if>>
					<td><s:property value="key" /></td>
					<td><s:property value="name" /></td>
					<td><s:property value="version" /></td>
					<td><a
						href="<s:url action="%{actionName}" method="input"><s:param name="processDefinitionKey" value="%{key}"/></s:url>">Start</a>
					</td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</body>
</html>
