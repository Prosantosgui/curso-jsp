<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="head.jsp"></jsp:include>
<body>

	<jsp:include page="theme-loader.jsp"></jsp:include>
	<!-- Pre-loader end -->
	<div id="pcoded" class="pcoded">
		<div class="pcoded-overlay-box"></div>
		<div class="pcoded-container navbar-wrapper">

			<jsp:include page="navbar.jsp"></jsp:include>
			<div class="pcoded-main-container">
				<div class="pcoded-wrapper">

					<jsp:include page="navbarmainmenu.jsp"></jsp:include>

					<div class="pcoded-content">
						<!-- Page-header start -->

						<jsp:include page="page-header.jsp"></jsp:include>

						<!-- Page-header end -->
						<div class="pcoded-inner-content">
							<!-- Main-body start -->
							<div class="main-body">
								<div class="page-wrapper">
									<!-- Page-body start -->
									<div class="page-body">

										<div class="row">
											<div class="col-sm-12">
												<!-- Basic Form Inputs card start -->
												<div class="card">

													<div class="card-block">
														<h4 class="sub-title">Cadastro usu�rio</h4>
														
														<form class="form-material"
															action="<%= request.getContextPath() %>/ServletUsuarioController"
															method="post"
															id="formUser"
															>
															
															<input type="hidden" name="acao" id="acao" value=""> 
															
															<div class="form-group form-default">
																<input type="text" name="id" id="id"
																	class="form-control" required="required"
																	readonly="readonly" value="${modelLogin.id}"> 
																	<span class="form-bar"></span>
																<label class="float-label">ID:</label>
															</div>
															<div class="form-group form-default">
																<input type="email" name="email" id="email"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.email}"> 
																	<span class="form-bar"></span>
																<label class="float-label">Email:</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="login" id="login"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.login}"> 
																	<span class="form-bar"></span>
																<label class="float-label">Login:</label>
															</div>
															<div class="form-group form-default">
																<input type="password" name="senha" id="senha"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.senha}"> 
																	<span class="form-bar"></span>
																<label class="float-label">Senha:</label>
															</div>
															<div class="form-group form-default">
																<input type="text" name="nome" id="nome"
																	class="form-control" required="required"
																	autocomplete="off" value="${modelLogin.nome}">
																	 <span class="form-bar"></span>
																<label class="float-label">Nome:</label>
															</div>

															<button type="button" class="btn btn-primary waves-effect waves-light" onclick="limparForm();">Novo</button>
															<button class="btn btn-success waves-effect waves-light">Salvar</button>
															<button type="button" class="btn btn-info waves-effect waves-light" onclick="criarDelete();">Excluir</button>
														</form>
													</div>
												</div>
											</div>
										</div>
									<span>${msg}</span>
									
									</div>
									<!-- Page-body end -->
								</div>
								<div id="styleSelector"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="javascriptfile.jsp"></jsp:include>

<script type="text/javascript">
	function criarDelete(){
		document.getElementById("formUser").method = 'get';
		document.getElementById("acao").value = 'deletar';
		document.getElementById("formUser").submit();
	}

	function limparForm(){
	
		var elementos = document.getElementById("formUser").elements;
		
		for (p = 0; p < elementos.legnth; p++){
			elementos[p].value = '';
		}
	}
</script>
</body>


</html>
