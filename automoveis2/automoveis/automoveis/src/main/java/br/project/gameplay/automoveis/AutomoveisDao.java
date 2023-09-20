package br.project.gameplay.automoveis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AutomoveisDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //Dao pra obter
    public Automoveis obter(int id) throws Exception {
        String sqlSelect = "select CLIENTE, MODELO, PLACA from AUTOMOVEIS where id = ?";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next()) {
                    Automoveis a = new Automoveis();
                    a.setCliente(rs.getString("cliente"));
                    a.setModelo(rs.getString("modelo"));
                    a.setPlaca(rs.getString("placa"));
                    return a;
                }
            }
            throw new Exception("Id não encontrado na tabela");
        }
    }

    //Dao pra listar
    public List<Automoveis> listar() throws Exception {
        String sqlSelect = "select ID, CLIENTE, MODELO, PLACA from AUTOMOVEIS";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlSelect);) {
            List<Automoveis> automoveis = new ArrayList<>();
            try (ResultSet rs = ps.executeQuery();) {
                while (rs.next()) {
                    Automoveis a = new Automoveis();
                    a.setId(rs.getInt("id"));
                    a.setCliente(rs.getString("cliente"));
                    a.setModelo(rs.getString("modelo"));
                    a.setPlaca(rs.getString("placa"));
                    automoveis.add(a);
                }
            }
            return automoveis;
        }
    }

    //Dao pra inserir
    public Automoveis incluir(Automoveis a) throws Exception {
        String sqlInsert = "INSERT INTO AUTOMOVEIS(ID, CLIENTE, MODELO, PLACA"
                + "VALUES (?, ?, ?, ?)";
        try (Connection con = jdbcTemplate.getDataSource().getConnection();
             PreparedStatement ps = con.prepareStatement(sqlInsert);) {
            ps.setInt(1, a.getId());
            ps.setString(2, a.getCliente());
            ps.setString(3, a.getModelo());
            ps.setString(5, a.getPlaca());
            int result = ps.executeUpdate();
            if (result == 1) {
                System.out.println("Automoveis inserido com sucesso.");
                return a;
            }
            ps.close();
            throw new Exception("Erro na inserção.");
        }
    }
}
