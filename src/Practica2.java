import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.awt.BorderLayout.*;

public class Practica2  extends JFrame implements ActionListener, ChangeListener {
    CardLayout tarjetas;
    JPanel panelTarjetas;
    JPanel panelNorte, panelIzquierdo, panelinferior;
    JButton Siguiente, Atras, Aceptar1,Aceptar2,enviar,adjuntar_cve,finalizar,fin,ok,acabar,img;
    JLabel labelNorte, labelIzq, bienvenida, condiciones,datos_personales,nombre,email,contraseña,
            selecionPaises,resultadofinal,registroCompletado,terminado,instruc;
    private JPasswordField contraseña1;
    private JTextField email1,nombre1;
    BorderLayout miBorderLayout, No;
    FlowLayout flo;
    GridLayout g;
    JEditorPane intruciones = new JEditorPane();
    JEditorPane condicion = new JEditorPane();
    JEditorPane comprobador = new JEditorPane();
    JEditorPane resultadoFinal = new JEditorPane();
    private JScrollPane scrollpane1, scrollpane2,scrollpane3;
    private JCheckBox acepto, texto;

    private javax.swing.JComboBox<String> cmbCombo1;
    private javax.swing.JComboBox<String> cmbCombo2;
    private JProgressBar progress;
    JFrame frame = new JFrame();
    protected Color b, F1;




    int contadorTarjetas = 0;

    public  Practica2() {
        //Instancia un objeto BorderLayout con una separacion de 3px en horizonal y vertical
        miBorderLayout = new BorderLayout(0, 0);
        No = new BorderLayout();


        //Uso este BorderLayout para que sea el controlador de posicionamiento de mi objeto JFrame
        setLayout(miBorderLayout);


        //Inicializo el layout y el panel para las tarjetas
        tarjetas = new CardLayout();
        flo = new FlowLayout();
        g = new GridLayout();
        panelTarjetas = new JPanel();
        panelTarjetas.setLayout(tarjetas);



        //Inicializo 2 tarjetas, cada una es un JPanel con un color de fondo
        JPanel primeraTarjeta = new JPanel();
        JPanel segundaTarjeta = new JPanel();
        JPanel terceraTarjeta = new JPanel();
        JPanel cuartaTarjeta = new JPanel();
        JPanel quintaTarjeta = new JPanel();
        F1 = new Color(255, 255, 255, 255);//ColotrRgb
        primeraTarjeta.setBackground(F1);
        segundaTarjeta.setBackground(F1);
        terceraTarjeta.setBackground(F1);
        cuartaTarjeta.setBackground(F1);
        quintaTarjeta.setBackground(F1);

        ////////////////////////////////////////////////////////////////////////////////////////
        //LABEL TARJETAS///
        //--PRIMERA TARJETA--//
        bienvenida = new JLabel("Bienvenido ");
        bienvenida.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        bienvenida.setBounds(4300, 20, 300, 59);
        condiciones = new JLabel("Condiciones Lea Detenidamente: ");
        condiciones.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        condiciones.setBounds(100, 205, 300, 59);
        instruc =new JLabel("Instrucciones:  ");
        instruc.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        instruc.setBounds(100, 8, 300, 59);
        //__Condiciones --> Iniciar:://
        condicion = new JEditorPane();
        condicion.setOpaque(true);
        condicion.setBounds(100, 125, 800, 200);
        condicion.setText(" Documento revisado el 23/01/2020\n" +
                "Datos identificativos del responsable de la web\n" +
                "\n" +
                "En cumplimiento de la Ley 34/2002, de 11 de julio, de servicios de la sociedad de la información y de comercio electrónico, se informa:\n" +
                "\n" +
                "Denominación social: Videojuegos al poder\n" +
                "Actividad social: Educacion\n" +
                "Email: hola@videojuegosalpoder.com\n" +
                "Servicios ofertados en esta web\n" +
                "\n" +
                "Videojuegos al poder proporciona soporte y mantenimiento WordPress a través de una suscripción de pago. Se ofrecen intervenciones ilimitadas siempre que no duren más de 30 minutos de trabajo.\n" +
                "\n" +
                "Los tiempos de respuesta no están garantizados, pero normalmente serán el mismo día en el cual se abre el ticket y todas las consultas suelen ser resueltas en 24h. De todas formas esto se puede retrasar si necesitamos requerir información adicional al cliente.\n" +
                "\n" +
                "Videojuegos al poder pone a su disposición los siguientes servicios:\n" +
                "\n" +
                "Formación en desarrollo de videojuegos.\n" +
                "Como condición para utilizar nuestros servicios usted está obligado a registrarse en videojuegosalpoder.com, a seleccionar un usuario, contraseña e información de registro. La información que proporcione ha de ser precisa, completa y estar actualizada en todo momento. No está permitido utilizar los datos de otra persona u entidad sin la autorización apropiada.\n" +
                "\n" +
                "No revele la información de su cuenta a nadie más, usted es el único responsable de mantener la confidencialidad y seguridad de su cuenta y se compromete a notificar al sitio web de cualquier intrusión de seguridad.\n" +
                "\n" +
                "Modalidad del soporte y uso razonable\n" +
                "\n" +
                "El soporte deberá ser solicitado únicamente a través del sistema de tickets o por teléfono en caso de tener contratado el plan empresa. Cada intervención está sujeta a un máximo de 30 minutos de desarrollo.\n" +
                "\n" +
                "El tiempo necesitado para realizar la intervención está determinado únicamente por nosotros. Videojuegos al poder puede proporcionar soluciones alternativas al cliente incluyendo la derivación a algunos de nuestros socios.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Limitación y exclusión de responsabilidad\n" +
                "\n" +
                "Videojuegos al poder no responderá de ninguna consecuencia, daño o perjuicio que pudieran derivarse del uso indebido de los productos o servicios suministrados.\n" +
                "\n" +
                "Videojuegos al poder sólo será responsable de suministrar el servicio contratado en los términos y condiciones expresados en la presente política de contratación.\n" +
                "\n" +
                "Precios y formas de pago\n" +
                "\n" +
                "El Cliente se compromete al pago anticipado de los servicios contratados a Videojuegos al poder en las formas de pago aceptadas por el mismo.\n" +
                "\n" +
                "El servicio será suministrado una vez que se confirme el pago.\n" +
                "\n" +
                "Precios\n" +
                "\n" +
                "Los precios que se aplican serán los indicados en la página web de cada producto y/o servicio cuando se realiza el pedido o el encargo, aplicándoles, en su caso, el IVA que corresponda según el país del Cliente.\n" +
                "\n" +
                "Los precios de los servicios y productos pueden cambiar en cualquier momento a discreción única y exclusivamente de Videojuegos al poder. No brindará ninguna protección de precios fijos o de reembolsos.\n" +
                "\n" +
                "Forma de pago\n" +
                "\n" +
                "El pago se realizará a través del siguiente medio:\n" +
                "\n" +
                "Tarjeta de crédito\n" +
                "Transferencia bancaria\n" +
                "Paypal\n" +
                "Stripe\n" +
                "Aplázame\n" +
                "Compramastarde\n" +
                "Causas de disolución del contrato\n" +
                "\n" +
                "Videojuegos al poder no establece ninguna permanencia mínima en el servicio contratado, por lo que puede darse de baja en cualquier momento.\n" +
                "\n" +
                "Igualmente Videojuegos al poder puede cancelar cualquier cuenta sin previo aviso si no se cumplen los términos y condiciones indicados.\n" +
                "\n" +
                "Propiedad intelectual e Industrial\n" +
                "\n" +
                "Videojuegos al poder por sí o como cesionario, es titular de todos los derechos de propiedad intelectual e industrial de su página web, así como de los elementos contenidos en la misma.\n" +
                "\n" +
                "Cualquier uso no autorizado previamente por Videojuegos al poder será considerado un incumplimiento grave de los derechos de propiedad intelectual o industrial del autor.\n" +
                "\n" +
                "Está prohibido modificar, transmitir, distribuir, reutilizar, reenviar o usar la totalidad o parte del contenido de la página web para propósitos públicos o comerciales sin la autorización de Videojuegos al poder.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Tratamiento de datos personales\n" +
                "\n" +
                "De acuerdo con la Ley Orgánica 15/1999, de 13 de diciembre, de Protección de Datos de Carácter Personal, Videojuegos al poder informa al Cliente de la existencia de un fichero identificado como “Clientes y Proveedores” donde quedarán incorporados los datos que sean precisos para poder ofrecer el servicio que ha contratado.\n" +
                "\n" +
                "Es responsabilidad del Cliente la veracidad de los datos facilitados.\n" +
                "\n" +
                "Salvo oposición expresa, el Cliente consiente expresamente el tratamiento de sus datos personales para remitir información de interés, novedades y ofertas sobre los productos y servicios a través de cualquier medio, incluyendo el correo electrónico.\n" +
                "\n" +
                "Puede darse de baja de las comunicaciones publicitarias enviando un email a soporte@videojuegosalpoder.com.\n" +
                "\n" +
                "Podrá ejercitar sus derechos de acceso, rectificación, cancelación y oposición a través del correo electrónico soporte@videojuegosalpoder.com junto con prueba válida en derecho, como fotocopia de DNI o equivalente, indicando en el asunto “Protección de Datos”.\n" +
                "\n" +
                "Estos términos están sujetos a la política de privacidad de Videojuegos al poder.\n" +
                "\n" +
                "Normativa europea del consumo\n" +
                "\n" +
                "La Comisión Europea ha creado la primera plataforma europea para la resolución de conflictos en el comercio electrónico amparada en la última ley del consumidor. Videojuegos al poder, como responsable de esta plataforma de venta online, tiene el deber de informar a sus Clientes sobre la existencia de una plataforma online de resolución alternativa de conflictos.\n" +
                "\n" +
                "Puede acceder a la misma utilizando el siguiente enlace: https://ec.europa.eu/consumers/odr/main/index.cfm?event=main.home.chooseLanguage\n" +
                "\n" +
                " \n" +
                "\n" +
                "Legislación aplicable y jurisdicción\n" +
                "\n" +
                "La relación entre Videojuegos al poder y el Cliente se regirá por la normativa española vigente y cualquier controversia se someterá a los Juzgados y Tribunales de Granada, salvo que la Ley aplicable disponga otra cosa.");
        condicion.setEditable(false);
        //--Instruciones de Uso --//
        //__Condiciones --> Iniciar:://
        intruciones = new JEditorPane();
        intruciones.setOpaque(true);
        intruciones.setBounds(100, 50, 800, 150);
        //intruciones.setEditable(false);
        intruciones.setText("Instrucciones de Creacion Fichero:"+"\n"+

        "1-Lea detenidamente y No dejar  ningun campo sin rellenar."+"\n"+
                        "2- Aceptar condiciones y que ha leido instrucciones."
                +"\n"+ "3- Rellene sus datos , y revise que se han introducido correctamente.");

        scrollpane3 = new JScrollPane(intruciones);
        scrollpane3.setBounds(100, 50, 800, 150);


        scrollpane2 = new JScrollPane(condicion);
        scrollpane2.setBounds(100, 250, 800, 150);
        // scrollpane2.setVisible(false);
        //--Check box Aceptar condiciones--//
        acepto = new JCheckBox(" Acepto Condiciones ");
        acepto.setBounds(785, 420, 200, 30);
        acepto.addChangeListener(this);
        //acepto.setVisible(true);
        //acepto.addChangeListener(this);
        Aceptar1 = new JButton("Aceptar");
        Aceptar1.setVisible(false);
        Aceptar1.setBounds(800, 450, 150, 50);
        Aceptar1.addActionListener(this);

        ////////////////////////////////////////////////////////////////////////////////////////
        //--PRIMERA TARJETA--//
        panelTarjetas.add(primeraTarjeta, "Bienvenida");
        primeraTarjeta.setLayout(null);
        primeraTarjeta.add(bienvenida);
        primeraTarjeta.add(condiciones);
        //primeraTarjeta.add(condicion);
        primeraTarjeta.add(scrollpane2);
        primeraTarjeta.add(acepto);
        primeraTarjeta.add(Aceptar1);
        primeraTarjeta.add(scrollpane3);
        primeraTarjeta.add(instruc);

        ////////////////////////////////////////////////////////////////////////////////////////
        //--Label 2 Tarjeta--//
        datos_personales = new JLabel("Registro :  ");
        datos_personales.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 60));
        datos_personales.setBounds(45, 20, 300, 80);
        nombre = new JLabel("Nombre :  ");
        nombre.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        nombre.setBounds(45, 100, 300, 59);
        email = new JLabel("Email :  ");
        email.setBounds(45, 150, 300, 59);
        email.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));
        contraseña = new JLabel("Contraseña:  ");
        contraseña.setBounds(45, 200, 300, 59);
        contraseña.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 20));

        //--Rellenables Datos--//
        nombre1 = new JTextField();
        nombre1.setBounds(190, 120, 250, 25);
        email1 = new JTextField();
        email1.setBounds(190, 170, 250, 25);
        contraseña1 = new JPasswordField();
        contraseña1.setBounds(190, 220, 250, 25);
        //--Boton 2 Tarjeta--//
        Aceptar2 = new JButton("Aceptar");
        //Aceptar2.setVisible(false);
        Aceptar2.setBounds(800, 400, 150, 50);
        Aceptar2.addActionListener(this);



        //--ADD SEGUNDA TARJETA--//
        panelTarjetas.add(segundaTarjeta, "Registro");
        //Layaut null (Borrar restricciones)
        segundaTarjeta.setLayout(null);
        segundaTarjeta.add(datos_personales);
        segundaTarjeta.add(nombre);
        segundaTarjeta.add(nombre1);
        segundaTarjeta.add(email);
        segundaTarjeta.add(email1);
        segundaTarjeta.add(contraseña);
        segundaTarjeta.add(contraseña1);
        segundaTarjeta.add(Aceptar2);
        segundaTarjeta.add(comprobador);

        ////////////////////////////////////////////////////////////////////////////////////////
        //--TERCERA TARJETA:--//
        //--Label 3 Tarjeta--//
        selecionPaises = new JLabel("SELECIONAR PAIS : ");
        selecionPaises.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 40));
        selecionPaises.setBounds(45, 20, 400, 150);

        //--ADD COMBOBOX --//
        cmbCombo1 = new JComboBox();
        cmbCombo1.setBounds(200, 180, 200, 25);
        cmbCombo1.addItem("Selecciona");
        cmbCombo1.addItem("EEUU");
        cmbCombo1.addItem("Spain");

        cmbCombo2 = new JComboBox();
        cmbCombo2.setBounds(200, 210, 200, 20);
        cmbCombo2.addItem("Selecionar");

        cmbCombo1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(cmbCombo1.getSelectedItem()=="Spain")
                {
                    cmbCombo2.removeAllItems();
                    cmbCombo2.addItem("Madrid");
                    cmbCombo2.addItem("Castolla la Mancha");
                    cmbCombo2.addItem("Castilla y Leon");
                    cmbCombo2.addItem("Andalucia");
                    cmbCombo2.addItem("C.Valenciana");
                    cmbCombo2.addItem("Cataluña");
                    cmbCombo2.addItem("Aragon");
                    cmbCombo2.addItem("Navarra");
                    cmbCombo2.addItem("Pais Vaso");
                    cmbCombo2.addItem("Asturias");
                    cmbCombo2.addItem("Cantabria");
                    cmbCombo2.addItem("Galicia");
                    cmbCombo2.addItem("Extremadura");
                    cmbCombo2.addItem("LAs Palmas");
                    cmbCombo2.addItem("Baleares");


                }
                else if (cmbCombo1.getSelectedItem()=="EEUU")
                {

                    cmbCombo2.removeAllItems();
                    cmbCombo2.addItem("Dakota");
                    cmbCombo2.addItem("Iowa");
                    cmbCombo2.addItem("Minnesota");
                    cmbCombo2.addItem("Montana");
                    cmbCombo2.addItem("Colorado");
                    cmbCombo2.addItem("Kansas");
                    cmbCombo2.addItem("Oclahoma");
                    cmbCombo2.addItem("Kentucky");
                    cmbCombo2.addItem("New Mexico");
                    cmbCombo2.addItem("Texas");
                    cmbCombo2.addItem("Arizona");
                    cmbCombo2.addItem("Loussiana");
                    cmbCombo2.addItem("Ohio");
                    cmbCombo2.addItem("Michigan");
                    cmbCombo2.addItem("Nebraska");
                }
            }
        });
        //--Boton 3 Tarjeta--//
        enviar = new JButton("Enviar");
        //Aceptar2.setVisible(false);
        enviar.setBounds(800, 400, 150, 50);
        enviar.addActionListener(this);

        //--ADD TERCERA TARJETA--//
        panelTarjetas.add(terceraTarjeta, "Selecionae Pais");
        terceraTarjeta.setLayout(null);
        terceraTarjeta.add(selecionPaises);
        terceraTarjeta.add(cmbCombo1);
        terceraTarjeta.add(cmbCombo2);
        terceraTarjeta.add(enviar);
        ////////////////////////////////////////////////////////////////////////////////////////
        //--CUARTA TARJETA:--//
        //--Label 4 Tarjeta--//
        resultadofinal = new JLabel("Resultado Final  :  ");
        resultadofinal.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 40));
        resultadofinal.setBounds(45, 20, 300, 150);
        initComprobadorFinal();
        //--CHECK BOX CONVERTIR TEXTO-//
        texto = new JCheckBox(" Convertir En Fichero Texto ");
        texto.setBounds(700, 380, 300, 20);
        texto.addChangeListener(this);
        //--BOTTON ADJUNTAR CV--//
        //--Boton--//
        adjuntar_cve = new JButton("Adjuntar Cv");
        adjuntar_cve.setBounds(700, 420, 150, 25);
        adjuntar_cve.addActionListener(this);
        adjuntar_cve.setVisible(false);
        //--BOTTON FINALIZAR--//
        //--Boton finalizar--//
        finalizar = new JButton("Finalizar");
        finalizar.setBounds(400, 450, 150, 25);
        finalizar.addActionListener(this);
        //adjuntar_cve.setVisible(false);

        //--ADD CUARTO TARJETA--//
        panelTarjetas.add(cuartaTarjeta, "Resultado");
        cuartaTarjeta.setLayout(null);
        cuartaTarjeta.add(resultadofinal);
        cuartaTarjeta.add(resultadoFinal);
        cuartaTarjeta.add(texto);
        cuartaTarjeta.add(adjuntar_cve);
        cuartaTarjeta.add(finalizar);
        //cuartaTarjeta.add(scrollpane1);
        ////////////////////////////////////////////////////////////////////////////////////////
        //--QUINTQ TARJETA:--//
        //--Label 5 Tarjeta--//
        registroCompletado = new JLabel("Final Registro : ");
        registroCompletado.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        registroCompletado.setBounds(50, 40, 300, 59);
        //--Barra JProgrres--//
        progress = new JProgressBar(0,100);//Lennar barra de 0 a 100;
        //progress.setValue(0);
        progress.setMaximum(100);
        progress.setStringPainted(true);
        progress.setBorderPainted(true);
        progress.setVisible(true);
        progress.setForeground(Color.green);
        progress.setBackground(Color.blue);
        progress.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        progress.setBounds(100, 100, 800, 100);

        //init_LlenarBarra();
        //--Boton Final--//
        fin = new JButton("Ok");
        fin.setBounds(400, 350, 150, 25);
        fin.addActionListener(this);



            //--ADD QUINTA TARJETA--//
        panelTarjetas.add(quintaTarjeta, "Final");
        quintaTarjeta.setLayout(null);//Resetear Layaout
        quintaTarjeta.add(registroCompletado);
        quintaTarjeta.add(progress);
        quintaTarjeta.add(fin);


        //Muestro la primera
        tarjetas.show(panelTarjetas, "Bienvenida");

        //Añado el panel de tarjetas a la parte central del border layout
        add(panelTarjetas, BorderLayout.CENTER);


        ///////////////////////////////imagen (NO ME FUNCIONA)/////////////////////
        ImageIcon image = new ImageIcon("/Users/roxhi/Desktop/butterfly.jpg");


        ////////////////////////////////////////////////////////////////////////////////////////
        //-- PANEL NORTE  "TITULO"--//
        panelNorte = new JPanel();
        labelNorte = new JLabel(" Crear Fichero de Texto");
        labelNorte.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 30));
        //labelNorte.setBounds(600,100,100,100);
        img = new JButton();
        img.setPreferredSize(new Dimension(400, 110));
        img.setBorderPainted(false);
        img.add(labelNorte);
        // labelNorte.setBounds(panelNorte,NORTH);
        b= new Color(42, 58, 236, 255);//ColotrRgb
        panelNorte.setBackground(b);
       // panelNorte.add(labelNorte);
        //Añadir el panel al norte del la ventana:
        add(panelNorte, NORTH);
        panelNorte.add(img);


        //-- PANEL IZQ  "LOGO"--//
        panelIzquierdo = new JPanel();
        panelIzquierdo.setBackground(Color.blue);
        labelIzq = new JLabel(new ImageIcon("/Users/roxhi/Desktop/butterfly.jpg"));
        // labelIzq.getGraphics().drawImage(paint(labelIzq.getGraphics()),300,500,550,770,Color.red,null);
        panelIzquierdo.add(labelIzq);
        //Añadir el panel al norte del la ventana:
        add(panelIzquierdo, WEST);

        //-- PANEL INFERIOR  "BOTONES"--//
        panelinferior = new JPanel();
        b= new Color(235, 236, 252, 255);//ColotrRgb
        panelinferior.setBackground( b);
        //panelinferior.setLayout(null);
        Siguiente = new JButton();
        Siguiente.setText("Siguiente");
        //Siguiente.setVisible(false);
        Siguiente.setEnabled(false);
        Siguiente.setPreferredSize(new Dimension(100, 100));
        Siguiente.addActionListener(this);
        //--Boton Atras--//
        Atras = new JButton();
        Atras.setText("Atras");
        Atras.setPreferredSize(new Dimension(100, 100));//Dimensiones
        Atras.setVisible(false);//False Visvibiladad
        Atras.addActionListener(this);
        //--Boton Terminar y salir app--//
        acabar = new JButton();
        acabar.setText("Terminar");
        acabar.setPreferredSize(new Dimension(100, 100));
        acabar.setVisible(false);
        acabar.addActionListener(this);
        //--ADD al panel sur los accesorios(JButton)--//
        panelinferior.add(Atras);
        panelinferior.add(Siguiente);
        panelinferior.add(acabar);
        //Añadir el panel al norte del la ventana:
        add(panelinferior, SOUTH);


        //CPNFIGURAR Y MOSTRAR EK JFRAME
        initPantalla();


    }
    private void init_LlenarBarra(){
        // function to increase the progressBar

        Thread t = new Thread(new Runnable() {
            public void run() {
                int i = 1;
                progress.setMinimum(0);
                progress.setMaximum(100);
                try {
                    while (i <= 100 || true) {
                        progress.setValue(i);
                        i++;
                        Thread.sleep(38);

                    }
                } catch (InterruptedException ex){}

            }});
        t.start();}

         /**   int i=0;
            while(i <= 1000)
            {
                // fills the bar
                progress.setValue(i);
                i = i + 10;
                try
                {
                    // delay the thread
                    Thread.sleep(120);
                }
                catch(Exception e){}
            }
        }

       /** int numeroAletorio = 0;
        int porcentaje = 0;
        int total = 0;

        while(porcentaje < 100) {

        }
            //for (int i = 0;i <120 ;i= i=i+res){
            numeroAletorio = (int) Math.random();

            System.out.println("Caballo " + nombre +" ha aumentado "+ numeroAletorio);
            porcentaje += numeroAletorio;
            total = total + numeroAletorio;
            System.out.println(total);
            progress.setValue(porcentaje);*/





   /** public  void runTestPaises() {
        String filePath = "/Users/roxhi/Acceso a Datos/Fichero_Paises.txt";
        FileReader leerArchivo;
        BufferedReader textoArchivo;
        ArrayList contentPaises;
        try {
            leerArchivo  = new FileReader(new File(filePath));
            textoArchivo = new BufferedReader(leerArchivo);

            contentPaises = getContentPaises(textoArchivo);
            try {
                textoArchivo.close();
                leerArchivo.close();
            } catch (IOException ex) {
                System.err.println("Error -> " + ex);
            }

            // Show the results
            if (contentPaises != null) {
                showResults(contentPaises);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error -> " + ex);
        }
    }
    ArrayList getContentPaises(BufferedReader bufReader) {

        String lineContent = "";
        int lineNumber     = 0;
        while (lineContent != null) {

            try {
                lineContent = bufReader.readLine();
            } catch (IOException ex) {
                System.err.println(
                        "Error reading line: " + lineNumber + " -> " + ex);
            }
            if (lineContent != null && ! lineContent.equals("")) {
                System.out.println("Line readed: " + lineContent);

                String[] lineElements = lineContent.split(",");
                contentPaises.add(String.valueOf(lineElements));
            }

            lineNumber++;
        }

        System.out.println(contentPaises);
        return contentPaises;
    }
    public  void runTestProvincias() {
        String filePath = "/Users/roxhi/Acceso a Datos/Fichero_Provincias.txt";
        FileReader leerArchivo;
        BufferedReader textoArchivo;
        ArrayList contentProvincias;
        try {
            leerArchivo  = new FileReader(new File(filePath));
            textoArchivo = new BufferedReader(leerArchivo);

             contentProvincias= getContentProvincias(textoArchivo);
            try {
                textoArchivo.close();
                leerArchivo.close();
            } catch (IOException ex) {
                System.err.println("Error -> " + ex);
            }

            // Show the results
            if (contentProvincias != null) {
                showResultsP(contentProvincias);
            }

        } catch (FileNotFoundException ex) {
            System.err.println("Error -> " + ex);
        }
    }
    ArrayList getContentProvincias(BufferedReader bufReader) {
        contentProvincias = new ArrayList();
        String lineContents = "";
        int lineNumber     = 0;
        while (lineContents != null) {

            try {
                lineContents = bufReader.readLine();
            } catch (IOException ex) {
                System.err.println(
                        "Error reading line: " + lineNumber + " -> " + ex);
            }
            if (lineContents != null && ! lineContents.equals("")) {
                System.out.println("Line readed: " + lineContents);

                String[] lineElements = lineContents.split(",");
                contentProvincias.add(String.valueOf(lineElements));
            }

            lineNumber++;
        }

        System.out.println(contentProvincias);
        return contentProvincias;
    }
    private static void showResultsP(ArrayList contentProvincias) {
        System.out.println("Readed contents  PROVINCIAS.................................");

        for(int i = 0; i < contentProvincias.size(); i++) {
           String[] lineElements = (String[]) contentProvincias.get(i);
            for (String lineElement : lineElements) {
                System.out.print(lineElement + " ");
            }
            System.out.println(contentProvincias+" ");
        }




    private static void showResults(ArrayList contentPaises) {
        System.out.println("Readed contents PAISES.................................");

        for(int i = 0; i < contentPaises.size(); i++) {
            String[] lineElements = (String[]) contentPaises.get(i);
            for (String lineElement : lineElements) {
                System.out.print(lineElement + " ");

            System.out.println(contentPaises+ " ");
        }
    }*/
   public void ventana2() {

      frame = new JFrame();
       //--JLabel Mostrat Mensaje Todo Correcto--//
       terminado = new JLabel("Fichero Escrito Correctamente ");
       terminado.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 12));
       terminado.setBounds(80, 20, 200, 59);

       //--ADD Jlabel al Frame--//
       frame.add(terminado);
      //--Boton Ok--//
       ok = new JButton("Ok");
       ok.setBounds(800, 400, 150, 90);
       ok.setBorderPainted(true);
       ok.setBackground(Color.gray);
       ok.addActionListener(this);
       //--ADD Boton al Frame--//
       frame.add(ok);
       frame.setTitle("Ventana desde JFrame");
       frame.setSize(340, 240);
       frame.setLocation(200,200);
       frame.setResizable(false);
       frame.setVisible(true);

   }


   // --VALIDAR NOMBRE--//
    private void init_Comprobar() {
        //-- SI NO ESTA RELLENO EL NOMBRE:--//
        // System.out.println("aoy"+nombre1.getText());
        if (nombre1.getText().equals("")) {
            // nombre.setForeground(new Color(215, 18, 48));
            nombre1.setBorder(new LineBorder(Color.red));
            nombre1.setText("Nombre Vacio");

        //-- SI EST RELLENO EL NOMBRE:--//
        } else {
            nombre1.getText();

        }
    }
    // --VALIDAR LA EMAIL--//
    public void init_ComprobarM() {
            // Patrón para validar el email
            Pattern pattern = Pattern
                    .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

            // El email a validar
           //String email = "correo@prueba.com";
         Matcher mather = pattern.matcher(email1.getText());

            if (mather.find() == true) {
               email1.getText();
            //-- EMAIL NO CORRECTO--//
            } else {
                email1.setBorder(new LineBorder(Color.red));
                email1.setText(" Email Incorrecto");
            }
        }
    // --VALIDAR LA CONTRASEÑA--//
    public  void init_ComprobarContraseña() {

     //Comprobar contraseña so es correcta:

       String PASSWORD_REGEX =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$";

        Pattern PASSWORD_PATTERN =
                Pattern.compile(PASSWORD_REGEX);


            //--SI  ES CORRECTA LA CONTRASEÑA:--/
            if (PASSWORD_PATTERN.matcher(contraseña1.getText()).matches()) {
               contraseña1.setText(" Es valida");
                //Comprobacion que pasa por aqui
                System.out.print(" La Password " + contraseña1 + " is valid");
            }
            //--SI NO ES CORRECTA LA CONTRASEÑA:--/
            else {
                contraseña1.setText(" The Password "+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" +
                        "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" +
                        "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+
                        "\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" +
                       " Requiere: Entre 8 y 16 caracteres , "+ "\n"+ "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+
                        "\n" + "\n" +"\n" + "\n"+ " 1 Digito Numerico (MINIMO),"
                        +"\n"+ "\n"+ "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+
                        "\n" + "\n" +"\n" + "\n"+  "\n"+"\n" + "\n"+"\n" + "\n"+" 1 Mayuscula(Minimo)," +
                        "\n"+ "\n"+ "\n"+ "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+
                        "\n" + "\n" +"\n" + "\n"+  "\n"+"\n" + "\n"+"\n" + "\n"+ "\n" + "\n" +"\n" + "\n"+  "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n"+ "\n"+ "\n"+ "\n"+" 1Minuscula(Minimo),"+
                        "\n"+ "\n"+ "\n"+ "\n"+ "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" +
                        "\n"+"\n" + "\n"+"\n" + "\n" +"\n" + "\n"+"\n" + "\n"+"\n" +"\n" + "\n"+"\n" + "\n"+"\n" + "\n"+
                        "\n" + "\n" +"\n" + "\n"+  "\n"+"\n" + "\n"+"\n" + "\n"+ "\n" + "\n" +"\n" + "\n"+  "\n"+"\n"
                        + "\n"+ "\n"+ "\n"+"\n" + "\n"+"\n"   +" Caracter Especia[!@#$%&]l(Minimo)");
                //INCORRECTO:
                contraseña1.setBorder(new LineBorder(Color.red));
               //Comprobacion que pasa por aqui
                System.out.print(" The Password " + contraseña1 + " Requiere: Entre 8 y 16 caracteres , "+ "\n"+"1 Digito Numerico (MINIMO)"
                +"\n"+ " 1 Mayuscula(Minimo)" +"\n"+ " 1Minuscula(Minimo)"+"\n"+ " Caracter Especia[!@#$%&]l(Minimo)");
            }
        }

        public void paint(Graphics g) {
        super.paint(g);
        //Para poder modificar más propiedades con Graphics 2d
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(400, 500, Color.white, 80, 20, Color.blue);
        g2d.setPaint(gp);
        g2d.fillRect(0, 145, 105, 545);
        //g.drawImage(imagen, 0, 0, this);
            Toolkit t = Toolkit.getDefaultToolkit();
            Image imagen = t.getImage ("//Users/roxhi/Desktop/sonicTTT.jpg");
            Image imagen1 = t.getImage ("//Users/roxhi/Desktop/sonicT.jpg");

            g2d.drawImage(imagen, 5, 160, this);
            g2d.drawImage(imagen1, 1005, 30, this);
        //labelIzq.setBackground(gp);
    }
    public void initComprobadorErrores(){

        comprobador.setBounds(500, 70, 100, 150);//Posición y dimensiones
        comprobador.setOpaque(true);////Para poder darle un color de fondo
        comprobador.setBorder(new LineBorder(Color.BLUE));
        comprobador.setSize(400, 300);
        comprobador.setEditable(false);// Solo se puede leer
        comprobador.setVisible(true);
        //comprobador.setBackground(Color.black);
       // comprobador.;

    }
    public void initComprobadorFinal(){
        resultadoFinal.setBounds(90, 120, 700, 200);//Posición y dimensiones
        resultadoFinal.setOpaque(true);////Para poder darle un color de fondo
        resultadoFinal.setBorder(new LineBorder(Color.BLUE));
        resultadoFinal.setSize(700, 200);
        resultadoFinal.setEditable(false);// Solo se puede leer
        //resultadoFinal.setVisible(false);

    }

    private void initPantalla() {

        setTitle("Practica_2"); //Título del JFrame
        setSize(1100, 800); //Dimensiones del JFrame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Cerrar proceso al cerrar ventana
        setVisible(true); //Mostrar JFrame


    }

    public static void main(String[] args) {


        new Practica2();
    }

    @Override
    public void stateChanged(ChangeEvent e) {

        //Chek bpx activado para aceptar condiciones
        if (acepto.isSelected()) {
            System.out.println(" Hola paso por el check");
            Aceptar1.setVisible(true);
        }
        if (texto.isSelected()) {
            System.out.println(" Hola paso por el check");
            adjuntar_cve.setVisible(true);
        }


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Aceptar1) {
            Siguiente.setEnabled(true);
            resultadoFinal.setText("\n"+" Resulatdo de Todo lo Selecionado: " +"\n"+" -Has Aceptado las condiciones");
        }

         if (e.getSource() == Siguiente){
             contadorTarjetas++;
             System.out.println(contadorTarjetas);


            if (contadorTarjetas >=1) {
                tarjetas.next(panelTarjetas);
                Atras.setVisible(true);
            }
            if (contadorTarjetas ==4){
                Atras.setVisible(false);
                Siguiente.setVisible(false);
                acabar.setVisible(true);
            }
            // Siguiente.setEnabled(false);
            // }
            //if (contadorTarjetas == 4) {
               // Siguiente.setVisible(false);
            }

        if (e.getSource() == Atras) {
            contadorTarjetas--;
            tarjetas.previous(panelTarjetas);
            System.out.println(contadorTarjetas);
            if (contadorTarjetas == 1) {
                Atras.setVisible(true);

            }
            // contadorTarjetas--;

            }
        if (e.getSource() == acabar) {
            dispose();
        }
        if (e.getSource()==Aceptar2) {
            comprobador.setVisible(true);
            initComprobadorErrores();
            init_Comprobar();
            init_ComprobarM();//Comprobar mail
            init_ComprobarContraseña();//Conprobar contraseña

            comprobador.setText("\n" + "\n" +" Datos Introducidos: " + "\n" + "\n" + " Nombre : "
            + nombre1.getText()+"\n"  + "\n" +" Email: "+ email1.getText()+ "\n"+ "\n" + "Contraseña: "+ contraseña1.getText());


        }
        if (e.getSource()==enviar) {

           /** initComprobadorErrores();
            init_Comprobar();
            init_ComprobarM();//Comprobar mail
            init_ComprobarContraseña();//Conprobar contraseña*/

            resultadoFinal.setText("\n"+" Resulatdo de Todo lo Selecionado: " +"\n"+"\n"+" -Has Aceptado las condiciones"+ "\n" + " -Nombre : "
                    + nombre1.getText() + "\n" +" -Email: "+ email1.getText()+ "\n" + " -Contraseña: "+ contraseña1.getText() + "\n"+"-Has Selecionado: " +cmbCombo1.getSelectedItem().toString()
                    + "\n"+"-Has Selecionado: "+ cmbCombo2.getSelectedItem().toString());


        }
        if (e.getSource() == adjuntar_cve) {
            //Activar la visibilidad del boton
            finalizar.setVisible(true);
            //VENTANA PARA GUARDAR EL ARCHVO DE TEXTO
            JFileChooser seleccion = new JFileChooser(); // Se crea la instancia para colocar parametros de interes
            seleccion.setDialogTitle("GUARDAR");    // Titulo de la ventana emergente
            seleccion.setDialogType(JFileChooser.SAVE_DIALOG); // El tipo de JFileChooser que vamos a usar
            seleccion.setFont(new java.awt.Font("Lucida Handwriting", 0, 18)); // (opcional) Cambiando el tipo de letra
            //seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); //(opcional) Estableciendo que solo me muestre los directorios.

            String res = "";
            int respuesta = seleccion.showSaveDialog(this); // Se apertura la ventana.
            switch (respuesta) { // segun la opcion del usuario se ejecutan los algoritmos de interes
                case JFileChooser.APPROVE_OPTION:
                    seleccion.getSelectedFile();
                    System.out.println("Guardar");
                    break;
                case JFileChooser.CANCEL_OPTION:
                    System.out.println("Cancelado");
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            //CREAR EL ARCHIVO DE LOS RESULTADOS
            res = seleccion.getSelectedFile().toString();
            File fichesal = new File(String.valueOf(res));//declarar fichero
            FileWriter ficsal = null; //crear el flujo de salida
            try {
                ficsal = ficsal = new FileWriter(fichesal);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            String cadena = resultadoFinal.getText().toString();
            System.out.println(cadena);
            char[] cad = cadena.toCharArray();
            for (int i = 0; i < cad.length; i++) {

                try {
                    ficsal.write(cad[i]);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ficsal.append('*');
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try {
                    ficsal.write(cad);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("Fichero escrito");
            }
        }


        if (e.getSource()==fin) {
            //Reaparecer la barra JProgress
            progress.setVisible(true);
           //Llenar Barra Progrees
            init_LlenarBarra();

            //Mensaje de Fichero Escrtio correctamente:
            ventana2();

        }
        if(e.getSource()==ok){
            //Cerrar Ventana
            frame.dispose();


        }

    }
        }





