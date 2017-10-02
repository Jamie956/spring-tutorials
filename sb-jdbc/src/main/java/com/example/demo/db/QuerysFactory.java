package com.example.demo.db;

import java.util.ArrayList;

public class QuerysFactory {
    private static QuerysFactory singleInstance = null;

    public static QuerysFactory getInstance() {
        if (singleInstance == null) {
            synchronized (QuerysFactory.class) {
                try {
                    singleInstance = new QuerysFactory();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return singleInstance;
    }

    public QuerysFactory() {
    }

    public String[] getQueryString(String[] _aColumns, String _aIndex, String _aTable, String _aJoin,
            String _aWhere, String _sql) {
        return getQueryStringp(_aColumns, _aIndex, _aTable, _aJoin, _aWhere, _sql, "");
    }

    private String[] getQueryStringp(String[] _aColumns, String _aIndex, String _aTable, String _aJoin,
            String _aWhere, String _sql, String _groupby) {

        ArrayList<String> list = new ArrayList<>();

        if (!_aWhere.isEmpty() && _aWhere != null) {
            list.add(_aWhere);
        }

//        String _search = info.getQueryParameters().getFirst("search");
        String sWhere = " ";
//        if (_search != null) {
//            String[] search = new String[_aColumns.length];
//            for (int i = 0; i < _aColumns.length; i++) {
//                search[i] = String.format(" %s LIKE '%%%s%%' ", _aColumns[i], _search);
//            }
//            String str = "(" + Utils.join(search, " OR ") + ")";
//            list.add(str);
//        }
        String sJoin = " ";
        if (_aJoin != null && (!_aJoin.equals(""))) {
            sJoin += _aJoin;
        }
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String item : list) {
                if (sb.length() > 0) {
                    sb.append(" AND ");
                }
                sb.append(item);
            }
            String result = sb.toString();
            sWhere = " WHERE " + result;
        }
        String sGroupby = " ";
        sGroupby += _groupby;
        String sOrderBy = "";
//        String _order = info.getQueryParameters().getFirst("order");
//        String _sort = info.getQueryParameters().getFirst("sort");
//        if (_order != null && !_order.equals("") && _sort != null && !_sort.equals("")) {
//            sOrderBy = String.format(" ORDER BY %s %s", _sort, _order);
//        }
        String sLimit = "";
//        String _offset = info.getQueryParameters().getFirst("offset");
//        String _limit = info.getQueryParameters().getFirst("limit");
//        if (_offset != null && !_offset.equals("") && _limit != null && !_limit.equals("")) {
//            sLimit = String.format(" LIMIT %s , %s", _offset, _limit);
//        }

        String sQuery = _sql + sJoin + sWhere + sGroupby + sOrderBy + sLimit;
        String sQueryTotal = "SELECT COUNT(" + _aIndex + ") AS cnt FROM " + _aTable + sJoin + sWhere;
        
        String[] res = new String[2];
        res[0] = sQuery;
        res[1] = sQueryTotal;
        for (String str : res) {
            System.out.println("-> "+str);
        }
        return res;

    }

}
