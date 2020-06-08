import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutionException;

class Main implements Constraints{

    Window w = new Window();
    GridBagConstraints grid = new GridBagConstraints();
    JFrame window = new JFrame("Brah...");

    public static void main(String[] args) throws ExecutionException {

        GeneticManager ga = new GeneticManager();
        ga.startGA();
        Floor champ = ga.getChampian();

        Main rc = new Main(champ.floor);
        while (ga.genNum < numGenerations) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ga.nextGeneration();
            champ = ga.getChampian();
            rc.paint(champ.floor);
        }
    }

    public Main(char[][] boi) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }

                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                w.paintItt(boi);
                window.add(w);
                window.pack();
                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }

    public void paint(char[][] c){
        w.paintItt(c);
    }

    public class Window extends JPanel {

        GridBagConstraints grid;

        public Window() {
            setLayout(new GridBagLayout());
            grid = new GridBagConstraints();
            grid.gridy = 0;
            for(int i = 0; i < 6; i++){
                grid.gridx = 0;
                for(int j = 0; j < 6; j++){
                    JPanel cell = new JPanel() {
                        @Override
                        public Dimension getPreferredSize() {
                            return new Dimension(50, 50);
                        }

                    };
                    add(cell, grid);
                    grid.gridx++;
                }
                grid.gridy++;
            }
    }

    public void paintItt(char[][] boi){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                this.getComponent(i+(j*6)).setBackground(getColor(boi[i][j]));

            }

        }
    }
    }


    private Color getColor(char c){
        switch (c){
            case 'r':
                return Color.RED;
            case 'b':
                return Color.BLUE;
            case 'g':
                return Color.GREEN;
            case 'v':
                return Color.BLACK;
            case 'p':
                return Color.PINK;
            case 'y':
                return Color.YELLOW;
            case 'o':
                return Color.ORANGE;

        }
        return Color.LIGHT_GRAY;
    }

}