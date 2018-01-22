package com.example.demo.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ICategoryDao;
import com.example.demo.model.Category;
import com.example.demo.model.JsonTable;
import com.example.demo.util.QuerysFactory;
import com.google.gson.Gson;

@Repository
public class CategoryDaoImpl implements ICategoryDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	private static final RowMapper<Category> itemsMapper = new RowMapper<Category>() {
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category item = new Category();
			item.setId(rs.getString("id"));
//			item.setOriginalId(rs.getString("original_id"));
			item.setName(rs.getString("name"));
//			item.setMerchantId(rs.getString("merchant_id"));
			item.setCategoryUfo(rs.getString("category_ufo"));
//			item.setScript(rs.getString("script"));
			item.setCreatedTime(rs.getString("created_time"));
			item.setUpdatedTime(rs.getString("updated_time"));
			item.setAlcohol(rs.getString("alcohol"));
//			item.setHidden(rs.getString("hidden"));
//			item.setFlag(rs.getString("flag"));
			item.setDisplayName(rs.getString("display_name"));
//			item.setServiceType(rs.getString("service_type"));
			return item;
		}
	};

	@Override
	public String listCategoryByMid() {
		// TODO Auto-generated method stub
		String merchant_id = "ufo_BvYnk3qrrtw";
		String[] _Columns  = { "id", "name", "created_time", "updated_time", "category_ufo", "alcohol", "display_name" };
		String _Index      = "id";
		String _Table      = "t_category";
		String _Join       = "";
		String _Where      = " merchant_id = '" + merchant_id + "' AND flag = 0";
		String _sql        = "SELECT id, name, created_time, updated_time, category_ufo, alcohol, display_name FROM t_category ";
		String[] queryStr = QuerysFactory.getInstance().getQueryString(_Columns, _Index, _Table, _Join, _Where, _sql);
		String strResult = null;
		try {
			List<?> items = jdbcTemplate.query(queryStr[0], itemsMapper);
			Integer count = jdbcTemplate.queryForObject(queryStr[1], Integer.class);
			JsonTable result = new JsonTable(count, items);
			Gson gson = new Gson();
			strResult = gson.toJson(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return strResult;
	}

	@Override
	public String getCategoryById(String id) {
		// TODO Auto-generated method stub
		String merchant_id = "ufo_BvYnk3qrrtw";
		String[] _Columns  = { "id", "name", "created_time", "updated_time", "category_ufo", "alcohol", "display_name" };
		String _Index      = "id";
		String _Table      = "t_category";
		String _Join       = "";
		String _Where      = " id = '" + id + "' AND merchant_id = '" + merchant_id + "' AND flag = 0";
		String _sql        = "SELECT id, name, created_time, updated_time, category_ufo, alcohol, display_name FROM t_category ";
		String[] queryStr = QuerysFactory.getInstance().getQueryString(_Columns, _Index, _Table, _Join, _Where, _sql);
		String strResult = null;
		try {
			List<?> items = jdbcTemplate.query(queryStr[0], itemsMapper);
			Integer count = jdbcTemplate.queryForObject(queryStr[1], Integer.class);
			JsonTable result = new JsonTable(count, items);
			Gson gson = new Gson();
			strResult = gson.toJson(result);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return strResult;
	}

	@Override
	public String saveCategory(Category category) {
		// TODO Auto-generated method stub
		String _id           = category.getId();
		String _name         = category.getName();
		String _merchant_id  = category.getMerchantId();
		String _alcohol      = category.getAlcohol();
		String _category_ufo = category.getCategoryUfo();
		String _dispaly_name = category.getDisplayName();
		String _hidden       = category.getHidden();
		String _sql = "INSERT INTO t_category (id, name, merchant_id, created_time, updated_time, "
				+ "alcohol, category_ufo, display_name, hidden) VALUES (?, ?, ?, NOW(), NOW(), ?, ?, ?, ? )";
		Object[] _val = {_id, _name, _merchant_id, _alcohol, _category_ufo, _dispaly_name, _hidden };
		int count = 0;
		try {
			count = jdbcTemplate.update(_sql, _val);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String result = (count == 1) ? 	"success" : "fail";
		return result;
	}

	@Override
	public String removeCategory(String id) {
		// TODO Auto-generated method stub
		String _sql = " UPDATE t_category SET flag = 1 WHERE id = ?";
		Object[] _val = { id };
		int count = 0;
		try {
			count = jdbcTemplate.update(_sql, _val);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String result = (count == 1) ? 	"success" : "fail";
		return result;
	}

	@Override
	public String updateCategory(Category category) {
		// TODO Auto-generated method stub
	    String _name         = category.getName();
	    String _dispaly_name = category.getDisplayName();
	    String _id           = category.getId();
	    String _sql          = "UPDATE t_category set name = ?, display_name = ? where id = ?";
	    Object[] _val        = { _name, _dispaly_name, _id };
		
		int count = 0;
		try {
			count = jdbcTemplate.update(_sql, _val);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String result = (count == 1) ? 	"success" : "fail";
		return result;
	}
	
	public String saveCategories(List<Category> categoriesList) {
		String _sql = "INSERT INTO t_category (id, name, merchant_id, created_time, updated_time, alcohol, category_ufo, display_name, hidden) VALUES (?, ?, ?, NOW(), NOW(), ?, ?, ?, ? )";
		int[] updateCounts = null;
		try {
			updateCounts = jdbcTemplate.batchUpdate(_sql, new BatchPreparedStatementSetter() {
				@Override
				public int getBatchSize() {
					// TODO Auto-generated method stub
					return categoriesList.size();
				}
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					// TODO Auto-generated method stub
					String _id           = categoriesList.get(i).getId();
					String _name         = categoriesList.get(i).getName();
					String _merchant_id  = categoriesList.get(i).getMerchantId();
					String _alcohol      = categoriesList.get(i).getAlcohol();
					String _category_ufo = categoriesList.get(i).getCategoryUfo();
					String _dispaly_name = categoriesList.get(i).getDisplayName();
					String _hidden       = categoriesList.get(i).getHidden();
					
					ps.setString(1, _id);
					ps.setString(2, _name);
					ps.setString(3, _merchant_id);
					ps.setString(4, _alcohol);
					ps.setString(5, _category_ufo);
					ps.setString(6, _dispaly_name);
					ps.setString(7, _hidden);
				}
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String result = (updateCounts != null) ? "success" : "fail";
		return result;
	}
	
}
