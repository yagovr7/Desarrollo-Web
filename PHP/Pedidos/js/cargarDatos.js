
/**
 * La función de añadir productos está asociada al formulario de la tabla de productos.
 * Cuando se envía el formulario se ejecuta la función. El argumento de la función 
 * es el propio formulario. La función se encarga de coger los datos del formulario 
 * y enviarlos a anadir_json.php. Como es un envío POST hay que crear una cabecera 
 * y una cadena con los parámetros. Al recibir la respuesta muestra una alerta La función 
 * eliminar es igual, pero llama a eliminar_json.php. llama a cargarCarrito(). 
 */
function anadirProductos(formulario){
	var xhttp = new XMLHttpRequest();		
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert("Producto añadido con éxito");
			cargarCarrito();						
	}};
	var params = "cod="+formulario.elements['cod'].value+"&unidades="+formulario.elements['unidades'].value;
	xhttp.open("POST", "anadir_json.php", true);	
	xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhttp.send(params);	
	return false;
}

function eliminarProductos(formulario){
	var xhttp = new XMLHttpRequest();		
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			alert("Producto eliminado con éxito");
			cargarCarrito();						
		}};
	var params = "cod="+formulario.elements['cod'].value+"&unidades="+formulario.elements['unidades'].value;
	xhttp.open("POST", "eliminar_json.php", true);	
	//Send the proper header information along with the request
	xhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xhttp.send(params);	
	return false;
}


function cargarProductos(destino){
	var xhttp = new XMLHttpRequest();	
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {			
			var prod = document.getElementById("contenido");
			var titulo = document.getElementById("titulo");
			titulo.innerHTML ="Productos";
			try{
				var filas =  JSON.parse(this.responseText);	
				var tabla = crearTablaProductos(filas);				
				prod.innerHTML = "";
				prod.appendChild(tabla);												
			}catch(e){
				var mensaje = document.createElement("p");
				mensaje.innerHTML = "Categoría sin productos";
				prod.innerHTML = "";
				prod.appendChild(mensaje);
			}					
		}
	};	
	xhttp.open("GET", destino, true);
	xhttp.send();
	return false;
}

function crear_fila(campos, tipo){
	var fila = document.createElement("tr");
	for(var i = 0; i < campos.length; i++){
		var celda = document.createElement(tipo);
		celda.innerHTML = campos[i];
		fila.appendChild(celda);
	}
	return fila;
	
}
function crearFormulario(texto, cod, funcion){
	var formu = document.createElement("form");		
	var unidades = document.createElement("input");
	unidades.value = 1;
	unidades.name = "unidades";
	var codigo = document.createElement("input");
	codigo.value = cod;
	codigo.type = "hidden";
	codigo.name = "cod";
	var bsubmit = document.createElement("input");
	bsubmit.type = "submit";
	bsubmit.value = texto;
	formu.onsubmit = function(){return funcion(this);}
	formu.appendChild(unidades);
	formu.appendChild(codigo);
	formu.appendChild(bsubmit);
	return formu;
}
function crearTablaProductos(productos){
	var tabla = document.createElement("table");
	var cabecera = 	crear_fila(["Código", "Titulo", "Autor", "Precio", "Stock", "Cantidad"], "th");
	tabla.appendChild(cabecera);
	for(var i = 0; i < productos.length; i++){
		/*formulario*/
		formu = crearFormulario( "Añadir", productos[i]['CodProd'],anadirProductos);		
		fila = crear_fila([productos[i]['CodProd'], productos[i]['Titulo'], productos[i]['Autor'],productos[i]['Precio'],productos[i]['Stock']], "td");
		celda_form = document.createElement("td");
		celda_form.appendChild(formu);
		fila.appendChild(celda_form);		
		tabla.appendChild(fila);		
	}	
	return tabla;		
}
/**
 * Esta función solicita procesar_pedido_json.php al servidor. Muestra un mensaje de 
 * confirmación o error según reciba las cadenas TRUE o FALSE en la respuesta.

 */
function procesarPedido(){
	var xhttp = new XMLHttpRequest();		
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var contenido = document.getElementById("contenido");
			contenido.innerHTML = "";
			var titulo = document.getElementById("titulo");
			titulo.innerHTML ="Estado del pedido";
			if(this.responseText=="TRUE"){
				contenido.innerHTML = "Pedido realizado";
			}else{
				contenido.innerHTML = "Error al procesar el pedido";
			}						
	}};
	xhttp.open("GET", "procesar_pedido_json.php", true);
	xhttp.send();
	return false;
}
function cargarCarrito(){
	var xhttp = new XMLHttpRequest();		
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var contenido = document.getElementById("contenido");
			contenido.innerHTML = "";
			var titulo = document.getElementById("titulo");
			titulo.innerHTML ="Carrito de la compra";
			try{
				var filas =  JSON.parse(this.responseText);
				console.log(filas);
				tabla = crearTablaCarrito(filas);				
				contenido.appendChild(tabla);		
				/*ahora el vínculo de procesar pedio*/
				var procesar = document.createElement("a");
				procesar.href ="#";
				procesar.innerHTML= "Realizar pedido";
				procesar.onclick = function (){return procesarPedido();};
				contenido.appendChild(procesar);
			}catch(e){
				var mensaje = document.createElement("p");
				mensaje.innerHTML = "Todavía no tiene productos";
				contenido.appendChild(mensaje);
			}			
						
	}};
	xhttp.open("GET", "carrito_json.php", true);
	xhttp.send();
	return false;
}

/**
 * Esta función solicita al servidor los datos de los productos del carrito (carrito_json.php)
 *  y crea la tabla de productos. Elimina el contenido de la sección "contenido" y luego
 *  introduce la tabla en ella. También muestra un vínculo para realizar el pedido, 
 * que está asociado con la función realizarPedido().
 * Para crear la tabla utiliza la función auxiliar crearTablaCarrito (filas), que es muy 
 * parecida a la de crear productos.
 */
function crearTablaCarrito(productos){
	var tabla = document.createElement("table");
	var cabecera = 	crear_fila(["Código", "Titulo", "Autor", "Unidades", "Eliminar"], "th");
	tabla.appendChild(cabecera);
	for(var i = 0; i < productos.length; i++){
		/*formulario*/
		formu = crearFormulario("Eliminar", productos[i]['CodProd'],eliminarProductos);		
		fila = crear_fila([productos[i]['CodProd'], productos[i]['Titulo'], productos[i]['Autor'],productos[i]['unidades']], "td");
		celda_form = document.createElement("td");
		celda_form.appendChild(formu);
		fila.appendChild(celda_form);		
		tabla.appendChild(fila);		
	}						
	return tabla;
}

/**
 * Mediante el atributo onclick, estos vínculos están asociados a la función cargarProductos(). 
 * En this está ruta del vínculo.
 */		
function crearVinculoCategorias(nom, cod){
	var vinculo = document.createElement("a");
	var ruta = "productos_json.php?categoria=" +cod;;
	vinculo.href = ruta;
	vinculo.innerHTML = nom;
	vinculo.onclick = function(){return cargarProductos(this);}
	return vinculo;
}
/** 
 * La función cargarCategorias() solicita al servidor los datos de las categorías 
 * (categorias_ json.php) y crea la lista de vínculos. Cuando recibe la respuesta del 
 * servidor:
            La convierte en un objeto JavaScript, que será un array. Cada elemento del 
			array será un objeto con campos codCat y nombre (los nombres de los campos en el 
				array JSON que devuelve el servidor).
		   Crea un elemento ul, la lista que tiene que crear.
		   Por cada elemento del array crea un vínculo usando el nombre y el código.
		   Ese elemento se introduce en un elemento 1i.
		   El elemento li se introduce en la lista.
		   Elimina el contenido de la sección "contenido" y luego introduce la 
		   lista en ella.

		Para crear los vínclos utiliza una función auxiliar.
 */
function cargarCategorias() {
	var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var cats =  JSON.parse(this.responseText);			
			var lista = document.createElement("ul");			
			for(var i = 0; i < cats.length; i++){
				var elem = document.createElement("li");					
				vinculo = crearVinculoCategorias(cats[i].nombre, cats[i].codCat);												
				elem.appendChild(vinculo);
				lista.appendChild(elem);
			}
			var contenido = document.getElementById("contenido");
			contenido.innerHTML = "";	
			var titulo = document.getElementById("titulo");
			titulo.innerHTML ="Categorías";
			contenido.appendChild(lista);
		}
	};
	xhttp.open("GET", "categorias_json.php", true);
	xhttp.send();
}
