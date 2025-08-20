package mack.exceptions;

public class NotaInvalidaException extends Exception{
    public NotaInvalidaException(){
        super("Nota Inválida - nao aceita nota negativa");
    }
}