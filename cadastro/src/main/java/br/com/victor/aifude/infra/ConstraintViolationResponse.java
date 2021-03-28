package br.com.victor.aifude.infra;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;

public class ConstraintViolationResponse {
    private final Collection<ConstraintViolationImpl> violacoes = new ArrayList<>();

    private ConstraintViolationResponse(ConstraintViolationException exception){
        exception.getConstraintViolations().forEach(violation -> violacoes.add(ConstraintViolationImpl.of(violation)));
    }

    public static ConstraintViolationResponse of(ConstraintViolationException exception){
        return new ConstraintViolationResponse(exception);
    }

    public Collection<ConstraintViolationImpl> getViolacoes(){
        return violacoes;
    }

}
