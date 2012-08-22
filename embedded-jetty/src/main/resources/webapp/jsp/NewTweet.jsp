<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
  <h1>New Tweet</h1>
  <s:form>
    <%@ include file="/jsp/includes/messages.jspf"%>
    <s:hidden name="processDefinitionKey" value="%{processDefinitionKey}" />
    <s:textfield label="Twitter account" name="processVariables['twitterAccount']"
      value="%{#processVariables['twitterAccount']}" id="twitterAccount" />
    <s:textarea label="Tweet content" name="processVariables['tweetContent']"
      value="%{#processVariables['tweetContent']}" id="tweetContent" maxlength="140" cols="50" rows="4" />
    <s:submit />
  </s:form>
</body>
</html>
