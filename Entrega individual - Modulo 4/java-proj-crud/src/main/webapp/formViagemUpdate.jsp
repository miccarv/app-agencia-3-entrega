<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" href="css/style.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
      <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>
      <title>Viagens Cadastradas</title>
    </head>

    <body class="home-bg">

      <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01"
          aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <a class="navbar-brand" href="index.html">Home</a>
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item">
              <a class="nav-link" href="destino.html">Destinos</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="promocoes.html">Promoções</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contato.html">Contato</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="CreateAndFind">Clientes Cadastrados</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="ViagemCreateAndFind">Viagens Cadastradas</a>
            </li>
          </ul>
          <form action="CreateAndFind" method="GET" class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="email" name="pesquisa" placeholder="Digite o email do cliente"
              aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0 nouline" type="submit">Buscar Cliente</button>
          </form>
        </div>
      </nav>

      <div class="container-fluid text-white px-3" style="padding: 56px 0 56px 0;">
        <div class="row w-100 justify-content-center">
          <div style="width:70%">
            <hr>
            <h3>Atualizar Viagem Cadastrada</h3>
            <hr>
            <form action="ViagemUpdate" method="POST">
              <input value="${viagem.id}" name="id" type="number" style="visibility:hidden">
              <div class="form-floating mb-3">
                <input value="${viagem.email}" name="email" maxlength="40" type="email" class="form-control"
                  id="floatingInput1">
                <label>Email</label>
              </div>
              <div class="form-floating mb-3">
                <input value="${viagem.duration}" name="duration" maxlength="40" type="text" class="form-control">
                <label>Duração</label>
              </div>
              <div class="form-floating mb-3">
                <input value="${viagem.date}" name="date" type="date" class="form-control" placeholder="Data da viagem">
                <label>Data da viagem</label>
              </div>
              <div class="form-floating mb-3">

                <select value="${viagem.destination}" name="destination" class="form-select mb-3"
                  aria-label="Default select example">
                  <option selected>-- Selecione o destino desejado</option>
                  <option value="Salvador">Salvador</option>
                  <option value="Porto Alegre">Porto Alegre</option>
                  <option value="Rio de Janeiro">Rio de Janeiro</option>
                </select>

                <label>Destino</label>
              </div>

              <button class="btn btn-success" type="submit">Atualizar
                Dados</button>
              <button class="btn btn-secondary" type="reset">Limpar
                Formulário</button>
            </form>
            <br>
          </div>
        </div>
      </div>

      <footer class="bg-light text-center text-lg-start fixed-bottom">
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
          © 2022 Copyright:
          <a class="text-dark" href="#">Placeholder</a>
        </div>
      </footer>

    </body>

    </html>