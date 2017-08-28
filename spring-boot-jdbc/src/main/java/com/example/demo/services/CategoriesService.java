package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.db.QuerysFactory;
import com.example.demo.repositories.CategoriesRepository;
import com.example.demo.repositories.JsonTableModel;

@Repository
public class CategoriesService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<CategoriesRepository> itemsMapper = new RowMapper<CategoriesRepository>() {
		public CategoriesRepository mapRow(ResultSet rs, int rowNum) throws SQLException {
			CategoriesRepository item = new CategoriesRepository();
			item.setId(rs.getString("id"));
			item.setName(rs.getString("name"));
			item.setCreatedTime(rs.getString("created_time"));
			item.setUpdatedTime(rs.getString("updated_time"));
			item.setCategoryUfo(rs.getString("category_ufo"));
			item.setAlcohol(rs.getString("alcohol"));
			item.setScriptValue(rs.getString("script_value"));
			item.setDisplayName(rs.getString("display_name"));
			return item;
		}
	};
	
	public JsonTableModel initCategoriesTableByMid() {
		String merchant_id = "ufo_BvYhCY871Ou";
		String _aWhere = " merchant_id = '" + merchant_id + "' AND flag = 0";
		String[] _aColumns = { "id", "name", "created_time", "updated_time", "category_ufo", "alcohol", "script_value", "display_name" };
		String _aIndex = "id";
		String _aTable = "t_category";
		String _aJoin = "";
		String _sql = "SELECT id, name, created_time, updated_time, category_ufo, alcohol, script_value, display_name FROM t_category ";
		
		String[] queryStr = QuerysFactory.getInstance().getQueryString(_aColumns, _aIndex, _aTable, _aJoin, _aWhere, _sql);
		
		List<?> items = jdbcTemplate.query(queryStr[0], itemsMapper);
		Integer totalItems = jdbcTemplate.queryForObject(queryStr[1], Integer.class);
		
		JsonTableModel result = new JsonTableModel(totalItems, items);
		return result;
	}

}
