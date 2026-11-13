import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class SparkleApp extends JFrame {
    private final ArrayList<Particula> particulas = new ArrayList<>();
    private final Random random = new Random();

    public SparkleApp() {
        setTitle("Sparkle - Efeito de Faísca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                synchronized (particulas) {
                    Iterator<Particula> iterator = particulas.iterator();
                    while (iterator.hasNext()) {
                        Particula ponto = iterator.next();
                        ponto.atualizar();
                        if (!ponto.brilho()) {
                            iterator.remove();
                        } else {
                            ponto.desenho(g2d);
                        }
                    }
                }
            }
        };

        canvas.setBackground(new Color(15, 15, 30));
        add(canvas);

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                spawnSparkles(e.getX(), e.getY(), 3);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                spawnSparkles(e.getX(), e.getY(), 5);
            }
        });

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                spawnSparkles(e.getX(), e.getY(), 15);
            }
        });

        Timer timer = new Timer(16, e -> canvas.repaint());
        timer.start();
    }

    private void spawnSparkles(int x, int y, int count) {
        synchronized (particulas) {
            for (int i = 0; i < count; i++) {
                particulas.add(new Particula(x, y, random));
            }
        }
    }
