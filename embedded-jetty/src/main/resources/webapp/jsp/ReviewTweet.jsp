<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head></head>
<body>
	<h1>Review Tweet</h1>
	<s:form>
		<%@ include file="/jsp/includes/messages.jspf"%>
		<s:hidden name="taskId" value="%{taskId}" />
		<s:textfield label="Twitter account"
			name="taskVariables['twitterAccount']"
			value="%{taskVariables['twitterAccount']}" id="twitterAccount"
			readonly="true" />
		<s:textarea label="Tweet content" name="taskVariables['tweetContent']"
			value="%{taskVariables['tweetContent']}" id="tweetContent"
			maxlength="140" cols="50" rows="4" readonly="true" />
		<s:textarea label="Comment" name="processVariables['comment']"
			id="tweetContent" cols="50" rows="4" />
		<s:checkbox label="Approved" name="processVariables['approved']" />
		<s:submit />
	</s:form>
</body>
</html>
