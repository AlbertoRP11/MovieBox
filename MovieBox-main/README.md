# MovieBox

## Requisitos

- [ ] CRUD de Avaliação 
- [ ] CRUD de Comentarios
- [ ] Autenticação

## EndPoints

## 1. Usuários:
`GET` /usuarios/{id}: 

Obter detalhes de um usuário específico.

**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

## 

`POST` /usuarios: 

Criar um novo usuário.

**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##

`PUT` /usuarios/{id}: 

Atualizar informações de um usuário.

**códigos de status**
     
`200` sucesso ou `404` id não encontrado ou`400` validação falhou.

##

`DELETE` /usuarios/{id}: 

Excluir um usuário.

**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

---


## 2. Filmes:
`GET` /filmes:

Obter uma lista de todos os filmes.
   
**códigos de status**
   
`200` sucesso.

##
     
`GET` /filmes/{id}: 

Obter detalhes de um filme específico.
   
**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

##
   
`POST` /filmes:

Adicionar um novo filme à lista.
     
**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##
     
`PUT` /filmes/{id}: 

Atualizar informações de um filme.
     
**códigos de status**
     
`200` sucesso ou `404` id não encontrado ou`400` validação falhou.

##
     
`DELETE` /filmes/{id}:

Remover um filme da lista.
     
**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

**Schema**

```js
{
    "id": 1,
    "nome": "Avenger EndGame"
}

```

---

## 3. Avaliações:
`GET` /avaliacoes/{id}: 

Obter detalhes de uma avaliação específica.

**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

##

`POST` /avaliacoes: 

Adicionar uma nova avaliação de um filme.

**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##

`PUT` /avaliacoes/{id}: 

Atualizar uma avaliação existente.

**códigos de status**
     
`200` sucesso ou `404` id não encontrado ou`400` validação falhou.

##

`DELETE` /avaliacoes/{id}: 

Remover uma avaliação.

**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

---

## 4. Listas de Assistidos/Favoritos:
`GET` /usuarios/{id}/assistidos: 

Obter a lista de filmes assistidos por um usuário.

**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

##

`GET` /usuarios/{id}/favoritos: 

Obter a lista de filmes favoritos de um usuário.

**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

##

`POST` /usuarios/{id}/assistidos: 

Adicionar um filme à lista de assistidos de um usuário.

**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##

`POST` /usuarios/{id}/favoritos: 

Adicionar um filme à lista de favoritos de um usuário.

**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##

`DELETE` /usuarios/{id}/assistidos/{filme_id}: 

Remover um filme da lista de assistidos de um usuário.

**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

##

`DELETE` /usuarios/{id}/favoritos/{filme_id}: 

Remover um filme da lista de favoritos de um usuário.

**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

---

## 5. Comentários:
`GET` /comentarios/{id}: 

Obter detalhes de um comentário específico.

**códigos de status**
   
`200` sucesso ou `404` id não encontrado.

##

`POST` /comentarios: 

Adicionar um novo comentário a um filme ou avaliação.

**códigos de status**
     
`201` criado com sucesso ou `400` validação falhou.

##

`PUT` /comentarios/{id}: 

Atualizar um comentário existente.

**códigos de status**
     
`200` sucesso ou `404` id não encontrado ou`400` validação falhou.

## 

`DELETE` /comentarios/{id}: 

Remover um comentário.

**códigos de status**
     
`204` apagado com sucesso ou `404` id não encontrado.

