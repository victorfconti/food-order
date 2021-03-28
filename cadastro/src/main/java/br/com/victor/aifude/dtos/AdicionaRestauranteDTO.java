package br.com.victor.aifude.dtos;

import br.com.victor.aifude.infra.DTO;
import br.com.victor.aifude.models.Restaurante;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotNull;

public class AdicionaRestauranteDTO implements DTO {
    @NotNull
    public String proprietario;
    @CNPJ
    @NotNull
    public String cnpj;
    @NotNull
    public String nome;
    @NotNull
    public LocalizacaoDTO localizacao;

    @Override
    public boolean isValid(ConstraintValidatorContext constraintValidatorContext) {
        constraintValidatorContext.disableDefaultConstraintViolation();
        if(Restaurante.find("cnpj", cnpj).count() > 0){
            constraintValidatorContext.buildConstraintViolationWithTemplate("CNPJ já cadastrado")
                    .addPropertyNode("CNPJ")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

}
