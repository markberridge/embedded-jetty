<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
  <h1>Cache</h1>
  <s:form>
    <%@ include file="/jsp/includes/messages.jspf"%>
    <s:property value="cache" />
    <s:textfield label="Add entry" name="value" />
    <s:submit />
  </s:form>
</body>
</html>
