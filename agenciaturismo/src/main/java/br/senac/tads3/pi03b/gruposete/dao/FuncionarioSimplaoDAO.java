package br.senac.tads3.pi03b.gruposete.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import br.senac.tads3.pi03b.gruposete.models.FuncionarioSimplao;
import br.senac.tads3.pi03b.gruposete.utils.DbUtil;

/**
 *
 * @author danimo
 */
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
    
    
}
