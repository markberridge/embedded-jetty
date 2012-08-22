<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <h1>
    Tasks for user [<s:property value="username" />]
  </h1>
  <%@ include file="/jsp/includes/messages.jspf"%>
  <table border="1" style="empty-cells: show;">
    <thead>
      <tr>
        <th>Task Name</th>
        <th>Description</th>
        <th>Action</th>
      </tr>
    </thead>
    <tbody>
      <s:iterator value="taskList" status="status">
        <tr <s:if test="#status.even == true">class="lightRow"</s:if>>
          <td><s:property value="name" /></td>
          <td><s:property value="description" /></td>
          <td><a href="<s:url action="%{actionName}" method="input"><s:param name="taskId" value="%{id}"/></s:url>">Complete</a>
          </td>
        </tr>
      </s:iterator>
    </tbody>
  </table>
</body>
</html>
