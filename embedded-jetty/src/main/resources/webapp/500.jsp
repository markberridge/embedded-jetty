<%@ page isErrorPage="true"%>
<html>
<head></head>
<body>
	<h1>500</h1>
	<pre>
<%
    if ( /*com.ufi.config.WebSettings.isStackTraceEnabled() &&*/exception != null) {
        Throwable e;
        if (exception instanceof ServletException) {
            e = ((javax.servlet.ServletException) exception).getRootCause();
        } else {
            e = exception;
        }
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw, true);
        e.printStackTrace(pw);
        out.print(sw.getBuffer().toString());
    }
%>
</pre>
</body>
</html>