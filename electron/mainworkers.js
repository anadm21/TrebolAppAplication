var editdiv = document.getElementById("edit-div");
var deletediv = document.getElementById("delete-div");

var btnmenuadd = document.getElementById("btnanadir");
var btnmenuedit = document.getElementById("btnedit");

var btneditar = document.getElementById("btneditar");
var btneliminar = document.getElementById("btneliminar");
var btnaceptar = document.getElementById("btnaceptar");
var btnfind = document.getElementById("btnfind");

var dni, nom, ape, edad, fnac, fant, tlf, dir;
var expresion_regular_dni = /^\d{8}-[a-zA-Z]$/;

function cargarTabla() {
	const xhttp = new XMLHttpRequest();
	xhttp.open("GET", "http://localhost:3333/api/workers/all");
	xhttp.send();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var tablero = "";
			const objects = JSON.parse(this.responseText);
			for (let object of objects) {
				tablero += '<tr>';
				tablero += '<td>' + object['dnitrabajador'] + '</td>';
				tablero += '<td>' + object['nombre'] + '</td>';
				tablero += '<td>' + object['apellidos'] + '</td>';
				tablero += '<td>' + object['salario'] + '</td>';
				var dian = object['fecha_nac'].split("-")[2];
				var mesn = object['fecha_nac'].split("-")[1];
				var anion = object['fecha_nac'].split("-")[0];
				fnac = dian + "-" + mesn + "-" + anion;
				tablero += '<td>' + fnac + '</td>';
				var diaa = object['fecha_ant'].split("-")[2];
				var mesa = object['fecha_ant'].split("-")[1];
				var anioa = object['fecha_ant'].split("-")[0];
				fant = diaa + "-" + mesa + "-" + anioa;
				tablero += '<td>' + fant + '</td>';
				tablero += '<td>' + object['direccion'] + '</td>';
				tablero += '<td>' + object['telefono'] + '</td>';
				tablero += '<td>' + object['turno'] + '</td>';
				tablero += '<td>' + object['tipo_contrato'] + '</td>';
				tablero += '<td>' + object['num_SS'] + '</td>';
				tablero += '<td>' + object['cuenta_bancaria'] + '</td>';
				tablero += "</tr>";
			}
			document.getElementById("tablatrabajadores").innerHTML = tablero;
		}
	};
}

cargarTabla();

btnmenuadd.addEventListener('click', function() {
	if (editdiv.style.display === "none") {
		editdiv.style.display = "block";
		deletediv.style.display = "none";
	} else {
		editdiv.style.display = "none";
	}
});

btnmenuedit.addEventListener('click', function() {
	if (deletediv.style.display === "none") {
		deletediv.style.display = "block";
		editdiv.style.display = "none";
	} else {
		deletediv.style.display = "none";
	}
});

btneditar.addEventListener('click', function(event) {
	event.preventDefault(); //esto cancela el comportamiento del click
	if (editdiv.style.display === "none") {
		var dni = document.getElementById("textdni").value;
		if (expresion_regular_dni.test(dni) != true) {
			Swal.fire("Formato de DNI incorrecto");
		} else {
			if (dni != "") {
				const xhttp = new XMLHttpRequest();
				xhttp.open("GET", "http://localhost:3333/api/workers/find/" + dni);
				xhttp.send();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						if (this.responseText == "") {
							Swal.fire("El DNI no existe en la BBDD");
						} else {
							const object = JSON.parse(this.responseText);
							document.getElementById("txtdni").value = object['dnitrabajador'];
							document.getElementById("txtdni").disabled = true;
							editdiv.style.display = "block";
						}
					}
				};
			} else {
				Swal.fire("El DNI es un campo obligatorio");
			}
		}
	}
	document.getElementById("textdni").value = "";
});

btneliminar.addEventListener('click', function(event) {
	event.preventDefault(); //esto cancela el comportamiento del click
	const xhttp = new XMLHttpRequest();
	var dni = document.getElementById("textdni").value;
	if (expresion_regular_dni.test(dni) != true) {
		Swal.fire("Formato de DNI incorrecto");
	} else {
		if (dni == "") {
			Swal.fire("El DNI es un campo obligatorio");
		} else {
			xhttp.open("GET", "http://localhost:3333/api/workers/find/" + dni);
			xhttp.send();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText == "") {
						Swal.fire("El DNI no existe en la BBDD");
						document.getElementById("textdni").value = "";
					} else {
						xhttp.open("DELETE", "http://localhost:3333/api/workers/delete/" + dni);
						xhttp.send();
						xhttp.onreadystatechange = function() {
							if (this.readyState == 4 && this.status == 200) {
								Swal.fire("El trabajador con DNI " + dni + " se ha eliminado correctamente");
								cargarTabla();
								deletediv.style.display = "none";
							}
						};
					}
				}
			};
		}
	}
	document.getElementById("textdni").value = "";
});

btnaceptar.addEventListener('click', function(event) {
	event.preventDefault(); //esto cancela el comportamiento del click
	const xhttp = new XMLHttpRequest();
	dni = document.getElementById("txtdni").value;
	nom = document.getElementById("txtnom").value;
	ape = document.getElementById("txtape").value;
	salario = document.getElementById("txtsalario").value;
	fnac = document.getElementById("txtfnac").value;
	fant = document.getElementById("txtfant").value;
	dir = document.getElementById("txtdir").value;
	tlf = document.getElementById("txttlf").value;
	turno = document.getElementById("txtturno").value;
	contrato = document.getElementById("txtcontrato").value;
	numss = document.getElementById("txtnumss").value;
	cuenta = document.getElementById("txtcuenta").value;

	if (expresion_regular_dni.test(dni) != true) {
		Swal.fire("Formato de DNI incorrecto");
	} else {
		if ((dni == "") || (nom == "") || (ape == "") || (salario == "") || (fnac == "") || (fant == "") || (cuenta == "") || (dir == "") || (tlf == "") || (turno == "") || (contrato == "") || (numss == "")) {
			Swal.fire("Todos los campos son obligatorios");
		} else {
			xhttp.open("GET", "http://localhost:3333/api/workers/find/" + dni);
			xhttp.send();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText != "") {
						const object = JSON.parse(this.responseText);
						xhttp.open("POST", "http://localhost:3333/api/workers/save");
						xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
						xhttp.send(JSON.stringify({
							"idtrabajador": object['idtrabajador'], "dnitrabajador": dni, "nombre": nom, "apellidos": ape, "salario": salario,
							"fecha_nac": fnac, "fecha_ant": fant, "cuenta_bancaria": cuenta, "direccion": dir, "telefono": tlf, "turno": turno, "tipo_contrato": contrato, "num_SS": numss
						}));
					} else {
						xhttp.open("POST", "http://localhost:3333/api/workers/save");
						xhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
						xhttp.send(JSON.stringify({
							"dnitrabajador": dni, "nombre": nom, "apellidos": ape, "salario": salario,
							"fecha_nac": fnac, "fecha_ant": fant, "cuenta_bancaria": cuenta, "direccion": dir, "telefono": tlf, "turno": turno, "tipo_contrato": contrato, "num_SS": numss
						}));
					}
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							cargarTabla();
						}
					};
					deletediv.style.display = "none";
					editdiv.style.display = "none";
				}
			};
		}
	}
	document.getElementById("txtdni").value = "";
	document.getElementById("txtnom").value = "";
	document.getElementById("txtape").value = "";
	document.getElementById("txtsalario").value = "";
	document.getElementById("txtfnac").value = "";
	document.getElementById("txtfant").value = "";
	document.getElementById("txtdir").value = "";
	document.getElementById("txttlf").value = "";
	document.getElementById("txtturno").value = "";
	document.getElementById("txtcontrato").value = "";
	document.getElementById("txtnumss").value = "";
	document.getElementById("txtcuenta").value = "";
});

btnfind.addEventListener('click', function() {
	Swal.fire({
		title: 'Introduzca el DNI del trabajador',
		html:
			'<input id="dni" class="swal2-input">',
		focusConfirm: false,
		preConfirm: () => {
			var dnivalue = document.getElementById("dni").value;
			const xhttp = new XMLHttpRequest();
			if (expresion_regular_dni.test(dni) != true) {
				Swal.fire("Formato de DNI incorrecto");
			} else {
				if (dnivalue != "") {
					xhttp.open("GET", "http://localhost:3333/api/workers/find/" + dnivalue);
					xhttp.send();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							var response = "";
							if (this.responseText != "") {
								const object = JSON.parse(this.responseText);
								response += "----- Resultado -----" + "\n";
								response += "DNI: " + object['dnitrabajador'] + "\n";
								response += "Nombre: " + object['nombre'] + "\n";
								response += "Apellidos: " + object['apellidos'] + "\n";
								response += "Salario: " + object['salario'] + "\n";
								var dian = object['fecha_nac'].split("-")[2];
								var mesn = object['fecha_nac'].split("-")[1];
								var anion = object['fecha_nac'].split("-")[0];
								fnac = dian + "-" + mesn + "-" + anion;
								response += "Fecha de nacimiento:" + fnac + "\n";
								var diaa = object['fecha_ant'].split("-")[2];
								var mesa = object['fecha_ant'].split("-")[1];
								var anioa = object['fecha_ant'].split("-")[0];
								fant = diaa + "-" + mesa + "-" + anioa;
								response += "Fecha de antigüedad: " + fant + "\n";
								response += "Cuenta bancaria: " + object['cuenta_bancaria'] + "\n";
								response += "Turno: " + object['turno'] + "\n";
								response += "Tipo de contrato: " + object['tipo_contrato'] + "\n";
								response += "Dirección: " + object['direccion'] + "\n";
								response += "Número SS: " + object['num_SS'] + "\n";
								response += "Teléfono: " + object['telefono'] + "\n";
								Swal.fire({
									html: '<pre text-align="left">' + response + '</pre>',
								});
							} else {
								Swal.fire("El DNI no existe en la BBDD");
							}
						}
					};
				} else {
					Swal.fire("Debe introducir un DNI");
				}
			}
		}
	})
});

