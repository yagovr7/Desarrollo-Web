<!--
    La cabecera, aunque corta, cambia completamente. Los vínculos se sustituyen por 
    llamadas a las funciones correspondientes. El nombre del usuario no aparece, en su 
    lugar hay un elemento span con id ="nombre". Esto es así porque la cabecera se 
    sirve antes de que se haya hecho login, así que no puede saberse el usuario.
     Si se hace login correctamente, se introduce el nombre desde JavaScript.
-->
<header>
 <span id="cab_usuario"></span>	
 <a href="#" onclick="cargarCategorias();">Home</a>
 <a href="#" onclick="cargarCarrito();">Carrito</a>
 <a href="#" onclick="cerrarSesionUnaPagina();">Cerrar sesión</a>
</header>
<hr>