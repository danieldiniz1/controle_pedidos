package br.com.controle.pedidos.service.validation;

import br.com.controle.pedidos.controller.form.ClienteForm;
import br.com.controle.pedidos.exception.FieldMessage;
import br.com.controle.pedidos.service.validation.utils.BrazilianDataUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Validation;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteForm> {

    @Override
    public void initialize(ClienteInsert constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(ClienteForm value, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if (value.getTipoCliente().equals(1)){
           if(!BrazilianDataUtils.isvalidCPF(value.getCpf())){
                list.add(new FieldMessage("CPF","CPF inválido"));
           }
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }

    private void validationCPF(String cpf) {

    }
}
