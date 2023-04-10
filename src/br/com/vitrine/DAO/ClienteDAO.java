
package br.com.vitrine.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/**
 *
 * @author Gessione
 */
public class ClienteDAO {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;
   
//       public void CadastrarCliente(Cliente objclientedto){
//   
//        String sql = "insert into tbclientes(nome,cpf,rg,telefone,email,sexo,cep,rua,numero,cidade,referencia,bairro,uf,data_nascimento,cnpj,apelido,observacao,rede_social)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        conexao = ModuloConexao.conectar();
//        try { 
//        pst = conexao.prepareStatement(sql);
//        pst.setString(1, objclientedto.getNome());
//        pst.setString(2, objclientedto.getCpf());
//        pst.setString(3, objclientedto.getRg());
//        pst.setString(4, objclientedto.getTelefone());
//        pst.setString(5, objclientedto.getEmail());
//        pst.setString(6, objclientedto.getSexo());
//        pst.setString(7, objclientedto.getCep());
//        pst.setString(8, objclientedto.getRua());
//        pst.setString(9, objclientedto.getNumero());
//        pst.setString(10, objclientedto.getCidade());
//        pst.setString(11, objclientedto.getReferencia());
//        pst.setString(12, objclientedto.getBairro());
//        pst.setString(13, objclientedto.getUf());
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        pst.setDate(14, (Date) objclientedto.getData_nascimento());
//        pst.setString(15, objclientedto.getCnpj());
//        pst.setString(16, objclientedto.getApelido());
//        pst.setString(17, objclientedto.getObservacao());
//        pst.setString(18, objclientedto.getRede_social());
//        
//        pst.execute();
//        pst.close();
//
//       } catch (SQLException erro) {
//            JOptionPane.showMessageDialog(null,"Cliente" + erro);
//       }
//       
//       
//       
//    }

    public void getClientes(String colunaOrderBy) {
     
       
    
    }

}












