var editdiv = document.getElementById("edit-div");
var deletediv = document.getElementById("delete-div");

var btnmenuadd = document.getElementById("btnanadir");
var btnmenuedit = document.getElementById("btnedit");

var btneditar = document.getElementById("btneditar");
var btneliminar = document.getElementById("btneliminar");
var btnaceptar = document.getElementById("btnaceptar");
var btnfind = document.getElementById("btnfind");

var dni, nom, ape, edad, fnac, fant, tlf, dir, fechant;
var expresion_regular_dni = /^\d{8}-[a-zA-Z]$/;

function cargarTabla() {
	const xhttp = new XMLHttpRequest();
	xhttp.open("GET", "http://localhost:3333/api/beneficiaries/all");
	xhttp.send();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			var tablero = "";
			const objects = JSON.parse(this.responseText);
			for (let object of objects) {
				tablero += '<tr>';
				tablero += '<td>' + object['dnibeneficiario'] + '</td>';
				tablero += '<td>' + object['nombre'] + '</td>';
				tablero += '<td>' + object['apellidos'] + '</td>';
				tablero += '<td>' + object['edad'] + '</td>';
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
				tablero += "</tr>";
			}
			document.getElementById("tablabeneficiarios").innerHTML = tablero;
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
				xhttp.open("GET", "http://localhost:3333/api/beneficiaries/find/" + dni);
				xhttp.send();
				xhttp.onreadystatechange = function() {
					if (this.readyState == 4 && this.status == 200) {
						if (this.responseText == "") {
							Swal.fire("El DNI/NIE no existe en la BBDD");
						} else {
							const object = JSON.parse(this.responseText);
							document.getElementById("txtdni").value = object['dnibeneficiario'];
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
			xhttp.open("GET", "http://localhost:3333/api/beneficiaries/find/" + dni);
			xhttp.send();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText == "") {
						Swal.fire("El DNI no existe en la BBDD");
						document.getElementById("textdni").value = "";
					} else {
						xhttp.open("DELETE", "http://localhost:3333/api/beneficiaries/delete/" + dni);
						xhttp.send();
						xhttp.onreadystatechange = function() {
							if (this.readyState == 4 && this.status == 200) {
								Swal.fire("El beneficiario con DNI " + dni + " se ha eliminado correctamente");
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
	edad = document.getElementById("txtedad").value;
	fnac = document.getElementById("txtfnac").value;
	fant = document.getElementById("txtfant").value;
	dir = document.getElementById("txtdir").value;
	tlf = document.getElementById("txttlf").value;

	if (expresion_regular_dni.test(dni) != true) {
		Swal.fire("Formato de DNI incorrecto");
	} else {
		if ((dni == "") || (nom == "") || (ape == "") || (edad == "") || (fnac == "") || (fant == "") || (dir == "") || (tlf == "")) {
			Swal.fire("Todos los campos son obligatorios");
		} else {
			xhttp.open("GET", "http://localhost:3333/api/beneficiaries/find/" + dni);
			xhttp.send();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if (this.responseText != "") {
						const object = JSON.parse(this.responseText);
						xhttp.open("POST", "http://localhost:3333/api/beneficiaries/save");
						xhttp.setRequestHeader("Content-Type", "application/json");
						xhttp.send(JSON.stringify({
							"idbeneficiario": object['idbeneficiario'], "dnibeneficiario": dni, "nombre": nom, "apellidos": ape, "edad": edad,
							"fecha_nac": fnac, "fecha_ant": fant, "direccion": dir, "telefono": tlf
						}));
					} else {
						xhttp.open("POST", "http://localhost:3333/api/beneficiaries/save");
						xhttp.setRequestHeader("Content-Type", "application/json");
						xhttp.send(JSON.stringify({
							"dnibeneficiario": dni, "nombre": nom, "apellidos": ape, "edad": edad,
							"fecha_nac": fnac, "fecha_ant": fant, "direccion": dir, "telefono": tlf
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
	document.getElementById("txtedad").value = "";
	document.getElementById("txtfnac").value = "";
	document.getElementById("txtfant").value = "";
	document.getElementById("txtdir").value = "";
	document.getElementById("txttlf").value = "";
});

btnfind.addEventListener('click', function() {
	Swal.fire({
		title: 'Introduzca el DNI del beneficiario',
		html:
			'<input id="dni" class="swal2-input">',
		focusConfirm: false,
		preConfirm: () => {
			var dnivalue = document.getElementById("dni").value;
			const xhttp = new XMLHttpRequest();
			if (expresion_regular_dni.test(dnivalue) != true && expresion_regular_nie.test(dnivalue) != true) {
				Swal.fire("Formato de DNI incorrecto");
			} else {
				if (dnivalue != "") {
					xhttp.open("GET", "http://localhost:3333/api/beneficiaries/find/" + dnivalue);
					xhttp.send();
					xhttp.onreadystatechange = function() {
						if (this.readyState == 4 && this.status == 200) {
							var response = "";
							if (this.responseText != "") {
								const object = JSON.parse(this.responseText);
								response += "----- Resultado -----" + "\n";
								response += "DNI: " + object['dnibeneficiario'] + "\n";
								response += "Nombre: " + object['nombre'] + "\n";
								response += "Apellidos: " + object['apellidos'] + "\n";
								response += "Edad: " + object['edad'] + "\n";
								var dian = object['fecha_nac'].split("-")[2];
								var mesn = object['fecha_nac'].split("-")[1];
								var anion = object['fecha_nac'].split("-")[0];
								fnac = dian + "-" + mesn + "-" + anion;
								response += "Fecha de nacimiento:" + fnac + "\n";
								var diaa = object['fecha_ant'].split("-")[2];
								var mesa = object['fecha_ant'].split("-")[1];
								var anioa = object['fecha_ant'].split("-")[0];
								fant = diaa + "-" + mesa + "-" + anioa;
								response += "Fecha de antig??edad: " + fant + "\n";
								response += "Direcci??n: " + object['direccion'] + "\n";
								response += "Tel??fono: " + object['telefono'] + "\n";
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


