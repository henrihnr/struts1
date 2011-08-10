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
	
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
	</script>
	
  </head>
  
  <body>
<html:form action="employee">
  	<div class="content">
  		<h1>Employee Search</h1>
  		
        <div class="paging">
			<html:hidden property="offset"/>
			<html:hidden property="pageSize"/>
			
			Records offset - endResult of totalRows
        </div>
        
        <div class="data">
            <table border="0" cellpadding="4" cellspacing="0">
                <tr>
                    <th>NPK</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date of Birth (dd-mm-yyyy)</th>
                    <th>Actions</th>
                </tr>
              <logic:present name="employees">
              <logic:iterate name="employees" id="employee">
                <tr>
                    <td><bean:write name="employee" property="npk"/></td>
                    <td><bean:write name="employee" property="name"/></td>
                    <td>
                    	<logic:equal name="employee" property="gender" value="m">
                    		Male
                    	</logic:equal>
                    	<logic:equal name="employee" property="gender" value="f">
                    		Female
                    	</logic:equal>
                    </td>
                    <td><bean:write name="employee" property="dob" format="dd-MM-yyyy"/></td>
                    <td>
                        <a href="employee.do?act=Show&id=<bean:write name="employee" property="id"/>" class="view">Show</a>
                        <a href="employee.do?act=Delete&id=<bean:write name="employee" property="id"/>" class="delete">Delete</a>
                    </td>
                </tr>
              </logic:iterate>
              </logic:present>
              <logic:notPresent name="employees">
                <tr><td colspan="5">No Employee Data</td></tr>
              </logic:notPresent>
            </table>
        </div>
        <br />
        <a href="employee.do?act=Show" class="add">Add New Employee</a>
        
  	</div>
</html:form>
  </body>
</html>