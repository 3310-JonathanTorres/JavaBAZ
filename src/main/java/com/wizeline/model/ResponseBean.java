package com.wizeline.model;

public class ResponseBean {
    /**
     * Attribute status: Guarda el resultado del request, posibles valores success o fail.
     */
    private String status;
    /**
     * Attribute code: Guarda el codigo de la operacion realizada o error.
     */
    private String code;
    /**
     * Attribute data: Guardar el resultado de la consulta realizada.
     */
    private Object result;

    /**
     * Attribute error: Bean que maneja un listado de errores presentados en durante el procesamiento de request.
     */
    private ErrorBean errors = new ErrorBean();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public ErrorBean getErrors() {
        return errors;
    }

    public void setErrors(ErrorBean errors) {
        this.errors = errors;
    }
}
