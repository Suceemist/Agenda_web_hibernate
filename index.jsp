<%-- 
    Document   : index
    Created on : 26-feb-2019, 9:41:45
    Author     : Mañanas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">		
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Agenda</title>
    </head>
    <body>
        <div class="container">
        <h3>Agenda</h3>
            <form action="ServletAgenda" method="POST">
                Nombre: <input type="text" class="form-control" name="nombre"><br>
                Email: <input type="text" class="form-control" name="email"><br>
                Telefono: <input type="text" class="form-control" name="telefono"><br>
                <input type="hidden" name="accion" value="insertar"/>
                <input type="submit" value="Insertar contacto" class="btn btn-success"><br><br>
            </form>
            <form action="ServletAgenda" method="POST">
                <input type="hidden" name="accion" value="vercontactos"/>
                <input type="submit" value="Mostrar agenda" class="btn btn-info">
            </form>
            <form action="ServletAgenda" method="POST">
                <h3>Buscar por nombre:</h3>
                <br/>
                <input id="nombre_buscado" type="text" name="nombre_buscado" class="form-control" placeholder="Introduzca nombre"/>
                <br/>
                <input type="hidden" name="accion" value="buscar"/>
                <input type="submit" value="Buscar" class="btn btn-danger"/>
            </form>
</div>
</body>
</html>
