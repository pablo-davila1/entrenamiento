package co.com.sofkau.entrenamento.curso;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofkau.entrenamiento.curso.commands.AgregarDirectrizDeMentoria;
import co.com.sofkau.entrenamiento.curso.events.DirectrizAgregadaAMentoria;
import co.com.sofkau.entrenamiento.curso.values.Directiz;
import co.com.sofkau.entrenamiento.curso.values.MentoriaId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AgregarDirectrizDeMentoriaUseCaseTest {

    private AgregarDirectrizDeMentoriaUseCase useCase;

    @BeforeEach
    public void setup(){
        useCase = new AgregarDirectrizDeMentoriaUseCase();
    }

    @Test
    public void crearDirectrizBuenAprendizaje(){
        //arrange
        /*
        MentoriaId entityId = MentoriaId.of("xxxxx"); //Nombre nombre, Fecha fecha
        Nombre nombre = new Nombre("DDD");
        Fecha fecha = new Fecha(8);

         */
        MentoriaId mentoriaId = MentoriaId.of("xxxxx");// Directiz directiz
        Directiz directiz = new Directiz("terminar");
        var command = new AgregarDirectrizDeMentoria( mentoriaId, directiz);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var directrizAgregada = (DirectrizAgregadaAMentoria)events.get(0);
        Assertions.assertEquals("xxxxx", directrizAgregada.getMentoriaId().value());
        Assertions.assertEquals("terminar", directrizAgregada.getDirectiz().value());
    }

}