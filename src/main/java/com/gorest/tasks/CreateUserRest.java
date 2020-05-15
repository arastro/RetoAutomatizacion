package com.gorest.tasks;

import com.gorest.interactions.ConsumeService;
import com.gorest.models.User;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateUserRest implements Task {

    private List<String> data;

    public CreateUserRest(List<String> data){
        this.data =data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ConsumeService.withPost(new User(data).toString()));
    }

    public static CreateUserRest with(List<String> data){
        return instrumented(CreateUserRest.class,data);
    }

}
