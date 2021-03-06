package br.com.alura.escola.academico.dominio.aluno;

import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

import java.time.format.DateTimeFormatter;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected void reage(Evento evento) {
        String momentoFormatado = evento.momento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        AlunoMatriculado alunoMatriculado = (AlunoMatriculado) evento;

        System.out.print(String.format("Aluno com cpf %s matriculado em: %s%n",
                alunoMatriculado.getCpfDoAluno(),
                momentoFormatado));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
