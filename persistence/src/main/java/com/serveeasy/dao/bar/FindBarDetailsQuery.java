package com.serveeasy.dao.bar;

import com.serveeasy.dao.api.Query;
import com.serveeasy.model.bar.BarDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
class FindBarDetailsQuery extends Query<BarDetails>{

    private final static String query = "SELECT * FROM `serveeasy`.`bar_details` WHERE `id` = ?";

    private int id;

    public FindBarDetailsQuery(int id) {
        this.id = id;
    }

    @Override
    public RowMapper<BarDetails> getRowMapper() {
        return new BarDetailsRowMapper();
    }

    @Override
    protected PreparedStatement getPreparedStatement(Connection connection) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);

        return ps;
    }
}
