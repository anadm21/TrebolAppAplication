function login() {
	Swal.fire({
		title: 'Introduzca sus credenciales',
		html: `<input type="text" id="username" class="swal2-input" placeholder="Usuario">
  			   <input type="password" id="password" class="swal2-input" placeholder="Contraseña">`,
		confirmButtonText: 'Aceptar',
		focusConfirm: false,
		preConfirm: () => {
			const username = Swal.getPopup().querySelector('#username').value
			const password = Swal.getPopup().querySelector('#password').value
			if (!username || !password) {
				Swal.showValidationMessage(`Debe introducir sus credenciales`)
			}
			return { username: username, password: password }
		}
	}).then((result) => {
		if (result.value.username=="user" && result.value.password=="1234") {
			window.location.href = "listb.html";
		} else {
			Swal.fire("No se ha identificado correctamente");
		}
	})
}