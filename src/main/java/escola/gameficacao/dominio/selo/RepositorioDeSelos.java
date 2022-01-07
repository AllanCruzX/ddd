package escola.gameficacao.dominio.selo;

import java.util.List;

import escola.shared.dominio.CPF;

public interface RepositorioDeSelos {
	
	void adicionar(Selo selo);
	List<Selo> selosDoAlunoDeCPF(CPF cpf);

}
