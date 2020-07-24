package com.example.collect.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.example.collect.bean.CartListBean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CART_LIST_BEAN".
*/
public class CartListBeanDao extends AbstractDao<CartListBean, Long> {

    public static final String TABLENAME = "CART_LIST_BEAN";

    /**
     * Properties of entity CartListBean.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property User_id = new Property(1, int.class, "user_id", false, "USER_ID");
        public final static Property Session_id = new Property(2, String.class, "session_id", false, "SESSION_ID");
        public final static Property Goods_id = new Property(3, int.class, "goods_id", false, "GOODS_ID");
        public final static Property Goods_sn = new Property(4, String.class, "goods_sn", false, "GOODS_SN");
        public final static Property Product_id = new Property(5, int.class, "product_id", false, "PRODUCT_ID");
        public final static Property Goods_name = new Property(6, String.class, "goods_name", false, "GOODS_NAME");
        public final static Property Market_price = new Property(7, int.class, "market_price", false, "MARKET_PRICE");
        public final static Property Retail_price = new Property(8, int.class, "retail_price", false, "RETAIL_PRICE");
        public final static Property Number = new Property(9, int.class, "number", false, "NUMBER");
        public final static Property Goods_specifition_name_value = new Property(10, String.class, "goods_specifition_name_value", false, "GOODS_SPECIFITION_NAME_VALUE");
        public final static Property Goods_specifition_ids = new Property(11, String.class, "goods_specifition_ids", false, "GOODS_SPECIFITION_IDS");
        public final static Property Checked = new Property(12, int.class, "checked", false, "CHECKED");
        public final static Property List_pic_url = new Property(13, String.class, "list_pic_url", false, "LIST_PIC_URL");
        public final static Property EditChecked = new Property(14, boolean.class, "editChecked", false, "EDIT_CHECKED");
        public final static Property IsServerDelete = new Property(15, boolean.class, "isServerDelete", false, "IS_SERVER_DELETE");
    }


    public CartListBeanDao(DaoConfig config) {
        super(config);
    }
    
    public CartListBeanDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CART_LIST_BEAN\" (" + //
                "\"_id\" INTEGER PRIMARY KEY NOT NULL ," + // 0: id
                "\"USER_ID\" INTEGER NOT NULL ," + // 1: user_id
                "\"SESSION_ID\" TEXT," + // 2: session_id
                "\"GOODS_ID\" INTEGER NOT NULL ," + // 3: goods_id
                "\"GOODS_SN\" TEXT," + // 4: goods_sn
                "\"PRODUCT_ID\" INTEGER NOT NULL ," + // 5: product_id
                "\"GOODS_NAME\" TEXT," + // 6: goods_name
                "\"MARKET_PRICE\" INTEGER NOT NULL ," + // 7: market_price
                "\"RETAIL_PRICE\" INTEGER NOT NULL ," + // 8: retail_price
                "\"NUMBER\" INTEGER NOT NULL ," + // 9: number
                "\"GOODS_SPECIFITION_NAME_VALUE\" TEXT," + // 10: goods_specifition_name_value
                "\"GOODS_SPECIFITION_IDS\" TEXT," + // 11: goods_specifition_ids
                "\"CHECKED\" INTEGER NOT NULL ," + // 12: checked
                "\"LIST_PIC_URL\" TEXT," + // 13: list_pic_url
                "\"EDIT_CHECKED\" INTEGER NOT NULL ," + // 14: editChecked
                "\"IS_SERVER_DELETE\" INTEGER NOT NULL );"); // 15: isServerDelete
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CART_LIST_BEAN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, CartListBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getUser_id());
 
        String session_id = entity.getSession_id();
        if (session_id != null) {
            stmt.bindString(3, session_id);
        }
        stmt.bindLong(4, entity.getGoods_id());
 
        String goods_sn = entity.getGoods_sn();
        if (goods_sn != null) {
            stmt.bindString(5, goods_sn);
        }
        stmt.bindLong(6, entity.getProduct_id());
 
        String goods_name = entity.getGoods_name();
        if (goods_name != null) {
            stmt.bindString(7, goods_name);
        }
        stmt.bindLong(8, entity.getMarket_price());
        stmt.bindLong(9, entity.getRetail_price());
        stmt.bindLong(10, entity.getNumber());
 
        String goods_specifition_name_value = entity.getGoods_specifition_name_value();
        if (goods_specifition_name_value != null) {
            stmt.bindString(11, goods_specifition_name_value);
        }
 
        String goods_specifition_ids = entity.getGoods_specifition_ids();
        if (goods_specifition_ids != null) {
            stmt.bindString(12, goods_specifition_ids);
        }
        stmt.bindLong(13, entity.getChecked());
 
        String list_pic_url = entity.getList_pic_url();
        if (list_pic_url != null) {
            stmt.bindString(14, list_pic_url);
        }
        stmt.bindLong(15, entity.getEditChecked() ? 1L: 0L);
        stmt.bindLong(16, entity.getIsServerDelete() ? 1L: 0L);
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, CartListBean entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
        stmt.bindLong(2, entity.getUser_id());
 
        String session_id = entity.getSession_id();
        if (session_id != null) {
            stmt.bindString(3, session_id);
        }
        stmt.bindLong(4, entity.getGoods_id());
 
        String goods_sn = entity.getGoods_sn();
        if (goods_sn != null) {
            stmt.bindString(5, goods_sn);
        }
        stmt.bindLong(6, entity.getProduct_id());
 
        String goods_name = entity.getGoods_name();
        if (goods_name != null) {
            stmt.bindString(7, goods_name);
        }
        stmt.bindLong(8, entity.getMarket_price());
        stmt.bindLong(9, entity.getRetail_price());
        stmt.bindLong(10, entity.getNumber());
 
        String goods_specifition_name_value = entity.getGoods_specifition_name_value();
        if (goods_specifition_name_value != null) {
            stmt.bindString(11, goods_specifition_name_value);
        }
 
        String goods_specifition_ids = entity.getGoods_specifition_ids();
        if (goods_specifition_ids != null) {
            stmt.bindString(12, goods_specifition_ids);
        }
        stmt.bindLong(13, entity.getChecked());
 
        String list_pic_url = entity.getList_pic_url();
        if (list_pic_url != null) {
            stmt.bindString(14, list_pic_url);
        }
        stmt.bindLong(15, entity.getEditChecked() ? 1L: 0L);
        stmt.bindLong(16, entity.getIsServerDelete() ? 1L: 0L);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public CartListBean readEntity(Cursor cursor, int offset) {
        CartListBean entity = new CartListBean( //
            cursor.getLong(offset + 0), // id
            cursor.getInt(offset + 1), // user_id
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // session_id
            cursor.getInt(offset + 3), // goods_id
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // goods_sn
            cursor.getInt(offset + 5), // product_id
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // goods_name
            cursor.getInt(offset + 7), // market_price
            cursor.getInt(offset + 8), // retail_price
            cursor.getInt(offset + 9), // number
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // goods_specifition_name_value
            cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11), // goods_specifition_ids
            cursor.getInt(offset + 12), // checked
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // list_pic_url
            cursor.getShort(offset + 14) != 0, // editChecked
            cursor.getShort(offset + 15) != 0 // isServerDelete
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, CartListBean entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setUser_id(cursor.getInt(offset + 1));
        entity.setSession_id(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setGoods_id(cursor.getInt(offset + 3));
        entity.setGoods_sn(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setProduct_id(cursor.getInt(offset + 5));
        entity.setGoods_name(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setMarket_price(cursor.getInt(offset + 7));
        entity.setRetail_price(cursor.getInt(offset + 8));
        entity.setNumber(cursor.getInt(offset + 9));
        entity.setGoods_specifition_name_value(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setGoods_specifition_ids(cursor.isNull(offset + 11) ? null : cursor.getString(offset + 11));
        entity.setChecked(cursor.getInt(offset + 12));
        entity.setList_pic_url(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setEditChecked(cursor.getShort(offset + 14) != 0);
        entity.setIsServerDelete(cursor.getShort(offset + 15) != 0);
     }
    
    @Override
    protected final Long updateKeyAfterInsert(CartListBean entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(CartListBean entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(CartListBean entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
