SELECT
  alunos.idAluno,
  alunos.nomeAluno,
  alunos.sobrenome,
  etapa.idEtapa,
  etapa.descricao,
  espaco.IDESPACO,
  espaco.NOMEESPACO
FROM
  alunoetapaespaco 
JOIN
  alunos ON alunoetapaespaco.idAluno = alunos.idAluno
JOIN
  etapa  on alunoetapaespaco.idEtapa = etapa.idEtapa
JOIN
  espaco  ON alunoetapaespaco.idEspaco = espaco.IDESPACO