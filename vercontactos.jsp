<%-- 
    Document   : vercontactos
    Created on : 26-feb-2019, 10:23:36
    Author     : Mañanas
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="agendawebhibernate.Contacto"%>
<%@page import="agendawebhibernate.Contacto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    List<Contacto> lista_contactos=(List<Contacto>)request.getAttribute("contactos");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Lista contactos</title>
    </head>
    <body>
        <div class="container">
            <table class="table">
            <tr><th>Nombre</th><th>Email</th><th>Telefono</th><th>Borrar contacto</th></tr>
            <s:iterator value="lista_contactos" var="contacto">
					<tr>
						<td><s:property value="contacto.nombre" />
						<td><s:property value="contacto.email" /></td>
						<td><s:property value="contacto.telefono"/></td>
					</tr>	
				</s:iterator>
            <%
                for(int i=0;i<lista_contactos.size();i++){
                Contacto c=lista_contactos.get(i);
            %>
            <tr><td><%=c.getNombre() %></td><td><%=c.getEmail() %></td><td><%=c.getTelefono() %></td><td><a href="ServletAgenda?accion=borrar&id=<%=c.getId()%>">Borrar contacto</a></td></tr>
          <%} %> 
        </table>
        </div>
    </body>
</html>
