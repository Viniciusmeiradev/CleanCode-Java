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
        switch(r.tipo){
            case COMISSIONADO:
                return new ComissionadoEmp(r);
            case SEMANA:
                return new SemanalEmp(r);
            case DIARIO:
                return new DiarioEmp(r);
            case HORA:
                return new HoraEmp(r);
            case SALARIO:
                return new SalarioEmp(r);
            
            default:
                throw new TipoPagamentoInvalido(r.tipo);
        }
    }
}
