import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame implements ActionListener {
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bMas, bMenos, bEntre, bPor, bIgual, bBorrar,
            botonCientifica, botonSin, botonCos,botonTan,botonCotag;
    Container container;
    JLabel mostrar;
    JTextField pantalla;
    boolean operando = false;
    JPanel panelAbajo, panelArriba, panelTop,panelCientifica;
    int op1, op2, tipoOperacion;

    public void initGUI() {
        instancias();
        configurarContainer();
        this.setBounds(50, 50, 400, 500);
        setLocationRelativeTo(null);
        acciones();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void configurarContainer() {
        container.setLayout(new BorderLayout());
        container.add(configArriba(), BorderLayout.CENTER);
        container.add(configTop(), BorderLayout.NORTH);
        container.add(configAbajo(), BorderLayout.SOUTH);
    }

    private JPanel configTop(){
        panelTop.setPreferredSize(new Dimension(50,50));
        panelTop.setLayout((new BorderLayout()));
        panelTop.add(botonCientifica);
        return panelTop;
    }

    private JPanel configArriba() {
        panelArriba.setPreferredSize(new Dimension(100, 150));
        panelArriba.setLayout(new BorderLayout());
        panelArriba.add(pantalla);
        return panelArriba;
    }

    private JPanel configAbajo() {
        panelAbajo.setPreferredSize(new Dimension(300, 300));
        panelAbajo.setLayout(new GridLayout(4, 4));
        panelAbajo.add(b7);
        panelAbajo.add(b8);
        panelAbajo.add(b9);
        panelAbajo.add(bEntre);
        panelAbajo.add(b4);
        panelAbajo.add(b5);
        panelAbajo.add(b6);
        panelAbajo.add(bPor);
        panelAbajo.add(b1);
        panelAbajo.add(b2);
        panelAbajo.add(b3);
        panelAbajo.add(bMenos);
        panelAbajo.add(bIgual);
        panelAbajo.add(b0);
        panelAbajo.add(bBorrar);
        panelAbajo.add(bMas);
        return panelAbajo;
    }

    private void acciones() {
        Component[] componentes = panelAbajo.getComponents();
        for (Component item : componentes) {
            ((JButton) item).addActionListener(this);
        }
        botonCientifica.addActionListener(this);
    }

    private void instancias() {
        b1 = new JButton("1");
        b1.setBackground(Color.GREEN);
        b1.setFont(new Font("Arial", Font.BOLD, 30));

        b2 = new JButton("2");
        b2.setBackground(Color.GREEN);
        b2.setFont(new Font("Arial", Font.BOLD, 30));

        b3 = new JButton("3");
        b3.setBackground(Color.GREEN);
        b3.setFont(new Font("Arial", Font.BOLD, 30));

        b4 = new JButton("4");
        b4.setBackground(Color.GREEN);
        b4.setFont(new Font("Arial", Font.BOLD, 30));

        b5 = new JButton("5");
        b5.setBackground(Color.GREEN);
        b5.setFont(new Font("Arial", Font.BOLD, 30));

        b6 = new JButton("6");
        b6.setBackground(Color.GREEN);
        b6.setFont(new Font("Arial", Font.BOLD, 30));

        b7 = new JButton("7");
        b7.setBackground(Color.GREEN);
        b7.setFont(new Font("Arial", Font.BOLD, 30));

        b8 = new JButton("8");
        b8.setBackground(Color.GREEN);
        b8.setFont(new Font("Arial", Font.BOLD, 30));

        b9 = new JButton("9");
        b9.setBackground(Color.GREEN);
        b9.setFont(new Font("Arial", Font.BOLD, 30));

        b0 = new JButton("0");
        b0.setBackground(Color.GREEN);
        b0.setFont(new Font("Arial", Font.BOLD, 30));

        bMas = new JButton("+");
        bMas.setBackground(Color.BLUE);
        bMas.setFont(new Font("Arial", Font.BOLD, 30));

        bMenos = new JButton("-");
        bMenos.setBackground(Color.BLUE);
        bMenos.setFont(new Font("Arial", Font.BOLD, 30));

        bEntre = new JButton("/");
        bEntre.setBackground(Color.BLUE);
        bEntre.setFont(new Font("Arial", Font.BOLD, 30));

        bPor = new JButton("*");
        bPor.setBackground(Color.BLUE);
        bPor.setFont(new Font("Arial", Font.BOLD, 30));

        bIgual = new JButton("=");
        bIgual.setBackground(Color.RED);
        bIgual.setFont(new Font("Arial", Font.BOLD, 30));

        bBorrar = new JButton("C");
        bBorrar.setBackground(Color.RED);
        bBorrar.setFont(new Font("Arial", Font.BOLD, 30));

        botonCientifica = new JButton("CIENTÍFICA");
        botonCientifica.setBackground(Color.LIGHT_GRAY);
        botonCientifica.setFont(new Font("Arial", Font.BOLD, 25));

        botonSin = new JButton("SIN");
        botonSin.setBackground(Color.LIGHT_GRAY);
        botonSin.setFont(new Font("Arial", Font.BOLD, 25));

        botonCos = new JButton("COS");
        botonCos.setBackground(Color.LIGHT_GRAY);
        botonCos.setFont(new Font("Arial", Font.BOLD, 25));

        botonTan = new JButton("TAG");
        botonTan.setBackground(Color.LIGHT_GRAY);
        botonTan.setFont(new Font("Arial", Font.BOLD, 25));

        botonCotag = new JButton("COTAG");
        botonCotag.setBackground(Color.LIGHT_GRAY);
        botonCotag.setFont(new Font("Arial", Font.BOLD, 25));

        panelAbajo = new JPanel();
        panelArriba = new JPanel();
        panelTop = new JPanel();
        panelCientifica = new JPanel();
        panelCientifica.add(new JLabel((Icon) mostrar));
        pantalla = new JTextField();
        container = this.getContentPane();
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonCientifica) {
            panelCientifica.setPreferredSize(new Dimension(100,100));
            panelCientifica.setLayout(new BorderLayout());
            panelCientifica.setLayout(new GridLayout(1,1));
            panelCientifica.add(botonCos);
            panelCientifica.add(botonTan);
            panelCientifica.add(botonSin);
            panelCientifica.add(botonCotag);
            if (panelCientifica.isShowing()) {
                container.remove(panelCientifica);
                pack();
            } else {
                container.add(panelCientifica, BorderLayout.EAST);
                pack();
            }
        }


        if (e.getSource() == b1) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "1");
            } else
                pantalla.setText("1");
            operando = false;

        } else if (e.getSource() == b2) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "2");
            } else
                pantalla.setText("2");
            operando = false;

        } else if (e.getSource() == b3) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "3");
            } else
                pantalla.setText("3");
            operando = false;

        } else if (e.getSource() == b4) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "4");
            } else
                pantalla.setText("4");
            operando = false;

        } else if (e.getSource() == b5) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "5");
            } else
                pantalla.setText("5");
            operando = false;

        } else if (e.getSource() == b6) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "6");
            } else
                pantalla.setText("6");
            operando = false;

        } else if (e.getSource() == b7) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "7");
            } else
                pantalla.setText("7");
            operando = false;

        } else if (e.getSource() == b8) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "8");
            } else
                pantalla.setText("8");
            operando = false;

        } else if (e.getSource() == b9) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "9");
            } else
                pantalla.setText("9");
            operando = false;

        } else if (e.getSource() == b0) {
            if (!operando) {
                pantalla.setText(pantalla.getText() + "0");
            } else
                pantalla.setText("0");
            operando = false;


        } else if (e.getSource() == bMas) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 1;

        } else if (e.getSource() == bMenos) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 2;

        } else if (e.getSource() == bPor) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 3;

        } else if (e.getSource() == bEntre) {
            operando = true;
            op1 = Integer.valueOf(pantalla.getText());
            tipoOperacion = 4;

        }else if(e.getSource()==bBorrar){
            pantalla.setText("");

        } else if (e.getSource() == bIgual) {
            op2 = Integer.valueOf(pantalla.getText());
            int resultado = 0;

            switch (tipoOperacion) {
                case 1:
                    resultado = op1 + op2;
                    break;
                case 2:
                    resultado = op1 - op2;
                    break;
                case 3:
                    resultado = op1 * op2;
                    break;
                case 4:
                    resultado = op1 / op2;
                    break;
            }
            pantalla.setText(Integer.toString(resultado));
        }
    }
}