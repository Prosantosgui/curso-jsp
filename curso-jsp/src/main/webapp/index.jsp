<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
	
	<title>Curso jsp</title>
	
	<style type="text/css">
		form{
		 position: absolute;
		 top: 40%;
		 left: 33%;
		 right: 33%;
		}
		h2{
		position: absolute;
		top: 30%;
		left: 35%;
		 
		}
		h5{
		position: absolute;
		top: 60%;
		left: 36%;
		color: #FF0000;
		}

	</style>
	
</head>
<body>
	<h2>Bem-vindo ao curso de JSP</h2>
	
		
	<form action="<%= request.getContextPath() %>/ServletLogin" method="post" class="row g-3 needs-validation" novalidate>
	
	<input type="hidden" value="<%= request.getParameter("url") %>">
	
	  <div class="col md-6">
	    <label class="form-label">Login</label>
	    <input class="form-control" name="login" required>
	    <div class="invalid-feedback">
        	Informe o login
        </div>
	  </div>
	  
	  <div class="col md-6">
	    <label class="form-label">Senha</label>
	    <input type="password" class="form-control" name="senha" required>
	    <div class="invalid-feedback">
        	Informe a senha
        </div>
	  </div>
	  
	  <button type="submit" class="btn btn-primary">Acessar</button>
	</form>
	
	
	 <h5>${msg}</h5>
	  
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
	(() => {
		  'use strict'

		  // Fetch all the forms we want to apply custom Bootstrap validation styles to
		  const forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.from(forms).forEach(form => {
		    form.addEventListener('submit', event => {
		      if (!form.checkValidity()) {
		        event.preventDefault()
		        event.stopPropagation()
		      }

		      form.classList.add('was-validated')
		    }, false)
		  })
		})()
	</script>
</body>
</html>