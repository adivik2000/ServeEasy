package com.serveeasy.dao.program;

import com.serveeasy.model.program.WorkProgram;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class ProgramRowMapper implements RowMapper {

    private final WorkProgram wp;

    ProgramRowMapper(WorkProgram wp) {
        this.wp = wp;
    }

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ProgramResultSetExtractor ext = new ProgramResultSetExtractor();
        ext.setWorkProgram(wp);
        return ext.extractData(resultSet);
    }
}