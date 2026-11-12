import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

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
        
        canvas.setBackground(new Color(15,15,30));
        add(canvas);

        canvas.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseMovimento(MouseEvent e){
                spawnSparkles(e.getX(), e.getY(), 3);
            }

            @Override
            public void mouseArrasto(MouseEvent e){
                spawnSparkles(e.getX(), e.getY(), 5);
            }
        });

        
        canvas.addMouseListener(new MouseAdapter(){
            @Override 
            public void mousePressionado(MouseEvent e){
                spawnSparkles(e.getX(), e;getY(),15);
            }
        });

        Timer timer = new Timer(16, e -> canvas.repaint());
        timer.start();
    }

    
    private void spawnSparkles(int x, int y, int count){
        synchronized (particulas){
            for(int = 0; i < count; i++){
                particulas.add(new Particula(x, y, random));
            }
        }
    }

    private static class Particula{
        double vetorx, vetory:
        double velocidadex, velocidadey;
        double transparencia;
        double TaxaDecaimento;
        int size;
        Color color;

        public Particula(int startX, int startY, Random rand){
            this.vetorX = startX + rand.nextInt(10) - 5;
            this.vetorY = startY + rand.nextInt(10) - 5;
            // Velocidade inicial
            this.velocidadex = (rand.nextDouble() - 0.5) * 4;
            this.velocidadey = (rand.nextDouble() - 0.5) * 4 - 1;
            this.transparencia = 1.0;
            this.taxaDecaimento = 0.02 + rand.nextDouble() * 0.03;
            this.tamanho = 4 + rand.nextInt(6);


            //Cores
            int colorChoice = rand.nextInt(3);
            if (colorChoice == 0){
                this.color = new Color(255, 223,0);
            }else if(colorChoice == 1){
                this.color = new Color(255, 255, 255);
            }else{
                this.color = new Color(135,206,250);
            }
        }

        public void Atualizar(){
            //Puxa pra baixo
            velocidadey += 0.2; 

            //Movimento 
            vetorx += velocidadex;
            vetory += velocidadey;

            //reduz transparencia
            transparencia -= taxaDecaimento;
            if (transparencia < 0) transparencia = 0;           
        }
        public boolean Brilho(){
            return transparencia > 0;
        }

        public void Desenho(Graphics2D g2d){
	    //opacidade
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float) transparencia));
            g2d.setColor(color);

                //Faisca
            g2d.fillOval((int) vetorx, (int) vetory, tamanho, tamanho);
            if (tamanho > 6){
                g2d.setColor(new Color(255, 255, 255, (int)(alpha * 150)));
                g2d.fillOval((int) vetorx - 1, (int) vetory -1, tamanho + 2, tamanho + 2);
            }
        }     
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(() ->{
            new SparkleApp().setVisible(true);
        });
    }
}
