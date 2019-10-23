package com.company.levelupservice.dao;

import com.company.levelupservice.model.LevelUp;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LevelUpDaoJdbcTemplateImpl implements LevelUpDao{

    //prepared statements
    public static final String INSERT_LEVELUP_SQL = "INSERT INTO level_up (customer_id, points, member_date) VALUE (?, ?, ?)";
    public static final String SELECT_LEVELUP_SQL = "SELECT * FROM level_up WHERE level_up_id = ?";
    public static final String SELECT_ALL_LEVELUPS_SQL = "SELECT * FROM level_up";
    public static final String UPDATE_LEVELUP_SQL = "UPDATE level_up SET customer_id = ?, point = ?, member_date = ? WHERE level_up_id = ?";
    public static final String DELETE_LEVELUP_SQL = "DELETE FROM level_up WHERE level_up_id = ?";

    private JdbcTemplate jdbcTemplate;

    public LevelUpDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public LevelUp createLevelUp(LevelUp lvl) {
        jdbcTemplate.update(INSERT_LEVELUP_SQL, lvl.getCustomer_id(), lvl.getPoints(), lvl.getMember_date());
        int id = jdbcTemplate.queryForObject("")

    }

    @Override
    public LevelUp readLevelUp(int level_up_id) {
        return null;
    }

    @Override
    public List<LevelUp> readAll() {
        return null;
    }

    @Override
    public void updateLevelUp(LevelUp lvl) {

    }

    @Override
    public void deleteLevelUp(int level_up_id) {

    }

    //row mapper
    private LevelUp mapRowToObject(ResultSet rs, int rowNum) throws SQLException{
        LevelUp levelUp = new LevelUp(
                rs.getInt("level_up_id"),
                rs.getInt("customer_id"),
                rs.getInt("points"),
                rs.getDate("member_date").toLocalDate()
        );
        return levelUp;
    }
}
