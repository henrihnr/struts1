<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html>
  <head>
	<title>Simple CRUD - Struts 1.x, Spring and Hibernate3</title>
	<meta http-equiv="Pragma" content="nocache">
	<meta http-equiv="Expires" content="-1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link  href="style/style.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript" src="script/jquery.js"></script>
	
	<link href="style/calendar.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="script/calendar.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
	
  </head>
  
  <body>
<html:form action="employee">
	<html:hidden property="id"/>
	
  	<div class="content">
  		<h1>Employee Detail</h1>
        
        <div class="data">
            <table>
                <tr>
                    <td width="30%">NPK</td>
                    <td>
                    	<html:text property="npk"/>
                   	</td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td><html:text property="name"/></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                    	<html:radio property="gender" value="m"/> Male
                    	<html:radio property="gender" value="f"/> Female
                    </td>
                </tr>
                <tr>
                    <td>Date of Birth (dd-MM-yyyy)</td>
                    <td>
                    	<html:text property="webDob" maxlength="10" onclick="displayDatePicker('webDob');"/>
                    	<a href="javascript:void(0);" onclick="displayDatePicker('webDob');">
                    		<img src="style/images/calendar.png" alt="calendar" border="0">
                   		</a>
                   	</td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td>
                      <logic:empty name="EmployeeForm" property="id">
                    	<html:submit property="act">
                    		<bean:message key="app.nav.add"/>
                    	</html:submit>
                      </logic:empty>
                      
                      <logic:notEmpty name="EmployeeForm" property="id">
                    	<html:submit property="act">
                    		<bean:message key="app.nav.modify"/>
                    	</html:submit>
                    	
                    	<html:submit property="act">
                    		<bean:message key="app.nav.delete"/>
                    	</html:submit>
                      </logic:notEmpty>
                    </td>
                </tr>
            </table>
        </div>
        <br/>
        <a href="employee.do?act=Search" class="back">back to Employee Search</a>
  	</div>
</html:form>
  </body>
</html>