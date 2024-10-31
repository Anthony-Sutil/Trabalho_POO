class TarefaException extends Exception {
    public TarefaException(String mensagem) {
        super(mensagem);
    }

    public TarefaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }

    public TarefaException(Throwable causa) {
        super(causa);
    }

    @Override
    public String toString() {
        return "TarefaException: " + getMessage();
    }
}