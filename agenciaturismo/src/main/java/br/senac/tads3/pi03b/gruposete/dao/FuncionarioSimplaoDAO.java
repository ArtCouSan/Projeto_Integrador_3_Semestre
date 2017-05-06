package br.senac.tads3.pi03b.gruposete.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.senac.tads3.pi03b.gruposete.models.FuncionarioSimplao;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuncionarioSimplaoDAO {
    
    private static Connection con;
    private static PreparedStatement stmt;
   
    
    public void inserir(FuncionarioSimplao fun){
        
        System.out.println("ENTROU NO METODO INSERIR>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        
        String sql = "INSERT INTO func (nome, sobrenome, idade) VALUES (?, ?, ?)";
        
        try{
            System.out.println("VAI TENTAR CONECTAR>>>>>>>>>>>>>>>>>>>>>");
            con = DbUtil.getConnection();
            stmt = con.prepareStatement(sql);
            System.out.println("CONECTOU NO BD>>>>>>>>>>>>>>>>>>>");
            
            stmt.setString(1, fun.getNome());
            stmt.setString(2, fun.getSobrenome());
            stmt.setInt(3, fun.getIdade());
            stmt.executeUpdate();
            System.out.println("DEU CERTO>>>>>>>>>>>>>>>>>>>>>>EBA Ò_Ò");
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    public ArrayList<FuncionarioSimplao> listar(){
        
        ArrayList<FuncionarioSimplao> listaFunc = new ArrayList<>();
        
        String query = "SELECT * FROM func";
        
        try {
            
            con = DbUtil.getConnection();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            
            while(resultSet.next()){
            
                String nome = resultSet.getString("Nome");
                String sobrenome = resultSet.getString("Sobrenome");
                int idade = resultSet.getInt("Idade");
                
                FuncionarioSimplao funcionario = new FuncionarioSimplao(nome, sobrenome, idade);
                
                listaFunc.add(funcionario);
            }
            
        } catch (Exception e) {
            
            Logger.getLogger(FuncionarioSimplaoDAO.class.getName()).log(Level.SEVERE, null, e);
        
        }
        
        return listaFunc;
    
    }
    
    
}
