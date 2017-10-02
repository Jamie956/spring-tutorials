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
	
	public int addCategoryInfo() {
		String _sql = "INSERT INTO t_category (id, name, merchant_id, created_time, updated_time, "
				+ "alcohol, category_ufo, display_name, hidden) VALUES (?, ?, ?, NOW(), NOW(), ?, ?, ?, ? )";
		Object[] _val = {"ufo_BvYnHc0xdyk", "papa", "ufo_BvYhCY871Ou", "1", "food", "ef", "0"};
		int count = jdbcTemplate.update(_sql, _val);
		return count;
	}
	
	public int editCategoryInfo() {
		String _sql = "UPDATE t_category set name = ? where id = ?";
		Object[] _val = {"ktkt", "ufo_BvYnHc0xdyk"};
		int count = jdbcTemplate.update(_sql, _val);
		return count;
	}
	
	public int removeCategoryInfo() {
		String _sql = " UPDATE t_category SET flag = 1 WHERE id = ?";
		Object[] _val = {"ufo_BvYnHc0xdyk"};
		int count = jdbcTemplate.update(_sql, _val);
		return count;
	}
	
}
