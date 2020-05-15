package com.gorest.tasks;

import com.gorest.interactions.ConsumeService;
import com.gorest.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

/*Tarea que consume el servicio de GOREST para crear un nuevo usuario con el metodo POST*/
public class CreateUserRest implements Task {

    private List<String> data;

    public CreateUserRest(List<String> data){
        this.data =data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        /*se envia la informacion del usuario en formato JSON dento de un string y el segundo parametro es el token*/
        actor.attemptsTo(ConsumeService.withPost(new User(data).toString(),data.get(4)));
    }

    public static CreateUserRest with(List<String> data){
        return instrumented(CreateUserRest.class,data);
    }

}
