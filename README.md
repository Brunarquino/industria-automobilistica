# REST API INDUSTRIA AUTOMOBILISTICA     
   

### APLICAÇÃO DE CONTROLE DE PRODUÇÃO E VENDAS

**TECNOLOGIAS UTILIZADAS**

 1. Lombok
 2. Flyway
 3. JWT
 4. MYSQL

***Desenvolvedoras do Projeto***


[Ana Karolina Aparecida Silva](https://github.com/anakarolinaaparecidasilva)
 
[Angela Zoldan Giampaoli](https://github.com/azgiampaoli)

[Bruna Arquino](https://github.com/brunarquino)

[Dyanna Mousinho](https://github.com/Dyannaom)

[Julie Cordeiro](https://github.com/juliecordeiro)

   
Esta API foi criada para o controle de produção de veículos e venda destes e de peças.
   
Toda a aplicação está sendo rodada pelo localhost:8080/v1
   
    
As requisições estão sendo realizadas via Postman
   

## *ENDPOINTS*  
     
   
   ***Autenticar Usuário:***   
   Request   
   POST /auth  

       {       
       "email": "admin@gft.com",       
       "senha": "1234"       
       }   
   Response   

       {   
       "token":   "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiaXNzIjoiUHJvZ3JhbWFTVEFSVEVSIiwiZXhwIjoxNjY5Njk2NzM5fQ.3X3KTHdIFfCwyx6Q5vRgs-56nZ1wAgN5caFtJy3aCxw"   
       }  
     
   
   ***Criar Usuário Administrador:***   
   Request   
   POST /auth/administradores     

    {  
       "email": "admin3@gft.com",   
       "senha": "1234"   
       }
     
   
   Response  
  

     {   
       "email": "admin3@gft.com",   
       "nomePerfil": "ADMIN"   
       }
   
   ***Criar Usuário Vendedor:***   
   Request   
   POST /auth/vendedores   

       {   
       "email": "vendedor@gft.com",   
       "senha": "1234"   
       }       
   
   Response   

      {   
       "email": "vendedor@gft.com",   
       "nomePerfil": "VENDEDOR"   
       }
  
   ***Criar Fornecedor:***   

   Request   
   POST /fornecedores   

       {   
       "nome": "Fornecedor B",   
       "cnpj": "12345678901234",   
       "pontuacao": 9,   
       "endereco": {   
       "cep": "95590000",   
       "logradouro": "Rua D",   
       "numero": "1234",   
       "complemento": ""   
       }   
       }   
        
   Response   

  

         {   
           "id": 2,   
           "nome": "Fornecedor B",   
           "cnpj": "12345678901234",   
           "nacionalidade": null,   
           "pontuacao": 9,   
           "endereco": {   
           "cep": "95590-000",   
           "uf": "RS",   
           "cidade": "",   
           "bairro": "",   
           "logradouro": "",   
           "numero": "1234",   
           "complemento": ""   
           }   
           }   
         
       
   ***Buscar Fornecedores: (com Paginação)***
       
Request   
GET /fornecedores    
       

Response
       
       {   
       "content": [   
       {   
       "id": 1,   
       "nome": "Industria Automobilistica Matriz",   
       "cnpj": "12345678905235",   
       "nacionalidade": "Brasileira",   
       "pontuacao": 10,   
       "endereco": {   
       "cep": "1111111",   
       "uf": "sp",   
       "cidade": "São Paulo",   
       "bairro": "Bairro A",   
       "logradouro": "Rua A",   
       "numero": "111",   
       "complemento": ""   
       } }  
       {   
       "id": 2,   
       "nome": "Fornecedor B",   
       "cnpj": "12345678901234",   
       "nacionalidade": null,   
       "pontuacao": 9,   
       "endereco": {   
       "cep": "95590-000",   
       "uf": "RS",   
       "cidade": "",   
       "bairro": "",   
       "logradouro": "",   
       "numero": "1234",   
       "complemento": ""   
       }   
       }   
       ],   
       "pageable": {   
       "sort": {   
       "empty": true,   
       "sorted": false,   
       "unsorted": true   
       },   
       "offset": 0,   
       "pageSize": 10,   
       "pageNumber": 0,   
       "paged": true,   
       "unpaged": false 
       }   
       "last": true,   
       "totalElements": 2,   
       "totalPages": 1,   
       "size": 10,   
       "number": 0,   
       "sort": {   
       "empty": true,   
       "sorted": false,   
       "unsorted": true   
       },   
       "first": true,   
       "numberOfElements": 2,   
       "empty": false  
        }

     
   ***Buscar Fornecedor por ID:***

Request   
GET /fornecedores/1

Response   

     {
    "id":  1,
    "nome":  "Industria Automobilistica Matriz",
    "cnpj":  "12345678905235",
    "nacionalidade":  "Brasileira",
    "pontuacao":  10,
    "endereco":  {
    "cep":  "1111111",
    "uf":  "sp",
    "cidade":  "São Paulo",
    "bairro":  "Bairro A",
    "logradouro":  "Rua A",
    "numero":  "111",
    "complemento":  ""
    }
    }

***Atualizar Fornecedor:***

Request
PUT  /fornecedores/1   

     {
        "nome":  "Fornecedor AB",
        "cnpj":  "12345678901234",
        "pontuacao":  9,
        "endereco":  {
        "cep":  "11111111",
        "logradouro":  "Rua D",
        "numero":  "1234",
        "complemento":  ""
        }
        }

Response

    {
    "nome":  "Fornecedor AB",
    "cnpj":  "12345678901234",
    "pontuacao":  9,
    "endereco":  {
    "cep":  "11111111",
    "logradouro":  "Rua D",
    "numero":  "1234",
    "complemento":  ""
    }
    }

***Deletar Fornecedor:***

Request
DELETE /fornecedores/1

Response

    Status: 200 OK

***Criar Cliente:***   

Request   
POST /clientes 

       {
        "nome":  "Dyanna",
        "cpf":  "1201234",
        "endereco":  {
        "cep":  "22730521",
        "logradouro":  "Rua D",
        "numero":  "1234",
        "complemento":  ""
        }
        }     
        
Response    

    {
    "id":  1,
    "nome":  "Dyanna",
    "cpf":  "1201234",
    "endereco":  {
    "cep":  "22730-521",
    "uf":  "RJ",
    "cidade":  "",
    "bairro":  "Taquara",
    "logradouro":  "Rua André Rocha",
    "numero":  "1234",
    "complemento":  ""
    }
    }          
         
       
   ***Buscar Clientes: (com Paginação)***
       
Request   
GET /clientes    


       
Response      
 

      {
        "content": [
            {
                "id": 1,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            },
            {
                "id": 2,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            },
            {
                "id": 3,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            },
            {
                "id": 4,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            },
            {
                "id": 5,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            },
            {
                "id": 6,
                "nome": "Dyanna",
                "cpf": "1201234",
                "endereco": {
                    "cep": "22730-521",
                    "uf": "RJ",
                    "cidade": "",
                    "bairro": "Taquara",
                    "logradouro": "Rua André Rocha",
                    "numero": "1234",
                    "complemento": ""
                }
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageNumber": 0,
            "pageSize": 10,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 6,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 6,
        "empty": false
    }
    
     
   ***Buscar Cliente por ID:***

Request   
GET /clientes/1

Response   

    {
        "id": 1,
        "nome": "Dyanna de O. D.",
        "cpf": "1201234",
        "endereco": {
            "cep": "22730521",
            "uf": null,
            "cidade": null,
            "bairro": null,
            "logradouro": "Rua D",
            "numero": "1234",
            "complemento": ""
        }
    }


***Atualizar Cliente:***

Request
PUT  /clientes/1   

    {
    "nome":  "Dyanna de O. D.",
    "cpf":  "1201234",
    "endereco":  {
    "cep":  "22730521",
    "logradouro":  "Rua D",
    "numero":  "1234",
    "complemento":  ""
    }
    }
 
Response

  

***Deletar Cliente:***

Request
DELETE /clientes/1

Response

    {
        "id": 1,
        "nome": "Dyanna de O. D.",
        "cpf": "1201234",
        "endereco": {
            "cep": "22730521",
            "uf": null,
            "cidade": null,
            "bairro": null,
            "logradouro": "Rua D",
            "numero": "1234",
            "complemento": ""
        }
    }

    Status: 200 OK


   ***Criar Peça:***   

Request   
POST /pecas 

    { 
    "nome":  "Peca D"    
    }     
        
Response    

    {
        "produto_id": 1,
        "nome": "Peca D"
    }
          
         
       
   ***Buscar Peças: (com Paginação)***
       
Request   
GET /pecas
       
Response
	   
	        {
        "content": [
            {
                "produto_id": 1,
                "nome": "Peca D"
            },
            {
                "produto_id": 2,
                "nome": "Peca D"
            },
            {
                "produto_id": 3,
                "nome": "Peca D"
            },
            {
                "produto_id": 4,
                "nome": "Peca D"
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 4,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 4,
        "empty": false
    }

   ***Buscar Peça por ID:***

Request   
GET /pecas/1

Response   

    {
        "produto_id": 1,
        "nome": "Peca D"
    }

***Atualizar Peças:***

Request
PUT  /pecas/1   

    {    
    "nome":  "Peca Atualizar"    
    }    

Response

    {
        "produto_id": 1,
        "nome": "Peca Atualizar"
    }
  

***Deletar Peça:***

Request
DELETE /pecas/1

Response

    Status: 200 OK


***Criar Veículo:***   

Request   
POST /veiculos

    {
    "nome":  "Veiculo B",
    "status":"EM_PRODUCAO",
    "valorInsumo":  4999.99,
    "pecasId":  [1,  2]
    }

        
Response    

    {
        "id": 1,
        "produto": {
            "id": 5,
            "tipoProduto": "VEICULOS",
            "nome": "Veiculo B"
        },
        "status": "EM_PRODUCAO",
        "valorInsumo": 4999.99,
        "pecas": [
            {
                "produto_id": 1,
                "nome": "Peca Atualizar"
            },
            {
                "produto_id": 2,
                "nome": "Peca D"
            }
        ]
    }
          
       
   ***Buscar Veículo: (com Paginação)***  

Request   
GET /veiculos
       
Response

        {
        "content": [
            {
                "id": 1,
                "produto": {
                    "id": 5,
                    "tipoProduto": "VEICULOS",
                    "nome": "Veiculo B"
                },
                "status": "EM_PRODUCAO",
                "valorInsumo": 5000,
                "pecas": [
                    {
                        "produto_id": 1,
                        "nome": "Peca Atualizar"
                    },
                    {
                        "produto_id": 2,
                        "nome": "Peca D"
                    }
                ]
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    }     

     
   ***Buscar Veículo por ID:***

Request   
GET /veiculos/1

Response   

    {
        "id": 1,
        "produto": {
            "id": 5,
            "tipoProduto": "VEICULOS",
            "nome": "Veiculo B"
        },
        "status": "EM_PRODUCAO",
        "valorInsumo": 5000,
        "pecas": [
            {
                "produto_id": 1,
                "nome": "Peca Atualizar"
            },
            {
                "produto_id": 2,
                "nome": "Peca D"
            }
        ]
    }


***Atualizar Veículo:***

Request
PUT  /veiculos/1   

    {
    "nome":  "Veiculo A",
    "status":"EM_PRODUCAO",
    "valorInsumo":  4999.99,
    "pecasId":  [1,  2]
    }
    

Response

    {
        "id": 1,
        "produto": {
            "id": 5,
            "tipoProduto": "VEICULOS",
            "nome": "Veiculo A"
        },
        "status": "EM_PRODUCAO",
        "valorInsumo": 4999.99,
        "pecas": [
            {
                "produto_id": 1,
                "nome": "Peca Atualizar"
            },
            {
                "produto_id": 2,
                "nome": "Peca D"
            }
        ]
    }
  

***Deletar Veículo:***

Request
DELETE /veiculos/1

Response

    Status: 200 OK

***Criar Compra:***

Request
POST /compras

    {
    "fornecedorId":  2,
    "itens":  [
    {
    "produto_id":  1,
    "quantidade":  50,
    "valor":  5.50
    },
    {
    "produto_id":  2,
    "quantidade":  50,
    "valor":  12.50
    },
    {
    "produto_id":  3,
    "quantidade":  50,
    "valor":  5.00
    }
    ]
    }

Response

    {
        "id": 1,
        "itens": [
            {
                "id": 1,
                "produto_id": {
                    "id": 1,
                    "tipoProduto": "PECAS",
                    "nome": "Peca Atualizar"
                },
                "quantidade": 50
            },
            {
                "id": 2,
                "produto_id": {
                    "id": 2,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 50
            },
            {
                "id": 3,
                "produto_id": {
                    "id": 3,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 50
            }
        ],
        "valorTotal": 1150.00,
        "fornecedor": {
            "id": 2,
            "nome": "Fornecedor A",
            "cnpj": "12345678901234",
            "nacionalidade": null,
            "pontuacao": 9,
            "endereco": {
                "cep": "95590-000",
                "uf": "RS",
                "cidade": "",
                "bairro": "",
                "logradouro": "",
                "numero": "1234",
                "complemento": ""
            }
        }
    }


***Buscar Compras:***

Request
GET /compras


Response

    {
        "content": [
            {
                "id": 1,
                "itens": [
                    {
                        "id": 1,
                        "produto_id": {
                            "id": 1,
                            "tipoProduto": "PECAS",
                            "nome": "Peca Atualizar"
                        },
                        "quantidade": 50
                    },
                    {
                        "id": 2,
                        "produto_id": {
                            "id": 2,
                            "tipoProduto": "PECAS",
                            "nome": "Peca D"
                        },
                        "quantidade": 50
                    },
                    {
                        "id": 3,
                        "produto_id": {
                            "id": 3,
                            "tipoProduto": "PECAS",
                            "nome": "Peca D"
                        },
                        "quantidade": 50
                    }
                ],
                "valorTotal": 1150.00,
                "fornecedor": {
                    "id": 2,
                    "nome": "Fornecedor A",
                    "cnpj": "12345678901234",
                    "nacionalidade": null,
                    "pontuacao": 9,
                    "endereco": {
                        "cep": "95590-000",
                        "uf": "RS",
                        "cidade": "",
                        "bairro": "",
                        "logradouro": "",
                        "numero": "1234",
                        "complemento": ""
                    }
                }
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "paged": true,
            "unpaged": false
        },
        "last": true,
        "totalPages": 1,
        "totalElements": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    }

***Buscar Compra:***

Request
GET / compras/1

Response

    {
        "id": 1,
        "itens": [
            {
                "id": 1,
                "produto_id": {
                    "id": 1,
                    "tipoProduto": "PECAS",
                    "nome": "Peca Atualizar"
                },
                "quantidade": 50
            },
            {
                "id": 2,
                "produto_id": {
                    "id": 2,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 50
            },
            {
                "id": 3,
                "produto_id": {
                    "id": 3,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 50
            }
        ],
        "valorTotal": 1150.00,
        "fornecedor": {
            "id": 2,
            "nome": "Fornecedor A",
            "cnpj": "12345678901234",
            "nacionalidade": null,
            "pontuacao": 9,
            "endereco": {
                "cep": "95590-000",
                "uf": "RS",
                "cidade": "",
                "bairro": "",
                "logradouro": "",
                "numero": "1234",
                "complemento": ""
            }
        }
    }

***Criar Venda:***

Request
POST / vendas

    {
    "clienteId":  1,
    "itens":  [
    {
    "produto_id":  1,
    "quantidade":  30,
    "valor":  7.50
    },
    {
    "produto_id":  2,
    "quantidade":  30,
    "valor":  13.50
    },
    {
    "produto_id":  3,
    "quantidade":  30,
    "valor":  7.00
    }
    ]
    }

Response

    {
        "id": 1,
        "cliente": {
            "id": 1,
            "nome": "Dyanna de O. D.",
            "cpf": "1201234",
            "endereco": {
                "cep": "22730521",
                "uf": null,
                "cidade": null,
                "bairro": null,
                "logradouro": "Rua D",
                "numero": "1234",
                "complemento": ""
            }
        },
        "fornecedor": {
            "id": 1,
            "nome": "Industria Automobilistica Matriz",
            "cnpj": "12345678905235",
            "nacionalidade": "Brasileira",
            "pontuacao": 10,
            "endereco": {
                "cep": "1111111",
                "uf": "sp",
                "cidade": "São Paulo",
                "bairro": "Bairro A",
                "logradouro": "Rua A",
                "numero": "111",
                "complemento": ""
            }
        },
        "itens": [
            {
                "id": 1,
                "produto_id": {
                    "id": 1,
                    "tipoProduto": "PECAS",
                    "nome": "Peca Atualizar"
                },
                "quantidade": 30
            },
            {
                "id": 2,
                "produto_id": {
                    "id": 2,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 30
            },
            {
                "id": 3,
                "produto_id": {
                    "id": 3,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 30
            }
        ],
        "valorTotal": 840.00
    }

***Buscar Vendas:***

Request
GET /vendas

Response

    {
        "content": [
            {
                "id": 1,
                "cliente": {
                    "id": 1,
                    "nome": "Dyanna de O. D.",
                    "cpf": "1201234",
                    "endereco": {
                        "cep": "22730521",
                        "uf": null,
                        "cidade": null,
                        "bairro": null,
                        "logradouro": "Rua D",
                        "numero": "1234",
                        "complemento": ""
                    }
                },
                "itens": [
                    {
                        "id": 1,
                        "produto": {
                            "id": 1,
                            "tipoProduto": "PECAS",
                            "nome": "Peca Atualizar"
                        },
                        "quantidade": 30,
                        "valorVenda": 7.50,
                        "lucroPorItem": 225.00,
                        "venda": {
                            "id": 1,
                            "valorTotal": 840.00,
                            "cliente": {
                                "id": 1,
                                "nome": "Dyanna de O. D.",
                                "cpf": "1201234",
                                "endereco": {
                                    "cep": "22730521",
                                    "uf": null,
                                    "cidade": null,
                                    "bairro": null,
                                    "logradouro": "Rua D",
                                    "numero": "1234",
                                    "complemento": ""
                                }
                            },
                            "lucroPorVenda": 840.00
                        }
                    },
                    {
                        "id": 2,
                        "produto": {
                            "id": 2,
                            "tipoProduto": "PECAS",
                            "nome": "Peca D"
                        },
                        "quantidade": 30,
                        "valorVenda": 13.50,
                        "lucroPorItem": 405.00,
                        "venda": {
                            "id": 1,
                            "valorTotal": 840.00,
                            "cliente": {
                                "id": 1,
                                "nome": "Dyanna de O. D.",
                                "cpf": "1201234",
                                "endereco": {
                                    "cep": "22730521",
                                    "uf": null,
                                    "cidade": null,
                                    "bairro": null,
                                    "logradouro": "Rua D",
                                    "numero": "1234",
                                    "complemento": ""
                                }
                            },
                            "lucroPorVenda": 840.00
                        }
                    },
                    {
                        "id": 3,
                        "produto": {
                            "id": 3,
                            "tipoProduto": "PECAS",
                            "nome": "Peca D"
                        },
                        "quantidade": 30,
                        "valorVenda": 7.00,
                        "lucroPorItem": 210.00,
                        "venda": {
                            "id": 1,
                            "valorTotal": 840.00,
                            "cliente": {
                                "id": 1,
                                "nome": "Dyanna de O. D.",
                                "cpf": "1201234",
                                "endereco": {
                                    "cep": "22730521",
                                    "uf": null,
                                    "cidade": null,
                                    "bairro": null,
                                    "logradouro": "Rua D",
                                    "numero": "1234",
                                    "complemento": ""
                                }
                            },
                            "lucroPorVenda": 840.00
                        }
                    }
                ],
                "valorTotal": 840.00,
                "lucroPorVenda": 840.00
            }
        ],
        "pageable": {
            "sort": {
                "empty": true,
                "sorted": false,
                "unsorted": true
            },
            "offset": 0,
            "pageSize": 10,
            "pageNumber": 0,
            "unpaged": false,
            "paged": true
        },
        "last": true,
        "totalElements": 1,
        "totalPages": 1,
        "size": 10,
        "number": 0,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "first": true,
        "numberOfElements": 1,
        "empty": false
    }

***Buscar Venda***

Request
GET / vendas/1

Response

    {
        "id": 1,
        "cliente": {
            "id": 1,
            "nome": "Dyanna de O. D.",
            "cpf": "1201234",
            "endereco": {
                "cep": "22730521",
                "uf": null,
                "cidade": null,
                "bairro": null,
                "logradouro": "Rua D",
                "numero": "1234",
                "complemento": ""
            }
        },
        "itens": [
            {
                "id": 1,
                "produto": {
                    "id": 1,
                    "tipoProduto": "PECAS",
                    "nome": "Peca Atualizar"
                },
                "quantidade": 30,
                "valorVenda": 7.50,
                "lucroPorItem": 225.00,
                "venda": {
                    "id": 1,
                    "valorTotal": 840.00,
                    "cliente": {
                        "id": 1,
                        "nome": "Dyanna de O. D.",
                        "cpf": "1201234",
                        "endereco": {
                            "cep": "22730521",
                            "uf": null,
                            "cidade": null,
                            "bairro": null,
                            "logradouro": "Rua D",
                            "numero": "1234",
                            "complemento": ""
                        }
                    },
                    "lucroPorVenda": 840.00
                }
            },
            {
                "id": 2,
                "produto": {
                    "id": 2,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 30,
                "valorVenda": 13.50,
                "lucroPorItem": 405.00,
                "venda": {
                    "id": 1,
                    "valorTotal": 840.00,
                    "cliente": {
                        "id": 1,
                        "nome": "Dyanna de O. D.",
                        "cpf": "1201234",
                        "endereco": {
                            "cep": "22730521",
                            "uf": null,
                            "cidade": null,
                            "bairro": null,
                            "logradouro": "Rua D",
                            "numero": "1234",
                            "complemento": ""
                        }
                    },
                    "lucroPorVenda": 840.00
                }
            },
            {
                "id": 3,
                "produto": {
                    "id": 3,
                    "tipoProduto": "PECAS",
                    "nome": "Peca D"
                },
                "quantidade": 30,
                "valorVenda": 7.00,
                "lucroPorItem": 210.00,
                "venda": {
                    "id": 1,
                    "valorTotal": 840.00,
                    "cliente": {
                        "id": 1,
                        "nome": "Dyanna de O. D.",
                        "cpf": "1201234",
                        "endereco": {
                            "cep": "22730521",
                            "uf": null,
                            "cidade": null,
                            "bairro": null,
                            "logradouro": "Rua D",
                            "numero": "1234",
                            "complemento": ""
                        }
                    },
                    "lucroPorVenda": 840.00
                }
            }
        ],
        "valorTotal": 840.00,
        "lucroPorVenda": 840.00
    }

***Visualizar Lucro:***

Request
GET /vendas/lucros

Response

    840.00





