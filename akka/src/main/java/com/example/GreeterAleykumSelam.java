package com.example;

import akka.actor.typed.Behavior;
import akka.actor.typed.javadsl.*;

public class GreeterAleykumSelam extends AbstractBehavior<Greeter.Greeted> {

    public static Behavior<Greeter.Greeted> create(int max) {
        return Behaviors.setup(context -> new GreeterAleykumSelam(context, max));
    }

    private final int max;
    private int greetingCounter;

    private GreeterAleykumSelam(ActorContext<Greeter.Greeted> context, int max) {
        super(context);
        this.max = max;
    }

    @Override
    public Receive<Greeter.Greeted> createReceive() {
        return newReceiveBuilder().onMessage(Greeter.Greeted.class, this::onGreeted).build();
    }

    private Behavior<Greeter.Greeted> onGreeted(Greeter.Greeted message) {
        greetingCounter++;
        getContext().getLog().info("Aleykum selam {}", message.whom);
        if (greetingCounter == max) {
            return Behaviors.stopped();
        } else {
            message.from.tell(new Greeter.Greet(message.whom, getContext().getSelf()));
            return this;
        }
    }
}
