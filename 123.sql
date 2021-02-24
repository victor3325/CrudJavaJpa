SELECT
  alunos.idAluno,
  alunos.nomeAluno,
  alunos.sobrenome,
  etapa.idEtapa,
  etapa.descricao,
  salas.idSala,
  salas.nomeSala
FROM
  alunoEtapaSala 
JOIN
  alunos ON alunoetapasala.idAluno = alunos.idAluno
JOIN
  etapa  on alunoetapasala.idEtapa = etapa.idEtapa
JOIN
  salas  ON alunoetapasala.idSala = salas.idSala
  WHERE alunos.IDALUNO = 1

   
