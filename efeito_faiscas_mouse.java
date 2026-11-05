import javax.swing.*;
import java.util.random;
import java.util.ArrayList;

public class SparkleApp extends JFrame{
    private final ArrayList<Particula> particulas = new ArrayList<>();
    private final Random random = new Random(); 

    public SparkApp(){
        setTitle("Sparkle - Efeito de Faísca");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //faiscas
        Painel canvas = new Painel(){
            @Override 
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                synchronized (particulas){
                    Iterator<Particula> iterator = particulas.iterator();
                    while (iterator.hasNext()){
                        Particula ponto = iterator.next();
                        ponto.update();
                        if (!ponto.isAlive()){
                            iterator.remove();
                        }else{
                            ponto.draw(g2d);
                        }
                    }
                } 
            }
        };
