package com.example.demo.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.db.QuerysFactory;
import com.example.demo.repository.Category;
import com.example.demo.repository.JsonTableModel;

@Repository
public class CategoryService {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<Category> itemsMapper = new RowMapper<Category>() {
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category item = new Category();
			item.setId(rs.getString("id"));
			item.setName(rs.getString("name"));
			item.setCreated_time(rs.getString("created_time"));
			item.setUpdated_time(rs.getString("updated_time"));
			item.setCategory_ufo(rs.getString("category_ufo"));
			item.setAlcohol(rs.getString("alcohol"));
			item.setScript(rs.getString("script"));
			item.setDisplay_name(rs.getString("display_name"));
			item.setOriginal_id(rs.getString("original_id"));
			item.setMerchant_id(rs.getString("merchant_id"));
			return item;
		}
	};
	
	public JsonTableModel initCategoriesTableByMid() {
		String merchant_id = "ufo_BvYhCY871Ou";
		String _aWhere = " merchant_id = '" + merchant_id + "' AND flag = 0";
		String[] _aColumns = { "id", "name", "created_time", "updated_time", "category_ufo", "alcohol", "script", "display_name",
				"original_id", "merchant_id" };
		String _aIndex = "id";
		String _aTable = "t_category";
		String _aJoin = "";
		String _sql = "SELECT id, name, created_time, updated_time, category_ufo, alcohol, script, display_name, original_id,"
				+ " merchant_id FROM t_category ";
		
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
