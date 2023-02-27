import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class union {
    private JComboBox comboBox1;
    public JPanel panel11;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JButton guardarButton;

    private PreparedStatement ps;

    public union() {
        Connection con;
        try {
            con = getConection();
            String queryC = "select * from  Dias;";
            Statement s = con.createStatement();
            ResultSet cs = s.executeQuery(queryC);
            /*recuperacion.addItem("dias");
            recuperacion.additem("meses");
            recuperacion.additem("anios");

            recuperacion.addItem("DD");
            recuperacion.additem("MM");
            recuperacion.additem("AA");*/


        } catch (HeadlessException | SQLException f) {
            System.err.println(f);
        }
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try {
                    con = getConection();
                    ps = con.prepareStatement("INSERT INTO dias(Dias,meses,anios) VALUES(?,?,?)");
                    ps.setString(1,comboBox1.getSelectedItem().toString());
                    ps.setString(2,comboBox2.getSelectedItem().toString());
                    ps.setString(3,comboBox3.getSelectedItem().toString());
                    System.out.println(ps);
                    if 


                } catch (HeadlessException | SQLException f) {
                    System.err.println(f);
                    JOptionPane.showMessageDialog(null,"Guardado correctamente");
                }
            }
        });

    }
    public static Connection getConection(){
        Connection con = null;
        String base = "recuperacion";
        String url = "jdbc:mysql://localhost/" + base;
        String user = "root";
        String password = "Hiphop1511@";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException | SQLException es){
            System.err.println(es);
        }
        return con;

    }

   public static void main(String[] args) {
        JFrame frame = new JFrame("correccion");
        frame.setContentPane(new union().panel11);
        frame.setSize(100,100);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
