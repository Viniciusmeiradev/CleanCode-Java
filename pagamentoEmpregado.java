public abstract class Empregado{
    public abstract boolean pagamentoDiario();
    public abstract Dinheiro calculoPagamento();
    public abstract void entregaPagamento(Dinheiro pago);
}

public interface EmpregadoFactory {
    public Empregado mEmpregado(EmpregadoGravar r) throws TipoPagamentoInvalido;
     
}

public class EmpregadoFactoryImp implements EmpregadoFactory{
    public Empregado mEmpregado(EmpregadoGravar r) throws TipoPagamentoInvalido{

    }
}
