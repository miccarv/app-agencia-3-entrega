Algoritmo "Menu_Cadastro_Consulta_Agencia"

Var
   cpf: vetor [1..3] de  inteiro
   nome: vetor [1..3] de caractere
   est: vetor [1..3] de  caractere
   desx: vetor [1..3] de  caractere
   desy: vetor [1..3] de  caractere
   per: vetor [1..3] de  caractere
   data: vetor [1..3] de  caractere

   codigo: inteiro
   cpfpesq: inteiro
   encontrado: logico
   despesq: caractere

procedimento principal()

Inicio

   repita
   escreval ("")
   escreval ("Menu Principal")
   escreval ("--------------")
   escreval ("Esc - Sair")
   escreval ("1 - Criar Novo Cadastro")
   escreval ("2 - Consultar Dados do Cliente")
   escreval ("3 - Cadastrar Destino")
   escreval ("4 - Consultar Destino")
   escreva ("Digite uma Opcao: ")
   leia (codigo)

   ate (codigo=1) ou (codigo=2) ou (codigo=3)  ou (codigo=4)
   escolha (codigo)
   caso 1
        cadastro()
   caso 2
        consulta_cpf()
   caso 3
        cadastro_destino()
   caso 4
        consulta_destino()
   fimescolha
   
fimprocedimento


procedimento cadastro()

var

   i:inteiro

   
inicio

   escreval("---------------------  CADASTRO ---------------------")
   para i de 1 ate 3 faca
      escreva ("Digite o CPF: ")
      leia (cpf[i])
      escreva ("Digite o Nome: ")
      leia (nome[i])
      escreva ("Digite seu Destino: ")
      leia (desx[i])
      escreval("")
   fimpara

   principal()

fimprocedimento

procedimento consulta_cpf()

var

 i:inteiro

inicio

      escreval("---------------------  CONSULTA ---------------------")
      escreva ("Digite um CPF para Consulta : ")
      leia (cpfpesq)
      para i de 1 ate 3 faca
      se (cpf[i]) = (cpfpesq) então
         escreval ("---------------------- CONSULTA PELO CPF -------------------")
         escreval ("CPF: ", cpf[i])
         escreval ("Nome: ", nome[i])
         escreval ("Destino: ", desx[i])

         encontrado<-verdadeiro
      fimse
      fimpara
      se encontrado=falso então
         escreval ("------------ Cadastro não encontrado! -------------")
      fimse
      principal()

fimprocedimento

procedimento cadastro_destino()

var

   i:inteiro

inicio

   escreval("---------------------  CADASTRO DESTINO ---------------------")
   para i de 1 ate 3 faca
      escreva ("Digite a duração da viagem: ")
      leia (per[i])
      escreva ("Digite quando será a viagem: (DD/MM/AAAA): ")
      leia (data[i])
      escreva ("Digite o Destino: ")
      leia (desy[i])
      escreval("")

   fimpara

   principal()

fimprocedimento

procedimento consulta_destino()

var

 i:inteiro

inicio

      escreval("---------------------  CONSULTA ---------------------")
      escreva ("Digite um Destino para Consulta : ")
      leia (despesq)
      para i de 1 ate 3 faca
      se (desy[i]) = (despesq) então
         escreval ("---------------------- CONSULTAR DESTINO -------------------")
         escreval ("Duração: ", per[i])
         escreval ("Data: ", data[i])
         escreval ("Destino: ", desy[i])

         encontrado<-verdadeiro
      fimse
      fimpara
      se encontrado=falso então
         escreval ("------------ Destino não encontrado! -------------")
      fimse
      principal()

fimprocedimento


inicio

      principal()
fimalgoritmo