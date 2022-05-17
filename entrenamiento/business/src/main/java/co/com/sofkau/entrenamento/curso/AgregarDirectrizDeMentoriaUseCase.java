package co.com.sofkau.entrenamento.curso;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofkau.entrenamiento.curso.Curso;
import co.com.sofkau.entrenamiento.curso.Mentoria;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectrizDeMentoria;
import co.com.sofkau.entrenamiento.curso.values.Fecha;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;

public class AgregarDirectrizDeMentoriaUseCase extends UseCase<RequestCommand<AgregarDirectrizDeMentoria>, ResponseEvents>  {
    @Override
    public void executeUseCase(RequestCommand<AgregarDirectrizDeMentoria> agregarDirectrizDeMentoriaRequestCommand){
        var command = agregarDirectrizDeMentoriaRequestCommand.getCommand();
        //var directrizdementoria = new Mentoria(command.getEntityId(), command.getNombre(), command.getFecha());
        var directrizdementoria = new AgregarDirectrizDeMentoria(command.getEntityId(),command.getNombre(),command.getFecha());
        //emit().onResponse(new ResponseEvents(directrizdementoria.getUncommittedChanges()));


    }
}
