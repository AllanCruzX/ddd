package escola.aplicacao.aluno.matricula;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import escola.academico.aplicacao.aluno.matricula.MatricularAluno;
import escola.academico.aplicacao.aluno.matricula.MatricularAlunoDto;
import escola.academico.dominio.aluno.Aluno;
import escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import escola.shared.dominio.CPF;
import escola.shared.dominio.evento.PublicadorDeEventos;

class MatricularAlunoTest {

	@Test
	void alunoDeveriaSerPersistido() {
		// MOCK -> Mockito futro
RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio, new PublicadorDeEventos());
		
		MatricularAlunoDto dados = new MatricularAlunoDto(
				"Fulano", 
				"123.456.789-00", 
				"fulano@email.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCPF(
				new CPF("123.456.789-00"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals(new CPF("123.456.789-00"), encontrado.getCpf());
		assertEquals("fulano@email.com", encontrado.getEmail());
	}

}
