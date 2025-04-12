package com.system.SystemERP.Exceptions.Custom;




public class NotFoundEntityException extends RuntimeException {

    public NotFoundEntityException (String msg){
        super(msg);
    }

}
