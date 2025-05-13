/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class CriaConexao2 {
    
    
    
     public  Statement       stm;
  public  ResultSet       rs;
  private  String      driver   =   "com.mysql.jdbc.Driver";
  private  String      caminho  =   "jdbc:mysql://localhost/biblioteca";
                        //"jdbc:mysql://" + serverName + "/" + mydatabase;
  private  String      usuario  =   "root";
  private  String        senha  =   "P9544504";
  public  Connection      con;
  

  
  
  public void conexao(){
  
      try {
          System.setProperty("jdbc.Drivers", driver);
          con = DriverManager.getConnection(caminho, usuario, senha);
        JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucessso");
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao se Conectar:\n" + ex.getMessage());
          
      }
  
  }
  
    public static void main(String[] args) {
        
         CriaConexao2         conex    =     new CriaConexao2();
        
        conex.conexao();
    }
  
  
  
  
  
  
  
   public void executaSql(String sql){
      try {
          stm = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,rs.CONCUR_READ_ONLY );
          rs = stm.executeQuery(sql);
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao executa sql:\n" +ex.getMessage());
      }
      
       
       }
       
       
       
      public void desconectar(){
           
      try {
          con.close();
          //JOptionPane.showMessageDialog(null, "Desconectado com Sucesso");
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Erro ao fechar onexão:\n"+ex.getMessage());
      }
       
       
       }


    
    
    
    
}
