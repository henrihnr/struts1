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
<html:form action="person">
  	<div class="content">
  		<h1>Person Search</h1>
  		
        <div class="paging">
			<html:hidden property="offset"/>
			<html:hidden property="pageSize"/>
			
			Records offset - endResult of totalRows
        </div>
        
        <div class="data">
            <table border="0" cellpadding="4" cellspacing="0">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Gender</th>
                    <th>Date of Birth (dd-mm-yyyy)</th>
                    <th>Actions</th>
                </tr>
              <logic:present name="persons">
              <logic:iterate name="persons" id="person">
                <tr>
                    <td><bean:write name="person" property="id"/></td>
                    <td><bean:write name="person" property="name"/></td>
                    <td>
                    	<logic:equal name="person" property="gender" value="m">
                    		Male
                    	</logic:equal>
                    	<logic:equal name="person" property="gender" value="f">
                    		Female
                    	</logic:equal>
                    </td>
                    <td><bean:write name="person" property="dob" format="dd-MM-yyyy"/></td>
                    <td>
                        <a href="person.do?act=Show&id=<bean:write name="person" property="id"/>" class="view">Show</a>
                        <a href="person.do?act=Delete&id=<bean:write name="person" property="id"/>" class="delete">Delete</a>
                    </td>
                </tr>
              </logic:iterate>
              </logic:present>
              <logic:notPresent name="persons">
                <tr><td colspan="5">No Person Data</td></tr>
              </logic:notPresent>
            </table>
        </div>
        <br />
        <a href="person.do?act=Show" class="add">Add New Person</a>
        
  	</div>
</html:form>
  </body>
</html>